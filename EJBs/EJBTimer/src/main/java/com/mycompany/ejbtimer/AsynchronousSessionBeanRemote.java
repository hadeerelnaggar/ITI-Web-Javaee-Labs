/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejbtimer;

import java.util.concurrent.Future;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author Hadeer
 */
@Remote
public interface AsynchronousSessionBeanRemote {

    public void slowMethod();
    public Future<Long> slowMethodWithReturnValue();
}
