package myapp.services;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

import io.swagger.annotations.ApiResponse;
import myapp.javaObjects.Weather;
import myapp.weatherApi.WeatherApi;


@RestController
@RequestMapping("/weatherService")
//@Api(value= "WeatherServiceApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class WeatherService {
//	EntityManager manager = EntityManagerHelper.getEntityManager();
	
	private WeatherApi weather = new WeatherApi();

	@GetMapping(value = "/city/{city}")
//	@ApiOperation("get weather with spicific id")
	@ApiResponse(code=200,message="Ok",response=WeatherApi.class)
	
	public List<Weather> getWeather(@PathVariable("city") String city)throws UnirestException {
		List<Weather> result = weather.getListWeather(city);
		//System.out.println(result);
		return result;
	}
}
