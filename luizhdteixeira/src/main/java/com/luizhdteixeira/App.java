package com.luizhdteixeira;

import com.luizhdteixeira.config.HibernateCfgConfig;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        Session session = HibernateCfgConfig.getSessionFactory().openSession();

        session.close();

        HibernateCfgConfig.getSessionFactory().close();

    }
}
