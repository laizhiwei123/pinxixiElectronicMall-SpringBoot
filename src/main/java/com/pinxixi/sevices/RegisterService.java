package com.pinxixi.sevices;

import com.pinxixi.dao.MerchantUserDao;
import com.pinxixi.model.UserModel;
import com.pinxixi.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.regex.Pattern;


/**
 * description: 注册服务层，主要进行注册的业务处理 <br>
 * date: 2019/12/21 15:05 <br>
 * author: laizhiwei <br>
 * version: 1.0 <br>
 */

@Service
public class RegisterService {

    @Autowired
    private SessionUtil sessionUtil;
    @Autowired
    private MerchantUserDao merchantUserDao;

    /**
     * description: 用户注册，写入数据库 <br>
     * version: 1.0 <br>
     * date: 2019/12/21 19:09 <br>
     * author: laizhiwei <br>
     *
     * @param data
     * @return void
     */
    public void register(Map<String, String> data) throws Exception {
        UserModel userModel = new UserModel();
        String email = data.get("email");

        userModel.setName(data.get("name"));
        userModel.setPassword(data.get("password"));
        userModel.setEmail(email);
        try {
            merchantUserDao.addUser(userModel);
        }catch (Exception e) {
            throw  new  Exception("数据库错误");
        }finally {
            sessionUtil.deleteSession("email");
            sessionUtil.deleteSession("verifyCode");
        }
    }

    /**
     * description: 验证验证码和邮件是否存在session中 <br>
     * version: 1.0 <br>
     * date: 2019/12/22 23:05 <br>
     * author: laizhiwei <br>
     *
     * @param data
     * @return boolean
     */

    public boolean VerifyCodeAndEamil(Map<String, String> data) {
        String email = data.get("email");
        String verifyCode = data.get("verificationCode");
        String sessionVerifyCode= null;
        String sessionEmail = null;
        try {
            sessionVerifyCode = (String) sessionUtil.getSession("verifyCode");
            sessionEmail = (String) sessionUtil.getSession("email");
        }catch (Exception e) {
            System.err.println("session不存在");
            return false;
        }

        return verifyCode.equals(sessionVerifyCode) && email.equals(sessionEmail);
    }

    /**
     * description: 验证前端发来的数据，包含用户名、邮箱地址、验证码 <br>
     * version: 1.0 <br>
     * date: 2019/12/21 18:21 <br>
     * author: laizhiwei <br>
     *
     * @param data
     * @return void
     */
    public boolean verifyRequestData(Map<String, String> data) {
        //有bug应该判断属性是否有值
        int nameLength = data.get("name").length();//获取用户名长度
        String password = data.get("password");
        String email = data.get("email");
        int verifyCodeLength = data.get("verificationCode").length();//获取密码长度
        //验证密码是否正确
        boolean passwordState = Pattern.matches("^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$", password);

        System.out.println("passwordState: " + passwordState);
        //验证邮箱是否正确
        boolean emailState = Pattern.matches("^([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$", email);
        System.out.println("emailState: " + emailState);
        if ((nameLength > 0 & nameLength <= 20) && (verifyCodeLength == 6) && (passwordState) && (emailState)) {
            //验证用户名，密码，邮箱，验证码是否正确
            return true;
        }
        return false;
    }
}
