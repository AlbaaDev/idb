import { Customer } from "./customer";
import {User} from "./user";

export class Adviser extends User {
  customers: Customer[];

  constructor(customers: Customer[]) {
    super();
    this.customers = customers;
  }
}
