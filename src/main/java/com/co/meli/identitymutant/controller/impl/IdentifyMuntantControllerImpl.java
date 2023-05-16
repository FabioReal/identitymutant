package com.co.meli.identitymutant.controller.impl;

import com.co.meli.identitymutant.controller.IdentifyMuntantController;
import com.co.meli.identitymutant.dto.RequestChainMutantDTO;
import com.co.meli.identitymutant.dto.ResponseChainMutantDTO;
import com.co.meli.identitymutant.service.IndentifyMutantServiceBuilder;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "PromotionController", value = "Service Rest for validate mutant in Magneto")
@RestController()
@RequestMapping("/magneto/validate")
public class IdentifyMuntantControllerImpl implements IdentifyMuntantController  {

    private static final Logger logger = LoggerFactory.getLogger(IdentifyMuntantControllerImpl.class);

    @Override
    @PostMapping("/mutant")
    public ResponseEntity<ResponseChainMutantDTO> validateMuntant(@RequestBody RequestChainMutantDTO requestChainMutantDTO)  {
        try {
            logger.info("Init Validate Mutant");
            // return Mono.fromCallable(() -> indentifyMutantService.validateMutant(validateMuntantDTO))
            //         .map(consecutivo -> ResponseEntity.ok(consecutivo))
            //         .defaultIfEmpty(ResponseEntity.notFound().build());


            // Boolean status = indentifyMutantService.validateMutant(validateMuntantDTO);
            ResponseChainMutantDTO responseChainMutantDTO = new IndentifyMutantServiceBuilder().vaidateDNA(requestChainMutantDTO.getId_muntant());
            return ResponseEntity.ok(responseChainMutantDTO);
        }catch (Exception ex){
            logger.error("[ERROR] - " + ex.getCause() + " - " +ex.getMessage());
            return  new ResponseEntity<>(HttpStatus.FORBIDDEN);

        }

    }
}