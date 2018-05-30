import {Post} from "./post.model";

export class Comment {
    id: number;
    content: string;
    dateTimeOfComment: Date;
    post: Post;

    constructor(content: string, post: Post) {
        this.content = content;
        this.post = post;
    }
}
