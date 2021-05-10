/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejbtimer;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

/**
 *
 * @author Hadeer
 */
@Named(value = "managedBean")
@SessionScoped
public class ManagedBean implements Serializable {

    @EJB
    AsynchronousSessionBeanRemote bean;
    
    Future<Long> result;
    Long num;
    /**
     * Creates a new instance of ManagedBean
     */
    public ManagedBean() {
    }
    
    public Long getNum(){
        return num;
    }
    
    public void slowMethod(){
        bean.slowMethod();
    }
    
    public void slowMethodWithReturn(){
        result = bean.slowMethodWithReturnValue();
    }
    
    public void longResult(){
        try {
//            Logger.getLogger(ManagedBean.class.getName()).log(Level.SEVERE, null, result.get());
            num = result.get();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(ManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
