import {Component, OnInit} from '@angular/core';
import {PostService} from "../../service/post.service";
import {Post} from "../../model/post.model";
import {Router} from "@angular/router";

@Component({
    selector: 'app-search-result',
    templateUrl: './search-result.component.html',
    styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent implements OnInit {
    searchedPosts: Post[] = [];
    data: string;

    constructor(private postService: PostService, private router: Router) {
    }

    ngOnInit() {
        this.router.routerState.root.queryParams.subscribe(
            params => {
                this.data = params['searchData'];
            }
        );
        console.log(this.data);
        this.postService.searchPost(this.data)
            .subscribe(
                (posts: any[]) => {
                    this.searchedPosts = posts;
                    console.log(this.searchedPosts);
                },
                (error) => console.log(error)
            );
    }
}
