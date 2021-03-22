package com.f1soft.controller;

import dto.EmployeeCreateRequest;
import dto.EmployeeEditRequest;
import entity.Employee;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import service.EmployeeService;

@Path("employee")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    @Inject EmployeeService employeeService;
   
    public EmployeeResource(){
    }
    
    @GET
    public List<Employee> getAll(){
        return employeeService.getAll();
    }
    
    @GET
    @Path("/{id}")
    public Employee getById(@PathParam("id") int id){
        return employeeService.getById(id);
    }
 
    @POST
    public Employee create(EmployeeCreateRequest employeeCreateRequest) {
        return employeeService.create(employeeCreateRequest);
    }
    
    @PUT
    @Path("/{id}")
    public Employee edit(@PathParam("id") int id, EmployeeEditRequest employeeEditRequest){
        return employeeService.edit(id, employeeEditRequest);
    }
    
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id){
        employeeService.delete(id);
    }
}