import { Injectable } from '@angular/core';
import { Observable }  from 'rxjs/Rx';
import { Http } from '@angular/http';


@Injectable()
 export class Config {
 private url: string;
 constructor(private http: Http) {
 }

    load() {
    return this.http.get("config.json")
    .map(res => res.json());
    }
 }