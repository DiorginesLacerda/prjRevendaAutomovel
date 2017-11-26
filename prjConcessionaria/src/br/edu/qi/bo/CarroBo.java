/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.CarroDao;
import br.edu.qi.model.Carro;
import br.edu.qi.model.CarroAcessorio;
import br.edu.qi.model.Modelo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diorgines
 */
public class CarroBo extends GenericBo<Carro>{
    
    private CarroAcessorioBo carroacessorioBo;
    private Carro carro;
    public CarroBo() throws Exception {
        super(CarroDao.getInstance());
        this.carroacessorioBo = new CarroAcessorioBo();
    }
    
    

    @Override
    public List<Carro> findAll() throws Exception {
        ModeloBo modeloBo =new ModeloBo();
        
        List<Carro> carros = super.findAll();
        List<Modelo> modelos = modeloBo.findAll();
        
       carros.forEach((carro)->{
           modelos.forEach((modelo)->{
               Modelo m = carro.getModelo();
               int id = m.getIdModelo();
               if(modelo.getIdModelo() == id)
                   carro.setModelo(modelo);
           });
       });
        return  carros;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Carro t) throws Exception {
        super.save(t);
        List<Carro> listCarro = findAll();
        int i = 0;
        listCarro.forEach((c)->{
            if(c.getIdCarro()>i)
                this.carro = c;
        });
        this.carro.setCarroAcessorios(t.getCarroAcessorios());
        
        
        carro.getCarroAcessorios().forEach((carroAcessorio)->{
            try {
               // if(carroAcessorio.getAcessorio().getCarroAcessorios()==null){
               //   carroAcessorio.getAcessorio().setCarroAcessorios(new HashSet<CarroAcessorio>(0));  
                //}
                //carroAcessorio.getAcessorio().getCarroAcessorios().add(carroAcessorio);
                    
                carroacessorioBo.save(carroAcessorio);
            } catch (Exception ex) {
                
            }
        });
         //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    public List<String> getColors(){
        List lista = new ArrayList();
        lista.add("Selecione");
        lista.add("Azul");
        lista.add("Preto");
        lista.add("Branco");
        lista.add("Tricolor");
        lista.add("Ouro");
        lista.add("Vermelho");
        lista.add("Cor de Burro quando Foge");
        return lista;
    }
}
