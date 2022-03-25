import { Component, OnInit } from '@angular/core';
import {IUser} from "../../interfaces/IUser";

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss']
})
export class SettingsComponent implements OnInit {
  constructor() { }

  ngOnInit(): void {
    localStorage.getItem('user');
  }

}
