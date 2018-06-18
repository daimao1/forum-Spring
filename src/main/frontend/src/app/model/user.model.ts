export class User {
    id: number;
    username: string;
    password: string;
    email: string;
    firstName: string;
    lastName: string;
    isActive: boolean;
    avatarUrl: string;
    dateOfSignUp: Date;

    constructor(username: string, password: string, email: string, firstName: string, lastName: string, avatarUrl: string) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatarUrl = avatarUrl;
    }
}
