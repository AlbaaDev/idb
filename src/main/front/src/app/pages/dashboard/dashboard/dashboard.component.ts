import { Component, OnInit, ViewChild } from '@angular/core';
import { AccountService } from 'src/app/services/user.service';
import { MatSidenav } from '@angular/material/sidenav';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  @ViewChild('sidenav') public sidenav?: MatSidenav;

  constructor(private authService: AccountService) { }
  ngOnInit(): void { }
  isAuth() {
    return this.authService.loggedIn();
  }
}
