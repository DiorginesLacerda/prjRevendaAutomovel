/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;

import br.edu.qi.dao.CarroDao;
import br.edu.qi.model.Carro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diorgines
 */
public class CarroBo extends GenericBo<Carro>{
    
    public CarroBo() throws Exception {
        super(CarroDao.getInstance());
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
