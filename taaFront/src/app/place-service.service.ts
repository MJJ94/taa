import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PlaceServiceService {

  constructor(private http: HttpClient) { }
 getAllPlaces(){
  return this.http.get("http://localhost:8080/lieuService/lieux");
  }
}
