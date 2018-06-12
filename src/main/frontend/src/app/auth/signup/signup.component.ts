import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {AuthService} from "../auth.service";

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
    @ViewChild('f') signupUserForm: NgForm;

    constructor(private authService: AuthService) {
    }

    ngOnInit() {
    }

    onSignup() {
        const value = this.signupUserForm.value;
        const username = value.username;
        const password = value.password;
        this.authService.signupUser(username, password);
    }

}
