package myapp.scheduler;

import java.util.List;
import java.util.Properties;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import myapp.dao.PersonDao;
import myapp.javaObjects.Person;




@Component
public class Schedulerapp {

	@Autowired
	PersonDao personDao;
	
	
	
	
	

	//@Scheduled(cron = "0 0 0 * * TUE" )
	@Scheduled(cron = "0 * * * * *" )
	public void work() {
		
		List<Person> persons =  personDao.findAll();
		
		for(Person p:persons) {
			
		sendSimpleMessage(p.getEmail(), "test", "text");
		
		}
		
	
	}
	

		@Autowired
		public JavaMailSender emailSender;

		public void sendSimpleMessage(String to, String subject, String text) {

			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(to);
			message.setSubject(subject);
			message.setText(text);
			emailSender.send(message);
		}

		@Bean
		public JavaMailSender getJavaMailSender() {
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			mailSender.setHost("smtp.gmail.com");
			mailSender.setPort(587);

			mailSender.setUsername("projettaa.gli@gmail.com");
			mailSender.setPassword("taagli2018");

			Properties props = mailSender.getJavaMailProperties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.debug", "true");

			return mailSender;
		}


	}
