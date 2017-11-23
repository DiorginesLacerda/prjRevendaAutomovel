/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.MarcaDao;
import br.edu.qi.model.Marca;

/**
 *
 * @author Diorgines
 */
public class MarcaBo extends GenericBo<Marca>{
    
    public MarcaBo() throws Exception {
        super(MarcaDao.getInstance());
    }
    
}
