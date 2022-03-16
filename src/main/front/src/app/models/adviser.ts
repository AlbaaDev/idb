import {IAdviser} from "../interfaces/IAdviser";
import {User} from "./user";
import {IAccount} from "../interfaces/IAccount";
import {IPerson} from "../interfaces/IPerson";

export class Adviser extends User implements IAdviser {
  accounts?: IAccount[];
  person: IPerson;

  constructor(type: string,  accounts: IAccount[], person: IPerson, email: string, password: string) {
    super(email, password, type);
    this.accounts = accounts;
    this.person = person;
  }
}
