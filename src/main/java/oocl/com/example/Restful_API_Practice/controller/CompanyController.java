package oocl.com.example.Restful_API_Practice.controller;

import oocl.com.example.Restful_API_Practice.domin.Company;
import oocl.com.example.Restful_API_Practice.domin.Employee;
import oocl.com.example.Restful_API_Practice.service.CompanyService;
import oocl.com.example.Restful_API_Practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("/companies")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }
}
