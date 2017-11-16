/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.GenericDao;
import br.edu.qi.dao.MarcaDao;
import br.edu.qi.model.Marca;
import br.edu.qi.model.Modelo;
import java.io.Serializable;


/**
 *
 * @author Diorgines
 */
public class MarcaBo extends BaseBo<Marca>{
    
    public MarcaBo(GenericDao<Marca, Serializable> dao) throws Exception {
        super(MarcaDao.getInstance());
    }

    @Override
    public void delete(Marca t) throws Exception {
        if(super.findByCod(t.getIdMarca())!=null){
            if(super.findByCod(t.getIdMarca()).getModelos().isEmpty()){
                super.delete(t);
            }
            else
                throw new Exception("Impossível remover a marca pois existem modelos associados a ela");
        }
        else
            throw new Exception("Marca não encontrada na base de dados");
    }

    @Override
    public void update(Marca t) throws Exception {
        if(super.findByCod(t.getIdMarca())!=null){
            if(super.findByCod(t.getIdMarca()).getModelos().isEmpty()){
                super.update(t);
            }
            else
                throw new Exception("Impossível atualizar a marca pois existem modelos associados a ela");
        }
        else
            throw new Exception("Impossível atualizar! Marca não encontrada na base de dados");
         //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public void addModelo(Modelo modelo,Marca marca) throws Exception{
        boolean sucess = false;
        boolean findMarca = false;
        for(Marca ma :dao.getList()){
            if(ma.getIdMarca().equals(marca.getIdMarca())){
                if(ma.getModelos().isEmpty() ||
                        !ma.getModelos().contains(modelo))
                    ma.getModelos().add(modelo);       
            }              
        }
        if(!sucess){
            if(findMarca){
                throw new Exception("Este modelo já está cadastrano nesta marca");
            }
            throw new Exception("Impossível Salvar Modelo, Marca não Encontrada");
        }
    }
    
    public void removeModelo(Modelo modelo, Marca marca) throws Exception{
        boolean sucess=false;
        boolean findMarca = false;
        for(Marca ma : dao.getList()){
            if(ma.getIdMarca().equals(marca.getIdMarca())){
                if(ma.getModelos().contains(modelo)){
                    ma.getModelos().remove(modelo);
                    sucess = true;
                }
                findMarca=true;
            }        
        }
        if(!sucess){
            if(findMarca)
                throw new Exception("Modelo não encontrado para esta marca");
            throw new Exception("Impossível remover o modelo, Marca não Encontrada");
        }
    }
    
    public void updateModelo(Modelo modelo,Marca marca){
        for(Marca ma:dao.getList()){
            if(ma.getIdMarca().equals(marca.getIdMarca())){
                for(Modelo mo:ma.getModelos()){
                    if(mo.getIdModelo().equals(modelo.getIdModelo())){
                        ma.getModelos().remove(mo);
                        ma.getModelos().add(modelo);
                    }  
                }
            }
        }
    }
    
    
}
