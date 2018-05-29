import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Comment} from "../model/comment.model";

@Injectable()
export class CommentService {

    constructor(private http: HttpClient) {

    }

    saveComment(newComment: Comment) {
        return this.http.post('/api/comments', newComment).subscribe(
            (response: Response) => {
                console.log(response);
            }
        );
    }

    getComments() {
        return this.http.get('/api/comments');
    }

    getCommentsWithPostId(id: number) {
        return this.http.get('/api/comments/post/' + id);
    }
}
