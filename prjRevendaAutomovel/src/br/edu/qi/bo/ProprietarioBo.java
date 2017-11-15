/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.GenericDao;
import br.edu.qi.dao.ProprietarioDao;
import br.edu.qi.model.Proprietario;
import java.io.Serializable;


/**
 *
 * @author Diorgines
 */
public class ProprietarioBo extends BaseBo<Proprietario>{

    public ProprietarioBo(GenericDao<Proprietario, Serializable> dao) throws Exception {
        super(ProprietarioDao.getInstance());
    }
}