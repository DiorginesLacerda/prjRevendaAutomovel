/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.util.HibernateUtil;
import java.io.Serializable;
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

    public GenericDao(T entity) {
        this.entity = entity;
    }

    public void save(T e) throws Exception {
        if(!find(e)){
            s = HibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction();
            s.save(e);
            t.commit();
            s.close();
        }
        else
            throw new Exception(String.format("Impossível cadastrar,{0} já existe no banco", e.getClass().getName()));  
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
    
    public boolean find(T t) throws Exception{
        List<T> list = this.findAll();
        for(T t1:list){
            if(t1.equals(t)){
                return true;
            }
        }
        return false;
    }

}
