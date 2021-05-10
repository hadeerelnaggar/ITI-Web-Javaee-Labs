/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.TimerService;

/**
 *
 * @author Hadeer
 */
@Singleton
public class ProgrammingTimer {

    @Resource
    private TimerService timerService;

    @Timeout
    public void timeOut() {
        System.out.println("Method Invoked");
        // Add business logic below. (Right-click in editor and choose
        // "Insert Code > Add Business Method")
    }

    public void initTimer() {
        System.out.println("INIT-CALLED");
        ScheduleExpression exp = new ScheduleExpression();
        exp.hour("*").minute("*").second("*/4");
        timerService.createCalendarTimer(exp);
    }

}
