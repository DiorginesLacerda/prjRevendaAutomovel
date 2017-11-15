/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.model.Carro;
import java.io.Serializable;

/**
 *
 * @author Diorgines
 */
public class CarroDao extends GenericDao<Carro, Serializable> {
    
    private static CarroDao instance;
    private static Carro carro;
    
    private CarroDao(Carro entity) throws Exception {
        super(entity);
    }
    
    public static CarroDao getInstance() throws Exception{
        if(instance == null)
            instance = new CarroDao(carro);
        return instance;
    }
    
}
