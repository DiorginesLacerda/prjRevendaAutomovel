/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.model.Carro;
import br.edu.qi.model.CarroAcessorio;
import java.io.Serializable;

/**
 *
 * @author Diorgines
 */
public class CarroAcessorioDao extends GenericDao<CarroAcessorio, Serializable>{
    
    private static CarroAcessorioDao instance;
    
    private CarroAcessorioDao(CarroAcessorio entity) {
        super(entity);
    }
    
    public static CarroAcessorioDao getInstance() throws Exception{
        if(instance == null)
            instance = new CarroAcessorioDao(new CarroAcessorio());
        return instance;
    }
    
}
