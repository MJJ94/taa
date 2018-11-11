package myapp.weatherApi;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import myapp.javaObjects.Weather;

@Component
public class WeatherApi {
	public WeatherApi() {
	}

	private String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?q={city},{countryCode}&cnt={daysNumber}&units={unit}&appid={appId}";
	private String appId = "660a011eacb537501d74bc02816b6d06";

	public JSONArray getWeather(String city, Integer days) throws UnirestException {
		String daysNumber = days.toString();
		HttpResponse<JsonNode> response = Unirest.get(apiUrl).routeParam("city", city)
				.routeParam("countryCode", "fr").routeParam("daysNumber", daysNumber).routeParam("unit", "metric").routeParam("appId", appId).asJson();
		JSONArray result = response.getBody().getObject().getJSONArray("list");
		return result;
	}

	public List<Weather> getListWeather(String city, Integer days) throws UnirestException {
		JSONArray array = getWeather(city, days);
		List<Weather> result = new ArrayList<>();
		for (int i = array.length()-2; i < array.length(); i++) {
			JSONObject obj = (JSONObject) array.get(i);
			double temp = obj.getJSONObject("main").getDouble("temp");
			JSONObject weatherJson = (JSONObject)obj.getJSONArray("weather").get(0);
			String state = weatherJson.getString("main");
			result.add(new Weather(state, temp));

		}
		return result;
	}
}
