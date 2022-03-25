import {AccountService} from 'src/app/services/user.service';
import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {User} from "../../../models/user";
import {IUser} from "../../../interfaces/IUser";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  hide = true;
  submitted = false;


  loginForm: FormGroup = new FormGroup(
    {
      email: new FormControl(''),
      password: new FormControl(''),
    }
  );

  constructor(private router: Router, private formBuilder: FormBuilder,
              private authService: AccountService) {
  }

  get email() {
    return this.loginForm.get('email');
  }

  get password() {
    return this.loginForm.get('password');
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }

  onSubmit() {
    this.submitted = true;
    var email = this.email?.value;
    var password = this.password?.value;
    if (this.loginForm.invalid) {
      return;
    }

    const user: IUser = new User(email, password, "customer");
    this.authService.login(user).subscribe(
      () => {
        this.authService.isAuthenticated = true;
        this.router.navigateByUrl('/account');
      });
  }
}
