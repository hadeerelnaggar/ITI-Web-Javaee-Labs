/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Hadeer
 */
@Stateless
@Remote(NewSessionBeanLocal.class)
@WebService
public class NewSessionBean implements NewSessionBeanLocal {
private final String message = "Hello, ";
    @Override
    @WebMethod
    public String sayHello(String name) {
        return message+name;
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
