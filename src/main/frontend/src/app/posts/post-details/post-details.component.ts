import {Component, OnInit} from '@angular/core';
import {PostService} from "../post.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Post} from "../post.model";

@Component({
    selector: 'app-post-details',
    templateUrl: './post-details.component.html',
    styleUrls: ['./post-details.component.css']
})
export class PostDetailsComponent implements OnInit {
    post = {} as Post;
    id: number;

    constructor(private postService: PostService, private route: ActivatedRoute) {
    }

    ngOnInit() {
        this.route.params.subscribe(
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
}
