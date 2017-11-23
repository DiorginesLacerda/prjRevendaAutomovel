/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.model.Modelo;
import java.io.Serializable;

/**
 *
 * @author Diorgines
 */
public class ModeloDao extends GenericDao<Modelo, Serializable> {
    
    private static ModeloDao instance;
    
    private ModeloDao(Modelo entity) throws Exception {
        super(entity);
    }
    
    public static ModeloDao getInstance() throws Exception{
        if( instance == null)
            instance = new ModeloDao(new Modelo());
        return instance;
    }
    
}
