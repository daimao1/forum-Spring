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
    isSendButtonActivated;

    constructor(private authService: AuthService, private router: Router) {
    }

    ngOnInit() {
        this.isSendButtonActivated = true;
        this.authService.loginOrEmailNotAvailable = false;
    }

    onSignup() {
        this.isSendButtonActivated = false;
        const value = this.signupUserForm.value;
        const user = new User(value.username, value.password, value.email, value.firstName, value.lastName, null);
        this.authService.signupUser(user);
        /*        if (this.authService.loginOrEmailNotAvailable) {
                    this.router.navigate(['posts-list']);
                }*/

        this.isSendButtonActivated = true;
        this.signupUserForm.reset();

    }
}
