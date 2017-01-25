import {RoomModel} from "../room/room.model";
import { Token }          from '../login/token';
import { Injectable }     from '@angular/core';
import { Router }    from '@angular/router';
import { Headers, RequestOptions } from '@angular/http';
import {Http} from '@angular/http';
import { Response } from '@angular/http';
import { UserModel } from '../user/user.model';
import {Config} from '../config'

/**
 * Authentification service. It's a placeholder for all the auth data. Theses data are available to
 * any class wishing to access them.
 */
@Injectable()
export class DataService {

public currentRoom : RoomModel;

public BASE_API_URL = "";
public BASE_WS_URL = "";
/**
 * constructor
 */
  constructor(private _http: Http, private _router: Router, private _config: Config)
  {
    this._config.load()
    .subscribe((data) => {
        this.BASE_API_URL= "http://" + data.serverBaseAdress+ "/api";
        this.BASE_WS_URL=data.serverBaseAdress;
        console.log(this.BASE_API_URL);
      },
        error => alert("FAILED TO LOAD CONFIGURATION FILE")
      );
  }
}
