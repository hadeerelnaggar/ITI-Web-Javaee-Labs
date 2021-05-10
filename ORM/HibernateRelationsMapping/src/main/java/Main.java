import dao.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Session;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        User user = new User("hashem@gmail.com","giza",new Date(),"hashem","123");
//        session.persist(user);
//        Seller seller = new Seller(user,"cloth Seller");
//        session.persist(seller);
//        Category category = new Category("clothes","women clothes",new HashSet<>());
//        session.persist(category);
//        Set<Category> categorySet = new HashSet<>();
//        categorySet.add(category);
//        Product product = new Product(seller,"dress","long dress","h&m",new Date(),new Date(),30,new Date(),new Date(),categorySet,new HashSet<>(),new HashSet<>());
//        session.persist(product);
//        Buyer buyer = new Buyer(user,"clothes buyer");
//        session.persist(buyer);
//        BuyerBidProductId buyerBidProductId = new BuyerBidProductId(buyer.getId(), product.getId());
//        BuyerBidProduct buyerBidProduct = new BuyerBidProduct(buyerBidProductId,buyer,product,new Date(),50.2f,20);
//        session.persist(buyerBidProduct);
//        BuyerBuyProductId buyerBuyProductId = new BuyerBuyProductId(buyer.getId(),product.getId());
//        BuyerBuyProduct buyerBuyProduct = new BuyerBuyProduct(buyerBuyProductId,buyer,product,new Date(),10.4f,5);
//        session.persist(buyerBuyProduct);
//
//        session.getTransaction().commit();
//        session.close();

        Session session1 = sessionFactory.openSession();
        Buyer buyer = session1.find(Buyer.class,1);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(buyer.getUser().getEmail());
        if(buyer.getBuyerBuyProducts()==null){
            System.out.println("Buyer buy products not fetched yet");
        }
        else{
            System.out.println("buyerBuyProducts "+ buyer.getBuyerBuyProducts().size());
        }
        if(buyer.getBuyerBidProducts()==null){
            System.out.println("Buyer bid products not fetched yet");
        }
        else{
            System.out.println("buyerBIdproduct "+buyer.getBuyerBidProducts().size());
        }

        session1.close();
        Session session2 = sessionFactory.openSession();
        Buyer buyer1 = session2.find(Buyer.class,1);
        System.out.println(buyer1.getValue());

        session2.close();
        sessionFactory.close();
    }
}
