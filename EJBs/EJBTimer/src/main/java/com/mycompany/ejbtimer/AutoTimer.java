/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejbtimer;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Hadeer
 */

//@DependsOn("ProgrammingTimer")
//@Singleton
//@Startup
public class AutoTimer {

    @PostConstruct
    @Schedule(hour = "*", minute = "*", second = "*/4")
    public void timeOut() {
        System.out.println("Auto Method Invoked");
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
