package com.seller.dao;

import com.seller.domain.Provider;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProviderDaoTest {

    @Test
    public void saveProvider_Happy() {
        // GIVEN
        Provider provider = new Provider();
        ProviderDao providerDao = new ProviderDao();

        // WHEN
        provider.setName("Luiz");
        providerDao.save(provider);

        // THEN
        Assert.assertNotNull(providerDao);

    }

    @Test
    public void findAllProvider_Happy() {
        // GIVEN
        List<Provider> providerList;
        ProviderDao providerDao = new ProviderDao();

        // WHEN
        providerList = providerDao.findAll();

        // THEN
        Assert.assertNotNull(providerList);
    }

    @Ignore
    @Test
    public void findByNameProvider_Happy() {
        // GIVEN
        Provider provider = new Provider();
        ProviderDao providerDao = new ProviderDao();

        // WHEN
        provider.setName("Luiz");
        //providerDao.findByName(provider.getName());

        // THEN
        Assert.assertNotNull(providerDao);



    }


}
