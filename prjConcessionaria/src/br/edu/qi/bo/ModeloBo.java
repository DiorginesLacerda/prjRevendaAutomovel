/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.GenericDao;
import br.edu.qi.dao.ModeloDao;
import br.edu.qi.model.Modelo;
import java.io.Serializable;

/**
 *
 * @author Diorgines
 */
public class ModeloBo extends GenericBo<Modelo>{
    
    public ModeloBo(GenericDao<Modelo, Serializable> dao) throws Exception {
        super(ModeloDao.getInstance());
    }
    
}
