import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {PostsComponent} from './posts/posts.component';
import {HeaderComponent} from './header/header.component';
import {PostsListComponent} from './posts/posts-list/posts-list.component';
import {PostsAddComponent} from './posts/posts-add/posts-add.component';
import {PostService} from "./posts/post.service";
import {HttpModule} from "@angular/http";


@NgModule({
  declarations: [
      AppComponent,
      PostsComponent,
      HeaderComponent,
      PostsListComponent,
      PostsAddComponent
  ],
  imports: [
      BrowserModule,
      HttpModule
  ],
    providers: [PostService],
  bootstrap: [AppComponent]
})
export class AppModule { }
