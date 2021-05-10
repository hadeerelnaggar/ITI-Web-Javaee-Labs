package iti.hadeer.restservices;

import iti.hadeer.models.Task;
import iti.hadeer.repositories.TaskRepo;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/tasks")
@Produces({"application/json","application/xml"})
@Consumes({"application/json","application/xml"})
public class TaskResource {
    TaskRepo taskRepo = new TaskRepo();

    @GET
    public List<Task> getAllTasks(){
        return taskRepo.getAllTasks();
    }

    @POST
    public void createNewTask(Task task){
        taskRepo.addTask(task);
    }

    @PUT
    @Path("{cid}")
    public void UpdateTask(@PathParam("cid") int id,Task task){
        taskRepo.updateTask(id,task);
    }

    @GET
    @Path("{cid}")
    public Task getTask(@PathParam("cid") int id){
        return taskRepo.getTask(id);
    }

    @DELETE
    @Path("{cid}")
    public void deleteTask(@PathParam("cid") int id){
        taskRepo.deleteTask(id);
    }

}
