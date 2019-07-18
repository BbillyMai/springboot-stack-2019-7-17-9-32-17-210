package com.tw.apistackbase.controller;

import com.tw.apistackbase.Repository.ProcuracyRepostory;
import com.tw.apistackbase.Repository.ProcuratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcuratorController {

    @Autowired
    private ProcuratorRepository procuratorRepository;


}
