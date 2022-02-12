import { AuthService } from './services/auth.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'IDB';
  constructor(private authService: AuthService) {  }
  isAuth() {
    return this.authService.loggedIn();
  }
}
