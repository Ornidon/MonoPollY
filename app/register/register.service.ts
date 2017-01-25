import { Injectable }  from '@angular/core';
import { Router }      from '@angular/router';
import { AuthService } from '../services/auth.service';
import { HTTPService } from '../http/http.service';
import { Observable }  from 'rxjs/Rx';
import { HeaderModel } from '../http/header.model';
import { Response }    from '@angular/http';
import { UserModel }   from '../user/user.model';
import { RegisterModel } from './register.model';
import {Http} from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { DataService } from '../services/data.service';

/**
 * Service for the register component.
 */
@Injectable()
export class RegisterService {

    private apiURL = '/user';
    private headers: Headers;
    /**
     * constructor
     */
    public constructor(private httpService:HTTPService,
                       private auth: AuthService,
                       private router: Router,
                       private _http: Http,
                       private _data: DataService)
    {
        this.headers = new Headers();
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('Accept', 'application/json');
    }

    /**
     * Register in the API this user.
     */
    public register(registerModel: RegisterModel):Observable<Response>
    {
        return this._http.post(this._data.BASE_API_URL + this.apiURL, registerModel, { headers: this.headers });
    }
}
