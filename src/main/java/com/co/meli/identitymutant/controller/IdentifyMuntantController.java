package com.co.meli.identitymutant.controller;


import com.co.meli.identitymutant.dto.RequestChainMutantDTO;
import com.co.meli.identitymutant.dto.ResponseChainDTO;
import com.co.meli.identitymutant.dto.ResponseChainMutantDTO;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Api(tags = "IdentifyMuntantController", value = "Service Rest for IdentifyMuntant management")
public interface IdentifyMuntantController {


    @ApiOperation(value = "Service Rest POST for register promotion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Service Rest POST for validate Mutant.")})
    public ResponseEntity<ResponseChainMutantDTO> validateMuntant(
            @RequestBody RequestChainMutantDTO requestChainMutantDTO) throws Exception;


    @ApiOperation(value = "Service Rest Get for getChainMutantAll Mutant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Service Rest Get for getChainMutantAll Mutant") })
    public ResponseEntity<Map<String, Long>> getChainMutantAll(
            HttpServletResponse httpServletResponse,
            HttpServletRequest httpServletRequest)
            throws Exception;

}
