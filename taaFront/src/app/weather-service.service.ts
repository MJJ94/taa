import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IWeather } from './iweather';

@Injectable({
  providedIn: 'root'
})
export class WeatherServiceService {

  constructor(private http: HttpClient) { }

  getWeather(cityName) {
    return this.http.get<IWeather[]>("http://localhost:8080/weatherService/city/" + cityName);
  }
}
