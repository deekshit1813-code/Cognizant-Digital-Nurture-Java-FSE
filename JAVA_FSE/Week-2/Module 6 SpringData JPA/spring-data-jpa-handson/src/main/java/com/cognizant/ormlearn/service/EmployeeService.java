package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.entity.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee getEmployeeByName(String name) {
        return employeeRepository.getEmployeeByName(name);
    }

    public List<Employee> getAllEmployeesNative() {
        return employeeRepository.getAllEmployeesNative();
    }

    public Employee getEmployeeByNameNative(String name) {
        return employeeRepository.getEmployeeByNameNative(name);
    }
}