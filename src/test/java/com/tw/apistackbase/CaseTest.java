package com.tw.apistackbase;


import com.tw.apistackbase.Repository.CaseRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CaseTest {

    @Autowired
    private CaseRepository caseRepository;

    @Test
    public void should_insert_into_when_insert(){

    }
}
