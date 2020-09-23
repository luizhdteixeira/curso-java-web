package com.seller.dao;

import com.seller.config.HibernateCfgConfig;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
public class GenericDao<T> {


    private Session session() {
        return HibernateCfgConfig.getSessionFactory().openSession();
    }

    private Transaction transaction() {
        return session().beginTransaction();
    }


    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    /**
     * @Param entity
     * @Throw RuntimeException
     *
     * Persistence: Save entity
     *
     * */
    public void save(T entity) {
        try {
            transaction();
            session().save(entity);
            transaction().commit();
        } catch (RuntimeException e) {
           if (transaction() != null) {
               transaction().rollback();
           }
            throw e;
        } finally {
            session().close();
        }
    }

    /**
     * @Param No Param
     * @Throw RuntimeException
     *
     * Persistence: retrieve entity
     *
     */

    public List<T> findAll() {
        try {
            List<T> listEntity;

            transaction();
            Query query = session().createQuery("from " + getEntityClass().getName());
            listEntity = query.list();
            return listEntity;
        } catch (RuntimeException e) {
            if (transaction() != null) {
                transaction().rollback();
            }
            throw e;
        } finally {
            session().close();
        }
    }

}
