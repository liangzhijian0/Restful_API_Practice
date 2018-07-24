package oocl.com.example.Restful_API_Practice.controller;

import oocl.com.example.Restful_API_Practice.domin.Employee;
import oocl.com.example.Restful_API_Practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/Employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/Employees/{id}")
    public Map<String ,Object> getEmployeeById(@PathVariable long id){
        Map<String ,Object> response = new LinkedHashMap<>();
        Employee employee =  employeeService.getEmployee(id);
        if(employee != null){
            response.put("status","successful");
            response.put("employee",employee);
        }else{
            response.put("status","fail");
        }
        return response;
    }

    @GetMapping("/Employees/male")
    public List<Employee> getMaleEmployees(){
        return employeeService.getMaleEmployees();
    }

    @GetMapping("/Employees/female")
    public List<Employee> getFemaleEmployees(){
        return employeeService.getFemaleEmployees();
    }

    @GetMapping("/Employees/page/{page}/pageSize/{pageSize}")
    public List<Employee> getEmployeesByPage(@PathVariable int page,@PathVariable int pageSize){
        return  employeeService.getEmployeesByPage(page,pageSize);
    }

    @PostMapping(path = "Employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/Employees/{id}")
    public Map<String ,Object> deleteEmployee(@PathVariable Long id){
        Map<String ,Object> response = new LinkedHashMap<>();
        Employee employee =  employeeService.deleteEmployee(id);
        if(employee != null){
            response.put("status","successful");
            response.put("employee",employee);
        }else{
            response.put("status","fail");
        }
        return response;
    }

    @PutMapping("/Employees/{id}")
    public Map<String ,Object> updateEmployee(@PathVariable Long id, @RequestBody Employee request){
        Map<String ,Object> response = new LinkedHashMap<>();
        Employee employee =  employeeService.updateEmployee(id,request);
        if(employee != null){
            response.put("status","successful");
            response.put("employee",employee);
        }else{
            response.put("status","fail");
        }
        return response;
    }


}
