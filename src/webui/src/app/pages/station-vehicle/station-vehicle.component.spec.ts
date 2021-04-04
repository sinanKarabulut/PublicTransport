import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StationVehicleComponent } from './station-vehicle.component';

describe('StationVehicleComponent', () => {
  let component: StationVehicleComponent;
  let fixture: ComponentFixture<StationVehicleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StationVehicleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StationVehicleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
