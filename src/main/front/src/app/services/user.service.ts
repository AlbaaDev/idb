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
  user?: IUser;

  //private userSubject: BehaviorSubject<User>;
  //public user: Observable<User>;

  constructor(private router: Router, private http: HttpClient) {
    //this.userSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem("user")));
    //this.user = this.userSubject.asObservable();
  }

  login(user: IUser): Observable<any> {
    return this.http.post<any>(`http://localhost:8080/${user.type}/authenticate`, user)
      .pipe(map(res => {
        this.user = res.user;
        this.isAuthenticated = true;
      }));
  }

  logout(): void {
    if (this.isAuthenticated) {
      this.http.post('http://localhost:8080/customer/logout', null)
        .subscribe(
          () => {
            this.router.navigateByUrl('home');
            this.isAuthenticated = false;
          }
        );
    }
  }

  getUser(): any {
    return this.user;
  }

  register(user: IUser) {
    return this.http.post<IUser>('http://localhost:8080/customer/register', user);
  }

  loggedIn() {
    this.http.get<boolean>('http://localhost:8080/customer/is-authenticated')
      .subscribe((value) => this.isAuthenticated = value);
  }
}
