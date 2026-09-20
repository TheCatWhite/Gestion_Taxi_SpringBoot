package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Vehicule;

public interface  VehiculeRepository extends JpaRepository<Vehicule, Long>{

}
