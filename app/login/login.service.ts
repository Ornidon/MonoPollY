import { Injectable }     from '@angular/core';
import {Http} from '@angular/http';
import { Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Token } from './token';
import {LoginModel} from './login.model'
import 'rxjs/add/operator/map'
import {AuthService} from '../services/auth.service'
import {Router} from '@angular/router'
import { UserModel } from '../user/user.model'
import { DataService } from '../services/data.service'

/**
 * Service for the login component. As the HTTP request differs from usual it has it own method with http from Angular2.
 */
@Injectable()
export class LoginService {
    private apiURL = '/auth';
    private headers: Headers;

    /**
     * constructor
     */
    constructor(private _http: Http, private _auth: AuthService, private _router: Router, private _data : DataService ) {
        this.headers = new Headers();
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('Accept', 'application/json');
    }

    /**
     * Request a token and all informations to be placed in the AuthService.
     */
    public requestToken(loginModel: LoginModel){
        if(!loginModel.username || !loginModel.password)
        {
            console.log("[LOGIN_SERVICE][E] Empty fields. Not sending.");
            return;
        }
        console.log("[LOGIN_SERVICE][I] Sending authentification request...");
        let credentials = JSON.stringify({ username : loginModel.username, password : loginModel.password });

        this._http.post(this._data.BASE_API_URL + this.apiURL, credentials, { headers: this.headers })
            .map(res => res.json())
            .subscribe(
                data =>
                {
                    this.saveJwt(data);
                    console.log("[LOGIN_SERVICE][I] Authentication Complete.");
                    this._router.navigateByUrl('/poll');
                 },
                err =>
                {
                    console.log(err);
                    alert(JSON.parse(err._body).message);
                    loginModel.password = "";
                    loginModel.username = "";
                }
            );
    }

    saveJwt(jwt) {
        if(jwt) {
            this._auth.setToken(new Token(jwt.token));
            this._auth.setUserId(jwt.userId);
        }
    }
}
