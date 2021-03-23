package service;

import DaoImpl.AttendanceDaoImpl;
import dto.AttendanceRequest;
import entity.Attendance;
import entity.Employee;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class AttendanceService {
    @Inject AttendanceDaoImpl attendanceDaoImpl; 

    public List<Attendance> getAll(){
        return attendanceDaoImpl.getAll();
    }
    
    public Attendance checkInOut(AttendanceRequest attendanceRequest){
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        
        Attendance attendance = new Attendance();
        attendance.setLoggedDate(date);
        attendance.setLoggedTime(time);
        attendance.setStatus(attendanceRequest.getStatus());
        attendance.setEmployee(attendanceRequest.getEmployee());
        return attendanceDaoImpl.checkInOut(attendance);
    }
    
    public List<Attendance> getEarlyCheckOut(){
        LocalTime lt = LocalTime.parse("18:00:00");
        List<Attendance> attendanceList = getAll();
        List<Attendance> earlyCheckOutList = new ArrayList<>();
        
        for(int i = 0; i < attendanceList.size(); i++){
            if(attendanceList.get(i).getStatus().equals("Check Out")){
                int val = lt.compareTo(attendanceList.get(i).getLoggedTime());
                if (val > 0){
                    earlyCheckOutList.add(attendanceList.get(i));
                }
            }
        }
        return earlyCheckOutList;
    }
    
    public List<Attendance> getLateCheckIn(){
        LocalTime lt = LocalTime.parse("09:00:00");
        List<Attendance> attendanceList = getAll();
        List<Attendance> lateCheckInList = new ArrayList<>();
        
        for(int i = 0; i < attendanceList.size(); i++){
            if(attendanceList.get(i).getStatus().equals("Check In")){
                int val = lt.compareTo(attendanceList.get(i).getLoggedTime());            
                if (val < 0){
                    lateCheckInList.add(attendanceList.get(i));
                }
            }
        }        
       return lateCheckInList;
    }
}
