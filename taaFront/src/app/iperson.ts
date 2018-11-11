import { PlaceInterface } from "./place-interface";
import { ISport } from "./isport";

export interface Iperson {
    id: number,
    firstName: String,
    lastName: String,
    email: String,
    password: String,
    place: PlaceInterface,
    sports: ISport[]
}
