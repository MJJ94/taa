package myapp.javaObjects;

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

}
