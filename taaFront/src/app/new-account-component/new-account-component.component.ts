import { Component, OnInit } from '@angular/core';
import { NewAccountService } from '../new-account.service';
import { PlaceServiceService } from '../place-service.service';
import { PlaceInterface } from '../place-interface';
import { SportServiceService } from '../sport-service.service';
import { ISport } from '../isport';
import { PersonServiceService } from '../person-service.service';

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
  selectedPlaces = [];
  selectedPlace = "";
  places=[];
  placeDropdownSettings = {};
  selectedSports = [];
  selectedSport = "";
  sports = [];
  sportDropdownSettings = {};
  constructor(private personService:PersonServiceService, private placeService: PlaceServiceService, private sportService:SportServiceService) { }

  handleSignUp() {
    this.personService.addPerson().subscribe(
      response => console.log("resp: " , response),
      err => console.log("err: " , err)
    )
    if ((this.firstName.length > 0) && (this.lastName.length > 0) && (this.email.length > 0) && (this.password.length > 0)) {
      console.log("working")
    }
  }

  ngOnInit() {
    this.getAllPlaces()
    this.getAllSports()
    //this.places.push({id:1 , name:"Beaulieu"})
    this.placeDropdownSettings = {
      singleSelection: false,
      text: "Select Places",
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
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
      console.log("data: " , this.places)
    }, err => { console.log(err.message) })
  }

  getAllSports() {
    this.sportService.getAllSports().subscribe((data: ISport[]) => {
      this.sports = data;
      console.log("data: " , this.sports)
    }, err => { console.log(err.message) })
  }

}
