package com.tw.apistackbase.Repository;

import com.tw.apistackbase.model.CaseInfo;
import com.tw.apistackbase.model.Kase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CaseRepository extends JpaRepository<Kase, Integer> {

    //@Query("SELECT c FROM Kase c WHERE c.name LIKE %?1%")
    List<Kase> findKasesByNameContains(String name);

    List<Kase> findAllByOrderByTimeDesc();

    Kase findKasesByCaseInfo(CaseInfo caseInfo);

}
