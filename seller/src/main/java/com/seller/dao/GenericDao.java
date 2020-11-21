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
    public T save(T entity) {
        try {
            transaction();
            session().save(entity);
            transaction().commit();
            return entity;
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
     * Persistence: retrieve of list entities
     *
     */

    public List<T> findAll() {
        try {
            List<T> listEntity;
            Criteria query = session().createCriteria(getEntityClass());
            listEntity = query.list();
            return listEntity;
        } catch (RuntimeException e) {
            session().close();
            throw e;
        } finally {
            session().close();
        }
    }

    /**
     * @Param code
     * @Throw RuntimeException
     *
     * Persistence: retrieve find by code
     *
     * */

    public T findByCode(Long code) {
        try {
            Criteria query = session().createCriteria(getEntityClass());
            query.add(Restrictions.idEq(code));
            return (T) query.uniqueResult();
        } catch (RuntimeException e) {
            session().close();
            throw e;
        } finally {
            session().close();
        }
    }

    /**
     * @Param entity
     * @Throw RuntimeException
     *
     * Persistence: delete entity
     *
     * */

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

    /**
     * @Param entity
     * @Throw RuntimeException
     *
     * Persistence: update entity
     *
     * */

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
