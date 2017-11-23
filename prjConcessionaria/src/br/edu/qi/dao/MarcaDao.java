/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.model.Marca;
import java.io.Serializable;

/**
 *
 * @author Diorgines
 */
public class MarcaDao extends GenericDao<Marca, Serializable>{
    
    private static MarcaDao instance;
    private static Marca marca;
    
    private MarcaDao(Marca entity) throws Exception {
        super(entity);
    }
    
    public static MarcaDao getInstance() throws Exception{
        if(instance == null)
            instance = new MarcaDao(marca);
        return instance;
    }
}
