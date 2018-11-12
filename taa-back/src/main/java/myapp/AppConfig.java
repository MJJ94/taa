package myapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import myapp.scheduler.Schedulerapp;

@Configuration
@EnableScheduling
public class AppConfig {
	
	@Bean
	public Schedulerapp task() {
		return new Schedulerapp();
		
	}

}
