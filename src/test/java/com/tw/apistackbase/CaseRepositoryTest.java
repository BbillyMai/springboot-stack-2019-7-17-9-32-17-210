package com.tw.apistackbase;


import com.tw.apistackbase.Repository.CaseRepository;
import com.tw.apistackbase.model.CaseInfo;
import com.tw.apistackbase.model.Kase;
import com.tw.apistackbase.model.Procuracy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class CaseRepositoryTest {

    @Autowired
    private CaseRepository caseRepository;

    @Test
    public void should_saving() {
        Date date = new Date();

        Kase kase = new Kase();
        CaseInfo caseInfo = new CaseInfo();
        caseInfo.setObjectiveDescription("hello world");
        caseInfo.setSubjectiveDescription("hello world");

        Procuracy procuracy = new Procuracy();
        procuracy.setName("ZHA");
        procuracy.setCases(Arrays.asList(kase));

        kase.setName("oocl");
        kase.setTime(date.getTime());
        kase.setCaseInfo(caseInfo);
        kase.setProcuracy(procuracy);

        caseRepository.save(kase);
        Kase fetchedKase = caseRepository.findById(kase.getId()).get();

        assertThat(fetchedKase.getName()).isEqualTo("oocl");
        assertThat(fetchedKase.getCaseInfo().getObjectiveDescription()).isEqualTo("hello world");
        assertThat(fetchedKase.getProcuracy().getName()).isEqualTo("ZHA");

    }


    @Test
    public void should_get_Case_by_id() {
        Kase kase = new Kase();
        Date date = new Date();

        kase.setName("theft");
        kase.setTime(date.getTime());
        Kase kase1 = caseRepository.save(kase);

        Kase fetctedKase = caseRepository.findById(kase.getId()).get();

        assertThat(fetctedKase).isEqualTo(kase1);
    }

    @Test
    public void should_find_Kase_by_time_DESC() {
        Kase kase1 = new Kase();
        Date date1 = new Date();
        kase1.setName("theft1");
        kase1.setTime(date1.getTime());
        caseRepository.save(kase1);

        Kase kase2 = new Kase();
        Date date2 = new Date();
        kase2.setName("theft2");
        kase2.setTime(date2.getTime());
        caseRepository.save(kase2);

        List<Kase> kases = caseRepository.findAllByOrderByTimeDesc();

        assertThat(kases.get(0)).isEqualTo(kase2);
        assertThat(kases.get(1)).isEqualTo(kase1);
    }

    @Test
    public void should_find_kase_by_name_like() {

        Kase kase1 = new Kase();
        Date date1 = new Date();
        kase1.setName("theft1");
        kase1.setTime(date1.getTime());
        caseRepository.save(kase1);

        Kase kase2 = new Kase();
        Date date2 = new Date();
        kase2.setName("theft2");
        kase2.setTime(date2.getTime());
        caseRepository.save(kase2);

        List<Kase> kases = caseRepository.findKasesByNameContains("the");
        assertThat(kases.get(0).getName()).contains("the");
        assertThat(kases.get(1).getName()).contains("the");
    }

    @Test
    public void shoule_delete_case_by_id() {

        Kase kase1 = new Kase();
        Date date1 = new Date();
        kase1.setName("theft1");
        kase1.setTime(date1.getTime());
        kase1 = caseRepository.save(kase1);

        caseRepository.deleteById(kase1.getId());

        assertNull(caseRepository.findById(kase1.getId()).orElse(null));
    }
}
