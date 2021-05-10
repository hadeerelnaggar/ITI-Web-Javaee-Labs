import dao.Buyer;
import dao.Product;
import dao.Seller;
import dao.User;
import dto.ProductDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        //get all products
        Query query = session.createQuery("from Product");
        List<Product> result = query.getResultList();
        System.out.println("All products:");
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i).getName());
        }
        System.out.println("----------------------------------------------------------------------------------");
        //get products with name = dress
        System.out.println("Dress products:");
        Query query1 = session.createQuery("from Product p where p.name like :name").setParameter("name","dress");
        List<Product> dressProducts = query1.getResultList();
        System.out.println("Dress products");
        for (Product product:
             dressProducts) {
            System.out.println(product.getName());
        }
        System.out.println("------------------------------------------------------------------------------------");
        Query query2 = session.createQuery("select p.name, p.id from Product p where p.manufacturingDate <= :date").setParameter("date",new Date(), TemporalType.DATE);
        List<Object[]> dateProducts = query2.getResultList();
        System.out.println("Date products");
        for (Object[] product:
                dateProducts) {
            System.out.println(product[0]+" "+product[1]);
        }
        System.out.println("------------------------------------------------------------------------------------");
        Seller seller = session.get(Seller.class,2);
        Query query3 = session.createQuery("select concat(u.userName,\'-\',u.email) from User u where u.seller= :sellerKey").setParameter("sellerKey",seller);
        List<String> userNames = query3.getResultList();
        System.out.println("User for seller");
        for (String userName:
                userNames) {
            System.out.println(userName);
        }
        System.out.println("------------------------------------------------------------------------------------");
        Query query4 = session.createQuery("select p.name, p.id from Product p where p.manufacturingDate is not null");
        List<Object[]> productsWithDate = query4.getResultList();
        System.out.println("Products with dates");
        for (Object[] product:
                productsWithDate) {
            System.out.println(product[0]+" "+product[1]);
        }
        System.out.println("------------------------------------------------------------------------------------");
        Query query5 = session.createQuery("from Product p where p.categories is not empty");
        List<Product> categoryProducts = query5.getResultList();
        System.out.println("Category products");
        for (Product product:
                categoryProducts) {
            System.out.println(product.getName());
        }
        System.out.println("------------------------------------------------------------------------------------");
        Query query6 = session.createQuery("from User u order by u.userName asc ,u.id desc ");
        List<User> ordered = query6.getResultList();
        System.out.println("users ordered");
        for (User user:
                ordered) {
            System.out.println(user.getUserName()+" "+user.getId());
        }
        System.out.println("------------------------------------------------------------------------------------");
        Query query7 = session.createQuery("from Product p where p member of p.categories");
        List<Product> memeberOf = query7.getResultList();
        System.out.println("products member of category");
        for (Product product:
                memeberOf) {
            System.out.println(product.getName()+" "+product.getId());
        }
        System.out.println("------------------------------------------------------------------------------------");
        Query query8 = session.createQuery("select sum(buy.amount) from BuyerBidProduct buy");
        List<Integer> totalAmount = query8.getResultList();
        System.out.println("sum of product amount");
        System.out.println(totalAmount.get(0));
        System.out.println("------------------------------------------------------------------------------------");
        Query query9 = session.createQuery("from Seller s where s.user.email like '%@hotmail.com'");
        List<Seller> sellers = query9.getResultList();
        System.out.println("sellers association");
        for (Seller seller1:
                sellers) {
            System.out.println(seller1.getId()+" "+seller1.getUser().getEmail());
        }
        System.out.println("------------------------------------------------------------------------------------");
        Query query10 = session.createQuery("from Product p join p.seller s where s.value like 'cloth%'");
        List<Object[]> joinResult = query10.getResultList();
        System.out.println("Products with dates");
        for (Object[] join:
                joinResult) {
            Product product = (Product) join[0];
            Seller seller1 = (Seller) join[1];
            System.out.println(product.getName()+"-"+seller1.getValue());
        }
        System.out.println("------------------------------------------------------------------------------------");
        Query query11 = session.createQuery("from Seller s , Buyer b where s.value = b.value");
        List<Object[]> thetaJoinResult = query11.getResultList();
        System.out.println("theta Join");
        for (Object[] join:
                thetaJoinResult) {
            Buyer buyer = (Buyer) join[1];
            Seller seller1 = (Seller) join[0];
            System.out.println(buyer.getValue()+"-"+seller1.getValue());
        }
        System.out.println("------------------------------------------------------------------------------------");
        Query query12 = session.createQuery("select p.name, count(p) from Product p group by p.name having count(p)>2");
        List<Object[]> groupingResult = query12.getResultList();
        System.out.println("groupingResult");
        for (Object[] join:
                groupingResult) {
            System.out.println(join[0]+" "+join[1]);
        }
        System.out.println("------------------------------------------------------------------------------------");
        ProductDto productDto = new ProductDto();
        Query query13 = session.createQuery("select new dto.ProductDto(p.name, count(p)) from Product p group by p.name having count(p)>2");
        List<ProductDto> productDTO = query13.getResultList();
        System.out.println("Dynamic instantiation");
        for (ProductDto res:
                productDTO) {
            System.out.println(res.getName()+" "+res.getCount());
        }
        System.out.println("------------------------------------------------------------------------------------");
        Query query14 = session.createQuery("from Product p where p.seller = all(from Seller s where s.value like 'cloth%')");
        List<Product> subSelect = query14.getResultList();
        System.out.println("subSelect");
        for (Product product:
                subSelect) {
            System.out.println(product.getName()+" "+product.getId());
        }






        session.close();
        sessionFactory.close();
    }
}
