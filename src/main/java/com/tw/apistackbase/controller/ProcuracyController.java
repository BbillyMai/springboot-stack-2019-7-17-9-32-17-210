package com.tw.apistackbase.controller;


import com.tw.apistackbase.Repository.ProcuracyRepostory;
import com.tw.apistackbase.model.Kase;
import com.tw.apistackbase.model.Procuracy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProcuracyController {

    @Autowired
    private ProcuracyRepostory procuracyRepostory;

    @GetMapping("/procuracies/{procuracyId}")
    public Procuracy findById(@PathVariable int procuracyId) {
        return procuracyRepostory.findById(procuracyId).orElse(null);
    }

    @PostMapping("/procuracies")
    public Procuracy add(@RequestBody Procuracy procuracy) {
        return procuracyRepostory.save(procuracy);
    }

    @GetMapping("/procuracies/{procuracyId}/kases")
    public List<Kase> findKaseByProcuracyId(@PathVariable int procuracyId) {
        return procuracyRepostory.findById(procuracyId).get().getCases();
    }

}
