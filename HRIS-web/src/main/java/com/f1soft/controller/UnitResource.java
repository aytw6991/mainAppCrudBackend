package com.f1soft.controller;

import dto.UnitCreateRequest;
import dto.UnitEditRequest;
import entity.Unit;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.UnitService;

@Path("unit")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UnitResource {
    @Inject UnitService unitService;

    public UnitResource() {
    }
    
    @GET
    public List<Unit> getAll(){
        return unitService.getAll();
    }
    
    @GET
    @Path("/{id}")
    public Unit getById(@PathParam("id") int id){
        return unitService.getById(id);
    }
    
    @POST
    public Unit create(UnitCreateRequest unitCreateRequest){
        return unitService.create(unitCreateRequest);
    }
    
    @PUT
    @Path("/{id}")
    public Unit edit(@PathParam("id") int id, UnitEditRequest unitEditRequest){
        return unitService.edit(id, unitEditRequest);
    }
    
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id){
        unitService.delete(id);
    }   
}
