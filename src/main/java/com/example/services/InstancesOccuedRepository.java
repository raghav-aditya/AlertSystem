package com.example.services;

import com.example.model.InstancesOccured;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstancesOccuedRepository extends JpaRepository<InstancesOccured, Long> {
    public List<InstancesOccured> findByIsPickedFalse();
}
