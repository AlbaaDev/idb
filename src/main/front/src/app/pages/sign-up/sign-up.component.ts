import { Component, OnInit } from '@angular/core';
import {
  Validators,
  FormBuilder,
} from '@angular/forms';
import { Router } from '@angular/router';
import { MustMatch } from "src/app/validators/MustMatch";
import { AccountService } from 'src/app/services/user.service';
import {Gender} from "../../enums/gender";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  submitted = false;
  hide  = true;
  hide2 = true;

  gender = Gender;

  signUpForm = this.formBuilder.group({
    firstName: ['', [Validators.required]],
    lastName: ['', [Validators.required]],
    gender: ['', [Validators.required]],
    adress: ['', [Validators.required]],
    city: ['', [Validators.required]],
    province: ['', [Validators.required]],
    postCode: ['', [Validators.required]],
    email: ['', [Validators.required, Validators.email]],
    phoneNumber: ['', [Validators.required]],
    password: ['', [Validators.required, Validators.minLength(6)]],
    confirmPassword: ['', [Validators.required]],
  }, {
    validators: MustMatch('password', 'confirmPassword')
  });

  constructor(private router: Router, private authService: AccountService,
              private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {};

  onSubmit() {
    this.submitted = true;
    if(this.signUpForm.invalid) {
      return;
    }
    this.authService.register(this.signUpForm.value).subscribe(() => {
        this.router.navigateByUrl('/login');
      });
  }

  get firstName() { return this.signUpForm.get('firstName'); }
  get lastName() { return this.signUpForm.get('lastName'); }
  get adress() { return this.signUpForm.get('adress'); }
  get province() { return this.signUpForm.get('province'); }
  get postCode() { return this.signUpForm.get('postCode'); }
  get phoneNumber() { return this.signUpForm.get('phoneNumber'); }
  get city() { return this.signUpForm.get('city'); }
  get email() { return this.signUpForm.get('email'); }
  get password() { return this.signUpForm.get('password'); }
  get confirmPassword() { return this.signUpForm.get('confirmPassword'); }
}
