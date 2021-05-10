package iti.hadeer.models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@XmlRootElement
@Entity
@Table(name = "employee")

@NamedQuery(
    name = "selectAll",
    query = "select e from Employee e"
)
public class Employee{
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "firstname")
    String firstName;

    @Column
    String email;

    @Column(name = "lastname")
    String lastName;

    @Column
    int age;

    @Setter
    @Getter
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    @Transient
    List<Link> links;

    public Employee(){

    }

    public Employee(String firstName, String lastName, String email, int age){
        this.age=age;
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }

    public void setAge(int age){
        this.age=age;
    }

    public int getAge(){
        return age;
    }


}