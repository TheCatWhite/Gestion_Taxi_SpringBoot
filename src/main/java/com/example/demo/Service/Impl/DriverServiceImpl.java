package com.example.demo.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Driver;
import com.example.demo.Mapper.DriverMapper;
import com.example.demo.Repository.DriverRepository;
import com.example.demo.Service.DriverService;
import com.example.demo.dto.Driver.DriverRequest;
import com.example.demo.dto.Driver.DriverResponse;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    public DriverServiceImpl(
            DriverRepository driverRepository,
            DriverMapper driverMapper
    ) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    @Override
    public DriverResponse create(DriverRequest request) {

        Driver driver = driverMapper.toEntity(request);

        Driver savedDriver = driverRepository.save(driver);

        return driverMapper.toResponse(savedDriver);
    }

    @Override
    public DriverResponse findById(Long id) {

        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        return driverMapper.toResponse(driver);
    }

    @Override
    public List<DriverResponse> findAll() {

        List<Driver> drivers = driverRepository.findAll();

        List<DriverResponse> responses = new ArrayList<>();

        for (Driver driver : drivers) {
            responses.add(driverMapper.toResponse(driver));
        }

        return responses;
    }

    @Override
    public DriverResponse update(Long id, DriverRequest request) {

        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        driver.setFirstName(request.getFirstName());
        driver.setLastName(request.getLastName());
        driver.setPhone(request.getPhone());
        driver.setLicenseNumber(request.getLicenseNumber());
        driver.setLicenseExpirationDate(
                request.getLicenseExpirationDate()
        );
        driver.setHireDate(request.getHireDate());

        Driver updatedDriver = driverRepository.save(driver);

        return driverMapper.toResponse(updatedDriver);
    }

    @Override
    public void delete(Long id) {

        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        driverRepository.delete(driver);
    }
}