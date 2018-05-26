/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Rim
 */
public class Instrument {
    
    private ArrayList<Fonds> instrument;
    private String key;
    
    public Instrument(){
        
    }
    
        void ajoutFonds(Fonds fonds){
        instrument.add(fonds);
    }
    
    void tri()
    {
        
        
    }
    
}
