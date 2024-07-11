package com.example;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

/* capas:
* DB --> JDBC --> Hibernate --> Spring Data JPA
* */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
      ApplicationContext context= SpringApplication.run(App.class, args);

     var employeesRepo =  context.getBean(EmployeeRepository.class);

     //creamos empleados porque no tenemos en la base de datos
        List<Employee> employees = List.of(
        new Employee(null, "employee1", LocalDate.now(),true),
        new Employee(null, "employee2", LocalDate.now(),false),
        new Employee(null, "employee3", LocalDate.now(),false),
        new Employee(null, "employee4", LocalDate.now(),true),
        new Employee(null, "employee5", LocalDate.now(),true)
    );
        employeesRepo.saveAll(employees);

        employeesRepo.findAllByMarriedTrue().forEach(System.out::println);

    }

}
