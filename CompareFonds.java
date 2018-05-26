/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author camille
 */
public class CompareFonds implements Comparable<Fonds> {
    
    private Fonds fonds ;
    
    public CompareFonds(Fonds fonds)
    {
        this.fonds = fonds;
    }
  
    public Boolean equals(Fonds fonds)
    {
        if(this.fonds.getAmount() == fonds.getAmount())
        {
            return true ;
        }
        else
            return false ;
    }
    
    public @Override int compareTo(Fonds fonds)
    {
        if(this.fonds.getAmount() > fonds.getAmount())
        {
            return 1 ;
        }
        if(this.fonds.equals(fonds))
        {
            return 0 ;
        }
        
        return -1 ;
    }
}
