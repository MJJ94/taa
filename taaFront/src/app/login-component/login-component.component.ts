import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { PersonServiceService } from '../person-service.service';
import { Iperson } from '../iperson';
import { routerNgProbeToken } from '@angular/router/src/router_module';


@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {
  email = "";
  password ="";
  person: Iperson
  wrongPassword: boolean = false;
  wrongEmail: boolean = false;
  constructor(private router: Router, private personService: PersonServiceService) { }
  ngOnInit() {
  }
    handleSignIn() {
    console.log("submit " + this.password)
    if (this.email.length > 0) {
      this.personService.findPersonByEmail(this.email).subscribe(
        (res:Iperson) => {
          if(res === null){
            console.log("wrong email")
            this.wrongEmail = true;
          }
          if(this.password === res.password){
            this.router.navigate(['/user', res.id])
          }else {
            console.log("wrong password")
            this.wrongEmail = false;
            this.wrongPassword = true;
          }
        },
        err => { console.log(err.message) }
      )
    }
  }
  handleSignUp() {
    console.log("new account")
    this.router.navigate(['/new-account']);
  }
}
