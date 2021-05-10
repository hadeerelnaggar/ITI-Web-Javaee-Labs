import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eclipse");
        EntityManager em = emf.createEntityManager();
        Author author = new Author("null","hjj","hagar",10);
        em.getTransaction().begin();
        em.persist(author);
        em.getTransaction().commit();
    }
}
