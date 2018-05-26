/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author Rim
 */
public class Instrument {
    
    private ArrayList<Fonds> instrument;
    private String key;
    
    public Instrument(){
        
    }
    
    public ArrayList<Fonds> getStringList() {
        return instrument;
    }
    
    void ajoutFonds(Fonds fonds){
    instrument.add(fonds);
    }
    
    void tri()
    {
        
        
        for(int i = 0 ; i < instrument.size() ; i++)
        {
            CompareFonds comparator = new CompareFonds(instrument.get(i)) ;
            sort(instrument, comparator) ;
            
        }
        
    }
    
}
