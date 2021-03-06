import { Component, OnInit } from '@angular/core';
import { Iperson } from '../iperson';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonServiceService } from '../person-service.service';
import { WeatherServiceService } from '../weather-service.service';
import { IWeather } from '../iweather';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user: Iperson
  saturdaySports = [];
  sundaySports = []
  saturday: IWeather
  sunday: IWeather
  constructor(private activatedRoute: ActivatedRoute, private personService: PersonServiceService, private router: Router, private weatherService: WeatherServiceService) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.paramMap.get('id')
    this.personService.findPersonById(id).subscribe(
      (res: Iperson) => {
        this.user = res
        this.weatherService.getWeather(res.place.itemName).subscribe(
          (res: IWeather[]) => {
            this.saturday = res[0];
            this.sunday = res[1];
            if ((this.saturday.main === "Rain") || (this.saturday.main === "Snow")) {
              this.user.sports.map((sport) => {
                if (sport.covered === 1) {
                  this.saturdaySports.push({ itemName: sport.itemName })
                }
              })
            } else {
              this.saturdaySports = this.user.sports
            }
            if (this.sunday.main === "Rain" || (this.saturday.main === "Snow")) {
              this.user.sports.map((sport) => {
                if (sport.covered === 1) {
                  this.sundaySports.push({ itemName: sport.itemName })
                }
              })
            } else {
              this.sundaySports = this.user.sports
            }
          }
        )
      }
    )
  }

  logOutHandler() {
    this.router.navigate(['/home'])
  }

  editHandler() {
    console.log(this.user);
    this.router.navigate(['/edit-account', this.user.id])
  }

}
