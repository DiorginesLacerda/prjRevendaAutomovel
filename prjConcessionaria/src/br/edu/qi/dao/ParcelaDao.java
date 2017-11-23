/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.model.Parcela;
import java.io.Serializable;

/**
 *
 * @author Diorgines
 */
public class ParcelaDao extends GenericDao<Parcela, Serializable> {
    
    private static ParcelaDao instance;
    private static Parcela parcela;
    
    private ParcelaDao(Parcela entity) throws Exception {
        super(entity);
    }
    
    public static ParcelaDao getInstance() throws Exception{
        if(instance == null)
            instance = new ParcelaDao(parcela);
        return instance;
    }
    
}
