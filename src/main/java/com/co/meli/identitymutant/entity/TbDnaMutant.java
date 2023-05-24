package com.co.meli.identitymutant.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TB_DNA_MUTANT")
public class TbDnaMutant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_dna")
    private Long pkIdDna;

    @Column(
            name = "dna_id_aplication")
    private String dnaIdAplication;

    @Column(
            name = "dna_state_mutant")
    private Boolean dnaStateMutant;


    @Column(
            name = "dna_chain")
    private String dnaChain;

    @Column(
            name = "dna_user_register")
    private String dnaUserRegister;

    @Column(
            name = "dna_date_register")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dnaDateCreation;

    public Long getPkIdDna() {
        return pkIdDna;
    }

    public void setPkIdDna(Long pkIdDna) {
        this.pkIdDna = pkIdDna;
    }

    public String getDnaIdAplication() {
        return dnaIdAplication;
    }

    public void setDnaIdAplication(String dnaIdAplication) {
        this.dnaIdAplication = dnaIdAplication;
    }

    public Boolean getDnaStateMutant() {
        return dnaStateMutant;
    }

    public void setDnaStateMutant(Boolean dnaStateMutant) {
        this.dnaStateMutant = dnaStateMutant;
    }

    public String getDnaChain() {
        return dnaChain;
    }

    public void setDnaChain(String dnaChain) {
        this.dnaChain = dnaChain;
    }

    public String getDnaUserRegister() {
        return dnaUserRegister;
    }

    public void setDnaUserRegister(String dnaUserRegister) {
        this.dnaUserRegister = dnaUserRegister;
    }

    public Date getDnaDateCreation() {
        return dnaDateCreation;
    }

    public void setDnaDateCreation(Date dnaDateCreation) {
        this.dnaDateCreation = dnaDateCreation;
    }
}
