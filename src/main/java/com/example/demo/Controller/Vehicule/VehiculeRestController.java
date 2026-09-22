package com.example.demo.Controller.Vehicule;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.VehiculeService;
import com.example.demo.dto.Vehicule.VehiculeReponse;
import com.example.demo.dto.Vehicule.VehiculeRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeRestController {
    private final VehiculeService vehiculeService;
    public VehiculeRestController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @PostMapping
    public ResponseEntity<VehiculeReponse> create(
            @Valid @RequestBody VehiculeRequest request
    ) {
        VehiculeReponse response = vehiculeService.create(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Valid @RequestBody Long id
    ) {
        vehiculeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<VehiculeReponse>> findAll(){
        List<VehiculeReponse> responses = vehiculeService.findAll();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculeReponse> findById(
            @Valid @RequestBody Long id
    ) {
        VehiculeReponse response = vehiculeService.findById(id);
        return ResponseEntity.ok(response);
    }
}
