import { NgModule }     from '@angular/core';
import { RouterModule } from '@angular/router';

import { LoginComponent }  from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { PollComponent } from './poll/poll.component';

@NgModule({
    imports: [
        RouterModule.forRoot([
            { path: 'login', component: LoginComponent },
            { path: 'register', component: RegisterComponent },
            { path: 'home', component: HomeComponent },
            { path: 'poll', component: PollComponent },
            { path: '', component: HomeComponent }
        ])
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule { }
