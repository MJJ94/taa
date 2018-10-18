import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AngularMultiSelectModule } from 'angular2-multiselect-dropdown/angular2-multiselect-dropdown';
import { AppComponent } from './app.component';
import { PlaceComponentComponent } from './place-component/place-component.component';

@NgModule({
  declarations: [
    AppComponent,
    PlaceComponentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AngularMultiSelectModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
