package com.tw.apistackbase.Repository;

import com.tw.apistackbase.model.Kase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CaseRepository extends JpaRepository<Kase, Integer> {

    @Query("SELECT c FROM Kase c WHERE c.name LIKE %?1%")
    List<Kase> findByName(String name);

    List<Kase> findAllByOrderByTimeDesc();

}
