/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.util;

/**
 *
 * @author Diorgines
 */
public class NumberUtil {
    
    public static Long setFloat(String string) throws Exception{
        try {
            float f = Float.parseFloat(string);
            long lo = (long)f*100;
            return lo;
        } catch (Exception e) {
            throw new Exception("Valor inválido");
        }
    }
    
    public static float getFloat(Long l){
        return l/100;
    }
    
    
    
}
