import dao.Account;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Account account = new Account();
        account.setUserName("sss");
        account.setAddress("solimania");
        account.setBirthday(new Date());
        account.setFullName("hadeer elnaggar");
        account.setPhone("01939029392");
        account.setPassword("123");

        session.beginTransaction();
        session.persist(account);
        session.getTransaction().commit();
        session.close();

    }
}
