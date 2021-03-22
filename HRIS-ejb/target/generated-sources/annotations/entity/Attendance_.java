package entity;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-22T13:04:38")
@StaticMetamodel(Attendance.class)
public class Attendance_ { 

    public static volatile SingularAttribute<Attendance, String> loggedBy;
    public static volatile SingularAttribute<Attendance, LocalTime> loggedTime;
    public static volatile SingularAttribute<Attendance, Integer> id;
    public static volatile SingularAttribute<Attendance, LocalDate> loggedDate;

}