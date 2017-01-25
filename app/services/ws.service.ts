import { Component,Injectable } from '@angular/core';
import {Observable} from 'rxjs/Rx';
import { DataService } from './data.service';


@Injectable()
export class WsService {

    private websocket: any;
    private receivedMsg: any;

    constructor(private _data : DataService){}
    
    public sendMessage(text:string){
      this.websocket.send(text);
    }

    public doAuth(text:string): Observable<any>{
      this.websocket = new WebSocket("ws://" + this._data.BASE_WS_URL + "/api/ws");
      this.websocket.onopen =  (evt) => {
          this.websocket.send(text);
      };

      return Observable.create(observer=>{
          this.websocket.onmessage = (evt) => { 
              observer.next(evt);
          };
      })
      .map(res=> res.data)
      .share();
    }

}