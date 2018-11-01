import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {
  login = "";
  password = "";
  constructor(private router:Router, private activatedRoute: ActivatedRoute) { }
  handleSignIn() {
    console.log("submit")
  }
  handleSignUp(){
    console.log("new account")
    this.router.navigate(['/new-account']);
  }
  ngOnInit() {
  }

}
