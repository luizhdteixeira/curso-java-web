package com.seller.config;

import org.hibernate.*;

public class HibernateCfgConfig {
    
    private static SessionFactory sessionFactory = sessionFactory();
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    private static SessionFactory sessionFactory() {
        try {
            
            Configuration config = new Configuration().configure();
            
            ServiceRegistry register = new StandardServiceRegistryBuilder()
                                                .applySettings(config.getProperties())
                                                .build();
            
            return config.buildSessionFactory(register);
            
        } catch (Throwable ex) {
            
            System.err.println("The session factory was not created, check." + ex);
            
            throw new ExceptionInInitializerError(ex);
        }
    }
}
