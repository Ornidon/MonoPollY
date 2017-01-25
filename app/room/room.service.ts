import {RoomModel} from "./room.model";
import { Injectable }  from '@angular/core';
import { Router }      from '@angular/router';
import { AuthService } from '../services/auth.service';
import { HTTPService } from '../http/http.service';
import { Observable }  from 'rxjs/Rx';
import { HeaderModel } from '../http/header.model';
import { Response }    from '@angular/http';
import { UserModel }   from '../user/user.model';
import { Http } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { DataService } from '../services/data.service';

/**
 * Service for the register component.
 */
@Injectable()
export class RoomService {

    private apiURL:string = '/user/rooms';
    private apiPostRoom : string = '/rooms'
    /**
     * constructor
     */
    public constructor(private httpService:HTTPService,
                       private auth: AuthService,
                       private router: Router,
                       private _http: Http,
                       private _data: DataService)
    {
    }

    /**
     * Register in the API this user.
     */
    public getRooms()
    {
        return this.httpService.doGet(this._data.BASE_API_URL + this.apiURL)
        .map((obj: Object) => <RoomModel[]>(obj))
    }

    public createRoom(room):Observable<Response>
    {
        let tmp = {
            name: room.name
            };

        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        headers.append('Accept', 'application/json');
        headers.append('token', this.auth.getToken().token);

        let bodyString = JSON.stringify(tmp);
        let options = new RequestOptions({ headers: headers });

        return this._http.post(this._data.BASE_API_URL + this.apiPostRoom, bodyString, options);
    }
}
