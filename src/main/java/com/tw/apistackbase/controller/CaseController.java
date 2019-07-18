package com.tw.apistackbase.controller;

import com.tw.apistackbase.Repository.CaseRepository;
import com.tw.apistackbase.model.Kase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
public class CaseController {

    @Autowired
    private CaseRepository caseRepository;

    @PostMapping("/kases")
    public Kase add(@RequestBody Kase kase) {
        Date date = new Date();
        kase.setTime(date.getTime());
        caseRepository.save(kase);
        return kase;
    }

    @GetMapping("/kases/{kaseId}")
    public Kase add(@PathVariable int kaseId) {
        return caseRepository.findById(kaseId).orElse(null);
    }

    @GetMapping("/kases")
    public List<Kase> findAllByOrderByTimeDesc() {
        return caseRepository.findAllByOrderByTimeDesc();
    }

    @GetMapping(value = "/kases", params = "name")
    public List<Kase> findByName(String name){
        return caseRepository.findKasesByNameContains(name);
    }

    @DeleteMapping("/kases/{kaseId}")
    public void deleteById(@PathVariable int kaseId){
        caseRepository.deleteById(kaseId);
    }
}
