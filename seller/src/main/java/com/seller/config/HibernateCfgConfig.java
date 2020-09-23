package com.seller.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateCfgConfig {

    private static final SessionFactory sessionFactory = sessionFactory();
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private HibernateCfgConfig() {

    }
    
    private static SessionFactory sessionFactory() {
        try {
            Configuration config = new Configuration().configure();
            ServiceRegistry register = new StandardServiceRegistryBuilder()
                                                .applySettings(config.getProperties())
                                                .build();
            return config.buildSessionFactory(register);
        } catch (RuntimeException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
}
