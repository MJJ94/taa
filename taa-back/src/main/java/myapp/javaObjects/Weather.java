package myapp.javaObjects;
import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class Weather {

	private String main;
	private double temp;

	public Weather() {
	}

	public Weather(String main, double temp) {
		super();
		this.main = main;
		this.temp = temp;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}
	
	public Integer getDaysNumber(Integer day) {
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(day);
		return 9 - dayOfWeek;
	}
	
	public Integer getDaysNumber() {
		Calendar cal = Calendar.getInstance();
		Integer dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return getDaysNumber(dayOfWeek);
	}

}
