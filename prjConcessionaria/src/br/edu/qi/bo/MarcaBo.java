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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Diorgines
 */
public class MarcaBo extends GenericBo<Marca>{
  
    
    public MarcaBo() throws Exception {
        super(MarcaDao.getInstance());
    }

    @Override
    public List<Marca> findAll() throws Exception {
        List<Marca> listMarca = super.findAll();
        List<Modelo> listModelo  = ModeloDao.getInstance().findAll();
        listMarca.forEach((marca)->{
            Set<Modelo>setModelo = new HashSet();
            listModelo.forEach((modelo)->{
                Marca mk = modelo.getMarca();
                int id = mk.getIdMarca();
                if(marca.getIdMarca().equals(id)){
                    setModelo.add(modelo);
                }
            });
            marca.setModelos(setModelo);
        });
        return listMarca; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
