package com.tw.apistackbase.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "case")
public class Kase {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String name;

    private long time;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "case_info_id")
    private CaseInfo caseInfo;
//
//    @ManyToOne
//    //@NotNull
//    @JoinColumn(name="procuracy_id")
//    private Procuracy procuracy;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public CaseInfo getCaseInfo() {
        return caseInfo;
    }

    public void setCaseInfo(CaseInfo caseInfo) {
        this.caseInfo = caseInfo;
    }

//    public Procuracy getProcuracy() {
//        return procuracy;
//    }
//
//    public void setProcuracy(Procuracy procuracy) {
//        this.procuracy = procuracy;
//    }
}
