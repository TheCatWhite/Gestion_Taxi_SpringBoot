package com.example.demo.Service;

import java.util.List;

import com.example.demo.dto.Vehicule.VehiculeReponse;
import com.example.demo.dto.Vehicule.VehiculeRequest;

public interface  VehiculeService {
    VehiculeReponse create(VehiculeRequest request);

    VehiculeReponse findById(Long id);

    List<VehiculeReponse> findAll();
    
    void delete(Long id);
}
