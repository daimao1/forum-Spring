import {Injectable} from "@angular/core";
import "rxjs/add/operator/map";
import {Post} from "../model/post.model";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";

@Injectable()
export class PostService {

    constructor(private http: HttpClient) {

    }

    getPosts() {
        return this.http.get('/api/posts');
    }

    savePost(newPost: Post, file: File) {
        return this.http.post('/api/posts', newPost).subscribe(
            (response: Response) => {
                console.log(response);
                this.uploadImage(file);
            }
        );
    }

    getPostById(id: number) {
        return this.http.get('/api/posts/' + id);
    }

    private uploadImage(file: File) {
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
        });

    }

    changeRatingPoints(id: number, buttonState: number) {
        console.log("changeRatingPoints: id:" + id + " buttonState: " + buttonState);
        return this.http.put("/api/posts/" + id + "/rate", buttonState).subscribe(
            (response: Response) => {
                console.log(response);
            }
        );
    }

    deletePost(id: number) {
        this.http.delete("/api/posts/" + id).subscribe(
            () => {
                console.log('Deleted post with id: ' + id);
            }
        );
    }

    updatePost(updatedPost: Post, file: File) {
        return this.http.put('api/posts', updatedPost).subscribe(
            (response: Response) => {
                console.log(response);
                if (file != null) {
                    this.uploadImage(file);
                }
            }
        )
    }
}
