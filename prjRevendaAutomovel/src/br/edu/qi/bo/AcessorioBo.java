/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.AcessorioDao;
import br.edu.qi.dao.CarroAcessorioDao;
import br.edu.qi.dao.GenericDao;
import br.edu.qi.model.Acessorio;
import br.edu.qi.model.CarroAcessorio;
import java.io.Serializable;

/**
 *
 * @author Diorgines
 */
public class AcessorioBo extends BaseBo<Acessorio>{

    public AcessorioBo(GenericDao<Acessorio, Serializable> dao) throws Exception {
        super(AcessorioDao.getInstance());
    }

    @Override
    public void delete(Acessorio t) throws Exception {
        //testa se existe um acessório na lista com este id
        if(super.findByCod(t.getIdAcessorio())!=null){
            //testa de a lista de carroAcessório está vazia
            if(t.getCarroAcessorios().isEmpty()){
                super.delete(t);
            }
            else
                throw new Exception("Impossível remover o acessório pois existem carros que o contem");
        }
        else
            throw new Exception("Acessório não encontrado na base de dados");  
    }

    @Override
    public void update(Acessorio t) throws Exception {
        //testa se existe um acessório na lista com este id
        if(super.findByCod(t.getIdAcessorio())!=null){
            //testa de a lista de carroAcessório está vazia
            if(t.getCarroAcessorios().isEmpty()){
                super.update(t);
            }
            else
                throw new Exception("Impossível Atualizar! O acessório pois existem carros que o contem");
        }
        else
            throw new Exception("Impossível Atualizar! Acessório não encontrado na base de dados");
    }
    
    public void addCarroAcessorio(CarroAcessorio carroAcessorio) throws Exception{
        for(Acessorio acessorio:dao.getList()){
            //verifica se o acessorio existe na lista de acessorios
            if(acessorio.getIdAcessorio().equals(carroAcessorio.getAcessorio().getIdAcessorio())){
                
                for(CarroAcessorio ca:acessorio.getCarroAcessorios()){
                    //verifica se já existe este registro na lista de carroAcessório dentro do acessório
                    if(ca.getIdCarroAcessorio().equals(carroAcessorio.getIdCarroAcessorio()))
                        throw new Exception("Relação de Carro Acessório já vinculada a este acessório");
                }
                acessorio.getCarroAcessorios().add(carroAcessorio);
                return;
            }
            else
               throw new Exception("Impossível salvar Relação de Carro Acessório, Acessório não encontrado");        
        }
    }
    
    public void removeCarroAcessorio(CarroAcessorio carroAcessorio) throws Exception{
        for(Acessorio acessorio:dao.getList()){
            //verifica se o acessorio existe na lista de acessorios
            if(acessorio.getIdAcessorio().equals(carroAcessorio.getAcessorio().getIdAcessorio())){
                //verifica se existe este registro na lista de carroAcessório dentro do acessório
                for(CarroAcessorio ca:acessorio.getCarroAcessorios()){
                    if(ca.getIdCarroAcessorio().equals(carroAcessorio.getIdCarroAcessorio())){
                        acessorio.getCarroAcessorios().remove(ca);
                        return;
                    }
                }
                throw new Exception("Relação de Carro Acessório não foi encontrada nesta lista");
            }
            else
               throw new Exception("Impossível Remover Relação de Carro Acessório, Acessório não encontrado");        
        }
    }
    
}
