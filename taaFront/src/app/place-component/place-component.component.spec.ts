import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlaceComponentComponent } from './place-component.component';

describe('PlaceComponentComponent', () => {
  let component: PlaceComponentComponent;
  let fixture: ComponentFixture<PlaceComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlaceComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlaceComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
