import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {CommentService} from "../../service/comment.service";
import {Post} from "../../model/post.model";
import {PostService} from "../../service/post.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Comment} from "../../model/comment.model";

@Component({
    selector: 'app-comment-add',
    templateUrl: './comment-add.component.html',
    styleUrls: ['./comment-add.component.css']
})
export class CommentAddComponent implements OnInit {
    @ViewChild('f') addCommentForm: NgForm;
    post = {} as Post;
    id: number;

    constructor(private commentService: CommentService, private postService: PostService, private router: ActivatedRoute) {
    }

    ngOnInit() {
        //get actual post
        this.router.params.subscribe(
            (params: Params) => {
                this.id = +params['id'];
                this.postService.getPostById(this.id)
                    .subscribe(
                        (data: Post) => {
                            this.post = data;
                            console.log(this.post);
                        },
                        (error) => console.log(error)
                    );
            }
        );
    }

    //TODO:
    onAddComment() {
        const value = this.addCommentForm.value;
    }

}
