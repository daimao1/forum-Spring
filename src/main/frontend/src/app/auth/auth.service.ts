import {Injectable} from "@angular/core";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {TokenStorage} from "../token.storage";
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Router} from "@angular/router";

@Injectable()
export class AuthService {
    adminMode = false;
    badCredentials = false;

    user = {
        username: '',
        password: ''
    };

    constructor(private http: HttpClient, private token: TokenStorage) {
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
        return this.http.post('/api/token/generate-token', credentials)
            .catch(
                (err) => {
                    this.badCredentials = true;
                    console.log('Error. Bad credentials!');
                    return Observable.throw(err)
                })
    }

    logout() {
        this.token.signOut();
    }

    setAdminMode() {
        this.adminMode = !this.adminMode;
        console.log("admin mode is on");
    }

    isAdminMode() {
        return this.adminMode;
    }

    isAuthenticated() {
        return this.token.getToken() != null;
    }

    isBadCredentials() {
        return this.badCredentials;
    }

}
