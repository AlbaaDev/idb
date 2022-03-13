import {IUser} from "./IUser";

interface ILoggedUser {
  jwt?: string;
  user?: IUser;
}
