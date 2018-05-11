
export class Post {
    public id: number;
    public title: string;
    public content: string;
    public dateTimeOfPost: Date;
    public imageUrl: string;
    public categories: string[];

    constructor(title: string, content: string, categories: string[]) {
        this.title = title;
        this.content = content;
        this.categories = categories;
    }
}
