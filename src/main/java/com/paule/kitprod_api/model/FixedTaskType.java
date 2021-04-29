package com.paule.kitprod_api.model;

public enum FixedTaskType {
    NETTOYAGE_DESINFECTION("Nettoyage"),
    PREPARATION_BATIMENT("Preparation");

    public final String label;

    FixedTaskType(String label) {
        this.label = label;
    }
}
