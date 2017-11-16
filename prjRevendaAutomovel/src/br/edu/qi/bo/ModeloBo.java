/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.CarroDao;
import br.edu.qi.dao.GenericDao;
import br.edu.qi.dao.MarcaDao;
import br.edu.qi.dao.ModeloDao;
import br.edu.qi.model.Carro;
import br.edu.qi.model.Marca;
import br.edu.qi.model.Modelo;
import java.io.Serializable;

/**
 *
 * @author Diorgines
 */
public class ModeloBo extends BaseBo<Modelo>{
    
    public ModeloBo(GenericDao<Modelo, Serializable> dao) throws Exception {
        super(ModeloDao.getInstance());
    }

    @Override
    public void delete(Modelo t) throws Exception {
        
        if(dao.findByCod(t.getIdModelo())!=null){
            if(t.getCarros().isEmpty()){
                super.delete(t);
            }
            throw new Exception("Impossível remover este modelo pois exixtem carros cadastrados com este modelo");
        }
        else
            throw new Exception("Modelo não encontrado na base de dados");
    }

    @Override
    public void save(Modelo t) throws Exception {
        MarcaBo marcaBo = new MarcaBo(MarcaDao.getInstance());
        for(Marca marca :marcaBo.dao.getList()){
            if(marca.getIdMarca().equals(t.getMarca().getIdMarca())){
                marcaBo.addModelo(t, marca);
                super.save(t);
            }
        }
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Modelo t) throws Exception {
        
        MarcaBo marcaBo = new MarcaBo(MarcaDao.getInstance());
        boolean sucess = false;
        for(Modelo mo:dao.getList()){
            if(mo.getIdModelo().equals(t.getIdModelo())){
                //verifica se a marca foi alterada
                if(mo.getMarca().getIdMarca().equals(t.getMarca().getIdMarca())){
                    marcaBo.updateModelo(t, t.getMarca());
                }
                else{
                    marcaBo.removeModelo(mo, mo.getMarca());
                    marcaBo.addModelo(t, t.getMarca());
                }
                super.update(t);
                sucess=true;
            }     
        }
        if(!sucess)
            throw new Exception("Impossível atualizar, modelo não encontrado na base de dados");
    }
    
    
    
}
