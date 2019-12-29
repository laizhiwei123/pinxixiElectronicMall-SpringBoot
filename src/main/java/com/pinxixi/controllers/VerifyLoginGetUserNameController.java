package com.pinxixi.controllers;

import com.pinxixi.sevices.VerifyLoginGetUserNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/*
 * description: 获取用户名接口<br>
 * version: 1.0 <br>
 * date: 2019/12/28 21:52 <br>
 * author: laizhiwei <br>
 *
 * @param null
 * @return 
 */ 
@RestController
public class VerifyLoginGetUserNameController {
    @Autowired
    private VerifyLoginGetUserNameService verifcationNameAndPasswordService;
    @GetMapping("/api/v1/GetUserName")

    /*
     * description: getUserName 获取用户名接口 <br>
     * version: 1.0 <br>
     * date: 2019/12/28 21:52 <br>
     * author: laizhiwei <br>
     *
     * @param 
     * @return java.util.Map<java.lang.String,java.lang.String>
     */ 
    public Map<String, String> getUserName() {
        Map<String, String> responseData = new HashMap<String, String>();
        String name = null;
        try {
            name = verifcationNameAndPasswordService.verifcationSessionEmailAndPassWord();
        } catch (SQLException e) {
            //服务器出错， 返回301
            e.printStackTrace();
            responseData.put("stateCode","301");
            return responseData;
        }

        if (name == null) {
            //用户没登陆， 返回401
            responseData.put("stateCode","401");
            return responseData;
        }

        //全部成功，返回200，和用户名
        responseData.put("stateCode","200");
        responseData.put("name",name);
        return responseData;
    }
}
