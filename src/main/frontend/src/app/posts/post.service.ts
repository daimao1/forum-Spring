import {Injectable} from "@angular/core";
import "rxjs/add/operator/map";
import {Post} from "./post.model";
import {HttpClient} from "@angular/common/http";

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



}
