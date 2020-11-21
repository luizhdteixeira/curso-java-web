package com.seller.bean;

import com.seller.dao.EmployeeDao;
import com.seller.domain.Employee;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import java.util.Objects;

@ManagedBean
@ViewScoped
public class EmployeeBean {

    private Employee employee;
    private List<Employee> employees;

    @PostConstruct
    public void findAll() {
        try {
            EmployeeDao employeeDao = new EmployeeDao();
            employees = employeeDao.findAll();
        } catch (RuntimeException e) {
            Messages.addGlobalError("Couldn't retrieve content");
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            EmployeeDao employeeDao = new EmployeeDao();
            employeeDao.save(employee);
            employee = new Employee();
            Messages.addGlobalInfo("Save successfully!");
        } catch (RuntimeException e) {
            Messages.addGlobalError("The new record could not be saved");
            e.printStackTrace();
        }
    }

    public Employee getEmployee() {
        if (Objects.isNull(employee)) {
            employee = new Employee();
        }
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
