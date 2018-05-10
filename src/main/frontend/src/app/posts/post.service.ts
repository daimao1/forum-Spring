import {Injectable} from "@angular/core";
import "rxjs/add/operator/map";
import {Post} from "./post.model";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class PostService {

    constructor(private http: HttpClient) {

    }

    getPosts() {
        return this.http.get('/api/posts');
    }

    savePost(newPost: Post) {
        return this.http.post('/api/posts', newPost).subscribe(
            (response: Response) => {
                console.log(response);
            }
        );
    }

    getPostById(id: number) {
        return this.http.get('/api/posts/' + id);
    }

    upload(file: File) {
        let formData = new FormData();
        formData.append('file', file);
        const req = this.http.post('/api/posts/upload', formData);

        req.subscribe((data) => {
            console.log(data);
        }, (err: HttpErrorResponse) => {
            if (err.error instanceof Error) {
                console.log('An error occured: ', err.error.message);
            }
            else {
                console.log('Backend returned code', err.status, 'body was ', err.error);
            }
        })
    }



}
