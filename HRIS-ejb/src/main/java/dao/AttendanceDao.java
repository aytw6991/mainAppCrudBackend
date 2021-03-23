package dao;

import entity.Attendance;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AttendanceDao {
    public List<Attendance> getAll();
    public Attendance checkInOut(Attendance attendance);
}
