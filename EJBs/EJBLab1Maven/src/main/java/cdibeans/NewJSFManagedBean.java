/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdibeans;

import beans.NewSessionBean;
import beans.NewSessionBeanLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Hadeer
 */
@Named(value = "newJSFManagedBean")
@SessionScoped
public class NewJSFManagedBean implements Serializable{

    @EJB
    private NewSessionBeanLocal newSessionBeanLocal;
    String message;
    public NewJSFManagedBean(){
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public void callBean(){
        this.message = newSessionBeanLocal.sayHello(getMessage());
    }
    
}
