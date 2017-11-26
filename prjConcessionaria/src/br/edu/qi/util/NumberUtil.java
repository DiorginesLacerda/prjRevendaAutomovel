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
    
    public static double LongtoDouble(Long l){
        return l/100;
    }
    
    public static long DoubletoLong(Double d){
        d *=100;
        long l = d.longValue();
        return l;
    }
    
    public static int getInteger(String s) throws Exception{
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            throw new Exception("Valor Inválido");
        }
    }
    
    
    
    public static double getDouble(String s) throws Exception{
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            throw new Exception("Valor Inválido");
        }
    }
    
    
}
