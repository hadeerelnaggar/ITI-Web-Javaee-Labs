package iti.hadeer;

import java.util.Set;

import javax.xml.namespace.QName;

import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;

public class MySoapHandler implements SOAPHandler<SOAPMessageContext>{

    @Override
    public void close(MessageContext arg0) {
        
    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleFault(SOAPMessageContext arg0) {
        System.out.println("handle SOAP faults");
        return true;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext arg0) {
        System.out.println("handle SOAP messages");
        return true;
    }
    
}
