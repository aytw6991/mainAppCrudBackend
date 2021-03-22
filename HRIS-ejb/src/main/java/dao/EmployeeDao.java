package dao;

import entity.Employee;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EmployeeDao {
    public List<Employee> getAll();
    public Employee getById(int id);
    public Employee create(Employee employee);
    public Employee edit(int id, Employee employee);
    public void delete(int id);
}
