package com.seller.bean;

import com.seller.dao.ProductDao;
import com.seller.domain.Product;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import java.util.Objects;

@ManagedBean
@ViewScoped
public class ProductBean {

    private Product product;
    private List<Product> products;

    @PostConstruct
    public void findAll() {
        try {
            ProductDao productDao = new ProductDao();
            products = productDao.findAll();
        } catch (RuntimeException e) {
            Messages.addGlobalError("Couldn't retrieve content");
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            ProductDao productDao = new ProductDao();
            productDao.save(product);
            product = new Product();
            Messages.addGlobalInfo("Save successfully!");
        } catch (RuntimeException e) {
            Messages.addGlobalError("The new record could not be saved");
            e.printStackTrace();
        }
    }

    public Product getProduct() {
        if (Objects.isNull(product)) {
            product = new Product();
        }
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
