/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Singleton;

/**
 *
 * @author Hadeer
 */
@Singleton
public class Counterbean {
    private int hits=1;
    
    public int getHits(){
        return hits++;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
