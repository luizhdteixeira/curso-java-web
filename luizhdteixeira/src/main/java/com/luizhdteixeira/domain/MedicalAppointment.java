package com.luizhdteixeira.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class MedicalAppointment extends GenericDomain{

    @Temporal(TemporalType.DATE)
    private Date dateAppointment;
    @Temporal(TemporalType.TIME)
    private Date timeAppointment;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;

    public Date getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(Date dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public Date getTimeAppointment() {
        return timeAppointment;
    }

    public void setTimeAppointment(Date timeAppointment) {
        this.timeAppointment = timeAppointment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
