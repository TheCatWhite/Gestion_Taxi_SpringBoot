package com.example.demo.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Driver;
import com.example.demo.Enums.DriverStatus;
import com.example.demo.Exception.DriverNotFoundException;
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
            DriverMapper driverMapper) {
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
                .orElseThrow(() -> new DriverNotFoundException("le chauffeur avec l'ID " + id + " n'a pas été trouvé"));

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
                .orElseThrow(() -> new DriverNotFoundException("le chauffeur avec l'ID " + id + " n'a pas été trouvé"));

        driver.setFirstName(request.getFirstName());
        driver.setLastName(request.getLastName());
        driver.setPhone(request.getPhone());
        driver.setLicenseNumber(request.getLicenseNumber());
        driver.setLicenseExpirationDate(
                request.getLicenseExpirationDate());
        driver.setHireDate(request.getHireDate());

        Driver updatedDriver = driverRepository.save(driver);

        return driverMapper.toResponse(updatedDriver);
    }

    @Override
    public void delete(Long id) {

        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new DriverNotFoundException("le chauffeur avec l'ID " + id + " n'a pas été trouvé"));

        driverRepository.delete(driver);
    }

    @Override
    public boolean isLicenseValid(Long driverId) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new DriverNotFoundException(
                        "le chauffeur avec l'ID " + driverId + " n'a pas été trouvé"));

        return driver.getLicenseExpirationDate().isAfter(java.time.LocalDate.now());
    }

    @Override
    public boolean isAvailable(Long driverId) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new DriverNotFoundException(
                        "le chauffeur avec l'ID " + driverId + " n'a pas été trouvé"));

        return driver.getStatus() == DriverStatus.DISPONIBLE;
    }

    @Override
    public void changeStatus(Long driverId, DriverStatus status) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new DriverNotFoundException(
                        "le chauffeur avec l'ID " + driverId + " n'a pas été trouvé"));

        driver.setStatus(status);
        driverRepository.save(driver);
    }

    @Override
    public List<DriverResponse> findAvailableDrivers() {
        List<Driver> availableDrivers = driverRepository.findByStatus(DriverStatus.DISPONIBLE);
        List<DriverResponse> responses = new ArrayList<>();
        for (Driver driver : availableDrivers) {
            responses.add(driverMapper.toResponse(driver));
        }
        return responses;
    }

    @Override
    public List<DriverResponse> findDriversWithValidLicense() {
        List<Driver> allDrivers = driverRepository.findAll();
        List<DriverResponse> responses = new ArrayList<>();
        for (Driver driver : allDrivers) {
            if (driver.getLicenseExpirationDate().isAfter(java.time.LocalDate.now())) {
                responses.add(driverMapper.toResponse(driver));
            }
        }
        return responses;
    }


}