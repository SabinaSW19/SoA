import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {AddBookComponent } from './add-book/add-book.component';
import {Service} from './shared/service';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {LoginComponent} from "./login/login.component";
import {UserService} from "./shared/user.service";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AddBookComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [
    Service,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
