package com.seller.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Provider extends GenericDomain{

    @Column(length = 50, nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
