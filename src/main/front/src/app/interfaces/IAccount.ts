import {ICustomer} from "./ICustomer";

export interface IAccount {
  amount: number;
  identifier: number;
  customer?: ICustomer[];
}
