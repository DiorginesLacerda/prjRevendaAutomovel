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
public class ModeloDao extends GenericDao<Modelo, Serializable>{
    
    public ModeloDao(Modelo entity) {
        super(entity);
    }
    
}
