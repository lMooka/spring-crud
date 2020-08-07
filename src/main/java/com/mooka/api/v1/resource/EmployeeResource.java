package com.mooka.api.v1.resource;

import com.mooka.api.v1.model.Employee;
import com.mooka.api.v1.service.EmployeeService;
import com.mooka.msr.MsrResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(EmployeeResource.baseUrl)
public class EmployeeResource extends MsrResource<Employee, EmployeeService, Integer> {
    public final static String baseUrl = "api/v1/employee";

    public EmployeeResource(EmployeeService service) {
        super(service);
    }

    @GetMapping
    public List<Employee> searchEmployeeName(String name) {
        return service.findAll(EmployeeService.byName(name));
    }
}
