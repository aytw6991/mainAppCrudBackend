package DaoImpl;

import entity.Employee;
import dao.EmployeeDao;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@ApplicationScoped
public class EmployeeDaoImpl implements EmployeeDao{
    @PersistenceContext
    EntityManager em;
    
    @Override
    public List<Employee> getAll() {
        Query query =  em.createNamedQuery("Employee.findAll", Employee.class);
        return query.getResultList();
    }
    
    @Override
    public Employee getById(int id) {
        return em.find(Employee.class, id);
    }

    @Override
    public Employee create(Employee employee) {
        em.persist(employee);
        return employee;    
    }

    @Override
    public Employee edit(int id, Employee employee) {
        em.find(Employee.class, id);
        em.merge(employee);
        return employee;
    }

    @Override
    public void delete(int id) {
        Employee f = em.find(Employee.class, id);
        em.remove(f);
    }
}