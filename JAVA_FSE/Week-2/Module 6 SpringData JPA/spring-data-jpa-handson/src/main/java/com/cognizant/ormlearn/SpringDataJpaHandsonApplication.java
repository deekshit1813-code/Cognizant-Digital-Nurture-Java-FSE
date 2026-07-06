package com.cognizant.ormlearn;

import com.cognizant.ormlearn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaHandsonApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaHandsonApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("\n========== NATIVE QUERY : GET ALL EMPLOYEES ==========");

        employeeService.getAllEmployeesNative().forEach(System.out::println);

        System.out.println("\n========== NATIVE QUERY : GET EMPLOYEE BY NAME ==========");

        System.out.println(employeeService.getEmployeeByNameNative("Rahul"));
    }
}