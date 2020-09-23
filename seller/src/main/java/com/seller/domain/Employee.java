package com.seller.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Employee extends GenericDomain{

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 14, nullable = false)
    private String documentNumber;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 30, nullable = false)
    private String function;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
