/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.GenericDao;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diorgines
 */
public abstract class GenericBo <T> implements IBo<T>{

    protected GenericDao<T, Serializable> dao;
    
    public GenericBo(GenericDao<T, Serializable> dao) {
        this.dao=dao;
    }
    
    @Override
    public void save(T t) throws Exception {
        dao.save(t);
    }

    @Override
    public void delete(T t) throws Exception {
        dao.delete(t);
    }

    @Override
    public void update(T t) throws Exception {
        dao.update(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public T findByCod(Integer t) {
        try {
            return this.dao.findByCod(t);
        } catch (Exception ex) {
            Logger.getLogger(GenericBo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
    }
    
    @Override
    public List<T> findAllWithoutClose(){
        try {
            return this.dao.findAllWithoutClose();
        } catch (Exception ex) {
            Logger.getLogger(GenericBo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public void closeSession(){
        try {
            this.dao.closeSession();
        } catch (Exception ex) {
            Logger.getLogger(GenericBo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
