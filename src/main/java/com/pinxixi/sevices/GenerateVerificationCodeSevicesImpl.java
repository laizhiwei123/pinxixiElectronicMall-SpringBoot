package com.pinxixi.sevices;

import com.pinxixi.dao.MerchantUserDao;
import com.pinxixi.sevicesinterface.GenerateVerificationCodeSevices;
import com.pinxixi.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

@Service
public class GenerateVerificationCodeSevicesImpl implements GenerateVerificationCodeSevices {
    @Autowired
    private MailUtil mailUtil;
    @Autowired
    private MerchantUserDao merchantUserDao;

    public boolean sendEmail(String email) {
        //使用((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();获取Request和Response不会导致线程问题
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String emailTitle = "拼西西注册";
        //生成验证码
        String verifyCode = String.valueOf((int) ((Math.random() * 9 + 1) * 100000)) ;
        String emaliContent = "欢迎使用拼西西: " + verifyCode;
        try {
            mailUtil.sendMailServer(email, emailTitle,emailTitle + verifyCode);
        }catch (Exception e) {
            //如果异常打印异常，并返回false代表邮件发送失败
            e.printStackTrace();
            return false;
        }
        httpServletRequest.getSession().setAttribute("email", email);
        httpServletRequest.getSession().setAttribute("verifyCode", verifyCode);
        System.out.println(httpServletRequest.getSession().getAttribute("email"));
        System.out.println(httpServletRequest.getSession().getAttribute("verifyCode"));
        return true;
    }

    public boolean verifyMailboxExists(String email) {
        if (merchantUserDao.getUserMailBased(email).isEmpty()) {
            //判空，如果为空，就是没查询到数据返回true，表示可以注册
            return  true;
        }else {
            //否则，就是查询到数据返回false，代表不能注册
            return false;
        }
    }
    public boolean verifyMailbox(String email) {
        //验证有所漏洞
        return Pattern.matches("^([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$", email);
    }
}
