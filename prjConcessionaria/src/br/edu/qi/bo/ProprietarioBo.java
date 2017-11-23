/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;


import br.edu.qi.dao.ProprietarioDao;
import br.edu.qi.model.Proprietario;


/**
 *
 * @author Diorgines
 */
public class ProprietarioBo extends GenericBo<Proprietario>{
    
    public ProprietarioBo() throws Exception {
        super(ProprietarioDao.getInstance());
    }
    
}
