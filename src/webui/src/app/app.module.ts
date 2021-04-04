import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StationVehicleComponent } from './pages/station-vehicle/station-vehicle.component';
import {VehicleComponent} from "./pages/vehicle/vehicle.component";
import {StationComponent} from "./pages/station/station.component";
import {AppLayoutComponent, FooterComponent, HeaderComponent, SidebarComponent} from "./_layout";
import {LoginComponent} from "./pages/login/login.component";
import {VehicleModule} from "./pages/vehicle/vehicle.module";
import {StationModule} from "./pages/station/station.module";
import {StationVehicleModule} from "./pages/station-vehicle/station-vehicle.module";

@NgModule({
  declarations: [
    AppComponent,
    AppLayoutComponent,
    FooterComponent,
    HeaderComponent,
    SidebarComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    VehicleModule,
    StationModule,
    StationVehicleModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
