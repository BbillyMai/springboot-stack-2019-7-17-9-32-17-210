package com.tw.apistackbase.Repository;


import com.tw.apistackbase.model.Procuracy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcuracyRepostory extends JpaRepository<Procuracy, Integer> {

}
