
export class Post {
    id: number;
    title: string;
    content: string;
    dateTimeOfPost: Date;
    imageUrl: string;
    categories: string[];
    ratingPoints: number;
    comments: Comment[];

    constructor(title: string, content: string, categories: string[]) {
        this.title = title;
        this.content = content;
        this.categories = categories;
        this.ratingPoints = 0;
    }
}
