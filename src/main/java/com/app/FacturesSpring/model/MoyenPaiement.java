package com.app.FacturesSpring.model;

public enum MoyenPaiement {

    VIREMENT("Virement"),
    ESPECE("Espèce"),
    PAYPAL("Paypal");

    private final String moyen;

    MoyenPaiement(String s) {
        this.moyen = s;
    }

    public String getMoyenPaiement() {
        return moyen;
    }

}
