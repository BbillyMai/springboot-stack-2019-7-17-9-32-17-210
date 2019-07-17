//package com.tw.apistackbase.model;
//
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "procuracy")
//public class Procuracy {
//
//    @Id
//    @GeneratedValue
//    private int id;
//
//    @Column(length = 50, unique = true)
//    private String name;
//
//    @OneToMany()
//    @JoinColumn(name = "procuracy_id")
//    private List<Kase> cases;
//
//    @OneToMany
//    @JoinColumn(name = "procuracy_id")
//    private List<Procurator> procurators;
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Kase> getCases() {
//        return cases;
//    }
//
//    public void setCases(List<Kase> cases) {
//        this.cases = cases;
//    }
//
//    public List<Procurator> getProcurators() {
//        return procurators;
//    }
//
//    public void setProcurators(List<Procurator> procurators) {
//        this.procurators = procurators;
//    }
//}
