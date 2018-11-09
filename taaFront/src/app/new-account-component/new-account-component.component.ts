import { Component, OnInit } from '@angular/core';
import { PlaceServiceService } from '../place-service.service';
import { PlaceInterface } from '../place-interface';
import { SportServiceService } from '../sport-service.service';
import { ISport } from '../isport';
import { PersonServiceService } from '../person-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-account-component',
  templateUrl: './new-account-component.component.html',
  styleUrls: ['./new-account-component.component.css']
})
export class NewAccountComponentComponent implements OnInit {
  firstName = '';
  lastName = '';
  email = '';
  password = '';
  selectedPlace: PlaceInterface[];
  places: PlaceInterface[];
  placeDropdownSettings = {};
  selectedSports: ISport[];
  sports: ISport[];
  sportDropdownSettings = {};
  constructor(private personService: PersonServiceService, private placeService: PlaceServiceService, private sportService: SportServiceService, private router: Router) { }

  handleSignUp() {
    if ((this.firstName.length > 0) && (this.lastName.length > 0) && (this.email.length > 0) && (this.password.length > 0)) {
      console.log("place: " , this.selectedPlace[0])
      this.personService.addPerson(this.firstName, this.lastName, this.email, this.password, this.selectedPlace[0], this.selectedSports).subscribe(
        response => this.router.navigateByUrl(""),
        err => console.log("err: ", err)
      )
    }
  }

  ngOnInit() {
    this.getAllPlaces()
    this.getAllSports()
    this.placeDropdownSettings = {
      singleSelection: true,
      text: "Select Place",
      enableSearchFilter: true,
      classes: "myclass custom-class"
    };
    this.sportDropdownSettings = {
      singleSelection: false,
      text: "Select Sports",
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      enableSearchFilter: true,
      classes: "myclass custom-class"
    };
  }


  getAllPlaces() {
    this.placeService.getAllPlaces().subscribe((data: PlaceInterface[]) => {
      this.places = data;
      console.log("data: ", this.places)
    }, err => { console.log(err.message) })
  }

  getAllSports() {
    this.sportService.getAllSports().subscribe((data: ISport[]) => {
      this.sports = data;
      console.log("data: ", this.sports)
    }, err => { console.log(err.message) })
  }

}
