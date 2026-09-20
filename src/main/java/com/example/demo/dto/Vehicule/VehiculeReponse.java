package com.example.demo.dto.Vehicule;

import com.example.demo.Enums.VehicleStatus;
import java.util.Objects;

public class VehiculeReponse {
    private Long id;

    private String immatriculation;

    private String marque;

    private String modele;

    private String annee;

    private int  capacite;

    private float kilometrage;

    private VehicleStatus status;


    public VehiculeReponse() {
    }

    public VehiculeReponse(Long id, String immatriculation, String marque, String modele, String annee, int capacite, float kilometrage, VehicleStatus status) {
        this.id = id;
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.capacite = capacite;
        this.kilometrage = kilometrage;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public VehicleStatus getStatus() {
        return this.status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public VehiculeReponse id(Long id) {
        setId(id);
        return this;
    }

    public VehiculeReponse immatriculation(String immatriculation) {
        setImmatriculation(immatriculation);
        return this;
    }

    public VehiculeReponse marque(String marque) {
        setMarque(marque);
        return this;
    }

    public VehiculeReponse modele(String modele) {
        setModele(modele);
        return this;
    }

    public VehiculeReponse annee(String annee) {
        setAnnee(annee);
        return this;
    }

    public VehiculeReponse capacite(int capacite) {
        setCapacite(capacite);
        return this;
    }

    public VehiculeReponse kilometrage(float kilometrage) {
        setKilometrage(kilometrage);
        return this;
    }

    public VehiculeReponse status(VehicleStatus status) {
        setStatus(status);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VehiculeReponse)) {
            return false;
        }
        VehiculeReponse vehiculeReponse = (VehiculeReponse) o;
        return Objects.equals(id, vehiculeReponse.id) && Objects.equals(immatriculation, vehiculeReponse.immatriculation) && Objects.equals(marque, vehiculeReponse.marque) && Objects.equals(modele, vehiculeReponse.modele) && Objects.equals(annee, vehiculeReponse.annee) && capacite == vehiculeReponse.capacite && kilometrage == vehiculeReponse.kilometrage && Objects.equals(status, vehiculeReponse.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, immatriculation, marque, modele, annee, capacite, kilometrage, status);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", immatriculation='" + getImmatriculation() + "'" +
            ", marque='" + getMarque() + "'" +
            ", modele='" + getModele() + "'" +
            ", annee='" + getAnnee() + "'" +
            ", capacite='" + getCapacite() + "'" +
            ", kilometrage='" + getKilometrage() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
    
}
