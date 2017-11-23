/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.ModeloDao;
import br.edu.qi.model.Modelo;

/**
 *
 * @author Diorgines
 */
public class ModeloBo extends GenericBo<Modelo>{
    
    public ModeloBo() throws Exception {
        super(ModeloDao.getInstance());
    }
    
}
