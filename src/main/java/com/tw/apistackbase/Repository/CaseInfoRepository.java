package com.tw.apistackbase.Repository;

import com.tw.apistackbase.model.CaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseInfoRepository extends JpaRepository<CaseInfo, Integer> {


}
