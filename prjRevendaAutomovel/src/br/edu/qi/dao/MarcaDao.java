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
public class MarcaDao extends GenericDao<Marca, Serializable> {
    
    public MarcaDao(Marca entity) {
        super(entity);
    }
    
}
