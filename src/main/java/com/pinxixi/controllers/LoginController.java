<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d57567eb7f790b3d83549bd0d34f30e23631d97d
package com.pinxixi.controllers;

import com.pinxixi.sevices.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * description: 登录模块的接口 <br>
 * date: 2019/12/27 17:57 <br>
 * author: laizhiwei <br>
 * version: 1.0 <br>
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * description: loginController <br>
     * version: 1.0 <br>
     * date: 2019/12/27 18:20 <br>
     * author: laizhiwei <br>
     *
     * @param requestBodyData
     * @return java.util.Map<java.lang.String, java.lang.String>
     */
    @PostMapping("/api/v1/Login")
    public Map<String, String> loginController(@RequestBody Map<String, String> requestBodyData) {
        System.out.println(requestBodyData);
        String email = requestBodyData.get("email");
        String password = requestBodyData.get("password");
        System.out.println("email: " + email + "password: " + password);

        Map<String, String> responseData = new HashMap<String, String>();
        boolean verifyRequestDataState = loginService.verifyRequestDataFormat(email, password);
        if (!verifyRequestDataState) {
            //前端数据格式错误返回0
            responseData.put("stateCode", "0");
            return responseData;
        }
        boolean verifyNameAndPasswordState;
        try {
            //数据库出现问题，返回301
            verifyNameAndPasswordState =  loginService.verifyEmailAndPassword(email, password);
        } catch (SQLException e) {
            e.printStackTrace();
            responseData.put("stateCode", "301");
            return responseData;
        }
        System.out.println("verifyNameAndPasswordState: " +verifyNameAndPasswordState);
        if (!verifyNameAndPasswordState) {
            //账号密码错误，返回401
            responseData.put("stateCode", "401");
            return responseData;
        }else {
            loginService.addSessionBasedEmailandpassword(email, password);
        }

        //账号密码正确，返回200
        responseData.put("stateCode", "200");
        return responseData;
    }
}
<<<<<<< HEAD
=======
package com.pinxixi.controllers;

import com.pinxixi.sevices.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * description: 登录模块的接口 <br>
 * date: 2019/12/27 17:57 <br>
 * author: laizhiwei <br>
 * version: 1.0 <br>
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * description: loginController <br>
     * version: 1.0 <br>
     * date: 2019/12/27 18:20 <br>
     * author: laizhiwei <br>
     *
     * @param requestBodyData
     * @return java.util.Map<java.lang.String, java.lang.String>
     */
    @PostMapping("/api/v1/Login")
    public Map<String, String> loginController(@RequestBody Map<String, String> requestBodyData) {
        System.out.println(requestBodyData);
        String email = requestBodyData.get("email");
        String password = requestBodyData.get("password");
        System.out.println("email: " + email + "password: " + password);

        Map<String, String> responseData = new HashMap<String, String>();
        boolean verifyRequestDataState = loginService.verifyRequestDataFormat(email, password);
        if (!verifyRequestDataState) {
            //前端数据格式错误返回0
            responseData.put("stateCode", "0");
            return responseData;
        }
        boolean verifyNameAndPasswordState;
        try {
            //数据库出现问题，返回301
            verifyNameAndPasswordState =  loginService.verifyEmailAndPassword(email, password);
        } catch (SQLException e) {
            e.printStackTrace();
            responseData.put("stateCode", "301");
            return responseData;
        }
        System.out.println("verifyNameAndPasswordState: " +verifyNameAndPasswordState);
        if (!verifyNameAndPasswordState) {
            //账号密码错误，返回401
            responseData.put("stateCode", "401");
            return responseData;
        }else {
            loginService.addSessionBasedEmailandpassword(email, password);
        }

        //账号密码正确，返回200
        responseData.put("stateCode", "200");
        return responseData;
    }
}
>>>>>>> pinxixi
=======
>>>>>>> d57567eb7f790b3d83549bd0d34f30e23631d97d
