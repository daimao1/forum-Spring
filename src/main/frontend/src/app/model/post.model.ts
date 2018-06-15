import {User} from "./user.model";

export class Post {
    id: number;
    title: string;
    content: string;
    dateTimeOfPost: Date;
    imageUrl: string;
    categories: string[];
    ratingPoints: number;
    user: User;

    constructor(title: string, content: string, categories: string[], user: User) {
        this.title = title;
        this.content = content;
        this.categories = categories;
        this.ratingPoints = 0;
        this.user = user;
    }
}
