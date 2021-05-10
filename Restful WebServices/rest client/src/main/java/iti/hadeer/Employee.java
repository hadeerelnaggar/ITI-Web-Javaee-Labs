package iti.hadeer;

import java.util.List;

import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.*;

@XmlRootElement
public class Employee {

    @Getter
    @Setter
    int id;
    @Getter
    @Setter
    String firstName;
    @Getter
    @Setter
    String email;
    @Getter
    @Setter
    String lastName;
    @Getter
    @Setter
    int age;

    @Setter
    @Getter
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    List<Link> links;

}
