package iti.hadeer.restservices;

import java.util.List;

import iti.hadeer.models.Employee;
import iti.hadeer.repositories.EmployeeRepo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/employees")
@Produces({"application/json","application/xml"})
@Consumes({"application/json","application/xml"})
public class EmployeeResource {
    EmployeeRepo employeeRepo = new EmployeeRepo();
    
    @GET
    public List<Employee> getAllEmpolyees(){
        return employeeRepo.getAllEmployees();
    }

    @POST
    public void createNewEmployee(Employee employee){
        employeeRepo.addEmployee(employee);
    }

    @PUT
    @Path("{cid}")
    public void updateEmployee(@PathParam("cid") int id,Employee employee){
        employeeRepo.updateEmployee(id,employee);
    }

    @GET
    @Path("{cid}")
    public Employee getEmployee(@PathParam("cid") int id){
        return employeeRepo.getEmployee(id);
    }

    @DELETE
    @Path("{cid}")
    public void deleteEmployee(@PathParam("cid") int id){
        employeeRepo.deleteEmployee(id);
    }
}
