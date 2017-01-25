import {PollService} from "./poll.service";
import {DataService} from "../services/data.service";
import {RoomModel} from "../room/room.model";
import {RoomService} from "../room/room.service";
import {Component} from '@angular/core';
import {AuthService} from '../services/auth.service';
import {Router} from '@angular/router';
import {QuestionModel} from '../models/question.model';
import {StatsQuestionModel} from '../models/statisticalQuestion.model';
import {AnswerModel} from '../models/answer.model';
import {StatService} from "../services/stats.service";
import {WsService} from '../services/ws.service';
import {AuthModel} from '../services/auth.model';
import {UserModel} from '../user/user.model';
import {StatsAnswer} from '../models/statisticalAnswer.model';
import {DataHolder} from '../models/dataHolderQuestion.model';

import { ViewChild } from '@angular/core';


/**
 * Class for the LoginComponent.
 */
@Component({
    selector: 'poll',
    templateUrl: './poll.component.html',
})
export class PollComponent{

    //GENERAL CONTROL
    private addingQuestion: boolean = false;

    //ROOM MANAGMENT
    private rooms: RoomModel[] = [];
    private roomName: string = "";
    private roomName2: string = "";
    private creationMode : boolean = false;
    private room : RoomModel = {
      id: 0,
      owner: 0,
      name: "string",
      questions: new Array<QuestionModel>(),
    };
    private currentlyCreatedRoom : RoomModel;

    //QUESTION CREATION MANAGMENT
    private questionToBeCreated : QuestionModel = new QuestionModel("", 0, false,  false, new Array<AnswerModel>());

    //ANSWER QUESTION MANAGMENT
    private current : number = 0;

    //WEBSOCKET MANAGMENT
    private currentlySubscribedRoom = -1;

    //CHART MANAGMENT
    private type = 'pie';
    options = {
    responsive: true,
    maintainAspectRatio: false
    };

    /**
     * constructor
     */
    constructor(private _auth: AuthService, 
                private _router: Router,
                private _rooms: RoomService, 
                private _data : DataService, 
                private _pollService : PollService, 
                private _statsService: StatService,
                private _ws : WsService){
        if(!this._auth.isConnected())
        {
            this._router.navigateByUrl('/home');
            return;
        }
        if (_auth.getToken() != undefined && _auth.getToken() != null) {
            this.loadRoom();
        }
        this._ws.doAuth("hello")
        .subscribe((result) => {
            let respObject = JSON.parse(result);
            if(respObject.code == "addQuestion" && this._data.currentRoom.owner != this._auth.getUserId())
            {
                var tmp : QuestionModel = respObject.completeQuestion;
                tmp.dataHolder = new DataHolder(new Array<number>(), 0, new Object);
                this._data.currentRoom.questions.unshift(tmp);
                this.addDataToChartQuestion(tmp);
            }

            if(respObject.code == "UserAnswer")
            {                              
                this._data.currentRoom.questions.forEach((question) =>
                {
                    if(question.id == respObject.questionId)
                    {
                        question.answers.forEach((answer) =>
                        {
                            if(answer.id == respObject.userAnswerId)
                            {
                                console.log("UserAnswer");
                                console.log(question.dataHolder.answerId.indexOf(answer.id));
                                console.log(respObject);
                                console.log(question.dataHolder);
                                question.dataHolder.data.datasets[0].data[question.dataHolder.answerId.indexOf(answer.id)]++;
                                question.dataHolder.totalReplys++;
                            }
                        });
                    }
                });
            }
        });
    }

    loadRoom()
    {
        this.rooms = [];
        this._rooms.getRooms()
                .subscribe(
                success => {
                    var i : number = 0;
                    success.forEach((room) => {
                        this.rooms.push(room);
                        this.currentlyCreatedRoom = room;
                        room.questions.forEach((question) =>{
                            this.getResponses(question);
                        })
                        i++;
                    });
                },
                error => {
                    console.log(error);
                });
    }

    getResponses(question: QuestionModel) {
        this._statsService.getResults(question.id)
            .subscribe(
            success => {
                question.dataHolder = new DataHolder(new Array<number>(), 0, new Object);
                this.addDataToChart(success, question);
            },
            error => {
                console.log(error);
            }
        );
    }

    addMode(){
      this.creationMode = true;
      this._data.currentRoom = null;
    }

    /**
     * Creates poll
     */
    create(event){
      if (event.keyCode == 13) {
          this.room.name= this.roomName2;
          this._rooms.createRoom(this.room)
          .subscribe((success) => {
            this.rooms.push(new RoomModel (
              this.room.id,
              this._auth.getUserId(),
              this.room.name,
              this.room.questions
            ));
            this.addingQuestion = false;
            this.loadRoom();
          },
        error =>
        {
            alert("Cannot create your room.");
            console.log(error);
        });
          //TODO : IF OK reload else TOAST
          this.creationMode = false;
          this.roomName2 = "";

      }
    }

    selectRoom(item) {
        console.log(item);
        if(item == undefined || item == null || this._data.currentRoom == undefined || item.id != this._data.currentRoom.id)
        {
            this._data.currentRoom = item;
            this.creationMode = false;
            console.log("USER ID: " + this._auth.getUserId() +" / ROOM OWNER" + this._data.currentRoom.owner + " // ROOM_ID: " + this._data.currentRoom.id);

            if(this.currentlySubscribedRoom != -1)
            {
                this._ws.sendMessage(JSON.stringify(new AuthModel(this._auth.getToken().token,this.currentlySubscribedRoom, false)));
            }
            this._ws.sendMessage(JSON.stringify(new AuthModel(this._auth.getToken().token,this._data.currentRoom.id, true)));
            this.currentlySubscribedRoom = this._data.currentRoom.id;
            this.loadRoom();
        }
    }

    answer(answerId: number){
      this._pollService.answer(answerId)
      .subscribe(
          success => {console.log("OK");},
          error => {console.log("error");}
      );
      this._data.currentRoom.questions[this.current].canAnswer = false;
    }

    find(event) {
        if (event.keyCode == 13) {
            this._pollService.subscribe(this.roomName)
            .subscribe((success) => {
                this.loadRoom();
            },
            error =>
            {
                alert("Cannot find this room");
            });
            //TODO : IF OK reload else TOAST
        }
    }

    /**
     * Logs out this user.
     */
    onLogout() {
        this._auth.logout();
        this._router.navigateByUrl('/home');
    }

    /**
     * Submit this question creation to the API
     */
    createQuestion()
    {
        let tmp = Object.assign({}, this.questionToBeCreated);
        delete tmp.id;
        delete tmp.closed;
        delete tmp.canAnswer;
        this._pollService.createQuestion(tmp, this._data.currentRoom.id)
        .subscribe(
            success => 
            {
                this._data.currentRoom.questions.unshift(success);
                this.addingQuestion = false;
                success.dataHolder = new DataHolder(new Array<number>(), 0, new Object);
                this.addDataToChartQuestion(success);
            },
            error => console.log(error)
        );
    }

    

    pushAnswer()
    {
        let tmp = new AnswerModel("", 0, false);
        delete tmp.id;
        this.questionToBeCreated.answers.push(tmp);
    }

    swtichAnswer(answer : AnswerModel)
    {
        answer.isValid = !answer.isValid;
    }

    enterCreationQuestionMode()
    {
        this.addingQuestion = true;
    }

    cancelQuestion(){
        this.questionToBeCreated = new QuestionModel("", 0, false, false, new Array<AnswerModel>());
    }

    deleteAnswer(answer : AnswerModel)
    {
        var index = this.questionToBeCreated.answers.indexOf(answer);
        if(index != -1)
        {
            this.questionToBeCreated.answers.splice(index, 1);
        }
    }

    deleteQuestion(question: QuestionModel)
    {
        var index = this._data.currentRoom.questions.indexOf(question);
        if(index != -1)
        {
            this._pollService.deleteQuestion(question.id)
            .subscribe(success => this._data.currentRoom.questions.splice(index, 1));
        }
    }

    goToPreviousQuestion()
    {
        this.current--;
    }

    goToNextQuestion()
    {
        this.current++;
    }

     addDataToChart(success: StatsQuestionModel, question:QuestionModel)
     {
         var labells: string[] = [];
         var datas: number[] = [];
         var background: string[] = [];
         var totalNumberOfAnswers:number = 0;

         for (var i = 0; i < success.answers.length; ++i) {
             labells.push(success.answers[i].body);
             datas.push(success.answers[i].users.length);
             question.dataHolder.answerId.push(success.answers[i].id);
             totalNumberOfAnswers = totalNumberOfAnswers+success.answers[i].users.length;
         if (success.answers[i].isValid)
             background.push("#2ecc71");
         else
             background.push("#e74c3c");
         }
 
         question.dataHolder.totalReplys = totalNumberOfAnswers;
         question.dataHolder.data = {
             labels: labells,
             datasets: [{
                     label: "Resultats",
                     data: datas,
                     backgroundColor: background
                 }]
         };
     }
 
     addDataToChartQuestion(success: QuestionModel)
     {
         var labells: string[] = [];
        var datas: number[] = [];
         var background: string[] = [];
 
         for (var i = 0; i < success.answers.length; ++i) {
             labells.push(success.answers[i].body);
             datas.push(0);
             success.dataHolder.answerId.push(success.answers[i].id);
         if (success.answers[i].isValid)
             background.push("#2ecc71");
         else
             background.push("#e74c3c");
         }
 
         success.dataHolder.totalReplys = 0;
         success.dataHolder.data = {
             labels: labells,
             datasets: [{
                     label: "Resultats",
                     data: datas,
                     backgroundColor: background
                 }]
         };
    }
}