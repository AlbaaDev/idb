export class Adress {
  street: string;
  city: string;
  province: string;
  postCode: number;

  constructor(street: string, city: string, province: string, postCode: number) {
    this.street = street;
    this.city = city;
    this.province = province;
    this.postCode = postCode;
  }
}
