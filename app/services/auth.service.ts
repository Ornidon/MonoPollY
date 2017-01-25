import { Token }          from '../login/token';
import { Injectable }     from '@angular/core';
import { Router }    from '@angular/router';
import { Headers, RequestOptions } from '@angular/http';
import {Http} from '@angular/http';
import { Response } from '@angular/http';
import { UserModel } from '../user/user.model'

/**
 * Authentification service. It's a placeholder for all the auth data. Theses data are available to
 * any class wishing to access them.
 */
@Injectable()
export class AuthService {
  private _token: Token;
  private _userId: number;

/**
 * constructor
 */
  constructor(private _http: Http, private _router: Router)
  {
    console.log("READING LOCALSTORAGE...");
    if(this._token == undefined ||this._userId == undefined)
    {
      let tmpToken = localStorage.getItem('MonopollyToken');
      let tmpUser =localStorage.getItem('MonopollyUserId');
      if(tmpUser != "NaN")
      {
        console.log(tmpUser);
        this._token = JSON.parse(tmpToken);
        this._userId = JSON.parse(tmpUser);
      }
    }
  }

  /**
  * Return the token of this user. If there are no connected users navigates to '/login'.
  */
  public getToken(): Token
  {
    if(this._token == null || this._token==undefined)
        this._router.navigateByUrl('/home');
    return this._token;
  }

  public getUserId(): number
  {
    if(this._userId== undefined || this._userId == null)
      return -1;
    return this._userId;
  }

  public setUserId(userId: number)
  {
    this._userId = userId;
    localStorage.setItem('MonopollyUserId', ""+this._userId);
  }

  /**
   * Checks if the user is connected and if his token is at a valid date.
   * If not tries to 'refresh' the token. If it failes navigates to '/login'.
   */
  public isConnected(): boolean
  {
    if(this._token == null)
      return false;
    return true;
  }
  /**
   * Sets the token.
   */
  public setToken(token: Token)
  {
    console.log(token);
    localStorage.setItem('MonopollyToken', JSON.stringify(token));
    this._token = token;
  }

  /**
   * Logs out this user.
   */
  public logout()
  {
    localStorage.clear();
    this._token = null;
  }
}
