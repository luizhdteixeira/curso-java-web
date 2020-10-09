package com.luizhdteixeira.domain;

import javax.persistence.Entity;

@Entity
public class Doctor extends GenericDomain{

    private String regionalCouncilOfMedicine;
    private String medicalSpecialty;

    public String getRegionalCouncilOfMedicine() {
        return regionalCouncilOfMedicine;
    }

    public void setRegionalCouncilOfMedicine(String regionalCouncilOfMedicine) {
        this.regionalCouncilOfMedicine = regionalCouncilOfMedicine;
    }

    public String getMedicalSpecialty() {
        return medicalSpecialty;
    }

    public void setMedicalSpecialty(String medicalSpecialty) {
        this.medicalSpecialty = medicalSpecialty;
    }
}
