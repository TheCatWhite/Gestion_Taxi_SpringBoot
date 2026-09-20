package com.example.demo.Mapper;

import com.example.demo.Entity.Vehicule;
import com.example.demo.Enums.VehicleStatus;
import com.example.demo.dto.Vehicule.VehiculeReponse;
import com.example.demo.dto.Vehicule.VehiculeRequest;

public class VehiculeMapper {
    public Vehicule toEntity(VehiculeRequest request) {
        Vehicule v = new Vehicule();
        v.setImmatriculation(request.getImmatriculation());
        v.setMarque(request.getMarque());
        v.setModele(request.getModele());
        v.setAnnee(request.getAnnee());
        v.setCapacite(request.getCapacite());
        v.setKilometrage(request.getKilometrage());
        v.setStatus(VehicleStatus.DISPONIBLE);
        return v;
    }

    public VehiculeReponse toReponse(Vehicule vehicule) {
        

        return new VehiculeReponse(vehicule.getId(), vehicule.getImmatriculation(), vehicule.getMarque(),
                vehicule.getModele(), vehicule.getAnnee(), vehicule.getCapacite(), vehicule.getKilometrage(),
                vehicule.getStatus());
        
    
    }
}
