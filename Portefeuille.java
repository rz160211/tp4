/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Controleur.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Rim, Camille
 */
public class Portefeuille {
    
    public HashMap<String,Fonds> hmapFonds = new HashMap<>() ;
    public HashMap<String,Instrument> hmapInstrument = new HashMap<>();
    
    public Portefeuille(){
    }

    public Fonds rechercheFonds(String key) throws ExceptionExistence {

        // si la cle existe 
        if (hmapFonds.containsKey(key)) {      
           // recuperer la valeur de la hmapFonds associÃ© Ã  la cle passÃ© en param
           Fonds value = hmapFonds.get(key); 
           return value ;
           
       }
       else{
           throw new ExceptionExistence("Fonds inexistant"); 
       }
        
    }

    public ArrayList<Fonds> rechercheInstrument(String key) throws ExceptionExistence {

        if (hmapInstrument.containsKey(key)) {
           // si la cle existe
           // recuperer la valeur de la hmapFonds associÃ© Ã  la cle passÃ© en param
            Instrument collection = hmapInstrument.get(key);  
            return collection.getStringList();       
        }
        else{
            throw new ExceptionExistence("Instrument inexistant"); 
        }

    }

    public void ajoutHmapFonds(String key, Fonds fonds){
        try {
            rechercheFonds(key);
        }
        catch(ExceptionExistence e)
        {
            System.out.println(e.getMessage());
            hmapFonds.put(key, fonds);
            System.out.println("Fonds " + key + " ajoute");
        }
    }
    
    public void ajoutHmapInstrument(String key, Instrument instru){
        try {
            rechercheInstrument(key);
            
        }
        catch(ExceptionExistence e)
        {
            System.out.println(e.getMessage());
            hmapInstrument.put(key, instru);
            System.out.println("Instrument " + key + " ajoute");
        }
        
    }

    public void ajoutFondsInstrument(String cle, Fonds fonds) 
    {
        try {
            rechercheInstrument(cle);
            Instrument instru = hmapInstrument.get(cle) ;
            instru.ajoutFonds(fonds);
            System.out.println("Fonds " + fonds.getKey() + "ajoute a l'instrument " + instru.getKey());
        }
        catch(ExceptionExistence e)
        {
            System.out.println(e.getMessage());              
        }


    }

    public void supprimerHmapFonds(String cle) 
    {
        try {
            rechercheFonds(cle);
            hmapFonds.remove(cle);
            System.out.println("Fonds " + cle + " supprime de la HashMap.");
        }
        catch(ExceptionExistence e)
        {
            System.out.println(e.getMessage());
           
        }
    }

    public void supprimerHmapInstrument(String cle) 
    {
        try {
            rechercheInstrument(cle);
            ArrayList<Fonds> instrument = hmapInstrument.get(cle).getStringList();
            for(int i = 0 ; i < instrument.size() ; i++)
            {
                instrument.remove(i);
            }
            hmapInstrument.remove(cle);
            System.out.println("Instrument " + cle + " supprime de la HashMap.");
        }
        catch(ExceptionExistence e)
        {
            System.out.println(e.getMessage());
            
        }
    }
    
    public HashMap<String,Instrument> getHmapInstru()
    {
        return this.hmapInstrument;
    }

}