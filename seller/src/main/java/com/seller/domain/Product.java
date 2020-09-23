package com.seller.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Product extends GenericDomain{

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    private Double quantity;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Provider provider;

}
