package oocl.com.example.Restful_API_Practice.service;

import oocl.com.example.Restful_API_Practice.dao.CompanyDao;
import oocl.com.example.Restful_API_Practice.domin.Company;
import oocl.com.example.Restful_API_Practice.domin.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyService implements CompanyDao {
    public CompanyService() {
    }

    public List<Company> allCompanies = new ArrayList<>();
    int companyId = 1;

    @Override
    public List<Company> getAllCompanies() {
//        Employee employee1 = new Employee(1,"sanlai",20,"male",3244);
//        Employee employee2 = new Employee(2,"ocean",21,"female",4554);
//        List<Employee> employees = new ArrayList<>();
//        employees.add(employee1);
//        employees.add(employee2);
//        allCompanies.add(new Company(1,"dab",23,employees));
//        allCompanies.add(new Company(2,"ocelai",32,employees));
        return allCompanies;
    }

    @Override
    public Company getCompanyById(long id) {
        for(Company company : allCompanies){
            if (company.getId() == id){
                return company;
            }
        }
        return null;
    }

    @Override
    public List<Company> getCompaniesByPage(int page, int pageSize) {
        List<Company> result = new ArrayList<>();
        int start = (page-1)*pageSize;
        int end = (start+pageSize)>allCompanies.size() ? allCompanies.size() : (start+pageSize);
        for(int i=start;i<end;i++){
            result.add(allCompanies.get(i));
        }
        return result;
    }

    @Override
    public List<Employee> getEmployeesFromCompany(long id) {
        for(Company company : allCompanies){
            if (company.getId() == id){
                return company.getEmployees();
            }
        }
        return null;
    }

    @Override
    public Company addCompany(Company company) {
        company.setId(companyId);
        companyId ++ ;
        allCompanies.add(company);
        return company;
    }

    @Override
    public Company updateCompany(Long id, Company newCompany) {
        for(Company company : allCompanies){
            if (company.getId() == id){
                System.out.println(111);
                company.setCompanyName(newCompany.getCompanyName() != "" ? newCompany.getCompanyName() : company.getCompanyName());
                company.setEmployees(newCompany.getEmployees().size()!=0 ? newCompany.getEmployees() : company.getEmployees());
                company.setEmployeesNumber(newCompany.getEmployeesNumber() != 0 ? newCompany.getEmployeesNumber() : company.getEmployeesNumber());
                return company;
            }
        }
        return null;
    }

    @Override
    public Company deleteCompany(Long id) {
        for(Company company : allCompanies){
            if (company.getId() == id){
                allCompanies.remove(company);
                return company;
            }
        }
        return null;
    }
}
