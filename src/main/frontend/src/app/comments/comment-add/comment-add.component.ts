import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {CommentService} from "../../service/comment.service";
import {Post} from "../../model/post.model";
import {PostService} from "../../service/post.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Comment} from "../../model/comment.model";
import {PostDetailsComponent} from "../../posts/post-details/post-details.component";

@Component({
    selector: 'app-comment-add',
    templateUrl: './comment-add.component.html',
    styleUrls: ['./comment-add.component.css']
})
export class CommentAddComponent implements OnInit {
    @ViewChild('f') addCommentForm: NgForm;
    post = {} as Post;
    id: number;

    constructor(private commentService: CommentService, private postService: PostService, private router: ActivatedRoute,
                private postDetailsComponent: PostDetailsComponent) {
    }

    ngOnInit() {
    }

    onAddComment() {
        const value = this.addCommentForm.value;
        const newComment = new Comment(value.content, this.postDetailsComponent.post);
        console.log(this.postDetailsComponent.post);
        this.commentService.saveComment(newComment);
    }

}
