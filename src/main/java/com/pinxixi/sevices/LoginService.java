package com.pinxixi.sevices;

import com.pinxixi.dao.MerchantUserDao;
import com.pinxixi.model.UserModel;
import com.pinxixi.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpSessionRequiredException;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * description: loginService <br>
 * date: 2019/12/27 18:24 <br>
 * author: laizhiwei <br>
 * version: 1.0 <br>
 */
@Service
public class LoginService {
    @Autowired
    private MerchantUserDao merchantUserDao;
    @Autowired
    private SessionUtil sessionUtil;

    /*
     * description: verifyRequestDataFormat 验证前端发来的数据格式是否正确，包含邮箱和密码 <br>
     * version: 1.0 <br>
     * date: 2019/12/27 19:22 <br>
     * author: laizhiwei <br>
     *
     * @param email 邮箱
 * @param password 密码
     * @return boolean 验证正确返回true， 错误返回 false
     */
    public boolean verifyRequestDataFormat(String email, String password) {
        boolean passwordState = Pattern.matches("^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$", password);
        boolean emailState = Pattern.matches("^([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$", email);
        if (emailState && passwordState) {
            return true;
        }
        return false;
    }

    /**
     * description: verifyNameAndPassword 验证前端发来的用户名、密码和数据库是否对上 <br>
     * version: 1.0 <br>
     * date: 2019/12/27 21:17 <br>
     * author: laizhiwei <br>
     *
     * @param email
     * @param password
     * @return boolean userModel里面没有元素，返回false， 否则返回true
     */
    public boolean verifyEmailAndPassword(String email, String password) throws SQLException {
        List<UserModel> userModel = merchantUserDao.getUserBasedPasswordAndEmail(email, password);
        System.out.println(userModel);
        if (userModel.size() == 0) {
            //数据库没找到用户信息，返回false
            return false;
        }
        return true;
    }

    /*
     * description: 将邮箱和密码写入session <br>
     * version: 1.0 <br>
     * date: 2019/12/29 21:01 <br>
     * author: laizhiwei <br>
     *
     * @param email
 * @param password
     * @return void
     */
    public void addSessionBasedEmailandpassword(String email, String password) {
        try {
            sessionUtil.addSession("email", email);
            sessionUtil.addSession("password", password);
        } catch (HttpSessionRequiredException e) {
            e.printStackTrace();
        }
    }
}