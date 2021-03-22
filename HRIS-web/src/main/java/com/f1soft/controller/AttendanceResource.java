package com.f1soft.controller;

import entity.Attendance;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import service.AttendanceService;

@Path("attendance")
public class AttendanceResource {
    @Inject AttendanceService attendanceService;
    
    @GET
    public List<Attendance> getAll(){
        return attendanceService.getAll();
    }
    
    @GET
    @Path("/late")
    public List<Attendance> getLateCheckIn(){
        return attendanceService.getLateCheckIn();
    }
    
    @GET
    @Path("/early")
    public List<Attendance> getEarlyCheckOut(){
        return attendanceService.getEarlyCheckOut();
    }
    
    @POST
    public Attendance logIn(Attendance attendance){
        return attendanceService.logIn(attendance);
    }
    
}
