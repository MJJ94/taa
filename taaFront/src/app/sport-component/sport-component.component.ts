import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sport-component',
  templateUrl: './sport-component.component.html',
  styleUrls: ['./sport-component.component.css']
})
export class SportComponentComponent implements OnInit {
  selectedSports = [];
  selectedSport = "";
  sports = [];
  dropdownSettings = {};
  constructor() { }

  ngOnInit() {
    let basket = { id: 1, itemName: "basket-ball" }
    let foot = { id: 2, itemName: "foot-ball" }
    this.sports = [basket, foot]
    this.dropdownSettings = {
      singleSelection: false,
      text: "Select Sport",
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      enableSearchFilter: true,
      classes: "myclass custom-class"
    };
  }

}
