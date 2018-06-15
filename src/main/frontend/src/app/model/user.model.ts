export class User {
    id: number;
    username: string;
    email: string;
    firstName: string;
    lastName: string;
    isActive: boolean;
    avatarUrl: string;
    dateOfSignUp: Date;

    constructor(username: string, email: string, firstName: string, lastName: string, avatarUrl: string) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatarUrl = avatarUrl;
    }
}
