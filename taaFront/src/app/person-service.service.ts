import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PersonServiceService {

  constructor(private http: HttpClient) { }
  addPerson(firstName, lastName, email, password, selectedPlace, selectedSports) {
    console.log("selectedPlaces: ", selectedPlace, " selectedSports: ", selectedSports)
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'my-auth-token'
      })
    }
    return this.http.post("http://localhost:8080/personService/person", { "firstName": firstName, "lastName": lastName, "place": selectedPlace, "sports": selectedSports, "email": email, "password": password });
  }

  updatePerson(firstName, lastName, email, password, selectedPlace, selectedSports, id) {
    console.log("selectedPlaces: ", selectedPlace, " selectedSports: ", selectedSports)
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'my-auth-token'
      })
    }
    return this.http.post("http://localhost:8080/personService/person", { "id": id, "firstName": firstName, "lastName": lastName, "place": selectedPlace, "sports": selectedSports, "email": email, "password": password });
  }

  findPersonByEmail(email) {
    return this.http.get("http://localhost:8080/personService/email/" + email);
  }

  findPersonById(id) {
    return this.http.get("http://localhost:8080/personService/" + id);
  }
}
