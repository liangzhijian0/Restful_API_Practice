package oocl.com.example.Restful_API_Practice.controller;

import oocl.com.example.Restful_API_Practice.domin.Company;
import oocl.com.example.Restful_API_Practice.domin.Employee;
import oocl.com.example.Restful_API_Practice.service.CompanyService;
import oocl.com.example.Restful_API_Practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("/companies")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping("/companies/{id}")
    public Map<String ,Object> getCompanyById(@PathVariable long id){
        Map<String ,Object> response = new LinkedHashMap<>();
        Company company =  companyService.getCompanyById(id);
        if(company != null){
            response.put("status","successful");
            response.put("employee",company);
        }else{
            response.put("status","fail");
        }
        return response;
    }

    @GetMapping("/companies/page/{page}/pageSize/{pageSize}")
    public List<Company> getCompaniesByPage(@PathVariable int page,@PathVariable int pageSize){
        return  companyService.getCompaniesByPage(page,pageSize);
    }

    @GetMapping("/companies/{id}/employees")
    public List<Employee> getEmployeesFromCompany(@PathVariable long id){
        return  companyService.getEmployeesFromCompany(id);
    }

    @PostMapping(path = "companies")
    public Company addCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }

    @PutMapping("/companies/{id}")
    public Map<String ,Object> updateEmployee(@PathVariable Long id, @RequestBody Company request){
        Map<String ,Object> response = new LinkedHashMap<>();
        Company company =  companyService.updateCompany(id,request);
        if(company != null){
            response.put("status","successful");
            response.put("company",company);
        }else{
            response.put("status","fail");
        }
        return response;
    }

    @DeleteMapping("/companies/{id}")
    public Map<String ,Object> deleteEmployee(@PathVariable Long id){
        Map<String ,Object> response = new LinkedHashMap<>();
        Company company =  companyService.deleteCompany(id);
        if(company != null){
            response.put("status","successful");
            response.put("company",company);
        }else{
            response.put("status","fail");
        }
        return response;
    }

}
