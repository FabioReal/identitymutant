package com.co.meli.identitymutant.service;

import com.co.meli.identitymutant.controller.impl.IdentifyMuntantControllerImpl;
import com.co.meli.identitymutant.dto.ResponseChainMutantDTO;
import com.co.meli.identitymutant.templatemethod.ValidateChainMutantBuilder;
import com.co.meli.identitymutant.util.ValidatorChainMutantUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class IndentifyMutantServiceBuilder extends ValidateChainMutantBuilder {

    private static final Logger logger = LoggerFactory.getLogger(IdentifyMuntantControllerImpl.class);

    @Autowired
    ValidatorChainMutantUtil validatorChainMutantUtil;


    @Override
    protected boolean validateStructureDNA(String[] array) throws Exception{
        try {
            logger.info("validateStructureDNA");
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
            char[][]  dnaTable = validatorChainMutantUtil.createDNATable(array);
            return dnaTable;
        }catch (Exception ex){
            throw ex;
        }
    }

    @Override
    protected void showDNATable(char[][] tableDNA) {
        try {
            validatorChainMutantUtil.printDNATable(tableDNA);
            logger.info("showDNATable");
        }catch (Exception ex){
            throw ex;
        }
    }

    @Override
    protected ResponseChainMutantDTO validateDNATable(char[][] tableDNA) throws Exception {
        try {
            logger.info("validateDNATable");
            Boolean state = validatorChainMutantUtil.hasConsecutiveSequences(tableDNA);
            ResponseChainMutantDTO statusValidate= new ResponseChainMutantDTO(state);
            if(!state)
                throw new Exception("[ERROR] - validateDNATable");
            return statusValidate;
        }catch (Exception ex){
            throw ex;
        }
    }
}




