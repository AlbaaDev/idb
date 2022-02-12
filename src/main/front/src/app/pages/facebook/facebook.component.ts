import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-facebook',
  templateUrl: './facebook.component.html',
  styleUrls: ['./facebook.component.scss']
})
export class FacebookComponent implements OnInit {
  searchForm: FormGroup;
  constructor(private formBuilder: FormBuilder) {
    this.searchForm = this.formBuilder.group({search : ['', [Validators.required]]});
  }

  ngOnInit(): void {
  }
  onSubmit() {
    return true;
  }
}
