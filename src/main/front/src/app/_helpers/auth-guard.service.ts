import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Injectable} from "@angular/core";
import { Observable } from "rxjs";
import {AccountService} from "../services/user.service";

@Injectable({providedIn: 'root'})
export class AuthGuard implements CanActivate {

  constructor(public accountService: AccountService, public router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (!this.accountService.loggedIn()) {
      this.router.navigate(['login']);
      return false;
    }
    return true;
  }
}
