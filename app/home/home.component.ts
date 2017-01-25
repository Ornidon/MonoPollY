import {Component} from '@angular/core'
import {AuthService} from '../services/auth.service'
import {Router} from '@angular/router'

/**
 * Class for the LoginComponent.
 */
@Component({
    selector: 'home',
    templateUrl: './home.component.html'
})
export class HomeComponent{

    /**
     * constructor
     */
    constructor(private _auth: AuthService, private _router: Router){
        if(this._auth.isConnected())
        {
            this._router.navigateByUrl('/poll');
        }
    }

}
