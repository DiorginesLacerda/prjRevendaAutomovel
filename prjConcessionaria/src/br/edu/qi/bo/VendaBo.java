/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;


import br.edu.qi.dao.VendaDao;
import br.edu.qi.model.Venda;


/**
 *
 * @author Diorgines
 */
public class VendaBo extends GenericBo<Venda>{
    
    public VendaBo() throws Exception {
        super(VendaDao.getInstance());
    }
    
    public float calculaparcela(Float valor, int parcela){
        return valor/parcela;
    }
}
