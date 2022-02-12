import { MatSidenav } from '@angular/material/sidenav';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SidenavService {
  private sidenav?: MatSidenav;

  constructor() { }

  public setSidenav(sidenav: MatSidenav) {
    this.sidenav = sidenav;
  }

  public open() {
      return this.sidenav?.open();
  }

  public close() {
      return this.sidenav?.close();
  }

  public toggle(): void {
    this.sidenav?.toggle();
  }
}
