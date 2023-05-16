package com.co.meli.identitymutant.dto;

public class RequestChainMutantDTO {
    private String id_aplication;
    private String[] id_muntant;

    public RequestChainMutantDTO(String id_aplication, String[] id_muntant) {
        this.id_aplication = id_aplication;
        this.id_muntant = id_muntant;
    }


    public String getId_aplication() {
        return id_aplication;
    }

    public void setId_aplication(String id_aplication) {
        this.id_aplication = id_aplication;
    }

    public String[] getId_muntant() {
        return id_muntant;
    }

    public void setId_muntant(String[] id_muntant) {
        this.id_muntant = id_muntant;
    }
}
