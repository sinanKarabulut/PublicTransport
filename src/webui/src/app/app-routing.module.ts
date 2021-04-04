import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./pages/login/login.component";
import {AppLayoutComponent} from "./_layout";
import {StationComponent} from "./pages/station/station.component";
import {VehicleComponent} from "./pages/vehicle/vehicle.component";
import {StationVehicleComponent} from "./pages/station-vehicle/station-vehicle.component";

const routes: Routes = [
  {
    path: "",
    component: AppLayoutComponent,
    children: [
      {path: "station", component: StationComponent},
      {path: "vehicle", component: VehicleComponent},
      {path: "station-vehicle", component: StationVehicleComponent}

    ]}
  ,
  {path: 'login', component:LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{
    enableTracing: false

  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
