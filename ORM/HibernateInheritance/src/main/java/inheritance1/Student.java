package inheritance1;

public class Student extends Person{
    String department;

    public Student() {
    }

    public Student(String firstName, String lastName, String department) {
        super(firstName, lastName);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
