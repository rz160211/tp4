package Modele;

import Controleur.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Rim
 */
public class Portefeuille {
    
private HashMap<String,Fonds> hmapFonds = new HashMap<>();
private HashMap<String,Instrument> hmapInstrument = new HashMap<>();

public Portefeuille(){
}

public Fonds rechercheFonds(String key) throws FondsInexistant {
   
    // si la cle existe 
    if (hmapFonds.containsKey(key)) {      
       // recuperer la valeur de la hmapFonds associé à la cle passé en param
        Fonds value = hmapFonds.get(key);  
        return value;       
    }
    else{
        return null; //mettre l'exception ici
    }
    
}

public ArrayList<Fonds> rechercheInstrument(String key){
    
    Instrument collection = new Instrument();
    
    if (hmapInstrument.containsKey(key)) {
       // si la cle existe
       // recuperer la valeur de la hmapFonds associé à la cle passé en param
        collection = hmapInstrument.get(key);  
        return collection.getStringList();       
    }
    else{
        return null; //mettre l'exception ici
    }
    
}

public void ajoutHmapFonds(String key, Fonds fonds){
    hmapFonds.put(key, fonds);
}

public void ajoutFondsInstrument(String key, double montant) throws FondsInexistant
{
    Fonds fonds = new Fonds() ;
    fonds.setAmount(montant) ;
    
    if(rechercheFonds(key)!=null)
    {
        System.out.println("Fonds existant"); //à remplacer par les exceptions
    }
    else
        hmapFonds.put(key, fonds) ;
        
}

public void supprimerHmapFond(String key) throws FondsInexistant
{
    if(rechercheFonds(key) != null)
    {
        hmapFonds.remove(key);
    }
    else
        System.out.println("Fonds inexistant"); //à remplacer par les exceptions
}

public void supprimerHmapInstrument(String key)
{
    if(rechercheInstrument(key) != null)
    {
        hmapInstrument.remove(key);
    }
    else
        System.out.println("Instrument inexistant"); //à remplacer par les exceptions
}
    

}

