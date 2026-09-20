package com.example.demo.dto.Vehicule;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Objects;

public class VehiculeRequest {
    @NotBlank(message = "doit contenir au moins 3 caractères")
    @Size(min=3)
    private String immatriculation;
    @NotBlank(message = "doit contenir au moins 3 caractères")
    @Size(min=3)
    private String marque;
    @NotBlank (message= "doit contenir au moins 3 caractères")
    private String modele;
    
    private String annee;
    @NotBlank (message="il est obligatoire de rentrer le nombre de place de la voiture")
    private int capacite;

    private float kilometrage;



    public VehiculeRequest() {
    }

    public VehiculeRequest(String immatriculation, String marque, String modele, String annee, int capacite, float kilometrage) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.capacite = capacite;
        this.kilometrage = kilometrage;
    }

    public String getImmatriculation() {
        return this.immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return this.marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return this.modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getAnnee() {
        return this.annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public int getCapacite() {
        return this.capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public float getKilometrage() {
        return this.kilometrage;
    }

    public void setKilometrage(float kilometrage) {
        this.kilometrage = kilometrage;
    }

    public VehiculeRequest immatriculation(String immatriculation) {
        setImmatriculation(immatriculation);
        return this;
    }

    public VehiculeRequest marque(String marque) {
        setMarque(marque);
        return this;
    }

    public VehiculeRequest modele(String modele) {
        setModele(modele);
        return this;
    }

    public VehiculeRequest annee(String annee) {
        setAnnee(annee);
        return this;
    }

    public VehiculeRequest capacite(int capacite) {
        setCapacite(capacite);
        return this;
    }

    public VehiculeRequest kilometrage(float kilometrage) {
        setKilometrage(kilometrage);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VehiculeRequest)) {
            return false;
        }
        VehiculeRequest vehiculeRequest = (VehiculeRequest) o;
        return Objects.equals(immatriculation, vehiculeRequest.immatriculation) && Objects.equals(marque, vehiculeRequest.marque) && Objects.equals(modele, vehiculeRequest.modele) && Objects.equals(annee, vehiculeRequest.annee) && capacite == vehiculeRequest.capacite && kilometrage == vehiculeRequest.kilometrage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(immatriculation, marque, modele, annee, capacite, kilometrage);
    }

    @Override
    public String toString() {
        return "{" +
            " immatriculation='" + getImmatriculation() + "'" +
            ", marque='" + getMarque() + "'" +
            ", modele='" + getModele() + "'" +
            ", annee='" + getAnnee() + "'" +
            ", capacite='" + getCapacite() + "'" +
            ", kilometrage='" + getKilometrage() + "'" +
            "}";
    }
    
}
