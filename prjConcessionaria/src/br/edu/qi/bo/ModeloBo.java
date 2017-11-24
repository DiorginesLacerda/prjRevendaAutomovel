/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.MarcaDao;
import br.edu.qi.dao.ModeloDao;
import br.edu.qi.model.Marca;
import br.edu.qi.model.Modelo;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Diorgines
 */
public class ModeloBo extends GenericBo<Modelo>{
    
    
    public ModeloBo() throws Exception {
        super(ModeloDao.getInstance());
        
    }

    @Override
    public List<Modelo> findAll() throws Exception {
        List<Modelo> listModelos = super.findAllWithoutClose();
        List<Marca> marcas = MarcaDao.getInstance().findAll();
        listModelos.forEach((modelo) -> {
            marcas.forEach((marca) -> {
                Marca m = modelo.getMarca();
                int id = m.getIdMarca();
                if(marca.getIdMarca()==id){
                    modelo.setMarca(marca);
                }                
            }); 
        });
        return listModelos;
    }
    
    
    
}
