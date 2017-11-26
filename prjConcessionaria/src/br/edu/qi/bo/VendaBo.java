/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;


import br.edu.qi.dao.VendaDao;
import br.edu.qi.model.Venda;
import java.util.List;


/**
 *
 * @author Diorgines
 */
public class VendaBo extends GenericBo<Venda>{
    
    private ParcelaBo parcelaBo;
    private Venda v;
    public VendaBo() throws Exception {
        super(VendaDao.getInstance());
        this.parcelaBo = new ParcelaBo();
    }
    
    public float calculaparcela(Float valor, int parcela){
        return valor/parcela;
    }

    @Override
    public void save(Venda t) throws Exception {
        super.save(t);
        List<Venda> listVenda = super.findAll();
        
        int i = 0;
        listVenda.forEach((venda)->{
            if(venda.getNroVenda()>i){
                v = venda;
            }
                
        });
        parcelaBo.saveLote(v);
         //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
