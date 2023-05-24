package com.co.meli.identitymutant.service;

import com.co.meli.identitymutant.dto.ResponseChainMutantDTO;
import com.co.meli.identitymutant.templatemethod.ValidateChainMutantBuilder;
import com.co.meli.identitymutant.util.ValidatorChainMutantUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IndentifyMutantServiceBuilder extends ValidateChainMutantBuilder {

    private static final Logger logger = LoggerFactory.getLogger(IndentifyMutantServiceBuilder.class);

    @Override
    protected boolean validateStructureDNA(String[] array) throws Exception{
        try {
            logger.info("validateStructureDNA");
            ValidatorChainMutantUtil validatorChainMutantUtil = new ValidatorChainMutantUtil();
            Boolean state = validatorChainMutantUtil.validateChainStructure(array);
            if(!state)
                throw new Exception("Incorrect number caracter");
            return state;
        }catch (Exception ex){
           throw ex;
        }
    }

    @Override
    protected char[][] buildDNATable(String[] array) {
        try {
            logger.info("buildDNATable");
            ValidatorChainMutantUtil validatorChainMutantUtil = new ValidatorChainMutantUtil();
            char[][]  dnaTable = validatorChainMutantUtil.createDNATable(array);
            return dnaTable;
        }catch (Exception ex){

            logger.error("[ERROR] buildDNATable" + ex.getMessage());
            throw new IllegalArgumentException("buildDNATable" + ex.getMessage());
        }
    }

    @Override
    protected void showDNATable(char[][] tableDNA) {
        try {
            ValidatorChainMutantUtil validatorChainMutantUtil = new ValidatorChainMutantUtil();
            validatorChainMutantUtil.printDNATable(tableDNA);
            logger.info("showDNATable");
        }catch (Exception ex){
            throw ex;
        }
    }

    @Override
    protected ResponseChainMutantDTO validateDNATable(char[][] tableDNA) throws Exception {
        try {
            logger.info("validateDNATable IndentifyMutantServiceBuilder");
            ValidatorChainMutantUtil validatorChainMutantUtil = new ValidatorChainMutantUtil();
            Boolean state = validatorChainMutantUtil.hasConsecutiveSequences(tableDNA);
            ResponseChainMutantDTO statusValidate= new ResponseChainMutantDTO(state);
            return statusValidate;
        }catch (Exception ex){
            throw ex;
        }
    }
}




