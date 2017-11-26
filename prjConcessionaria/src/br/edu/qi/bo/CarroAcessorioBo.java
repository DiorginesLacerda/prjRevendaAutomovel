/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.CarroAcessorioDao;
import br.edu.qi.model.Carro;
import br.edu.qi.model.Acessorio;
import br.edu.qi.model.CarroAcessorio;


/**
 *
 * @author Diorgines
 */
public class CarroAcessorioBo extends GenericBo<CarroAcessorio>{
    
    public CarroAcessorioBo() throws Exception {
        super(CarroAcessorioDao.getInstance());
    }
/*
    @Override
    public void save(CarroAcessorio t) throws Exception {
        Carro carro = new Carro();
        carro.setIdCarro(1);
        Acessorio acessorio = new Acessorio();
        acessorio.setIdAcessorio(2);
        t = new CarroAcessorio(acessorio, carro);
        super.save(t); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    
}
