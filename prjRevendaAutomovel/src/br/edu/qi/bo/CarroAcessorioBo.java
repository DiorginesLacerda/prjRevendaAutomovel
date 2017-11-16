/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.AcessorioDao;
import br.edu.qi.dao.CarroAcessorioDao;
import br.edu.qi.dao.GenericDao;
import br.edu.qi.model.CarroAcessorio;
import java.io.Serializable;

/**
 *
 * @author Diorgines
 */
public class CarroAcessorioBo extends BaseBo<CarroAcessorio>{
    
    public CarroAcessorioBo(GenericDao<CarroAcessorio, Serializable> dao) throws Exception {
        super(CarroAcessorioDao.getInstance());
    }

    @Override
    public void delete(CarroAcessorio t) throws Exception {
        CarroAcessorio carroA = dao.findByCod(t.getIdCarroAcessorio());
        if(carroA!=null){
            if(carroA.getIdCarroAcessorio().equals(t.getIdCarroAcessorio())){
                AcessorioBo acessorioBo = new AcessorioBo(AcessorioDao.getInstance());
                acessorioBo.removeCarroAcessorio(carroA);
                super.delete(t);
                return;
            }
        }
        throw new Exception("Impossível Remover! Relação Carro Acessório não encontrada na base de dados");
    }

    @Override
    public void save(CarroAcessorio t) throws Exception {
        //verifica se o registro já existe
        CarroAcessorio carroA = dao.findByCod(t.getIdCarroAcessorio());
        if(carroA!= null){
            if(carroA.getIdCarroAcessorio().equals(t.getIdCarroAcessorio()))
                throw new Exception("Relação Carro Acessório já existente");
        }
        AcessorioBo acessorioBo = new AcessorioBo(AcessorioDao.getInstance());
        //Salva o Carro acessório no acessório
        acessorioBo.addCarroAcessorio(t);
        //Salva a relação carroAcessório
        super.save(t); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
