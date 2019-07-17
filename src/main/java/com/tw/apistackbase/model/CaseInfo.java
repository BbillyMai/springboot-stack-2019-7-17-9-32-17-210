package com.tw.apistackbase.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="case_info")
public class CaseInfo {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "subjective_description")
    @NotBlank
    private String subjectiveDescription;

    @Column(name = "objective_description")
    @NotBlank
    private String objectiveDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getSubjectiveDescription() {
        return subjectiveDescription;
    }

    public void setSubjectiveDescription(String subjectiveDescription) {
        this.subjectiveDescription = subjectiveDescription;
    }

    public String getObjectiveDescription() {
        return objectiveDescription;
    }

    public void setObjectiveDescription(String objectiveDescription) {
        this.objectiveDescription = objectiveDescription;
    }
}
