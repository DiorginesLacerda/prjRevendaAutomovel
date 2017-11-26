/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.bo;


import br.edu.qi.dao.ParcelaDao;
import br.edu.qi.model.Parcela;
import br.edu.qi.model.Venda;
import br.edu.qi.util.NumberUtil;
import java.util.Calendar;


/**
 *
 * @author Diorgines
 */
public class ParcelaBo extends GenericBo<Parcela>{
    
    public ParcelaBo() throws Exception {
        super(ParcelaDao.getInstance());
    }

   
    public void saveLote(Venda v) throws Exception {
        for(int i = 0;i<v.getNroParcelas();i++){
            Parcela p = new Parcela();
            p.setVenda(v);
            Calendar cal = Calendar.getInstance();
            cal.setTime(v.getDataVenda());
            cal.add(Calendar.MONTH,i+1);
            p.setDataParcela(cal.getTime());
            p.setValorParcela(NumberUtil.DoubletoLong(v.getValor()/v.getNroParcelas()));
            
            super.save(p);
        }
        
         //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
