package iti.hadeer.repositories;

import iti.hadeer.models.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TaskRepo {
    EntityManagerFactory emf;
    EntityManager em;
    public TaskRepo(){
        emf = Persistence.createEntityManagerFactory("hibernate");
        em = emf.createEntityManager();
    }

    public Task addTask(Task emp){
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
        return emp;
    }

    public Task updateTask(int id,Task task){
        em.getTransaction().begin();
        Task employee = em.find(Task.class, id);
        if(employee==null){
            em.getTransaction().commit();
            return null;
        }
        employee.setTitle(task.getTitle());
        employee.setDone(task.isDone());
        employee.setCreateDate(task.getCreateDate());
        em.getTransaction().commit();
        return task;
    }

    public Task deleteTask(int id){
        em.getTransaction().begin();
        Task task = em.find(Task.class, id);
        if(task==null){
            em.getTransaction().commit();
            return null;
        }
        em.remove(task);
        em.getTransaction().commit();
        return task;
    }

    public Task getTask(int id){
        return em.find(Task.class, id);
    }

    public List<Task> getAllTasks(){
        TypedQuery<Task> tQuery = em.createNamedQuery("selectAllTasks",Task.class);
        return tQuery.getResultList();
    }
}
