import {Component, OnInit} from '@angular/core';
import {Post} from "../../model/post.model";
import {PostService} from "../../service/post.service";
import {AuthService} from "../../auth/auth.service";

@Component({
    selector: 'app-posts-list',
    templateUrl: './posts-list.component.html',
    styleUrls: ['./posts-list.component.css']
})
export class PostsListComponent implements OnInit {
    posts: Post[] = [];

    constructor(private postService: PostService, private authService: AuthService) {
    }

    ngOnInit() {
        return this.postService.getPosts()
            .subscribe(
                (posts: any[]) => {
                    this.posts = posts;
                },
                (error) => console.log(error)
            );
    }
}
