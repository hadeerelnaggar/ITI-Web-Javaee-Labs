package iti.hadeer;

import jakarta.xml.ws.handler.LogicalHandler;
import jakarta.xml.ws.handler.LogicalMessageContext;
import jakarta.xml.ws.handler.MessageContext;

public class MyLogicalHandler implements LogicalHandler<LogicalMessageContext>{

    @Override
    public void close(MessageContext arg0) {

    }

    @Override
    public boolean handleFault(LogicalMessageContext arg0) {
        System.out.println("handle logical fault");
        return true;
    }

    @Override
    public boolean handleMessage(LogicalMessageContext arg0) {
        System.out.println("handle logical message");

        return true;
    }

    
    
}
