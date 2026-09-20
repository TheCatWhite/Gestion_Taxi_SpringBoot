package com.example.demo.Service;

import java.util.List;

import com.example.demo.Enums.DriverStatus;
import com.example.demo.dto.Driver.DriverRequest;
import com.example.demo.dto.Driver.DriverResponse;

public interface DriverService {

    DriverResponse create(DriverRequest request);

    DriverResponse findById(Long id);

    List<DriverResponse> findAll();

    DriverResponse update(Long id, DriverRequest request);

    void delete(Long id);

    boolean isLicenseValid(Long driverId);
    
    boolean isAvailable(Long driverId);

    
    void changeStatus(Long driverId, DriverStatus status);

    List<DriverResponse> findAvailableDrivers();

    List<DriverResponse> findDriversWithValidLicense();
}