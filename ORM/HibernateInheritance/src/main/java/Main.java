import inheritance1.Person;
import inheritance1.Student;
import inheritance1.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Person student = new Student("hadeer","hello","jets");
        session.persist(student);
        Person teacher = new Teacher("tt","tt",new Date());
        session.persist(teacher);
        Person person = new Person("hiii","hadeer");
        session.persist(person);
        Person student2 = new Student("hashem","khaled","hhh");
        session.persist(student2);

        session.getTransaction().commit();
        session.close();

    }
}
