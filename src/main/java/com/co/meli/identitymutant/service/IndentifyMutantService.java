package com.co.meli.identitymutant.service;

import com.co.meli.identitymutant.dto.RequestChainMutantDTO;
import com.co.meli.identitymutant.dto.ResponseChainMutantDTO;
import com.co.meli.identitymutant.entity.TbDnaMutant;
import com.co.meli.identitymutant.repository.DnaMutantRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class IndentifyMutantService {

    private static final Logger logger = LoggerFactory.getLogger(IndentifyMutantService.class);

    @Autowired
    DnaMutantRespository dnaMutantRespository;



    public ResponseChainMutantDTO validateChain(RequestChainMutantDTO requestChainMutantDTO) throws Exception {
        try {
            ResponseChainMutantDTO responseChainMutantDTO = new IndentifyMutantServiceBuilder().vaidateDNA(requestChainMutantDTO.getId_muntant());
            TbDnaMutant entity = mapperDtoToEntityDnaMutant(requestChainMutantDTO, responseChainMutantDTO.getValidateChainMutant());
            dnaMutantRespository.save(entity);
            if (!responseChainMutantDTO.getValidateChainMutant())
                throw new Exception("[ERROR] - Method validateDNATable");
            return responseChainMutantDTO;
        }catch (Exception ex){
            logger.error("Method validateChain" + ex.getMessage());
        }
        return null;

    }


        public TbDnaMutant mapperDtoToEntityDnaMutant(RequestChainMutantDTO requestChainMutantDTO, Boolean stateMutant) throws Exception {
        try {
            TbDnaMutant entity = new TbDnaMutant();
            entity.setDnaIdAplication(requestChainMutantDTO.getId_aplication());
            entity.setDnaStateMutant(stateMutant);
            entity.setDnaChain(java.util.Arrays.toString(requestChainMutantDTO.getId_muntant()));
            entity.setDnaUserRegister("admin");
            entity.setDnaDateCreation(new Date());
            // Mapear otros campos del DTO al Entity
            return entity;
        }catch (Exception e){
            throw new Exception("[ERROR] - mapperDtoToEntityDnaMutant" + e.getMessage());
        }


        }

    public Map<String, Long> getRecordCounts() {
            List<Object[]> results = dnaMutantRespository.getRecordCounts();
            Map<String, Long> recordCounts = new HashMap<>();
            for (Object[] result : results) {
                BigInteger totalRecords = (BigInteger) result[0];
                BigInteger mutantRecords = (BigInteger) result[1];
                recordCounts.put("total_records", totalRecords.longValue());
                recordCounts.put("mutant_records", mutantRecords.longValue());
            }
            return recordCounts;
    }


}
