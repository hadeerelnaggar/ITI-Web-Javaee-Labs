/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author Hadeer
 */
@Remote
public interface NewSessionBeanLocal {
    String sayHello(String name);
    
}
