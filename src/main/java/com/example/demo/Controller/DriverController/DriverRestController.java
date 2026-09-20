package com.example.demo.Controller.DriverController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.DriverService;
import com.example.demo.dto.Driver.DriverRequest;
import com.example.demo.dto.Driver.DriverResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/drivers")
public class DriverRestController {

    private final DriverService driverService;

    public DriverRestController(DriverService driverService) {
        this.driverService = driverService;
    }

    // Créer un chauffeur
    @PostMapping
    public ResponseEntity<DriverResponse> create(
           @Valid  @RequestBody DriverRequest request
    ) {
        DriverResponse response = driverService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // Récupérer tous les chauffeurs
    @GetMapping
    public ResponseEntity<List<DriverResponse>> findAll() {

        List<DriverResponse> responses = driverService.findAll();

        return ResponseEntity.ok(responses);
    }

    // Récupérer un chauffeur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<DriverResponse> findById(
            @PathVariable Long id
    ) {
        DriverResponse response = driverService.findById(id);

        return ResponseEntity.ok(response);
    }

    // Modifier un chauffeur
    @PutMapping("/{id}")
    public ResponseEntity<DriverResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody DriverRequest request
    ) {
        DriverResponse response = driverService.update(id, request);

        return ResponseEntity.ok(response);
    }

    // Supprimer un chauffeur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        driverService.delete(id);

        return ResponseEntity.noContent().build();
    }
}