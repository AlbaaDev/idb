import {Component, OnInit} from '@angular/core';
import {AccountService} from '../../services/user.service';

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
    if (this.accountService.user) {
      this.firstName = this.accountService.user.email;
    }
  }

  isAuth() {
    return this.accountService.isAuthenticated;
  }

  logout() {
    this.accountService.logout();
  }
}
