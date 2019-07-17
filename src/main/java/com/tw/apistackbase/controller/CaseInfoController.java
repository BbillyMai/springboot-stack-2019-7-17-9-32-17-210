package com.tw.apistackbase.controller;

import com.tw.apistackbase.Repository.CaseInfoRepository;
import com.tw.apistackbase.Repository.CaseRepository;
import com.tw.apistackbase.model.CaseInfo;
import com.tw.apistackbase.model.Kase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseInfoController {

    @Autowired
    private CaseInfoRepository caseInfoRepository;

    @PostMapping("/caseInfo")
    public CaseInfo add(@RequestBody CaseInfo caseInfo){
        return caseInfoRepository.save(caseInfo);
    }

}
