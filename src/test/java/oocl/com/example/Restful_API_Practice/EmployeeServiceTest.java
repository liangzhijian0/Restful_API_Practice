package oocl.com.example.Restful_API_Practice;

import oocl.com.example.Restful_API_Practice.domin.Employee;
import oocl.com.example.Restful_API_Practice.service.EmployeeService;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {



    @Test
    public void should_return_employeeList_when_get_all_employees() {

        EmployeeService employeeService = new EmployeeService();
        employeeService.allEmployees.add(new Employee(1,"sanlai",20,"male",3244));
        employeeService.allEmployees.add(new Employee(2,"ocean",21,"female",4554));

        assertThat(employeeService.getAllEmployees(), is(employeeService.allEmployees));
    }

    @Test
    public void should_return_one_employee_when_get_employee_by_id() {

        EmployeeService employeeService = new EmployeeService();
        Employee employee1 = new Employee(1,"sanlai",20,"male",3244);
        Employee employee2 = new Employee(2,"ocean",21,"female",4554);
        employeeService.allEmployees.add(employee1);
        employeeService.allEmployees.add(employee2);

        assertThat(employeeService.getEmployee(1), is(employee1));
    }

    @Test
    public void should_return_male_employees_when_get_employee_by_male() {

        EmployeeService employeeService = new EmployeeService();
        Employee employee1 = new Employee(1,"sanlai",20,"male",3244);
        Employee employee2 = new Employee(2,"ocean",21,"female",4554);
        employeeService.allEmployees.add(employee1);
        employeeService.allEmployees.add(employee2);
        List<Employee> result = new ArrayList<>();
        result.add(employee1);

        assertThat(employeeService.getMaleEmployees(), is(result));
    }

    @Test
    public void should_return_employees_when_get_employee_by_page_and_pageSize() {

        EmployeeService employeeService = new EmployeeService();
        Employee employee1 = new Employee(1,"sanlai",20,"male",3244);
        Employee employee2 = new Employee(2,"ocean",21,"female",4554);
        Employee employee3 = new Employee(3,"ea",20,"male",15);
        Employee employee4 = new Employee(4,"oen",21,"female",23);
        employeeService.allEmployees.add(employee1);
        employeeService.allEmployees.add(employee2);
        employeeService.allEmployees.add(employee3);
        employeeService.allEmployees.add(employee4);

        List<Employee> result = new ArrayList<>();
        result.add(employee3);
        result.add(employee4);

        assertThat(employeeService.getEmployeesByPage(2,2), is(result));
    }

    @Test
    public void should_return_employee_when_add_employee() {

        EmployeeService employeeService = new EmployeeService();
        Employee employee1 = new Employee(1,"sanlai",20,"male",3244);
        Employee employee2 = new Employee(2,"ocean",21,"female",4554);
        employeeService.allEmployees.add(employee1);

        assertThat(employeeService.addEmployee(employee2), is(employee2));
    }

    @Test
    public void should_return_employee_when_delete_employee() {

        EmployeeService employeeService = new EmployeeService();
        Employee employee1 = new Employee(1,"sanlai",20,"male",3244);
        Employee employee2 = new Employee(2,"ocean",21,"female",4554);
        employeeService.allEmployees.add(employee1);

        assertThat(employeeService.deleteEmployee(1), is(employee1));
    }
}
