import {Component, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";
import {PostService} from "../post.service";
import {Post} from "../post.model";

@Component({
    selector: 'app-posts-add',
    templateUrl: './posts-add.component.html',
    styleUrls: ['./posts-add.component.css']
})
export class PostsAddComponent implements OnInit {

    constructor(private postService: PostService) {
    }

    ngOnInit() {
    }

    onAddPost(form: NgForm) {
        const tempImageUrl = 'http://qultqultury.pl/wp-content/uploads/2015/09/lana-del-rey.jpg';
        const value = form.value;
        const newPost = new Post(value.title, value.content, tempImageUrl, null);
        this.postService.savePost(newPost);
    }

}
