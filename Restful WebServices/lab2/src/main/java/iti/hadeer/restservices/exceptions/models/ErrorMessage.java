package iti.hadeer.restservices.exceptions.models;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

@Data
@XmlRootElement
public class ErrorMessage {
    @Setter
    int statusCode;
    @Setter
    String errorMessage;
    @Setter
    String errorDescription;
    
}
