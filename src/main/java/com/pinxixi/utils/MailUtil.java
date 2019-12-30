package com.pinxixi.utils;

import com.sun.mail.smtp.SMTPAddressFailedException;
import com.sun.mail.util.MailConnectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.SendFailedException;

@Component
public class MailUtil {
    @Value("${spring.mail.username}")
    private String fromUser;
    @Autowired
    private JavaMailSender javaMailSender;

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public void sendMailServer(String sendUser, String title, String text)  throws MailSendException, MailConnectException {
        //创建邮件的实体 用于封装发送邮件需要的信息
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //邮件的发送人
        simpleMailMessage.setFrom(fromUser);
        //邮件接收人
        simpleMailMessage.setTo(sendUser);
        //设置抄送人，发送前先给自己发一份(抄送),防止网易 554 DT:SPM yeah smtp1错误
        simpleMailMessage.setCc(fromUser);
        //邮件的标题
        simpleMailMessage.setSubject(title);
        //邮件的内容
        simpleMailMessage.setText(text);
        //发送邮件
        javaMailSender.send(simpleMailMessage);
    }
}