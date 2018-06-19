import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {CommentService} from "../../service/comment.service";
import {Post} from "../../model/post.model";
import {PostService} from "../../service/post.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Comment} from "../../model/comment.model";
import {PostDetailsComponent} from "../../posts/post-details/post-details.component";
import {User} from "../../model/user.model";
import {UserService} from "../../service/user.service";
import {AuthService} from "../../auth/auth.service";

@Component({
    selector: 'app-comment-add',
    templateUrl: './comment-add.component.html',
    styleUrls: ['./comment-add.component.css']
})
export class CommentAddComponent implements OnInit {
    @ViewChild('f') addCommentForm: NgForm;
    post = {} as Post;
    id: number;
    currentUser = {} as User;

    constructor(private commentService: CommentService, private postService: PostService, private userService: UserService, private router: ActivatedRoute,
                private postDetailsComponent: PostDetailsComponent, private authService: AuthService) {
    }

    ngOnInit() {
        if (this.authService.isAuthenticated()) {
            this.userService.getCurrentUser().subscribe(
                (data: User) => {
                    this.currentUser = data;
                    console.log(this.currentUser);
                },
                (error) => console.log(error)
            );
        }
    }

    onAddComment() {
        const value = this.addCommentForm.value;
        const newComment = new Comment(value.content, this.currentUser, this.postDetailsComponent.post);
        console.log(this.postDetailsComponent.post);
        this.commentService.saveComment(newComment);
    }

}
