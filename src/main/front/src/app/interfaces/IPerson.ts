import {IContact} from "./IContact";
import {IAdress} from "./IAdress";

export interface IPerson {
  firstName?: string;
  lastName?: string;
  gender?: number;
  adress?: IAdress;
  contact?: IContact;
}
