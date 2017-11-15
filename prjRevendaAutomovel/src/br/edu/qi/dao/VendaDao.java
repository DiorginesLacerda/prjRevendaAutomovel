/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;


import br.edu.qi.model.Venda;
import java.io.Serializable;

/**
 *
 * @author Diorgines
 */
public class VendaDao extends GenericDao<Venda, Serializable>{
    
    private static VendaDao instance;
    private static Venda venda;
    
    private VendaDao(Venda entity) throws Exception {
        super(entity);
    }
    
    public static VendaDao getInstance() throws Exception{
        if(instance == null){
            instance = new VendaDao(venda);
        }
        return instance;
    }
    
}
