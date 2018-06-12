import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class AuthService {
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

    attemptAuth(username: string, password: string): Observable<any> {
        const credentials = {username: username, password: password};
        console.log('token is generating...');
        return this.http.post('/api/token/generate-token', credentials);
    }

    setAdminMode() {
        this.adminMode = !this.adminMode;
        console.log("admin mode is on");
    }

    isAdminMode() {
        return this.adminMode;
    }
}
