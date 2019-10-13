package com.kk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMailsApplicationTests {

	@Autowired
	JavaMailSenderImpl javaMailSender;

	@Test
	public void sendSimpleMail() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setSubject("重要指示");
		simpleMailMessage.setText("今晚打老虎!!!");
		simpleMailMessage.setTo("18019915762@163.com");
		simpleMailMessage.setFrom("2437752322@qq.com");
		javaMailSender.send(simpleMailMessage);
	}


	@Test
	public  void sendMimeMail() throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

		mimeMessageHelper.setTo("18019915762@163.com");
		mimeMessageHelper.setFrom("2437752322@qq.com");

		mimeMessageHelper.setSubject("党中央重要指示");

		mimeMessageHelper.setText("<b style='color:red'>今晚7点打老虎</b>",true);

		mimeMessageHelper.addAttachment("1.png",new File("C:/Users/王骏康/Desktop/个人文件/考虫/听力2/1.png"));
		mimeMessageHelper.addAttachment("2.png",new File("C:/Users/王骏康/Desktop/个人文件/考虫/听力2/2.png"));

		javaMailSender.send(mimeMessage);

	}



}
