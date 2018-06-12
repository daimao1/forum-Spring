import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CommentService} from "../../service/comment.service";
import {PostDetailsComponent} from "../../posts/post-details/post-details.component";
import {AuthService} from "../../auth/auth.service";

@Component({
    selector: 'app-comments-list',
    templateUrl: './comments-list.component.html',
    styleUrls: ['./comments-list.component.css']
})
export class CommentsListComponent implements OnInit {
    comments: Comment[] = [];

    constructor(private commentService: CommentService, private router: ActivatedRoute, private postDetailsComponent: PostDetailsComponent,
                private authService: AuthService) {
    }

    ngOnInit() {
        console.log('id of actual post: ' + this.postDetailsComponent.id);

        return this.commentService.getCommentsWithPostId(this.postDetailsComponent.id)
            .subscribe(
                (comments: any[]) => {
                    this.comments = comments;
                },
                (error) => console.log(error)
            );
    }

    onDeleteComment(id: number) {
        this.commentService.deleteComment(id);
    }

}
