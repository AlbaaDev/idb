import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import {map} from "rxjs/operators";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment.prod";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isAuthenticated: boolean = false;

  constructor(private router: Router, private http: HttpClient) {}

  login(email: string, password: string) : Observable<any>{
      return this.http.post<{jwt: string}>(environment.apiUrl + 'users/authenticate',
                     {email, password}).pipe(map(res => {
            localStorage.setItem('jwt', res.jwt);
      }));
  }

  logout() {
    if (this.loggedIn()) {
      localStorage.removeItem('jwt');
      this.router.navigateByUrl('/home');
    }
  }

  register(email: string, password: string) {
    return this.http.post<{jwt: string}>(environment.apiUrl + 'users/register',
      {email, password});
  }

  loggedIn(): boolean{
    return localStorage.getItem('jwt') !==  null;
  }
}
