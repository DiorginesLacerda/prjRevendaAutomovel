/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.CarroDao;
import br.edu.qi.dao.GenericDao;
import br.edu.qi.model.Carro;
import java.io.Serializable;

/**
 *
 * @author Diorgines
 */
public class CarroBo extends GenericBo<Carro>{
    
    public CarroBo(GenericDao<Carro, Serializable> dao) throws Exception {
        super(CarroDao.getInstance());
    }
}
