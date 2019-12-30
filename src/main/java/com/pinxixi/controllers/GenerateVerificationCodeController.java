package com.pinxixi.controllers;

import com.pinxixi.sevices.GenerateVerificationCodeSevicesImpl;
import com.sun.mail.smtp.SMTPAddressFailedException;
import com.sun.mail.smtp.SMTPSenderFailedException;
import com.sun.mail.util.MailConnectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GenerateVerificationCodeController {
    @Autowired
    private GenerateVerificationCodeSevicesImpl generateVerificationCodeSevices;

    @PostMapping(value = "/api/v1/GenerateVerificationCode")
    public Map<String, String> generateVerificationCode(@RequestBody Map<String, String> httpRequestData) {
        System.out.println(httpRequestData);
        String email = httpRequestData.get("email");
        Map<String, String> responseData = new HashMap<>();
        //验证邮件格式，正确返回true，错误返回false
        boolean verifyMailboxState = generateVerificationCodeSevices.verifyMailbox(email);
        if (!verifyMailboxState) {
            //验证邮箱格式，注册过了返回0
            responseData.put("statusCode", "0");
            return responseData;
        }
        //验证邮件是否存在数据库，正确返回true，错误返回false
        boolean verifyMailboxExistsState = generateVerificationCodeSevices.verifyMailboxExists(email);
        if (!verifyMailboxExistsState) {
            //验证邮箱是否注册过了，不正确返回201
            responseData.put("statusCode", "201");
            return responseData;
        }
        //邮件发送状态，正确返回true，错误返回false
        try {
            generateVerificationCodeSevices.sendEmail(email);
        } catch (MailSendException e) {
           e.printStackTrace();
            System.out.println("dadad");
            responseData.put("statusCode", "101");
            return responseData;
        } catch (MailConnectException e) {
            e.printStackTrace();
            responseData.put("statusCode", "100");
            return responseData;
        }
        //全部成功返回200
        responseData.put("statusCode", "200");
        return responseData;
    }
}

