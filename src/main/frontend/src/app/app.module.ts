import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {PostsComponent} from './posts/posts.component';
import {HeaderComponent} from './header/header.component';
import {PostsListComponent} from './posts/posts-list/posts-list.component';
import {PostsAddComponent} from './posts/posts-add/posts-add.component';
import {PostService} from "./posts/post.service";
import {ShorterContentPipe} from "./shorter-content.pipe";
import {CategoriesFormatPipe} from "./categories-format.pipe";
import {AppRoutingModule} from "./app-routing.module";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [
      AppComponent,
      PostsComponent,
      HeaderComponent,
      PostsListComponent,
      PostsAddComponent,
      ShorterContentPipe,
      CategoriesFormatPipe
  ],
  imports: [
      BrowserModule,
      HttpClientModule,
      AppRoutingModule,
      FormsModule
  ],
    providers: [PostService],
  bootstrap: [AppComponent]
})
export class AppModule { }
