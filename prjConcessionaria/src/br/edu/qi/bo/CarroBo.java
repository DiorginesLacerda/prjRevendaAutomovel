/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.CarroDao;
import br.edu.qi.model.Carro;

/**
 *
 * @author Diorgines
 */
public class CarroBo extends GenericBo<Carro>{
    
    public CarroBo() throws Exception {
        super(CarroDao.getInstance());
    }
}
