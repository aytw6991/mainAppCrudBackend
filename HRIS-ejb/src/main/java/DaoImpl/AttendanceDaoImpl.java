package DaoImpl;

import dao.AttendanceDao;
import entity.Attendance;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@ApplicationScoped
public class AttendanceDaoImpl implements AttendanceDao{
    @PersistenceContext
    EntityManager em;
    
    
    @Override
    public List<Attendance> getAll() {
        Query query = em.createNamedQuery("Attendance.getAll", Attendance.class);
        return query.getResultList();
    }

    @Override
    public Attendance checkInOut(Attendance attendance) {
        em.persist(attendance);
        return attendance;
    }
    
}
