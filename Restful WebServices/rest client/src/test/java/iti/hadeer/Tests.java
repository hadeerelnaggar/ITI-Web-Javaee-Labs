package iti.hadeer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Tests {
    ClientClass clientClass = new ClientClass();;
    
    @Test
    public void getEmployee(){
        Employee emp = clientClass.getEmployee(13);
        assertEquals("dardora", emp.getFirstName());
    }

    
}
