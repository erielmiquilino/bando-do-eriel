package com.banco.model.dao;

import com.banco.util.HibenateFactory;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class GenericDaoImpl<T> implements GenericDao<T> {

    private Session session;

    private Session getSession(){
        if(this.session == null || !this.session.isOpen()){
            this.session = HibenateFactory.getSession();
        }
        return this.session;
    }

    public void save(T t){
        getSession().beginTransaction();
        getSession().save(t);
        getSession().close();
    }

    public void delete(T t){
        getSession().beginTransaction();
        getSession().delete(t);
        getSession().close();
    }

    public void alter(T t){
        getSession().beginTransaction();
        getSession().update(t);
        getSession().close();
    }

    public List<T> findAll(Class<T> type){
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        return getSession().createQuery(criteria).getResultList();
    }




}
