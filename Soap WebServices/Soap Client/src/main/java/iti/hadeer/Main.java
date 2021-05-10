package iti.hadeer;

import iti.hadeer.employeeservices.*;

public class Main {
    public static void main(String []args){
        EmployeeCRUDsService employeeCRUDsService= new EmployeeCRUDsService();
        EmployeeCRUDs employeeCRUDs = employeeCRUDsService.getEmployeeCRUDsPort();
        Employee emp = new Employee();
    
        emp.setAge(10);
        emp.setFirstName("dero");
        emp.setLastName("hhh");
        
        emp.setEmail("hd@dks.dkd");
        employeeCRUDs.addEmployee(emp);
    }

}
