/*
import {Injectable} from "@angular/core"; //injectable
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";

/!**
 * bütün requestlerde ilk önce buraya girer gönderilen  isteklerde headera tokenı ekler
 * localstorage da current user var ise token boş değil ise requeste ekler
 *!/
@Injectable()
export class JwtInterceptor implements HttpInterceptor{
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    debugger;
     let currentUser = JSON.parse(localStorage.getItem("currentUser"));
     if(currentUser && currentUser.token){
       req = req.clone({
          setHeaders :{
            Authorization : 'Bearer ${currentUser.token}'
          }
       });
     }
     return next.handle(req);
  }


}
*/
import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // add authorization header with jwt token if available
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    if (currentUser && currentUser.token) {
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${currentUser.token}`
        }
      });
    }

    return next.handle(request);
  }
}
