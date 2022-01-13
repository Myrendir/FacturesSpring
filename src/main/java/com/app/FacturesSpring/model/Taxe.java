package com.app.FacturesSpring.model;

public enum Taxe {

    TWENTY(20.0), TEN(10.0), FIVEFIVE(5.5), TWO(2.0), NONE(0);

    private final double value;

    Taxe(double taxe) {
        this.value = taxe;
    }

    public double getTaxe() {
        return value;
    }

}
