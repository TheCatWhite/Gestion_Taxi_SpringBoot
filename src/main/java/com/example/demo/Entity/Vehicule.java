package com.example.demo.Entity;

import com.example.demo.Enums.VehicleStatus;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;


@Entity 
public class Vehicule {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true,nullable = false)
    private String Immatriculation;
    @Column (nullable=false, unique=true)
    private String marque;
    @Column(nullable=false)
    private String modele;
    @Column (nullable=true)
    private String annee;
    @Column(nullable=false)
    private int capacite;
    private float kilometrage;
    @Enumerated(EnumType.STRING)
    private VehicleStatus status;


    public Vehicule() {
    }

    public Vehicule(Long id, String Immatriculation, String marque, String modele, String annee, int capacite, float kilometrage, VehicleStatus status) {
        this.id = id;
        this.Immatriculation = Immatriculation;
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
        return this.Immatriculation;
    }

    public void setImmatriculation(String Immatriculation) {
        this.Immatriculation = Immatriculation;
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

    public Vehicule id(Long id) {
        setId(id);
        return this;
    }

    public Vehicule Immatriculation(String Immatriculation) {
        setImmatriculation(Immatriculation);
        return this;
    }

    public Vehicule marque(String marque) {
        setMarque(marque);
        return this;
    }

    public Vehicule modele(String modele) {
        setModele(modele);
        return this;
    }

    public Vehicule annee(String annee) {
        setAnnee(annee);
        return this;
    }

    public Vehicule capacite(int capacite) {
        setCapacite(capacite);
        return this;
    }

    public Vehicule kilometrage(float kilometrage) {
        setKilometrage(kilometrage);
        return this;
    }

    public Vehicule status(VehicleStatus status) {
        setStatus(status);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vehicule)) {
            return false;
        }
        Vehicule vehicule = (Vehicule) o;
        return Objects.equals(id, vehicule.id) && Objects.equals(Immatriculation, vehicule.Immatriculation) && Objects.equals(marque, vehicule.marque) && Objects.equals(modele, vehicule.modele) && Objects.equals(annee, vehicule.annee) && capacite == vehicule.capacite && kilometrage == vehicule.kilometrage && Objects.equals(status, vehicule.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Immatriculation, marque, modele, annee, capacite, kilometrage, status);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", Immatriculation='" + getImmatriculation() + "'" +
            ", marque='" + getMarque() + "'" +
            ", modele='" + getModele() + "'" +
            ", annee='" + getAnnee() + "'" +
            ", capacite='" + getCapacite() + "'" +
            ", kilometrage='" + getKilometrage() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
 

}
