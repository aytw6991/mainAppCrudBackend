package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Employee_Table")
@NamedQuery(
    name = "Employee.findAll",
    query = "SELECT e FROM Employee e")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="Employee_Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="Employee_Name", nullable=false)
    private String name;
    @Column(name="Employee_Gender", nullable=false)
    private String gender;
    @Column(name="Employee_Vertical", nullable=false)
    private String vertical;
    @Column(name="Empoyee_Salary", nullable=false)
    private int salary;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }
}