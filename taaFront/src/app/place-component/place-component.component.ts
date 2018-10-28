import { Component, OnInit } from '@angular/core';
import { PlaceServiceService } from '../place-service.service';
import { PlaceInterface } from '../place-interface';

@Component({
  selector: 'app-place-component',
  templateUrl: './place-component.component.html',
  styleUrls: ['./place-component.component.css']
})
export class PlaceComponentComponent implements OnInit {
  selectedPlaces = [];
  selectedPlace = "";
  places=[];
  dropdownSettings = {};
  constructor(private serv: PlaceServiceService) { }

  ngOnInit() {
    this.getAllPlaces()
    //this.places.push({id:1 , name:"Beaulieu"})
    console.log("places: ", this.places.length)
    this.dropdownSettings = {
      singleSelection: false,
      text: "Select Places",
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      enableSearchFilter: true,
      classes: "myclass custom-class"
    };
  }

  getAllPlaces() {
    this.serv.getAllPlaces().subscribe((data: PlaceInterface[]) => {
      this.places = data;
      console.log("data: " , this.places)
    }, err => { console.log(err.message) })
  }
}
