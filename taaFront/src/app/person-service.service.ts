import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PersonServiceService {

  constructor(private http: HttpClient) { }
  addPerson(firstName, lastName, email, password, selectedPlaces, selectedSports) {
    console.log("selectedPlaces: " , selectedPlaces , " selectedSports: " , selectedSports)
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'my-auth-token'
      })
    }
    return this.http.post("http://localhost:8080/personneService/personne", { "name": firstName, "lieu": selectedPlaces, "sport": selectedSports, "email": email });
  }

  getPerson() {
    return this.http.get("http://localhost:8080/personneService/3");
  }
}
