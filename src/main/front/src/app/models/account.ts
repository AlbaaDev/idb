import {ICustomer} from "../interfaces/ICustomer";
import {IAccount} from "../interfaces/IAccount";

export class Account  implements IAccount{
  amount: number;
  identifier: number;
  customer?: ICustomer[];

  constructor(amount: number, identifier: number) {
    this.amount = amount;
    this.identifier = identifier;
  }
}
