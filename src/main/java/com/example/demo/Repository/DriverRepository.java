package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Driver;
import com.example.demo.Enums.DriverStatus;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    @Query("SELECT d FROM Driver d WHERE d.status = :status")
    List<Driver> findByStatus(@Param("status") DriverStatus status);
}