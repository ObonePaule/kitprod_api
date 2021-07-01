package com.paule.kitprod_api.model;


public enum ChargeType {
    ASSURANCE("Assurance"),
    MECANISATION("Mécanisation"),
    FRAIS_DE_GESTION("Frais de gestion"),
    ANNUITE_EQUIPEMENTS_AVICOLES("Annuité des équipements avicoles "),
    ANNUITE_BATIMENT("Annuité batiment"),
    ANNUITE_FAF("Annuité faf"),
    ENTRETIEN_COURANT_PETIT_MATERIEL("Entretien du courant et petit materiel"),
    AUTRE("Autre");



    public final String label;

    private ChargeType(String label) {
        this.label = label;
    }
}
