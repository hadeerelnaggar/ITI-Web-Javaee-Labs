package inheritance1;

import java.util.Date;

public class Teacher extends Person{
    Date hireDate;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, Date hireDate) {
        super(firstName, lastName);
        this.hireDate = hireDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
