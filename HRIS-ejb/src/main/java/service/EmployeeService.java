package service;

import DaoImpl.EmployeeDaoImpl;
import dto.EmployeeCreateRequest;
import dto.EmployeeEditRequest;
import entity.Employee;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EmployeeService {
    @Inject EmployeeDaoImpl employeeDaoImpl;
    
    public List<Employee> getAll(){
        return employeeDaoImpl.getAll();
    }
    
    public Employee getById(int id){
        Employee employee = employeeDaoImpl.getById(id);
        return employee;
    }
    
    public Employee create(EmployeeCreateRequest employeeCreateRequest){
        Employee employee = new Employee();
        employee.setName(employeeCreateRequest.getName());
        employee.setGender(employeeCreateRequest.getGender());
        employee.setVertical(employeeCreateRequest.getVertical());
        employee.setSalary(employeeCreateRequest.getSalary());
        return employeeDaoImpl.create(employee);
    }
    
    public Employee edit(int id, EmployeeEditRequest employeeEditRequest){
        Employee employee = getById(id);
        employee.setName(employeeEditRequest.getName());
        employee.setGender(employeeEditRequest.getGender());
        employee.setVertical(employeeEditRequest.getVertical());
        employee.setSalary(employeeEditRequest.getSalary());
        return employeeDaoImpl.edit(id, employee);
    }
    
    public void delete(int id){
        employeeDaoImpl.delete(id);
    }
}