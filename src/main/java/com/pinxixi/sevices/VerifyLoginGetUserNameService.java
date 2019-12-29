<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d57567eb7f790b3d83549bd0d34f30e23631d97d
package com.pinxixi.sevices;

import com.pinxixi.dao.MerchantUserDao;
import com.pinxixi.model.UserModel;
import com.pinxixi.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * description: VerifcationService <br>
 * date: 2019/12/28 12:50 <br>
 * author: laizhiwei <br>
 * version: 1.0 <br>
 */
@Service
public class VerifyLoginGetUserNameService {
    @Autowired
    private SessionUtil sessionUtil;
    @Autowired
    private MerchantUserDao merchantUserDao;
    public String verifcationSessionEmailAndPassWord() throws SQLException {

        String name = (String) sessionUtil.getSession("email");
        String password = (String) sessionUtil.getSession("password");

        if (name != null && password != null) {
            List<UserModel> userModelList = merchantUserDao.getUserBasedPasswordAndEmail(name, password);

            if (userModelList.size() == 0) {
                return null;
            }else {
                return userModelList.get(0).getName();
            }
        }
        return null;
    }
}
<<<<<<< HEAD
=======
package com.pinxixi.sevices;

import com.pinxixi.dao.MerchantUserDao;
import com.pinxixi.model.UserModel;
import com.pinxixi.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * description: VerifcationService <br>
 * date: 2019/12/28 12:50 <br>
 * author: laizhiwei <br>
 * version: 1.0 <br>
 */
@Service
public class VerifyLoginGetUserNameService {
    @Autowired
    private SessionUtil sessionUtil;
    @Autowired
    private MerchantUserDao merchantUserDao;
    public String verifcationSessionEmailAndPassWord() throws SQLException {

        String name = (String) sessionUtil.getSession("email");
        String password = (String) sessionUtil.getSession("password");

        if (name != null && password != null) {
            List<UserModel> userModelList = merchantUserDao.getUserBasedPasswordAndEmail(name, password);

            if (userModelList.size() == 0) {
                return null;
            }else {
                return userModelList.get(0).getName();
            }
        }
        return null;
    }
}
>>>>>>> pinxixi
=======
>>>>>>> d57567eb7f790b3d83549bd0d34f30e23631d97d
