package com.example.demo.Entity;
    
import java.time.LocalDate;
import java.util.Objects;

import com.example.demo.Enums.DriverStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String phone;

    private String licenseNumber;

    private LocalDate licenseExpirationDate;

    @Enumerated(EnumType.STRING)
    private DriverStatus status;

    private LocalDate hireDate;




    public Driver() {
    }

    public Driver(Long id, String firstName, String lastName, String phone, String licenseNumber, LocalDate licenseExpirationDate, DriverStatus status, LocalDate hireDate) {
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
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDate getLicenseExpirationDate() {
        return this.licenseExpirationDate;
    }

    public void setLicenseExpirationDate(LocalDate licenseExpirationDate) {
        this.licenseExpirationDate = licenseExpirationDate;
    }

    public DriverStatus getStatus() {
        return this.status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    public LocalDate getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Driver id(Long id) {
        setId(id);
        return this;
    }

    public Driver firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Driver lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public Driver phone(String phone) {
        setPhone(phone);
        return this;
    }

    public Driver licenseNumber(String licenseNumber) {
        setLicenseNumber(licenseNumber);
        return this;
    }

    public Driver licenseExpirationDate(LocalDate licenseExpirationDate) {
        setLicenseExpirationDate(licenseExpirationDate);
        return this;
    }

    public Driver status(DriverStatus status) {
        setStatus(status);
        return this;
    }

    public Driver hireDate(LocalDate hireDate) {
        setHireDate(hireDate);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Driver)) {
            return false;
        }
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id) && Objects.equals(firstName, driver.firstName) && Objects.equals(lastName, driver.lastName) && Objects.equals(phone, driver.phone) && Objects.equals(licenseNumber, driver.licenseNumber) && Objects.equals(licenseExpirationDate, driver.licenseExpirationDate) && Objects.equals(status, driver.status) && Objects.equals(hireDate, driver.hireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phone, licenseNumber, licenseExpirationDate, status, hireDate);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", phone='" + getPhone() + "'" +
            ", licenseNumber='" + getLicenseNumber() + "'" +
            ", licenseExpirationDate='" + getLicenseExpirationDate() + "'" +
            ", status='" + getStatus() + "'" +
            ", hireDate='" + getHireDate() + "'" +
            "}";
    }
    
}
