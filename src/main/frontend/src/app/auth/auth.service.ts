import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AuthServiceImitation {
    adminMode = false;

    user = {
        username: '',
        password: ''
    };

    constructor(private http: HttpClient) {
    }

    signupUser(username: string, password: string) {
        this.user.username = username;
        this.user.password = password;
        this.http.post('/api/users/signup', this.user).subscribe(
            () => {
                console.log("User signed up!");
            }
        )
    }

    getToken() {

    }

    setAdminMode() {
        this.adminMode = !this.adminMode;
        console.log("admin mode is on");
    }

    isAdminMode() {
        return this.adminMode;
    }
}
