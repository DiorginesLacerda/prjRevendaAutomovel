/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;


import br.edu.qi.dao.ParcelaDao;
import br.edu.qi.model.Parcela;


/**
 *
 * @author Diorgines
 */
public class ParcelaBo extends GenericBo<Parcela>{
    
    public ParcelaBo() throws Exception {
        super(ParcelaDao.getInstance());
    }
    
}
