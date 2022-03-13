import {IPerson} from "../interfaces/IPerson";
import {IAdress} from "../interfaces/IAdress";
import {IContact} from "../interfaces/IContact";

export class Person implements IPerson {
  firstName: string;
  lastName: string;
  gender: number;
  adress: IAdress;
  contact: IContact;

  constructor(firstName: string, lastName: string, gender: number, adress: IAdress, contact: IContact) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.adress = adress;
    this.contact = contact;
  }
}
