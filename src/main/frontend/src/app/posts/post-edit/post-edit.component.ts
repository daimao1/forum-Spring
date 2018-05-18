import {Component, OnInit, ViewChild} from '@angular/core';
import {PostService} from "../post.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Post} from "../post.model";
import {NgForm} from "@angular/forms";

@Component({
    selector: 'app-post-edit',
    templateUrl: './post-edit.component.html',
    styleUrls: ['./post-edit.component.css']
})
export class PostEditComponent implements OnInit {
    @ViewChild('f') addPostForm: NgForm;
    editedPost = {} as Post;
    id: number;
    isSend: boolean;
    isImageSelect: boolean;

    constructor(private postService: PostService, private router: ActivatedRoute) {
    }

    ngOnInit() {
        this.isSend = false;
        this.router.params.subscribe(
            (params: Params) => {
                this.id = +params['id'];
                this.postService.getPostById(this.id)
                    .subscribe(
                        (data: Post) => {
                            this.editedPost = data;
                            console.log(this.editedPost);
                        },
                        (error) => console.log(error)
                    );
            }
        );
    }

    onEditPost(files: any) {
        let file: File = files[0];
        console.log(file);
        const value = this.addPostForm.value;
        const updatedPost = {} as Post;

        updatedPost.id = this.id;
        updatedPost.title = value.title.toString();
        updatedPost.content = value.content.toString();
        updatedPost.ratingPoints = this.editedPost.ratingPoints;
        updatedPost.categories = this.editedPost.categories;
        updatedPost.imageUrl = this.editedPost.imageUrl;

        console.log(updatedPost);
        console.log(file);
        if (file == null) {
            console.log("file is empty or undefined");
            this.postService.updatePost(updatedPost, null);
        }
        else {
            this.postService.updatePost(updatedPost, file);
        }
        this.isSend = true;
    }
}
