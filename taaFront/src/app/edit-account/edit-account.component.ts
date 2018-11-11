import { Component, OnInit } from '@angular/core';
import { PlaceServiceService } from '../place-service.service';
import { PlaceInterface } from '../place-interface';
import { SportServiceService } from '../sport-service.service';
import { ISport } from '../isport';
import { PersonServiceService } from '../person-service.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Iperson } from '../iperson';
@Component({
  selector: 'app-edit-account',
  templateUrl: './edit-account.component.html',
  styleUrls: ['./edit-account.component.css']
})
export class EditAccountComponent implements OnInit {
  firstName = '';
  lastName = '';
  email: String = '';
  password: String = '';
  selectedPlace: PlaceInterface[] = [];
  places: PlaceInterface[];
  placeDropdownSettings = {};
  selectedSports: ISport[] = [];
  sports: ISport[] = [];
  sportDropdownSettings = {};
  user: Iperson;
  constructor(private activatedRoute: ActivatedRoute, private personService: PersonServiceService, private placeService: PlaceServiceService, private sportService: SportServiceService, private router: Router) { }

  editHandler() {
    if ((this.email.length > 0) && (this.password.length > 0)) {
      console.log("place: ", this.selectedPlace[0])
      this.personService.updatePerson(this.user.firstName, this.user.lastName, this.email, this.password, this.selectedPlace[0], this.selectedSports, this.user.id).subscribe(
        response => this.router.navigate(['/user', this.user.id]),
        err => console.log("err: ", err)
      )
    }
  }

  cancelHandler(){
    this.router.navigate(['/user', this.user.id])
  }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.paramMap.get('id')
    this.personService.findPersonById(id).subscribe((res: Iperson) => {
      console.log("babababab");
      this.user = res;
      this.email = this.user.email;
      this.password = this.user.password;
      console.log(this.user.sports[0].name)
      this.selectedPlace.push(this.user.place);
      this.user.sports.map((sport) => {
        this.selectedSports.push({id:sport.id, name:sport.name, covered:sport.covered})
      })
    })
    this.getAllPlaces()
    this.getAllSports()
    this.personService.findPersonById
    this.placeDropdownSettings = {
      singleSelection: true,
      text: "Select City",
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
    }, err => { console.log(err.message) })
  }

  getAllSports() {
    this.sportService.getAllSports().subscribe((data: ISport[]) => {
      this.sports = data;
    }, err => { console.log(err.message) })
  }
}
