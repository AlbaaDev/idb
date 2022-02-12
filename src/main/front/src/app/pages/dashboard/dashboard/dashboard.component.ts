import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { SidenavService } from 'src/app/services/sidenav.service';
import { MatSidenav } from '@angular/material/sidenav';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit, AfterViewInit {
  @ViewChild('sidenav') public sidenav?: MatSidenav;

  constructor(private authService: AuthService, private sidenavService: SidenavService) { }
  ngAfterViewInit(): void {
    this.sidenavService.setSidenav(this.sidenav as MatSidenav);
  }
  ngOnInit(): void { }
  isAuth() {
    return this.authService.loggedIn();
  }
}
