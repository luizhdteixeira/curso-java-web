package com.seller.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @Column(name = "ID_USER", nullable = false, unique = true)
    private Long id;

    @Column(name = "NM_USER", nullable = false, unique = true)
    private String username;

    @Column(name = "CD_PASSWORD", nullable = false)
    private String password;

    @Column(name = "DT_LASTACCESS", unique = true)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate lastAccess;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(LocalDate lastAccess) {
        this.lastAccess = lastAccess;
    }
}
