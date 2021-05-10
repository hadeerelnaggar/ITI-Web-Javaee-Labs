package iti.hadeer.restservices.exceptions;

import iti.hadeer.restservices.exceptions.models.ErrorMessage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException>{

    @Override
    public Response toResponse(ResourceNotFoundException exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatusCode(404);
        errorMessage.setErrorMessage(exception.getMessage());
        errorMessage.setErrorDescription("Probably wrong ID");
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    }
    
}
