export class Employee {
    ID: number;
    Name: string;
    FirstName: string = "Hadeer";
    LastName: string;
    Age: number;
    Mobile: string;
    Email: string;

    constructor(name?: string, lastName?: string, email?: string, age?: number, mobile?: string) {
        if (this.FirstName === undefined) {
            this.FirstName = "Hadeer"
        }
        else
            this.FirstName = name;
        if (this.Email === undefined) {
            this.Email = "Elnaggar"
        }
        else
            this.Email = email;
        if (age === undefined) {
            this.Age = 20;
        }
        else
            this.Age = age;
        if (mobile === undefined) {
            this.Mobile = "01206968970";
        }
        else
            this.Mobile = mobile
        if (this.LastName === undefined) {
            this.LastName = "elnaggar"
        }
        else
            this.LastName = lastName
        this.Name = this.getFullName();    
    }


    getFullName(): string {
        return this.FirstName + " " + this.LastName;
    }

    setFirstName(name: string) {
        this.FirstName = name;
    }
}