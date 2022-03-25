import {IUser} from "../interfaces/IUser";

class LoggedUser {
  accessToken: string;
  user: IUser;

  constructor(accessToken: string, user: IUser) {
    this.accessToken = accessToken;
    this.user = user;
  }
}
