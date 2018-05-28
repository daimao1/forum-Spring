import {Component, OnInit} from '@angular/core';
import {PostService} from "../service/post.service";
import {AuthServiceImitation} from "../auth/auth.service";

@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

    constructor() {
    }

    ngOnInit() {
    }

}
