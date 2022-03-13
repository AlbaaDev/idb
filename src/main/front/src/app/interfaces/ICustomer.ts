import {IAccount} from "./IAccount";
import {IAdviser} from "./IAdviser";
import {IPerson} from "./IPerson";
import {IUser} from "./IUser";

export interface ICustomer extends IUser {
  accounts?: IAccount[];
  adviser?: IAdviser;
  person: IPerson;
}
