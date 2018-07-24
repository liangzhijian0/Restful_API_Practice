package oocl.com.example.Restful_API_Practice;

import oocl.com.example.Restful_API_Practice.domin.Company;
import oocl.com.example.Restful_API_Practice.domin.Employee;
import oocl.com.example.Restful_API_Practice.service.CompanyService;
import oocl.com.example.Restful_API_Practice.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CompanyServiceTest {

    @Test
    public void should_return_companyList_when_get_all_companies() {

        CompanyService companyService = new CompanyService();
        Employee employee1 = new Employee(1,"sanlai",20,"male",3244);
        Employee employee2 = new Employee(2,"ocean",21,"female",4554);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        companyService.allCompanies.add(new Company(1,"dab",23,employees));
        companyService.allCompanies.add(new Company(2,"ocelai",32,employees));

        assertThat(companyService.getAllCompanies(), is(companyService.allCompanies));
    }

    @Test
    public void should_return_one_company_when_get_company_by_id() {

        CompanyService companyService = new CompanyService();
        Employee employee1 = new Employee(1,"sanlai",20,"male",3244);
        Employee employee2 = new Employee(2,"ocean",21,"female",4554);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        Company company1 = new Company(1,"dab",23,employees);
        Company company2 = new Company(2,"ocelai",32,employees);
        companyService.allCompanies.add(company1);
        companyService.allCompanies.add(company2);

        assertThat(companyService.getCompanyById(1), is(company1));
    }
}
