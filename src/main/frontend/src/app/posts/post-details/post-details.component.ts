import {Component, OnInit} from '@angular/core';
import {PostService} from "../../service/post.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Post} from "../../model/post.model";
import {AuthService} from "../../auth/auth.service";
import {User} from "../../model/user.model";

@Component({
    selector: 'app-post-details',
    templateUrl: './post-details.component.html',
    styleUrls: ['./post-details.component.css']
})
export class PostDetailsComponent implements OnInit {
    post = {} as Post;
    id: number;
    allowRate = true;
    author = "";

    constructor(private postService: PostService, private router: ActivatedRoute, private authService: AuthService) {
    }

    ngOnInit() {
        this.router.params.subscribe(
            (params: Params) => {
                this.id = +params['id'];
                this.postService.getPostById(this.id)
                    .subscribe(
                    (data: Post) => {
                        this.post = data;
                        this.author = data.user.username;
                        console.log(this.post);
                    },
                    (error) => console.log(error)
                );
            }
        );
    }

    onRate(buttonState: number) {
        this.allowRate = false;
        this.postService.changeRatingPoints(this.id, buttonState);
    }

    onDeletePost() {
        this.postService.deletePost(this.id);
    }
}
