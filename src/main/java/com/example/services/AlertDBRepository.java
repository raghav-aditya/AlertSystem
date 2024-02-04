package com.example.services;

import com.example.model.AlertDB;
import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertDBRepository extends  JpaRepository<AlertDB, Long> {
    AlertDB findByAlertName(String alertName);
}
