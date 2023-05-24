package com.co.meli.identitymutant.controller.impl;

import com.co.meli.identitymutant.controller.IdentifyMuntantController;
import com.co.meli.identitymutant.dto.RequestChainMutantDTO;
import com.co.meli.identitymutant.dto.ResponseChainDTO;
import com.co.meli.identitymutant.dto.ResponseChainMutantDTO;
import com.co.meli.identitymutant.service.IndentifyMutantService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Api(tags = "PromotionController", value = "Service Rest for validate mutant in Magneto")
@RestController()
@RequestMapping("/magneto/validate")
public class IdentifyMuntantControllerImpl implements IdentifyMuntantController  {
    private static final Logger logger = LoggerFactory.getLogger(IdentifyMuntantControllerImpl.class);

    @Autowired
    IndentifyMutantService indentifyMutantService;

    public IdentifyMuntantControllerImpl(IndentifyMutantService indentifyMutantService) {
    }

    @Override
    @PostMapping("/mutant")
    public ResponseEntity<ResponseChainMutantDTO> validateMuntant(@RequestBody RequestChainMutantDTO requestChainMutantDTO)  throws Exception {
            logger.info("Init Validate Mutant");

            try {
                ResponseChainMutantDTO rta=  indentifyMutantService.validateChain(requestChainMutantDTO);
                return new ResponseEntity(HttpStatus.OK);
            }catch (Exception e){
                logger.info("EROROR RestController " + e.getMessage());
                return new ResponseEntity(HttpStatus.FORBIDDEN);
            }
           /*ResponseChainMutantDTO rta = null;
            return Mono.fromCallable(() -> indentifyMutantService.validateChain(requestChainMutantDTO))
                     .map(other -> ResponseEntity.ok(rta)).onErrorResume(ex -> {
                if (ex instanceof Exception) {

                    logger.info("EEERRRORRRR 11111111 !!!!!!!");
                    // Realiza manejo específico para Exception
                    return Mono.error(new ResponseStatusException(HttpStatus.FORBIDDEN, "No se logro procesar la cadena DNA del humano"));
                } else {
                    logger.info("EEERRRORRRR 22222!!!!!!!");
                    // Manejo de otras excepciones
                    return Mono.error(ex);
                }
            })
                    .defaultIfEmpty(ResponseEntity.notFound().build());*/

    }

    @Override
    @GetMapping("/stat")
    public ResponseEntity<Map<String, Long>> getChainMutantAll(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) throws Exception {

        try{
            Map<String, Long> map = indentifyMutantService.getRecordCounts();
            return new ResponseEntity<>(map, HttpStatus.OK);
        }catch (Exception ex){
            logger.info("ERROR" + ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}