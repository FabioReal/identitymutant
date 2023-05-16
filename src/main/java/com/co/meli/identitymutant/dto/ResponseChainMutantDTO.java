package com.co.meli.identitymutant.dto;

public class ResponseChainMutantDTO {

    private Boolean validateChainMutant;

    public ResponseChainMutantDTO(Boolean validateChainMutant) {
        this.validateChainMutant = validateChainMutant;
    }

    public Boolean getValidateChainMutant() {
        return validateChainMutant;
    }

    public void setValidateChainMutant(Boolean validateChainMutant) {
        this.validateChainMutant = validateChainMutant;
    }
}
