/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import java.util.List;

/**
 *
 * @author Diorgines
 */
public interface IBo<T> {

    public void save(T t) throws Exception;

    public void delete(T t) throws Exception;
    
    public void update(T t) throws Exception;

    public List<T> findAll() throws Exception;

    //public List<T> findAllWithoutClose();
    
    //public void closeSession();
    
    public T findByCod(Integer id);
}
