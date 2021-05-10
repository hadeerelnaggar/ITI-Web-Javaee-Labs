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
        account.setUserName("hhh");
        account.setAddress("aaa");
        account.setBirthday(new Date());
        account.setFullName("hdjs elnaggar");
        account.setPhone("738289");
        account.setPassword("111");

        session.beginTransaction();
        session.persist(account);
        session.getTransaction().commit();
        session.close();

    }
}
