package iti.hadeer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import iti.hadeer.employeeservices.Employee;
import iti.hadeer.employeeservices.EmployeeCRUDs;
import iti.hadeer.employeeservices.EmployeeCRUDsService;

public class ServiceTest {
    private static EmployeeCRUDs employeeCRUDs;
    
    @BeforeAll
    public static void BeforeAll(){
        EmployeeCRUDsService employeeCRUDsService = new EmployeeCRUDsService();
        employeeCRUDs = employeeCRUDsService.getEmployeeCRUDsPort();
    }

    @Test
    public void addEmployee(){
        Employee emp = new Employee();
        emp.setAge(10);
        emp.setEmail("hadd@djs.cks");
        emp.setFirstName("ttt");
        emp.setLastName("value");
        Employee actualEmp = employeeCRUDs.addEmployee(emp);
        System.out.print(actualEmp);
        assertEquals(emp.getFirstName(), actualEmp.getFirstName());
        assertEquals(emp.getLastName(), actualEmp.getLastName());
        assertEquals(emp.getAge(), actualEmp.getAge());
        assertEquals(emp.getEmail(), actualEmp.getEmail());
        
 }

    @Test
    public void updateEmployee(){
        Employee emp = new Employee();
        emp.setFirstName("value");
        emp.setAge(11);
        emp.setLastName("value");
        // assertThrows(ServerSOAPFaultException.class, ()->{
        //     employeeCRUDs.updateEmployee(1, emp);
        // });
        assertEquals(null, employeeCRUDs.updateEmployee(1, emp));
    }

    @Test
    public void getNonExistingEmployee(){
        assertEquals(null, employeeCRUDs.getEmployee(1));
    }

    @Test
    public void getExistedEmployee(){
        assertNotNull(employeeCRUDs.getEmployee(2));
    }

    @Test
    public void deleteExistingEmployee(){
        assertNotNull(employeeCRUDs.deleteEmployee(10));
    } 

    @Test
    public void deleteNonExistingEmployee(){
        assertEquals(null, employeeCRUDs.deleteEmployee(1));
    }
}
