import {Component, OnInit, ViewChild} from '@angular/core';
import {AuthService} from "../auth.service";
import {TokenStorage} from "../../token.storage";
import {NgForm} from "@angular/forms";
import {Router} from "@angular/router";
import {UserService} from "../../service/user.service";

@Component({
    selector: 'app-signin',
    templateUrl: './signin.component.html',
    styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
    @ViewChild('f') signinUserForm: NgForm;
    isSendButtonActivated = true;

    constructor(private authService: AuthService, private token: TokenStorage, private router: Router, private userService: UserService) {
    }

    ngOnInit() {
    }

    onLogin(): void {
        const value = this.signinUserForm.value;
        const username = value.username;
        const password = value.password;
        this.authService.attemptAuth(username, password).subscribe(
            data => {
                this.token.saveToken(data.token);

                this.userService.getCurrentUser().subscribe(
                    (currentUser: any) => {
                        if (currentUser.roles[0].name === "ADMIN") {
                            this.authService.setAdminMode();
                            console.log("JESTEŚ ADMINEM");
                        }
                        else {
                            this.authService.deactivateAdminMode();
                        }
                    }
                );
                this.isSendButtonActivated = false;
                this.router.navigate(['posts-list']);
            }
        );
    }

}
