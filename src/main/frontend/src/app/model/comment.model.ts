import {Post} from "./post.model";

export class Comment {
    id: number;
    content: string;
    dateTimeOfComment: Date;
    post: Post;

    //userId: User;

    constructor(content: string, post: Post) {
        this.content = content;
        this.post = post;
    }
}
