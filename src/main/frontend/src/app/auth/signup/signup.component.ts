import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {AuthService} from "../auth.service";
import {Router} from "@angular/router";
import {User} from "../../model/user.model";

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
    @ViewChild('f') signupUserForm: NgForm;

    constructor(private authService: AuthService, private router: Router) {
    }

    ngOnInit() {
    }

    onSignup() {
        const value = this.signupUserForm.value;
        const user = new User(value.username, null, value.firstName, value.lastName, null);
        const password = value.password;
        this.authService.signupUser(user.username, password);
        this.router.navigate(['posts-list']);
    }

}
