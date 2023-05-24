package com.co.meli.identitymutant.dto;

import java.util.Date;

public class ResponseChainDTO {

    private Long dnaId;
    private String aplicationId;
    private String chain;
    private String registerUser;
    private Date registerDate;

    public Long getDnaId() {
        return dnaId;
    }

    public void setDnaId(Long dnaId) {
        this.dnaId = dnaId;
    }

    public String getAplicationId() {
        return aplicationId;
    }

    public void setAplicationId(String aplicationId) {
        this.aplicationId = aplicationId;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public String getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(String registerUser) {
        this.registerUser = registerUser;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
