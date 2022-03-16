import {IUser} from "../interfaces/IUser";

export class User implements IUser {
  email: string;
  password: string;
  type: string;

  constructor(email: string, password: string, type: string) {
    this.email = email;
    this.password = password;
    this.type = type;
  }
}
