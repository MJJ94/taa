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
    return this.http.post("http://localhost:8080/personService/person", { "firstName": firstName,"lastName":lastName, "place": selectedPlaces, "sport": selectedSports, "email": email, "password": password });
  }

  findPersonByEmail(email) {
    return this.http.get("http://localhost:8080/personService/email/" + email);
  }

  findPersonById(id){
    return this.http.get("http://localhost:8080/personService/" + id);
  }
}
