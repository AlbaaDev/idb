import {Component} from '@angular/core';
import {FormBuilder, Validators,} from '@angular/forms';
import {Router} from '@angular/router';
import {MustMatch} from "src/app/validators/MustMatch";
import {AccountService} from 'src/app/services/user.service';
import {Gender} from "../../enums/gender";
import {IPerson} from "../../interfaces/IPerson";
import {Person} from "../../models/person";
import {IAdress} from "../../interfaces/IAdress";
import {Adress} from "../../models/adress";
import {IContact} from "../../interfaces/IContact";
import {Contact} from "../../models/contact";
import {Customer} from "../../models/customer";
import {IAccount} from "../../interfaces/IAccount";
import {Account} from "../../models/account";
import {IUser} from "../../interfaces/IUser";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent {
  submitted = false;
  hide = true;
  hide2 = true;
  gender = Gender;

  signUpForm = this.formBuilder.group({
    firstName: ['', [Validators.required]],
    lastName: ['', [Validators.required]],
    gender: ['', [Validators.required]],
    birthDate: ['', [Validators.required]],
    street: ['', [Validators.required]],
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

  get firstName() {
    return this.signUpForm.get('firstName');
  }

  get lastName() {
    return this.signUpForm.get('lastName');
  }

  get birthDate() {
    return this.signUpForm.get('birthDate');
  }

  get genderType() {
    return this.signUpForm.get('gender');
  }

  get street() {
    return this.signUpForm.get('street');
  }

  get province() {
    return this.signUpForm.get('province');
  }

  get postCode() {
    return this.signUpForm.get('postCode');
  }

  get phoneNumber() {
    return this.signUpForm.get('phoneNumber');
  }

  get city() {
    return this.signUpForm.get('city');
  }

  get email() {
    return this.signUpForm.get('email');
  }

  get password() {
    return this.signUpForm.get('password');
  }

  get confirmPassword() {
    return this.signUpForm.get('confirmPassword');
  }

  onSubmit() {
    this.submitted = true;
    if (this.signUpForm.invalid) {
      return;
    }

    this.authService.register(this.createUser()).subscribe(() => {
      this.router.navigateByUrl('/login');
    });
  }

  createUser(): IUser {
    const adress: IAdress = new Adress(this.street?.value, this.city?.value, this.province?.value, this.postCode?.value);
    const contact: IContact = new Contact(this.phoneNumber?.value, this.email?.value);
    const person: IPerson = new Person(this.firstName?.value, this.lastName?.value, this.genderType?.value,
      adress, contact);

    const accounts: IAccount[] = [];
    const account: IAccount = new Account(10000, 8797979);
    accounts.push(account);
    //TODO switch user type
    return new Customer("customer", accounts, person, this.email?.value, this.password?.value);
  }
}
