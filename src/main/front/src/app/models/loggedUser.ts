import {IUser} from "../interfaces/IUser";

class LoggedUser {
  jwt: string;
  user: IUser;

  constructor(jwt: string, user: IUser) {
    this.jwt = jwt;
    this.user = user;
  }
}
