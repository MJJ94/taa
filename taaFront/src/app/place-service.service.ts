import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {PlaceInterface} from './place-interface'
@Injectable({
  providedIn: 'root'
})
export class PlaceServiceService {

  constructor(private http: HttpClient) { }
 getAllPlaces(){
  return this.http.get<[PlaceInterface]>("http://localhost:8080/lieuService/lieux");
  }
}
