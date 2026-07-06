package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("from Employee")
    List<Employee> getAllEmployees();

    @Query("from Employee e where e.name = ?1")
    Employee getEmployeeByName(String name);

    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();

    @Query(value = "SELECT * FROM employee WHERE name = ?1", nativeQuery = true)
    Employee getEmployeeByNameNative(String name);
}