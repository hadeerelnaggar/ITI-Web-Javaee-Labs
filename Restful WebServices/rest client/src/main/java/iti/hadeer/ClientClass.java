package iti.hadeer;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

public class ClientClass {
    WebTarget target;
    
    public ClientClass(){
        target = ClientBuilder.newClient().target("http://localhost:1919/REST-lab2/api/employees");
    }
    
    public Employee getEmployee(int id){
        return target.path("{sid}").resolveTemplate("sid", id).request().get(Employee.class);
    }

    
}
