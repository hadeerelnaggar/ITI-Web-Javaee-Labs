package iti.hadeer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;


@WebService
public class EmployeeCRUDs{
    EntityManagerFactory emf;
    EntityManager em;
    public EmployeeCRUDs(){
        emf = Persistence.createEntityManagerFactory("hibernate");
        em = emf.createEntityManager();
    }
    @WebMethod
    public Employee addEmployee(Employee emp){ 
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
        return emp;
    }
    @WebMethod
    public Employee updateEmployee(int id,Employee emp){
        em.getTransaction().begin();
        Employee employee = em.find(Employee.class, id);
        if(employee==null){
            em.getTransaction().commit();
            return null;
        }
        employee.setAge(emp.getAge());
        employee.setEmail(emp.getEmail());
        employee.setFirstName(emp.getFirstName());
        employee.setLastName(emp.getLastName());
        em.getTransaction().commit();
        return emp;
    }

    @WebMethod
    public Employee deleteEmployee(int id){
        em.getTransaction().begin();
        Employee employee = em.find(Employee.class, id);
        if(employee==null){
            em.getTransaction().commit();
            return null;
        }
        em.remove(employee);
        em.getTransaction().commit();
        return employee;
    }

    @WebMethod
    public Employee getEmployee(int id){
        // em.getTransaction().close();
        return em.find(Employee.class, id);
    }


}