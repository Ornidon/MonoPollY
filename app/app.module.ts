import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule }     from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule}       from '@angular/forms';
import { RouterModule }      from '@angular/router';
import { AppComponent }      from './app.component';
import { HttpModule }        from '@angular/http';

import { AuthService }       from './services/auth.service';
import { AppRoutingModule }  from './app-routing.module';
import { HTTPService }       from './http/http.service';
import { RoomService }       from './room/room.service';
import { DataService }       from "./services/data.service";
import { PollService }       from "./poll/poll.service";
import {WsService}           from './services/ws.service'
import {StatService}           from './services/stats.service'

import {Config} from './config'

import { LoginComponent }    from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent }   from './home/home.component';
import { PollComponent }   from './poll/poll.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    AppRoutingModule,
  ],
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    PollComponent,
  ],
  providers:[ AuthService, HTTPService, RoomService, DataService, PollService, StatService, WsService, Config],
  bootstrap: [ AppComponent ]
})
export class AppModule {
}
