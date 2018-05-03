export class Post {
    public id: number;
    public title: string;
    public content: string[20];
    public dateTimeOfPost: string;
    public imageUrl: string;

    constructor(id: number, title: string, content: string, dateTimeOfPost: string, imageUrl: string) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateTimeOfPost = dateTimeOfPost;
        this.imageUrl = imageUrl;
    }
}
