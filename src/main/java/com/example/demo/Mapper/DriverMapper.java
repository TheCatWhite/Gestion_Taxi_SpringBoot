package com.example.demo.Mapper;

import org.springframework.stereotype.Component;

import com.example.demo.Entity.Driver;
import com.example.demo.Enums.DriverStatus;
import com.example.demo.dto.Driver.DriverRequest;
import com.example.demo.dto.Driver.DriverResponse;

@Component
public class DriverMapper {

    public Driver toEntity(DriverRequest request) {

        Driver driver = new Driver();

        driver.setFirstName(request.getFirstName());
        driver.setLastName(request.getLastName());
        driver.setPhone(request.getPhone());
        driver.setLicenseNumber(request.getLicenseNumber());
        driver.setLicenseExpirationDate(
                request.getLicenseExpirationDate());
        driver.setHireDate(request.getHireDate());
        driver.setStatus(DriverStatus.DISPONIBLE);

        return driver;
    }
    
    public DriverResponse toResponse(Driver driver) {

    return new DriverResponse(
            driver.getId(),
            driver.getFirstName(),
            driver.getLastName(),
            driver.getPhone(),
            driver.getLicenseNumber(),
            driver.getLicenseExpirationDate(),
            driver.getStatus(),
            driver.getHireDate()
    );
    }
}