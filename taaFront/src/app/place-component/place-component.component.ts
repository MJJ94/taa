import { Component, OnInit } from '@angular/core';
import { PlaceServiceService } from '../place-service.service';

@Component({
  selector: 'app-place-component',
  templateUrl: './place-component.component.html',
  styleUrls: ['./place-component.component.css']
})
export class PlaceComponentComponent implements OnInit {
  selectedPlaces = [];
  selectedPlace = "";
  places = [];
  dropdownSettings = {};
  place = { id: Number, name: String }
  constructor(private serv: PlaceServiceService) { }

  ngOnInit() {
    this.places = this.getAllPlaces();
    console.log("places: ", this.places)
    let villJean = { id: 1, itemName: "Viljean" }
    let beaulieu = { id: 1, itemName: "Beaulieu" }
    //this.places = [villJean, beaulieu]
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
    let data1 = [];
    this.serv.getAllPlaces().subscribe(data => {
      console.log(data)
      data1 = data as any[];
      console.log("data1: ", data1)
      data1.forEach(element => this.places.push(element))
    }, err => { console.log(err.message) })
    return data1;
  }
}
