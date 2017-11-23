/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.AcessorioDao;
import br.edu.qi.model.Acessorio;
/**
 *
 * @author Diorgines
 */
public class AcessorioBo extends GenericBo<Acessorio>{
    
    public AcessorioBo() throws Exception {
        super(AcessorioDao.getInstance());
    }
    
}
