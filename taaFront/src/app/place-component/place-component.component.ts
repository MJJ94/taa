import { Component, OnInit } from '@angular/core';

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
  constructor() { }

  ngOnInit() {
   let villJean = {id:1 , itemName:"Viljean"}
   let beaulieu = {id:1 , itemName:"Beaulieu"}
   this.places = [villJean, beaulieu]
   this.dropdownSettings = { 
    singleSelection: false, 
    text:"Select Places",
    selectAllText:'Select All',
    unSelectAllText:'UnSelect All',
    enableSearchFilter: true,
    classes:"myclass custom-class"
  }; 
  }
}
