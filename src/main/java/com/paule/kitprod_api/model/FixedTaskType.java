package com.paule.kitprod_api.model;

public enum FixedTaskType {
    NETTOYAGE_DESINFECTION("Nettoyage et desinfection"),
    PREPARATION_BATIMENT("Preparation bâtiment"),
    MEP_LOT("Mise en place du lot"),
    TEMPS_ENLEVEMENT("Temps par enlevement"),
    TACHES_ADMINISTRATIVES("Tâches administratives"),
    AUTRE("Autre");

    public final String label;

    FixedTaskType(String label) {
        this.label = label;
    }
}
