package oocl.com.example.Restful_API_Practice.service;


import oocl.com.example.Restful_API_Practice.dao.EmployeeDao;
import oocl.com.example.Restful_API_Practice.domin.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeService implements EmployeeDao {

    private List<Employee> allEmployees = new ArrayList<>();

    int employeeId = 1;

    public List<Employee> getAllEmployees() {
        allEmployees.add(new Employee(1,"sanlai",20,"male",3244));
        allEmployees.add(new Employee(2,"ocean",21,"female",4554));
        return allEmployees;
    }

    @Override
    public Employee getEmployee(long id) {
        for(Employee employee : allEmployees){
            if (employee.getId() == id){
                return employee;
            }
        }
        return null;
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

    @Override
    public List<Employee> getMaleEmployees() {
        return allEmployees.stream().filter(employee -> employee.getGender().equals("male") ).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getFemaleEmployees() {
        return allEmployees.stream().filter(employee -> employee.getGender().equals("female")).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeesByPage(int page, int pageSize) {
        List<Employee> result = new ArrayList<>();
        int start = (page-1)*pageSize;
        int end = (start+pageSize)>allEmployees.size() ? allEmployees.size() : (start+pageSize);
        for(int i=start;i<end;i++){
            result.add(allEmployees.get(i));
        }
        return result;
    }


}
