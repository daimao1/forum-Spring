import {Component, OnInit} from '@angular/core';
import {PostService} from "../../service/post.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Post} from "../../model/post.model";
import {CommentService} from "../../service/comment.service";
import {PostDetailsComponent} from "../../posts/post-details/post-details.component";

@Component({
    selector: 'app-comments-list',
    templateUrl: './comments-list.component.html',
    styleUrls: ['./comments-list.component.css']
})
export class CommentsListComponent implements OnInit {
    comments: Comment[] = [];

    constructor(private commentService: CommentService, private router: ActivatedRoute, private postDetailsComponent: PostDetailsComponent) {
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

}
