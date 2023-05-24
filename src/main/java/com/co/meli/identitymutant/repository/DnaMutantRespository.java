package com.co.meli.identitymutant.repository;

import com.co.meli.identitymutant.entity.TbDnaMutant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface DnaMutantRespository extends JpaRepository<TbDnaMutant, Long> {


    @Query(value = "SELECT COUNT(*) AS total_records, SUM(CASE WHEN dna_state_mutant = true THEN 1 ELSE 0 END) AS human_identufy_mutant FROM TB_DNA_MUTANT", nativeQuery = true)
    List<Object[]> getRecordCounts();


}
