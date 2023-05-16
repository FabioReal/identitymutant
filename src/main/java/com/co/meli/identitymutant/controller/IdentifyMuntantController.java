package com.co.meli.identitymutant.controller;


import com.co.meli.identitymutant.dto.RequestChainMutantDTO;
import com.co.meli.identitymutant.dto.ResponseChainMutantDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "IdentifyMuntantController", value = "Service Rest for IdentifyMuntant management")
public interface IdentifyMuntantController {


    @ApiOperation(value = "Service Rest POST for register promotion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Service Rest POST for validate Mutant.")})
    public ResponseEntity<ResponseChainMutantDTO> validateMuntant(
            @RequestBody RequestChainMutantDTO requestChainMutantDTO);

}
