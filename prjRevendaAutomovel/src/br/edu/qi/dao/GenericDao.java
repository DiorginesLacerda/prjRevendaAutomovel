/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Diorgines
 */
public abstract class GenericDao<T, ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;
    Session s;
    Transaction t;
    Query q;
    Criteria c;

    T entity;
    private List<T> list;

    public GenericDao(T entity) throws Exception {
        this.entity = entity;
        this.list = findAll();
    }

    public void save(T e) throws Exception {
        try {
            if(find(e)==null){
            s = HibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction();
            s.save(e);
            t.commit();
            s.close();
            //atualiza o arrayLocal
            list.add(find(e));
        }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(T e) throws Exception {
        s = HibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction();
        s.update(e);
        t.commit();
        s.close();
    }

    public void delete(T e) throws Exception {
        s = HibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction();
        s.delete(e);
        t.commit();
        s.close();
    }

    public List<T> findAll() throws Exception {
        s = HibernateUtil.getSessionFactory().openSession();
        List<T> lista = s.createCriteria(entity.getClass()).list();
        s.close();
        return lista;

    }

    public List<T> findAllWithoutClose() {
        s = HibernateUtil.getSessionFactory().openSession();
        List<T> lista = s.createCriteria(entity.getClass()).list();
        return lista;
    }

    public void closeSession() {
        if (s.isOpen()) {
            s.close();
        }
    }

    public T findByCod(ID cod) {
        s = HibernateUtil.getSessionFactory().openSession();
        T e = (T) s.get(entity.getClass(), cod);
        s.close();
        return e;
    }
    
    public T find(T t) throws Exception{
        List<T> list = this.findAll();
        for(T t1:list){
            if(t1.equals(t)){
                return t1;
            }
        }
        return null;
    }

}
