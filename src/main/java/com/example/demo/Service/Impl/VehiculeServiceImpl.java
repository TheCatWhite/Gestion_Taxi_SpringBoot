package com.example.demo.Service.Impl;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Vehicule;
import com.example.demo.Exception.DriverNotFoundException;
import com.example.demo.Exception.VehiculeException;
import com.example.demo.Mapper.VehiculeMapper;
import com.example.demo.Repository.VehiculeRepository;
import com.example.demo.Service.VehiculeService;
import com.example.demo.dto.Vehicule.VehiculeReponse;
import com.example.demo.dto.Vehicule.VehiculeRequest;

@Service
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final VehiculeMapper vehiculeMapper;

    public VehiculeServiceImpl(
            VehiculeRepository vehiculeRepository,
            VehiculeMapper vehiculeMapper
    ) {
        this.vehiculeRepository = vehiculeRepository;
        this.vehiculeMapper = vehiculeMapper;
    }

    @Override
    public VehiculeReponse create(VehiculeRequest request) {

        Vehicule v = vehiculeMapper.toEntity(request);

        Vehicule savedVehicule = vehiculeRepository.save(v);

        return vehiculeMapper.toReponse(savedVehicule);
    }

    @Override
    public VehiculeReponse findById(Long id) {

        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new VehiculeException(
                        "le vehicule avec l'ID " + id + " n'a pas été trouvé"));

        return vehiculeMapper.toReponse(vehicule);
    }
    
    
}