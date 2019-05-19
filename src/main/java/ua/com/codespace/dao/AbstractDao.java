package ua.com.codespace.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import java.io.Serializable;

class AbstractDao<K extends Serializable, T> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    AbstractDao() {
        this.persistentClass = (Class<T>) GenericTypeResolver.resolveTypeArguments(getClass(), AbstractDao.class)[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    T getByKey(K key) {
        return getSession().get(persistentClass, key);
    }

    void persist(T entity) {
        getSession().persist(entity);
    }

    void delete(T entity) {
        getSession().delete(entity);
    }

    Criteria createCriteria() {
        return getSession().createCriteria(persistentClass);
    }
}
