import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ISport } from './isport';

@Injectable({
  providedIn: 'root'
})
export class SportServiceService {

  constructor(private http: HttpClient) { }
 getAllSports(){
  return this.http.get<[ISport]>("http://localhost:8080/sportService/sports/all");
  }}
