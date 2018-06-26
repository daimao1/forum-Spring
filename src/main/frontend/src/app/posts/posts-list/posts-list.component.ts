import {Component, OnInit} from '@angular/core';
import {Post} from "../../model/post.model";
import {PostService} from "../../service/post.service";
import {AuthService} from "../../auth/auth.service";
import {Router} from "@angular/router";

@Component({
    selector: 'app-posts-list',
    templateUrl: './posts-list.component.html',
    styleUrls: ['./posts-list.component.css']
})
export class PostsListComponent implements OnInit {

    posts: Post[] = [];

    currentPage = 1;
    totalElements: number;
    totalPages: number;
    elementsPerPage = 20;

    constructor(private postService: PostService, private authService: AuthService, private router: Router) {
    }

    ngOnInit() {
        return this.postService.getPosts(this.currentPage)
            .subscribe(
                (posts: any[]) => {
                    this.posts = posts;
                    this.totalElements = posts.length;
                    this.totalPages = this.totalElements / this.elementsPerPage + 1;
                    console.log("Total pages: " + this.totalPages);
                },
                (error) => console.log(error)
            );
    }

    onPageChange(pageNumber: number) {
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        else if (pageNumber > this.totalPages) {
            pageNumber = this.totalPages;
        }
        return this.postService.getPosts(pageNumber)
            .subscribe(
                (posts: any[]) => {
                    this.posts = posts;
                    this.currentPage = pageNumber;
                    window.scrollTo(0, 0);
                },
                (error) => console.log(error)
            );
    }

    createRange(number) {
        let items: number[] = [];
        for (let i = 1; i <= number; i++) {
            items.push(i);
        }
        return items;
    }
}
