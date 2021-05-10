package dao;
// Generated Mar 21, 2021, 3:28:36 PM by Hibernate Tools 6.0.0.Alpha2


import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Buyer generated by hbm2java
 */
@Entity
@Table(name="buyer"
    ,catalog="biddingschema"
    , uniqueConstraints = @UniqueConstraint(columnNames="user_id") 
)
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Buyer  implements java.io.Serializable {


     private Integer id;
     private User user;
     private String value;
     private Set<BuyerBuyProduct> buyerBuyProducts = new HashSet<BuyerBuyProduct>(0);
     private Set<BuyerBidProduct> buyerBidProducts = new HashSet<BuyerBidProduct>(0);

    public Buyer() {
    }

	
    public Buyer(User user, String value) {
        this.user = user;
        this.value = value;
    }
    public Buyer(User user, String value, Set<BuyerBuyProduct> buyerBuyProducts, Set<BuyerBidProduct> buyerBidProducts) {
       this.user = user;
       this.value = value;
       this.buyerBuyProducts = buyerBuyProducts;
       this.buyerBidProducts = buyerBidProducts;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", unique=true, nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="value", nullable=false, length=150)
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="buyer")
    public Set<BuyerBuyProduct> getBuyerBuyProducts() {
        return this.buyerBuyProducts;
    }
    
    public void setBuyerBuyProducts(Set<BuyerBuyProduct> buyerBuyProducts) {
        this.buyerBuyProducts = buyerBuyProducts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="buyer")
    public Set<BuyerBidProduct> getBuyerBidProducts() {
        return this.buyerBidProducts;
    }
    
    public void setBuyerBidProducts(Set<BuyerBidProduct> buyerBidProducts) {
        this.buyerBidProducts = buyerBidProducts;
    }




}

