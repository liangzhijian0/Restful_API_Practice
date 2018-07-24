package oocl.com.example.Restful_API_Practice.service;


import oocl.com.example.Restful_API_Practice.dao.EmployeeDao;
import oocl.com.example.Restful_API_Practice.domin.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService implements EmployeeDao {

    private List<Employee> allEmployees = new ArrayList<>();
    int employeeId = 1;

    public List<Employee> getAllEmployees() {
        return allEmployees;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setId(employeeId);
        employeeId ++ ;
        allEmployees.add(employee);
        return employee;
    }


    @Override
    public Employee deleteEmployee(long id) {
        for(Employee employee : allEmployees){
            if (employee.getId() == id){
                allEmployees.remove(employee);
                return employee;
            }
        }
        return null;
    }

    @Override
    public Employee updateEmployee(long id, Employee newEmployee) {
        for(Employee employee : allEmployees){
            if (employee.getId() == id){
                employee.setAge(newEmployee.getAge() != 0 ? newEmployee.getAge() : employee.getAge());
                employee.setName(newEmployee.getName() != "" ? newEmployee.getName() : employee.getName());
                employee.setGender(newEmployee.getGender() != "" ? newEmployee.getGender() : employee.getGender());
                return employee;
            }
        }
        return null;
    }
}
