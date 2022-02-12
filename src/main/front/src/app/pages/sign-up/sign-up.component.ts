import { Component, OnInit } from '@angular/core';
import {
  Validators,
  FormBuilder,
} from '@angular/forms';
import { Router } from '@angular/router';
import { MustMatch } from "src/app/validators/MustMatch";
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  submitted = false;
  hide  = true;
  hide2 = true;

  signUpForm = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(6)]],
    confirmPassword: ['', [Validators.required]],
  }, {
    validators: MustMatch('password', 'confirmPassword')
  });

  constructor(private router: Router, private authService: AuthService,
              private formBuilder: FormBuilder) {
  }


  ngOnInit(): void {};

  onSubmit() {
    this.submitted = true;
    if(this.signUpForm.invalid) {
      return;
    }
    var email = this.signUpForm.get('email')!.value;
    var password = this.signUpForm.get('password')!.value;
    this.authService.register(email, password).subscribe(() => {
        this.router.navigateByUrl('/login');
      });
  }

  get f() { return this.signUpForm.controls; }
  get email() { return this.signUpForm.get('email'); }
  get password() { return this.signUpForm.get('password'); }
  get confirmPassword() { return this.signUpForm.get('confirmPassword'); }
}
