import dao.BuyerBuyProduct;
import dao.Product;
import dao.Seller;
import dao.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.*;

import java.util.List;

public class NewMain {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<User> usersOrderedByName = session.createCriteria(User.class).addOrder(Order.asc("userName")).list();
        for(int i=0;i<usersOrderedByName.size();i++){
            System.out.println(usersOrderedByName.get(i).getUserName());
        }
        System.out.println("---------------------------------------------------------------------------------------");
        User oneUser = (User) session.createCriteria(User.class).add(Restrictions.eq("userName","Hashem").ignoreCase()).uniqueResult();
        System.out.println(oneUser.getUserName());
        String[] emails = { "hadeerelnaggar@hotmail.com", "Medhat@hibernate.org" };
        User newUser = (User) session.createCriteria(User.class).add(Restrictions.in("email",emails)).uniqueResult();
        System.out.println(newUser.getUserName()+" "+newUser.getEmail());
        List<String> userNames =session.createCriteria(User.class).setProjection(Projections.projectionList()
        .add(Projections.property("userName"))).list();
        for(int i=0;i<userNames.size();i++){
            System.out.println(userNames.get(i));
        }
//        DetachedCriteria subquery=DetachedCriteria.forClass(Product.class, "p");
//        subquery= subquery.add(Restrictions.eq("p.seller.id", "s.id")).add(Restrictions.isNotNull("p.buyerBidProducts")).setProjection(Property.forName("p.id").count());
//        List<Seller> sellers1= session.createCriteria(Seller.class, "s").add(Property.forName("*").gt(subquery)).list();
//        for(int i=0;i<sellers1.size();i++){
//            System.out.println(sellers1.get(i).getValue());
//        }

        List<Seller> sellers = session.createCriteria(Seller.class).createAlias("products", "p").add( Restrictions.like("value", "%seller%").ignoreCase()).add( Restrictions.like("p.name", "%re%")).list();
        for(int i=0;i<sellers.size();i++){
            System.out.println(sellers.get(i).getValue());
        }

//        session.createCriteria(BuyerBuyProduct.class).add(Restrictions.eq("product",));



    }
}
