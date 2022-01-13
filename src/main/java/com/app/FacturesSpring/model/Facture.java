package com.app.FacturesSpring.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private TypeFacture typeFacture;
    private float montant;
    private String reference;
    private LocalDate dateEmise;
    private LocalDate dateEncaissee;
    private StatusFacture statusFacture;
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

    public Facture(String reference) {
        this.reference = reference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeFacture getTypeFacture() {
        return typeFacture;
    }

    public void setTypeFacture(TypeFacture typeFacture) {
        this.typeFacture = typeFacture;
    }

    public StatusFacture getStatusFacture() {
        return statusFacture;
    }

    public void getStatusFacture(StatusFacture statusFacture) {
        this.statusFacture = statusFacture;
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
