package com.mooka.api.v1.service;

import com.mooka.api.v1.model.Employee;
import com.mooka.api.v1.repository.EmployeeRepository;
import com.mooka.msr.SpecificationMsrService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends SpecificationMsrService<EmployeeRepository, Employee, Integer> {
    public EmployeeService(EmployeeRepository repository) {
        super(repository);
    }
}
