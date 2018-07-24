package oocl.com.example.Restful_API_Practice.dao;

import oocl.com.example.Restful_API_Practice.domin.Company;
import oocl.com.example.Restful_API_Practice.domin.Employee;

import java.util.List;

public interface CompanyDao {
    List<Company> getAllCompanies();

    Company getCompanyById(long id);

    List<Company> getCompaniesByPage(int page, int pageSize);

    List<Employee> getEmployeesFromCompany(long id);

    Company addCompany(Company company);

    Company updateCompany(Long id, Company request);
}
