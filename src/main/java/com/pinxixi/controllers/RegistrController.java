package com.pinxixi.controllers;

import com.pinxixi.sevices.GenerateVerificationCodeSevicesImpl;
import com.pinxixi.sevices.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * description: 用户注册的接口 <br>
 * date: 2019/12/20 22:40 <br>
 * author: laizhiwei <br>
 * version: 1.0 <br>
 */

@RestController
public class RegistrController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private GenerateVerificationCodeSevicesImpl generateVerificationCodeSevices;

    /**
     * description: 接收前端传来的表单，对用户名，密码，验证码进行验证 <br>
     * version: 1.0 <br>
     * date: 2019/12/20 23:50 <br>
     * author: laizhiwei <br>
     *
     * @param requestData 是前端ajax发来的表单包含了，用户名，密码，验证码
     * @return java.util.Map<java.lang.String, java.lang.String>
     */
    @PostMapping("/api/v1/Register")
    public Map<String, String> registerController(@RequestBody Map<String, String> requestData) {
        Map<String, String> responseData = new HashMap<String, String>();
        System.out.println(requestData);
        boolean verifyRequestDataState = registerService.verifyRequestData(requestData);
        if (!verifyRequestDataState) {
            //返回0代表前端发来的数据格式错误
            responseData.put("stateCode", "0");
            return responseData;
        }

        String email = requestData.get("email");
        //验证邮箱是否注册过了
        boolean verifyMailboxState = generateVerificationCodeSevices.verifyMailboxExists(email);

        if (!verifyMailboxState) {
            //验证邮箱是否注册过了，注册了返回201用户去登录
            responseData.put("stateCode", "201");
            return responseData;
        }

        boolean verifyCodeAndEamilState = registerService.VerifyCodeAndEamil(requestData);
        if (!verifyCodeAndEamilState) {
            //返回100代表session不存在
            responseData.put("stateCode", "100");
            return responseData;
        }

        try {
            registerService.register(requestData);
        } catch (Exception e) {
            e.printStackTrace();
            //注册失败，数据库出现了问题
            responseData.put("stateCode", "301");
            return responseData;
        }
        //全部成功返回200
        responseData.put("stateCode", "200");
        return responseData;
    }
}
