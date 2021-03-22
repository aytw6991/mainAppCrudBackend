package service;

import DaoImpl.AttendanceDaoImpl;
import entity.Attendance;
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
    
    public Attendance logIn(Attendance attendance){
        Attendance attendanceNew = new Attendance();
        
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        
        attendanceNew.setLoggedDate(date);
        attendanceNew.setLoggedTime(time);
        attendanceNew.setLoggedBy(attendance.getLoggedBy());
        return attendanceDaoImpl.logIn(attendanceNew);
    }
    
    public List<Attendance> getEarly(){
        LocalTime lt = LocalTime.parse("11:00:00");
        List<Attendance> attendanceList = getAll();
        List<Attendance> earlyAttendanceList = new ArrayList<>();
        
        for(int i = 0; i < attendanceList.size(); i++){
            int val = lt.compareTo(attendanceList.get(i).getLoggedTime());
            if (val > 0){
                earlyAttendanceList.add(attendanceList.get(i));
            }   
        }        
        return earlyAttendanceList;
    }
    
    public List<Attendance> getLate(){
        LocalTime lt = LocalTime.parse("11:00:00");
        List<Attendance> attendanceList = getAll();
        List<Attendance> lateAttendanceList = new ArrayList<>();
        
        for(int i = 0; i < attendanceList.size(); i++){
            int val = lt.compareTo(attendanceList.get(i).getLoggedTime());            
            if (val < 0){
                lateAttendanceList.add(attendanceList.get(i));
            }
        }        
       return lateAttendanceList;
    }
}
