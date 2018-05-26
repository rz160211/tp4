package Controleur;

import Modele.*;
/**
 *
 * @author camille
 */
public class CompareFonds implements Comparable<Fonds> {
    private Fonds fonds ;
    
    public CompareFonds(Fonds fonds)
    {
        this.fonds = fonds ;
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
        if(equals(fonds))
        {
            return 0 ;
        }
        
        return -1 ;
    }
}