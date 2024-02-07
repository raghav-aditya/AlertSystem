package com.example.services;

import com.example.model.AlertDB;
import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.onCall = true AND e.team = ?1")
    List<Employee> findOnCallEmployeesByTeam(String team);
}
