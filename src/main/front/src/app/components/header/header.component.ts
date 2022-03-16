import { Component, OnInit } from '@angular/core';
import { AccountService } from '../../services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  opened = true;
  firstName?: string;
  lastName?: string;
  constructor(private accountService: AccountService) {}

  ngOnInit(): void {
    if (localStorage.getItem("loggedUser")) {
      this.firstName = JSON.parse(localStorage.getItem("loggedUser") as string).firstName;
      this.lastName = JSON.parse(localStorage.getItem("loggedUser") as string).lastName;
    }
  }

  isAuth() {
    return this.accountService.loggedIn();
  }

  logout() {
    this.accountService.logout();
  }
}
