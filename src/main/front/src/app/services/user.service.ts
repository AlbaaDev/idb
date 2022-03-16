import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {map} from "rxjs/operators";
import {Observable} from "rxjs";
import {IUser} from "../interfaces/IUser";

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  isAuthenticated: boolean = false;
  //private userSubject: BehaviorSubject<User>;
  //public user: Observable<User>;

  constructor(private router: Router, private http: HttpClient) {
    //this.userSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem("user")));
    //this.user = this.userSubject.asObservable();
  }

  login(user: IUser): Observable<any> {
    return this.http.post<any>('http://localhost:8080/customers/authenticate', user)
      .pipe(map(res => {
        localStorage.setItem('jwt', res.jwt);
        localStorage.setItem('loggedUser', JSON.stringify(res.loggedUser));
    }));
  }

  logout() {
    if (this.loggedIn()) {
      localStorage.removeItem('jwt');
      this.router.navigateByUrl('');
    }
  }

  getUser(): any {
    return localStorage.getItem('loggedUser');
  }

  register(user: IUser) {
    return this.http.post<{ jwt: string }>('http://localhost:8080/customers/register', user);
  }

  loggedIn(): boolean {
    return localStorage.getItem('jwt') !== null;
  }
}
