
package iti.hadeer.jaxws;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "addNumbers", namespace = "http://hadeer.iti/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addNumbers", namespace = "http://hadeer.iti/", propOrder = {
    "numberOne",
    "arg1"
})
public class Add {

    @XmlElement(name = "numberOne", namespace = "")
    private int numberOne;
    @XmlElement(name = "arg1", namespace = "")
    private int arg1;

    /**
     * 
     * @return
     *     returns int
     */
    public int getNumberOne() {
        return this.numberOne;
    }

    /**
     * 
     * @param numberOne
     *     the value for the numberOne property
     */
    public void setNumberOne(int numberOne) {
        this.numberOne = numberOne;
    }

    /**
     * 
     * @return
     *     returns int
     */
    public int getArg1() {
        return this.arg1;
    }

    /**
     * 
     * @param arg1
     *     the value for the arg1 property
     */
    public void setArg1(int arg1) {
        this.arg1 = arg1;
    }

}
