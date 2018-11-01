import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class NewAccountService {

  constructor(private http: HttpClient) { }
  addPerson() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })}
    return this.http.post("http://localhost:8080/personneService/personne",{"name":"foz", "lieux":[], "sports":[], "email":"siazjaji"}, httpOptions);
  }

  getPerson(){
    return this.http.get("http://localhost:8080/personneService/3");
  }
}
