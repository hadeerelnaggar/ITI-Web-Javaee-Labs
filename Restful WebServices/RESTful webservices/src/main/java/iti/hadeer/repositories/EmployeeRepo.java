package iti.hadeer.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import iti.hadeer.models.Employee;

public class EmployeeRepo {
    EntityManagerFactory emf;
    EntityManager em;
    public EmployeeRepo(){
        emf = Persistence.createEntityManagerFactory("hibernate");
        em = emf.createEntityManager();
    }

    public Employee addEmployee(Employee emp){ 
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
        return emp;
    }

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

    public Employee getEmployee(int id){
        return em.find(Employee.class, id);
    }

    public List<Employee> getAllEmployees(){
        TypedQuery<Employee> tQuery = em.createNamedQuery("selectAll",Employee.class);
        return tQuery.getResultList();
    }
}
