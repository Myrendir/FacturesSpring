package com.app.FacturesSpring.model;


import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "git ")
    private LocalDate dateEmise;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateEncaissee;

    private StatusFacture statusFacture;

    private String nature;

    private MoyenPaiement moyenPaiement;

    private Taxe taxe;

    private int nbCandidats;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Facture(Long id, float montant, String reference, LocalDate dateEmise, StatusFacture statusFacture, LocalDate dateEncaissee, String nature, MoyenPaiement moyenPaiement, Taxe taxe, int nbCandidats, Client client) {
        this.id = id;
        this.montant = montant;
        this.reference = reference;
        this.dateEmise = dateEmise;
        this.dateEncaissee = dateEncaissee;
        this.statusFacture = statusFacture;
        this.nature = nature;
        this.moyenPaiement = moyenPaiement;
        this.taxe = taxe;
        this.nbCandidats = nbCandidats;
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

    public StatusFacture getStatusFacture() {
        return statusFacture;
    }

    public void setStatusFacture(StatusFacture statusFacture) {
        this.statusFacture = statusFacture;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public MoyenPaiement getMoyenPaiement() {
        return moyenPaiement;
    }

    public void setMoyenPaiement(MoyenPaiement moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }

    public Taxe getTaxe() {
        return taxe;
    }

    public void setTaxe(Taxe taxe) {
        this.taxe = taxe;
    }

    public int getNbCandidats() {
        return nbCandidats;
    }

    public void setNbCandidats(int nbCandidats) {
        this.nbCandidats = nbCandidats;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

