import { ICustomer } from "./ICustomer";
import { IUser } from "./IUser";

export interface IAdviser extends IUser {
  customerList?: ICustomer[];
}
