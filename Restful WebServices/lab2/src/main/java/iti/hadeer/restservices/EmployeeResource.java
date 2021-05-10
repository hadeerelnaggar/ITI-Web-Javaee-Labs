package iti.hadeer.restservices;

import java.util.Arrays;
import java.util.List;

import iti.hadeer.models.Employee;
import iti.hadeer.repositories.EmployeeRepo;
import iti.hadeer.restservices.exceptions.ResourceNotFoundException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("/employees")
@Produces({"application/json","application/xml"})
@Consumes({"application/json","application/xml"})
public class EmployeeResource {
    EmployeeRepo employeeRepo = new EmployeeRepo();
    
    @GET
    public Response getAllEmpolyees(){
        List<Employee> employees = employeeRepo.getAllEmployees();
        return Response.ok(employees).build();
    }

    @POST
    public Response createNewEmployee(Employee employee,@Context UriInfo uriInfo){
        Employee emp = employeeRepo.addEmployee(employee);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(String.valueOf(emp.getId())).build()).entity(emp).build();

    }

    @PUT
    @Path("{cid}")
    public Response updateEmployee(@PathParam("cid") int id,Employee employee,@Context UriInfo uriInfo){
        Employee emp = employeeRepo.updateEmployee(id,employee);
        if(emp==null){
            throw new ResourceNotFoundException("Wrong id");
        }
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("Updated Employee").build();
        Link all = Link.fromUriBuilder(uriInfo.getBaseUriBuilder().path("employees")).rel("get all").build();
        emp.setLinks(Arrays.asList(self,all));
        return Response.status(Response.Status.ACCEPTED).entity(emp).build();
    }

    @GET
    @Path("{cid}")
    public Response getEmployee(@PathParam("cid") int id){
        Employee emp = employeeRepo.getEmployee(id);
        if(emp==null){
            throw new ResourceNotFoundException("Wrong id");
        }
        return Response.ok(emp).build();
    }

    @DELETE
    @Path("{cid}")
    public Response deleteEmployee(@PathParam("cid") int id){
        Employee emp = employeeRepo.deleteEmployee(id);
        if(emp==null){
            throw new ResourceNotFoundException("Wrong id");
        }
        return Response.ok().build();
    }
}
