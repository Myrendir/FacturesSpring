package com.app.FacturesSpring.model;

public enum TypeFacture {

    FORMATION("Formation"),
    PRESTATION("Prestation");

    private final String type;

    TypeFacture(String s) {
        this.type = s;
    }

    public String getType() {
        return type;
    }
}
