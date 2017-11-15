/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.AcessorioDao;
import br.edu.qi.dao.GenericDao;
import br.edu.qi.model.Acessorio;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Diorgines
 */
public class AcessorioBo extends BaseBo<Acessorio>{

    public AcessorioBo(GenericDao<Acessorio, Serializable> dao) {
        super(AcessorioDao.getInstance());
    }
    

    
    
}
