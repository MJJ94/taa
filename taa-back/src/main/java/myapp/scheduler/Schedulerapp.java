package myapp.scheduler;

import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mashape.unirest.http.exceptions.UnirestException;

import myapp.dao.PersonDao;
import myapp.javaObjects.Person;
import myapp.javaObjects.Sport;
import myapp.javaObjects.Weather;
import myapp.weatherApi.WeatherApi;

@Component
public class Schedulerapp {

	@Autowired
	private PersonDao personDao;

	@Autowired
	private WeatherApi weatherApi;

	@Autowired
	private Weather weather;

	@Autowired
	private JavaMailSender emailSender;

	 @Scheduled(cron = "0 0 0 * * TUE" )
	 /**
	  * 
	  * pour les tests
	  */
//	 @Scheduled(cron = "0 * * * * *" )
	public void work() throws UnirestException {

		List<Person> persons = personDao.findAll();

		for (Person p : persons) {

			List<Weather> weathers = weatherApi.getListWeather(p.getPlace().getItemName(),
					weather.getDaysNumber(Calendar.TUESDAY));
			String content = emailContent(weathers, p);
			sendSimpleMessage(p.getEmail(), "Weekend organiser", content);

		}
	}

	private String emailContent(List<Weather> weekendWeather, Person p) {
		List<Sport> sports = p.getSports();
		Weather saturdayWeather = weekendWeather.get(0);
		Weather sundayWeather = weekendWeather.get(1);
		String saturdayResult = "In "+ p.getPlace().getItemName() + " the weather state for saturday is " + saturdayWeather.getMain().toLowerCase()
				+ " our sports selection are : ";
		String sundayResult = "and for sunday the weather state is " + sundayWeather.getMain().toLowerCase()
				+ " our sports selection are : ";
		String result = "Dear " + p.getFirstName() + " " + p.getLastName() + "," + "\n \n";

		if ((saturdayWeather.getMain().equals("Rain")) || (saturdayWeather.getMain().equals("Snow"))) {
			for (Sport sport : p.getSports()) {
				if (sport.getCovered() == 1) {
					saturdayResult += "(" + sport.getItemName() + ")" + " ";
				}
			}
		} else {
			for (Sport sport : sports) {
				saturdayResult += "(" + sport.getItemName() + ")" + " ";
			}
		}

		if ((sundayWeather.getMain().equals("Rain")) || (sundayWeather.getMain().equals("Snow"))) {
			for (Sport sport : sports) {
				if (sport.getCovered() == 1) {
					sundayResult += "(" + sport.getItemName() + ")" + " ";
				}
			}
		} else {
			for (Sport sport : sports) {
				sundayResult += "(" + sport.getItemName() + ")" + " ";
			}
		}

		result += saturdayResult + "\n" + sundayResult + "\n \n" + "Thanks for using our services";

		return result;
	}

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
