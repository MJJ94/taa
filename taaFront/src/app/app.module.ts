import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AngularMultiSelectModule } from 'angular2-multiselect-dropdown/angular2-multiselect-dropdown';
import { AppComponent } from './app.component';
import { PlaceComponentComponent } from './place-component/place-component.component';
import { SportComponentComponent } from './sport-component/sport-component.component';
import { HttpClientModule } from '@angular/common/http';
@NgModule({
  declarations: [
    AppComponent,
    PlaceComponentComponent,
    SportComponentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AngularMultiSelectModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
