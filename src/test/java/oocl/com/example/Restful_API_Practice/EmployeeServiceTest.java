package oocl.com.example.Restful_API_Practice;

import oocl.com.example.Restful_API_Practice.domin.Employee;
import oocl.com.example.Restful_API_Practice.service.EmployeeService;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
