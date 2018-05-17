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
import {PostDetailsComponent} from './posts/post-details/post-details.component';
import {AuthServiceImitation} from "./auth/auth.service";
import {PostEditComponent} from './posts/post-edit/post-edit.component';


@NgModule({
  declarations: [
      AppComponent,
      PostsComponent,
      HeaderComponent,
      PostsListComponent,
      PostsAddComponent,
      ShorterContentPipe,
      CategoriesFormatPipe,
      PostDetailsComponent,
      PostEditComponent,
  ],
  imports: [
      BrowserModule,
      HttpClientModule,
      AppRoutingModule,
      FormsModule
  ],
    providers: [PostService, AuthServiceImitation],
  bootstrap: [AppComponent]
})
export class AppModule { }
