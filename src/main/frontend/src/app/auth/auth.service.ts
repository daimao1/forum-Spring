import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {TokenStorage} from "../token.storage";
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {User} from "../model/user.model";
import {UserService} from "../service/user.service";

@Injectable()
export class AuthService {
    adminMode = false;
    badCredentials = false;

    user = {} as User;

    constructor(private http: HttpClient, private token: TokenStorage) {
    }

    signupUser(user: User) {
        this.http.post('/api/users/signup', user).subscribe(
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
        this.adminMode = false;
        this.token.signOut();
    }

    setAdminMode() {
        this.adminMode = true;
        console.log("admin mode is on");
    }

    deactivateAdminMode() {
        this.adminMode = false;
        console.log("admin mode is off")
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
