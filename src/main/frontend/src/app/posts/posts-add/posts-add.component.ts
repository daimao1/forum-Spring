import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {PostService} from "../post.service";
import {Post} from "../post.model";
import {Router} from "@angular/router";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";

@Component({
    selector: 'app-posts-add',
    templateUrl: './posts-add.component.html',
    styleUrls: ['./posts-add.component.css']
})
export class PostsAddComponent implements OnInit {
    @ViewChild('f') addPostForm: NgForm;

    constructor(private postService: PostService, private router: Router, private http: HttpClient) {
    }

    ngOnInit() {
    }

    onAddPost() {
        const tempImageUrl = 'http://qultqultury.pl/wp-content/uploads/2015/09/lana-del-rey.jpg';
        const value = this.addPostForm.value;
        const newPost = new Post(value.title, value.content, tempImageUrl, this.addCategories());
        this.postService.savePost(newPost);
        this.router.navigate(['/posts-list']);
    }

    onImageUpload(files: any) {

        let file: File = files[0];
        this.postService.upload(file);
    }

    addCategories() {
        let newCategories: string[] = [];

        if (this.addPostForm.value.categories.celebrity === true) {
            newCategories.push('CELEBRITY');
        }

        if (this.addPostForm.value.categories.animal === true) {
            newCategories.push('ANIMAL');
        }

        if (this.addPostForm.value.categories.people === true) {
            newCategories.push('PEOPLE');
        }

        if (this.addPostForm.value.categories.curiosity === true) {
            newCategories.push('CURIOSITY');
        }

        if (this.addPostForm.value.categories.science === true) {
            newCategories.push('SCIENCE');
        }

        if (this.addPostForm.value.categories.funny === true) {
            newCategories.push('FUNNY');
        }

        if (this.addPostForm.value.categories.nature === true) {
            newCategories.push('NATURE');
        }

        if (this.addPostForm.value.categories.interestingPlace === true) {
            newCategories.push('INTERESTING_PLACE');
        }

        if (this.addPostForm.value.categories.art === true) {
            newCategories.push('ART');
        }

        if (this.addPostForm.value.categories.movie === true) {
            newCategories.push('MOVIE');
        }

        if (this.addPostForm.value.categories.fashion === true) {
            newCategories.push('FASHION');
        }

        if (this.addPostForm.value.categories.sale === true) {
            newCategories.push('SALE');
        }

        if (this.addPostForm.value.categories.music === true) {
            newCategories.push('MUSIC');
        }

        if (this.addPostForm.value.categories.culture === true) {
            newCategories.push('CULTURE');
        }

        if (this.addPostForm.value.categories.sport === true) {
            newCategories.push('SPORT');
        }

        if (this.addPostForm.value.categories.warszawa === true) {
            newCategories.push('WARSZAWA');
        }

        if (this.addPostForm.value.categories.lublin === true) {
            newCategories.push('LUBLIN');
        }

        if (this.addPostForm.value.categories.poznan === true) {
            newCategories.push('POZNAN');
        }

        if (this.addPostForm.value.categories.kielce === true) {
            newCategories.push('KIELCE');
        }

        if (this.addPostForm.value.categories.katowice === true) {
            newCategories.push('KATOWICE');
        }

        if (this.addPostForm.value.categories.gdansk === true) {
            newCategories.push('GDANSK');
        }

        if (this.addPostForm.value.categories.gdynia === true) {
            newCategories.push('GDYNIA');
        }

        if (this.addPostForm.value.categories.krakow === true) {
            newCategories.push('KRAKOW');
        }

        if (this.addPostForm.value.categories.wroclaw === true) {
            newCategories.push('WROCLAW');
        }

        return newCategories;
    }

}
