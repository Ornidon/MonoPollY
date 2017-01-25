import { Injectable }  from '@angular/core';
import { AuthService } from './auth.service';
import { HTTPService } from '../http/http.service';
import { Observable }  from 'rxjs/Rx';
import { DataService } from './data.service';
import {StatsQuestionModel} from '../models/statisticalQuestion.model';

/**
 * Service for the register component.
 */
@Injectable()
export class StatService {

    private apiURL:string = '/rooms/question/';
    /**
     * constructor
     */
    public constructor(private httpService:HTTPService,
                       private auth: AuthService,
                       private _data: DataService)
    {
    }

    /**
     * Register in the API this user.
     */
    public getResults(questionID: number) : Observable<StatsQuestionModel> {
      return this.httpService.doGet(this._data.BASE_API_URL + this.apiURL+questionID)
      .map((obj: Object) => <StatsQuestionModel>(obj));
    }
}
