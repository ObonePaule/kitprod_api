package com.paule.kitprod_api.model;

public enum ChargeType {
    ASSURANCE("Assurance"),
    MECANISATION("Mécanisation");


    public final String label;

    private ChargeType(String label) {
        this.label = label;
    }
}
