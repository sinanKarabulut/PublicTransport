import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./pages/login/login.component";
import {AppLayoutComponent} from "./_layout";
import {StationComponent} from "./pages/station/station.component";
import {VehicleComponent} from "./pages/vehicle/vehicle.component";
import {StationVehicleComponent} from "./pages/station-vehicle/station-vehicle.component";
import {RegisterComponent} from "./register/register.component";
import {NotfoundComponent} from "./shared/notfound/notfound.component";
import {AuthGuard} from "./security/auth-guard";

const routes: Routes = [
  {
    path: "",
    component: AppLayoutComponent,canActivate: [AuthGuard],
    children: [
      {path: "station", component: StationComponent},
      {path: "vehicle", component: VehicleComponent},
      {path: "station-vehicle", component: StationVehicleComponent}

    ]}
  ,
  {path: 'login', component:LoginComponent},
  {path: 'register', component:RegisterComponent},
  {path: '**', component: NotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{
    enableTracing: false

  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
