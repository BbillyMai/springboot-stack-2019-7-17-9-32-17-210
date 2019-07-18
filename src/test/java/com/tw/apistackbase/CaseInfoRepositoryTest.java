package com.tw.apistackbase;

import com.tw.apistackbase.Repository.CaseInfoRepository;
import com.tw.apistackbase.Repository.CaseRepository;
import com.tw.apistackbase.model.CaseInfo;
import com.tw.apistackbase.model.Kase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application-test.yml")
public class CaseInfoRepositoryTest {

    @Autowired
    private CaseInfoRepository caseInfoRepository;

    @Autowired
    private CaseRepository caseRepository;

    @Test
    public void should_saving_caseInfo() {
        CaseInfo caseInfo = new CaseInfo();
        caseInfo.setObjectiveDescription("theft");
        caseInfo.setSubjectiveDescription("theft");

        caseInfo = caseInfoRepository.save(caseInfo);

        CaseInfo fetchedCaseInfo = caseInfoRepository.getOne(caseInfo.getId());

        assertThat(fetchedCaseInfo).isEqualTo(caseInfo);
    }

    @Test
    public void should_find_case_by_caseInfo_id() {
        CaseInfo caseInfo = new CaseInfo();
        caseInfo.setObjectiveDescription("theft");
        caseInfo.setSubjectiveDescription("theft");

        Kase kase = new Kase();
        Date date1 = new Date();
        kase.setName("theft");
        kase.setTime(date1.getTime());
        kase.setCaseInfo(caseInfo);

        kase = caseRepository.save(kase);
        caseInfo = caseInfoRepository.findById(kase.getCaseInfo().getId()).get();

        Kase fetchedKase = caseRepository.findKasesByCaseInfo(caseInfo);

        assertThat(fetchedKase).isEqualTo(kase);
    }
}
