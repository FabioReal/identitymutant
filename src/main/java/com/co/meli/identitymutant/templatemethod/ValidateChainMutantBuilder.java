package com.co.meli.identitymutant.templatemethod;

import com.co.meli.identitymutant.dto.ResponseChainMutantDTO;

public abstract class ValidateChainMutantBuilder {

    private char[][] tableDNA;
    public final ResponseChainMutantDTO vaidateDNA(String[] array) throws Exception {
        validateStructureDNA(array);
        this.tableDNA = buildDNATable(array);
        showDNATable(tableDNA);
        return validateDNATable(tableDNA);
    }

    protected abstract boolean validateStructureDNA(String[] array) throws Exception;

    protected abstract char[][] buildDNATable(String[] array) throws Exception;

    protected abstract void showDNATable(char[][] tableDNA) throws Exception;

    protected abstract ResponseChainMutantDTO validateDNATable(char[][] tableDNA) throws Exception;


}
