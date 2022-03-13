import {IPerson} from "../interfaces/IPerson";
import {User} from "./user";
import {IAdviser} from "../interfaces/IAdviser";
import {IAccount} from "../interfaces/IAccount";
import { ICustomer } from "../interfaces/ICustomer";

export class Customer extends User implements ICustomer {
  accounts?: IAccount[];
  adviser?: IAdviser;
  person: IPerson;

  constructor(accounts: IAccount[], person: IPerson, email: string, password: string) {
    super(email, password);
    this.accounts = accounts;
    this.person = person;
  }
}
