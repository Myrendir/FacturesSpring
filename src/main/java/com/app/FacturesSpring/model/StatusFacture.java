package com.app.FacturesSpring.model;

public enum StatusFacture {
    PAID("Payée"),
    NOT_PAID("Non payée");

    private final String status;

    StatusFacture(String s) {
        this.status = s;
    }

    public String getStatus() {
        return status;
    }
}
