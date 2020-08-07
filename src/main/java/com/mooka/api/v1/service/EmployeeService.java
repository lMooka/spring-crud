package com.mooka.api.v1.service;

import com.mooka.api.v1.model.Employee;
import com.mooka.api.v1.repository.EmployeeRepository;
import com.mooka.msr.SpecificationMsrService;
import org.hibernate.Criteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmployeeService extends SpecificationMsrService<EmployeeRepository, Employee, Integer> {
    public EmployeeService(EmployeeRepository repository) {
        super(repository);
    }

    public static Specification<Employee> byName(String name) {
        return (root, criteriaQuery, builder) -> builder.equal(root.get("name"), name);
    }
}
