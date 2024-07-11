package com.example.repository;

import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //devuekve...

    // a tener en cuenta que si filtras poe una cosa pasarle un parametro si filtras por dos pasarle dos

    // optional solo devuelve uno. Para buscar datos que sabemos que van a ser únicos. por ejemmplo DNI
    Optional<Employee> findByFullName(String fullName);
    Optional<Employee> findByFullNameAndBirthDate(String fullName, LocalDate birthDate);

    //cuando sabemos que nos va a devolver mas de uno utilizamos...
    List<Employee> findAllByBirthDateAfter(LocalDate birthDate);
    List<Employee> findAllByBirthDateBetween(LocalDate min,  LocalDate max);
    List<Employee> findAllByMarriedTrue();
    List<Employee> findAllByMarriedFalse();






}
