package com.example.demo.dto.Driver;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class DriverRequest {
    @NotBlank(message = "Le prénom est obligatoire")
    @Size (min=3,max = 50, message = "Le prénom ne peut pas dépasser 50 caractères et doit contenir au moins 3 caractères")
    private String firstName;
    @NotBlank(message = "Le nom est obligatoire")
    @Size (min=3,max = 50, message = "Le nom ne peut pas dépasser 50 caractères et doit contenir au moins 3 caractères")
    private String lastName;
    @NotBlank (message = "Le numéro de téléphone est obligatoire")
    @Size(min = 10, max = 15, message = "Le numéro de téléphone doit être compris entre 10 et 15 caractères et dois contenir uniquement des chiffres")
    @Pattern(regexp="^(0|\\+261)(32|33|34|37|38)\\d{7}$",
			 message="Numéro de téléphone malgache invalide")
    private String phone;
    @NotBlank(message = "Le numéro de permis est obligatoire")
    @Size(min = 5, max = 20, message = "Le numéro de permis doit être compris entre 5 et 20 caractères")
    private String licenseNumber;
    @NotNull (message = "La date d'expiration du permis est obligatoire")
    private LocalDate licenseExpirationDate;
    @NotNull (message = "La date d'engagement est obligatoire")
    private LocalDate hireDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDate getLicenseExpirationDate() {
        return licenseExpirationDate;
    }

    public void setLicenseExpirationDate(LocalDate licenseExpirationDate) {
        this.licenseExpirationDate = licenseExpirationDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}

    
