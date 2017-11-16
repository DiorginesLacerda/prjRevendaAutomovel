/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.CarroAcessorioDao;
import br.edu.qi.dao.CarroDao;
import br.edu.qi.dao.GenericDao;
import br.edu.qi.model.Acessorio;
import br.edu.qi.model.Carro;
import br.edu.qi.model.CarroAcessorio;
import java.io.Serializable;

/**
 *
 * @author Diorgines
 */
public class CarroBo extends BaseBo<Carro>{
    
    public CarroBo(GenericDao<Carro, Serializable> dao) throws Exception {
        super(CarroDao.getInstance());
    }

    @Override
    public void delete(Carro t) throws Exception {
        //Verifica se existe venda para este carro
        if(super.findByCod(t.getIdCarro()).getVendas().isEmpty()){
            CarroAcessorioBo cABo =  new CarroAcessorioBo(CarroAcessorioDao.getInstance());
            //Remove todos os vinculos de acesorios com este carro
            for(CarroAcessorio carroAcessorio:cABo.dao.getList()){
                if(carroAcessorio.getCarro().getIdCarro().equals(t.getIdCarro())){
                    cABo.delete(carroAcessorio);
                }
            }
        }
        else
            throw  new Exception("Impossível remover este carro pois existe venda registrada para ele");
        super.delete(t);
    }

    @Override
    public void save(Carro t) throws Exception {
        try {
            CarroAcessorioBo cABo =  new CarroAcessorioBo(CarroAcessorioDao.getInstance());
            for(CarroAcessorio carroAcessorio:t.getCarroAcessorios()){
                cABo.save(carroAcessorio);
            }
            super.save(t);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void update(Carro t) throws Exception {
        Carro carro = super.findByCod(t.getIdCarro());
        if(carro!= null){
            if(!carro.getCarroAcessorios().equals(t.getCarroAcessorios())){
                CarroAcessorioBo cABo = new CarroAcessorioBo(CarroAcessorioDao.getInstance());
                //busca todos os acessorios vinculados a este carro
                for(CarroAcessorio ca:cABo.dao.getList()){
                    //seleciona os CarroAcessorio que tenham o mesmo id deste carro
                    if(ca.getCarro().getIdCarro().equals(t.getIdCarro())){
                        for(CarroAcessorio carroacesorio:t.getCarroAcessorios()){
                            //verifica se o acessório está na lista do novo carro
                            if(carroacesorio.equals(ca))
                                break;
                        }
                        //se o registro consta no antigo, mas não no novo delata o antigo
                        cABo.delete(ca);
                    } 
                }
                //adiciona os novos na lista de vinculos  
                for(CarroAcessorio ca:t.getCarroAcessorios()){
                    if(!cABo.dao.getList().contains(t)){
                        cABo.save(ca);
                    }
                }
                
            }
            super.update(t); //To change body of generated methods, choose Tools | Templates.
        }
        throw new Exception("Impossível salvar carro, valor nulo");
    }
    
    
    
}
