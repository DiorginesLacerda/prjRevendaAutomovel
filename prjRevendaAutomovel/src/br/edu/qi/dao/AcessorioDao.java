/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.model.Acessorio;
import java.io.Serializable;

/**
 *
 * @author Diorgines
 */
public class AcessorioDao extends GenericDao<Acessorio, Serializable>{
    
    private static AcessorioDao instance;
    private static Acessorio acessorio;
    private AcessorioDao(Acessorio entity) throws Exception {
        super(entity);
    }
    
    public static AcessorioDao getInstance() throws Exception{
        if(instance==null)
            instance = new AcessorioDao(acessorio);
        return instance;
    }

    public Acessorio findLocal(Acessorio t) throws Exception {
        for(Acessorio a:super.getList()){
            if(a.equals(t))
                return a;
        }
        return null; //To change body of generated methods, choose Tools | Templates.
    }
    
    public Acessorio findLocalByCod(int id){
        for(Acessorio a :super.getList()){
            if(a.getIdAcessorio().equals(id))
                return a;
        }
        return null;
    }

    @Override
    public void delete(Acessorio e) throws Exception {
        try {
            super.delete(e);
            super.getList().remove(e);
        } catch (Exception ex) {
        }
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Acessorio e) throws Exception {
        try {
            super.update(e);
            for( int i=0;i<super.getList().size();i++){
                if(super.getList().get(i).getIdAcessorio().equals(e.getIdAcessorio()))
                    super.getList().set(i, e);
            }
        } catch (Exception ex) {
        }
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Acessorio e) throws Exception {
        try {
            super.save(e);
            super.getList().add(e);
        } catch (Exception ex) {
        }
         //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
