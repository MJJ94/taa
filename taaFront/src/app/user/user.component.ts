import { Component, OnInit } from '@angular/core';
import { Iperson } from '../iperson';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonServiceService } from '../person-service.service';
import { PlaceInterface } from '../place-interface';
import { ISport } from '../isport';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user: Iperson
  constructor(private activatedRoute: ActivatedRoute, private personService: PersonServiceService, private router: Router) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.paramMap.get('id')
    this.personService.findPersonById(id).subscribe(
      (res: Iperson) => {
        this.user = res
        console.log("sports: " , this.user)
      }
    )
  }

  /*
  createTableValues() {
    if (this.user.place.length > this.user.sport.length) {
      this.user.place.map((element) => {
        this.values.push({ place: element.name })
      })
      for (let i = 0; i < this.user.sport.length; i++) {
        this.values[i].sport = this.user.sport[i].name
      }
    } else {
      this.user.sport.map((element) => {
        this.values.push({ sport: element.name })
      })
      for (let i = 0; i < this.user.place.length; i++) {
        this.values[i].place = this.user.place[i].name
      }
    }


  }
*/
  logOutHandler() {
    this.router.navigate(['/home'])
  }

}
