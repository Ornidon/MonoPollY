import { RoomModel } from "./room/room.model";
import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';
import { Router }    from '@angular/router';
import { RoomService } from './room/room.service'

/**
 * Class for the main component of this app.
 */
@Component({
    selector: 'my-app',
    templateUrl: './app.component.html'
})
export class AppComponent {
    /**
     * constructor
     */
    constructor(private _auth: AuthService, private _router: Router) {
    }
}
