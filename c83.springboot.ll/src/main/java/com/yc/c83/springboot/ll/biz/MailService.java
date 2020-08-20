package com.yc.c83.springboot.ll.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService  {
	@Autowired
	private JavaMailSender mailSender;
	//从spring的配置文件中获取一个配置值
	@Value("${mail.fromMail.addr}")
	 private String from;
	/*
	 *   to    接收者的邮箱
	 *   subject  主题
	 *   content   内容
	 * 
	 * */
	 public void sendSimplelMail(String to, String subject, String content) {
		 SimpleMailMessage message=new SimpleMailMessage();
		 message.setFrom(from);
		 message.setTo(to);
		//邮件主题
		 message.setSubject(subject);
		 message.setText(content);
		 mailSender.send(message);
		 
	 }
	
	
	

	
}
