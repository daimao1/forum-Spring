import {Component, OnInit, ViewChild} from '@angular/core';
import {PostService} from "../../service/post.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {Post} from "../../model/post.model";
import {NgForm} from "@angular/forms";
import {User} from "../../model/user.model";
import {UserService} from "../../service/user.service";

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
    currentUser = {} as User;

    constructor(private postService: PostService, private userService: UserService, private route: ActivatedRoute, private router: Router) {
    }

    ngOnInit() {
        this.isSend = false;
        this.route.params.subscribe(
            (params: Params) => {
                this.id = +params['id'];
                this.postService.getPostById(this.id)
                    .subscribe(
                        (data: Post) => {
                            this.editedPost = data;
                            this.currentUser = data.user;
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
        updatedPost.user = this.currentUser;

        console.log('updated post:' + updatedPost);
        console.log('file: ' + file);
        if (file == null) {
            console.log("file is empty or undefined");
            this.postService.updatePost(updatedPost, null);
        }
        else {
            this.postService.updatePost(updatedPost, file);
        }
        this.isSend = true;
        this.router.navigate(['posts-list']);
    }
}
