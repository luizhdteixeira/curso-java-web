package com.seller.dao;

import com.seller.domain.Employee;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeDaoTest {

    @Test
    public void saveEmployee_Happy() {
        // GIVEN
        Employee employee = new Employee();
        EmployeeDao employeeDao = new EmployeeDao();

        // WHEN
        employee.setName("Roberta");
        employee.setDocumentNumber("111.222.333-44");
        employee.setPassword("ro2020");
        employee.setFunction("Vendedora");
        employeeDao.save(employee);

        // THEN
        Assert.assertNotNull(employeeDao);
    }
}
