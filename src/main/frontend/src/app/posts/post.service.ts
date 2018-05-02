import {Http} from "@angular/http";
import {Injectable} from "@angular/core";
import "rxjs/add/operator/map";

@Injectable()
export class PostService {

    constructor(private http: Http) {

    }

    getPosts() {
        return this.http.get('/api/posts').map(response => response.json());
    }

}
