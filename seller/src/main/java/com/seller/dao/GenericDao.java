package com.seller.dao;

import com.seller.config.HibernateCfgConfig;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
            Criteria query = session().createCriteria(getEntityClass());
            listEntity = query.list();
            return listEntity;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            session().close();
        }
    }

    public T findByCode(Long code) {
        try {
            Criteria query = session().createCriteria(getEntityClass());
            query.add(Restrictions.idEq(code));
            T entity = (T) query.uniqueResult();
            return entity;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            session().close();
        }
    }

    public void delete(T entity) {
        try {
            transaction();
            session().delete(entity);
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

    public void update(T entity) {
        try {
            transaction();
            session().update(entity);
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

}
