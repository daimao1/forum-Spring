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

    getCommentsWithPostId(id: number) {
        return this.http.get('/api/comments/post/' + id);
    }

    deleteComment(id: number) {
        this.http.delete('api/comments/' + id).subscribe(
            () => {
                console.log('Deleted comment with id: ' + id);
            }
        )
    }
}
