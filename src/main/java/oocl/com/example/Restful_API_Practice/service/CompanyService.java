package oocl.com.example.Restful_API_Practice.service;

import oocl.com.example.Restful_API_Practice.dao.CompanyDao;
import oocl.com.example.Restful_API_Practice.domin.Company;
import oocl.com.example.Restful_API_Practice.domin.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyService implements CompanyDao {

    private List<Company> allCompanies = new ArrayList<>();

    @Override
    public List<Company> getAllCompanies() {
        Employee employee1 = new Employee(1,"sanlai",20,"male",3244);
        Employee employee2 = new Employee(2,"ocean",21,"female",4554);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        allCompanies.add(new Company("dab",23,employees));
        allCompanies.add(new Company("ocelai",32,employees));
        return allCompanies;
    }
}
