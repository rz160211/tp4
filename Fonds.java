/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Rim
 */
public class Fonds {
    
    private double amount;
    private String key ;
    
    public Fonds(){
        amount = 0; key = ""; 
    }
    
    public void setAmount(double amount){
        this.amount=amount;
    }
    
    public double getAmount(){
        return this.amount;
    }
    
    public void setKey(String key){
        this.key=key;
    }
    
    public String getKey(){
        return this.key;
    }
       
}