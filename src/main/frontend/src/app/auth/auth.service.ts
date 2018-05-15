import {Injectable} from "@angular/core";

@Injectable()
export class AuthServiceImitation {
    adminMode = false;

    setAdminMode() {
        this.adminMode = !this.adminMode;
        console.log("admin mode is on");
    }

    isAdminMode() {
        return this.adminMode;
    }
}
