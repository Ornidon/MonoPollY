import {AnswerModel} from "../models/answer.model";
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
import { QuestionModel } from '../models/question.model';
import { DataService } from '../services/data.service';

/**
 * Service for the register component.
 */
@Injectable()
export class PollService {

    private apiURL:string = '/subscribe/';
    private answerAPI:string = '/answer/';
    private createQuestionURL:string = '/rooms/';
    private deleteQuestionURL:string = '/rooms/question/';

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
      this.headers.append('token', this.auth.getToken().token);
    }

    /**
     * Register in the API this user.
     */
    public subscribe(roomName : string):Observable<Response>
    {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        headers.append('Accept', 'application/json');
        headers.append('token', this.auth.getToken().token);

        let options = new RequestOptions({ headers: headers });

        return this._http.post(this._data.BASE_API_URL + this.apiURL + roomName, {}, options);
    }

    public answer(answerId: number) : Observable<QuestionModel>{
      return this.httpService.doPost({},this._data.BASE_API_URL + this.answerAPI+answerId)
      .map((obj: Object) => <QuestionModel>(obj))
    }

    public createQuestion(question: Object, roomId: number) : Observable<QuestionModel>
    {
      return this.httpService.doPost(question,this._data.BASE_API_URL + this.createQuestionURL + roomId)
      .map((obj: Object) => <QuestionModel>(obj))
    }

    public deleteQuestion(questionId: number) : Observable<QuestionModel>
    {
      return this.httpService.doDelete(this._data.BASE_API_URL + this.deleteQuestionURL + questionId)
      .map((obj: Object) => <QuestionModel>(obj))
    }
}
