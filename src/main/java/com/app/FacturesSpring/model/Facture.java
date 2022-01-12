package com.app.FacturesSpring.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private float montant;
    private String reference;
    private LocalDate dateEmise;
    private LocalDate dateEncaissee;
    private final StatusFacture statusFacture = StatusFacture.NOT_PAID;
    private String nature;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Facture(Long id, float montant, String reference, LocalDate dateEmise, LocalDate dateEncaissee, String nature, Client client) {
        this.id = id;
        this.montant = montant;
        this.reference = reference;
        this.dateEmise = dateEmise;
        this.dateEncaissee = dateEncaissee;
        this.nature = nature;
        this.client = client;
    }

    public Facture() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDate getDateEmise() {
        return dateEmise;
    }

    public void setDateEmise(LocalDate dateEmise) {
        this.dateEmise = dateEmise;
    }

    public LocalDate getDateEncaissee() {
        return dateEncaissee;
    }

    public void setDateEncaissee(LocalDate dateEncaissee) {
        this.dateEncaissee = dateEncaissee;
    }

    public StatusFacture getTypeFacture() {
        return statusFacture;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}