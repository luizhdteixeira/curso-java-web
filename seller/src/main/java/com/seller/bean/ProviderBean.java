package com.seller.bean;

import com.seller.dao.ProviderDao;
import com.seller.domain.Provider;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@ManagedBean
@ViewScoped
public class ProviderBean implements Serializable {

    private Provider provider;
    private List<Provider> providers;

    @PostConstruct
    public void findAll() {
        try {
            ProviderDao providerDao = new ProviderDao();
            providers = providerDao.findAll();
        } catch (RuntimeException e) {
            Messages.addGlobalError("Couldn't retrieve content");
            e.printStackTrace();
        }
    }
    
    public void save() {
        try {
            ProviderDao providerDao = new ProviderDao();
            providerDao.save(provider);
            provider = new Provider();
            Messages.addGlobalInfo("Save successfully!");
        } catch (RuntimeException e) {
            Messages.addGlobalError("The new record could not be saved");
            e.printStackTrace();
        }
    }

    public Provider getProvider() {
        if (Objects.isNull(provider)) {
            provider = new Provider();
        }
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }
}
