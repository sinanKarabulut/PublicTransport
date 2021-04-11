import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {catchError} from "rxjs/operators";
import {of} from 'rxjs';
import {environment} from "../../environments/environment"

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) {
  }

  private httpOptions = {
    headers:new HttpHeaders(
      {
        'Content-Type' : 'application/json'
      }
    )
  }


  get(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.get(environment.API_BASE_PATH + path, {params}).pipe(
      //hata gelirse pipe girer
      catchError(this.formatError)
    );
  }

  post(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.post(environment.API_BASE_PATH + path, params,this.httpOptions).pipe(
      //hata gelirse pipe girer
      catchError(this.formatError)
    );
  }

  put(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.put(environment.API_BASE_PATH + path, JSON.stringify(params),this.httpOptions).pipe(
      //hata gelirse pipe girer
      catchError(this.formatError)
    );
  }

  delete(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http.delete(environment.API_BASE_PATH + path, {params}).pipe(
      //hata gelirse pipe girer
      catchError(this.formatError)
    );
  }

  private formatError(error: any) {
    return of(error.error);
  }
}
