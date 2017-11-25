/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.CarroAcessorioDao;
import br.edu.qi.model.CarroAcessorio;


/**
 *
 * @author Diorgines
 */
public class CarroAcessorioBo extends GenericBo<CarroAcessorio>{
    
    public CarroAcessorioBo() throws Exception {
        super(CarroAcessorioDao.getInstance());
    }
    
}
