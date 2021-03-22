package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Attendance_Table")
@NamedQuery(
    name = "Attendance.getAll",
    query = "SELECT a from Attendance a")
public class Attendance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="Attendance_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="Logged_Time", nullable=false)
    private LocalTime loggedTime;
    @Column(name="Logged_Date", nullable=false)
    private LocalDate loggedDate;
    @Column(name="Employee_Name", nullable=false)
    private String loggedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getLoggedTime() {
        return loggedTime;
    }

    public void setLoggedTime(LocalTime loggedTime) {
        this.loggedTime = loggedTime;
    }

    public LocalDate getLoggedDate() {
        return loggedDate;
    }

    public void setLoggedDate(LocalDate loggedDate) {
        this.loggedDate = loggedDate;
    }

    public String getLoggedBy() {
        return loggedBy;
    }

    public void setLoggedBy(String loggedBy) {
        this.loggedBy = loggedBy;
    }
    
}