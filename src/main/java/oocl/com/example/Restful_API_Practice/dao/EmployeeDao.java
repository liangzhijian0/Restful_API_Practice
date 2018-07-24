package oocl.com.example.Restful_API_Practice.dao;


import oocl.com.example.Restful_API_Practice.domin.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAllEmployees();

    Employee getEmployee(long id);

    Employee addEmployee(Employee employee);

    Employee deleteEmployee(long id);

    Employee updateEmployee(long id, Employee employee);

    List<Employee> getMaleEmployees();

    List<Employee> getFemaleEmployees();
}
