package iti.hadeer;

import com.mysql.cj.x.protobuf.MysqlxNotice.SessionStateChanged.Parameter;

import org.hibernate.procedure.spi.ParameterStrategy;
import org.jboss.jandex.TypeTarget.Usage;

import jakarta.jws.Oneway;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.Use;

@WebService(name = "CalculatorWebService", portName = "calc", serviceName = "calculator")
// @SOAPBinding(style = Style.RPC, use = Use.ENCODED, parameterStyle =
// ParameterStyle.WRAPPED)
// @SOAPBinding(style = Style.DOCUMENT, parameterStyle = ParameterStyle.BARE,
// use = Use.LITERAL)
@SOAPBinding(style = Style.DOCUMENT, parameterStyle = ParameterStyle.BARE, use = Use.LITERAL)
public class Calculator {

    @WebMethod(operationName = "addNumbers")
    public int add(@WebParam(name = "numberOne") int num1/*, @WebParam(partName = "numberTwo") int num2*/) {
        return num1;
    }

    @WebMethod(exclude = true)
    @Oneway
    public void oneWayMethod(int num) {
        System.out.println("helloo");
    }

}
