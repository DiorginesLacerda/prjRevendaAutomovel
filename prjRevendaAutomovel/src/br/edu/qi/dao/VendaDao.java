/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.dao.GenericDao;
import br.edu.qi.model.Venda;
import java.io.Serializable;

/**
 *
 * @author Diorgines
 */
public class VendaDao extends GenericDao<Venda, Serializable>{
    
    public VendaDao(Venda entity) {
        super(entity);
    }
    
}