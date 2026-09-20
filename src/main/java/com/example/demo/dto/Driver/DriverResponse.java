package com.example.demo.dto.Driver;

import java.time.LocalDate;

import com.example.demo.Enums.DriverStatus;



public class DriverResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String phone;

    private String licenseNumber;

    private LocalDate licenseExpirationDate;

    private DriverStatus status;

    private LocalDate hireDate;

    public DriverResponse() {
    }

    public DriverResponse(
            Long id,
            String firstName,
            String lastName,
            String phone,
            String licenseNumber,
            LocalDate licenseExpirationDate,
            DriverStatus status,
            LocalDate hireDate
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.licenseNumber = licenseNumber;
        this.licenseExpirationDate = licenseExpirationDate;
        this.status = status;
        this.hireDate = hireDate;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public LocalDate getLicenseExpirationDate() {
        return licenseExpirationDate;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }
}