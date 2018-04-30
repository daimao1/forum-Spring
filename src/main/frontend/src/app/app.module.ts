import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {PostsComponent} from './posts/posts.component';
import {HeaderComponent} from './header/header.component';


@NgModule({
  declarations: [
      AppComponent,
      PostsComponent,
      HeaderComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
