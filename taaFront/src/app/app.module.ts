import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AngularMultiSelectModule } from 'angular2-multiselect-dropdown/angular2-multiselect-dropdown';
import { AppComponent } from './app.component';
import { PlaceComponentComponent } from './place-component/place-component.component';
import { SportComponentComponent } from './sport-component/sport-component.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponentComponent } from './login-component/login-component.component';
import { NewAccountComponentComponent } from './new-account-component/new-account-component.component';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './main/main.component';
const appRoutes: Routes = [
  { path: 'home', component: MainComponent},
  { path: 'new-account', component: NewAccountComponentComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
]
@NgModule({
  declarations: [
    AppComponent,
    PlaceComponentComponent,
    SportComponentComponent,
    LoginComponentComponent,
    NewAccountComponentComponent,
    MainComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AngularMultiSelectModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
