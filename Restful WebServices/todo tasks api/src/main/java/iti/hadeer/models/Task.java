package iti.hadeer.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@Entity
@Table(name = "tasks")
@Data
@NamedQuery(name = "selectAllTasks",
        query = "select t from Task t ")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter(AccessLevel.NONE)
    int id;

    @Setter
    @Getter
    String title;

    @Setter
    @Getter
    @Column(name = "isdone")
    boolean done;

//    @Setter
//    @Getter
//    @Column(name = "createdate")
//    Date createDate;


}
