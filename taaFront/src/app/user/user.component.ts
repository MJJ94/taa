import { Component, OnInit } from '@angular/core';
import { Iperson } from '../iperson';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonServiceService } from '../person-service.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  person: Iperson
  constructor(private activatedRoute: ActivatedRoute, private personService: PersonServiceService, private router: Router) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.paramMap.get('id')
    this.personService.findPersonById(id).subscribe(
      (res: Iperson) => { this.person = res }
    )
  }

  logOutHandler() {
    this.router.navigate(['/home'])
  }

}
