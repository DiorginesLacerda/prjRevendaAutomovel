/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.GenericDao;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Diorgines
 */
public abstract class BaseBo <T> implements IBo<T>{

    protected GenericDao<T, Serializable> dao;

    public BaseBo(GenericDao<T, Serializable> dao) {
        this.dao=dao;
    }

    @Override
    public  void update(T t) throws Exception{
        dao.update(t);
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
    public List<T> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public T findByCod(Integer id) {
        return dao.findByCod(id);
    }
    
}
