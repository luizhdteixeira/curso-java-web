package com.seller;

import com.seller.config.HibernateCfgConfig;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {

        Session session = HibernateCfgConfig.getSessionFactory().openSession();

        session.close();

        HibernateCfgConfig.getSessionFactory().close();

    }
}
