/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.ExceptionExistence;
import Modele.*;
import java.util.*;

/**
 *
 * @author Rim, Camille
 */
public class Affichage {
    
    public Affichage(){}
    
    
    
    /* Méthode d'affichage des fonds d'un instrument triés par montant */
    
    public void afficherTriFondsInstrument(Instrument instrument)
    {
        instrument.tri();
        ArrayList<Fonds> fonds = instrument.getStringList();
        for(int i = 0 ; i < fonds.size() ; i++)
        {
            System.out.println("Fonds " + fonds.get(i).getKey() + " de montant " + fonds.get(i).getAmount());
        }
    }
    
    /**
     *
     * @param hmapInstrument
     * @return 
     */
    /*Une méthode qui affiche, pour chaque instrument, 
    sa clé, son nombre total de fonds et la somme totale des montants de ses fonds*/
    
    public List<Double> afficherInstrument(HashMap<String,Instrument> hmapInstrument)
    {
        Instrument instrument;
        ArrayList<Fonds> collection;
        List<Double> list = new ArrayList<>();
        double valeur;
        double somme = 0;
        
        for (HashMap.Entry<String,Instrument> entry : hmapInstrument.entrySet())
        {
            //affichage de la cle
            System.out.println(entry.getKey());
            
            //affichage du nombre total de fonds
            instrument = entry.getValue();
            collection = instrument.getStringList();
            System.out.println("Cet instrument contient " + collection.size() + " fonds.");
            
            //affichage de la somme des fonds
            for(Fonds amount : collection){
                valeur = amount.getAmount();
                somme = somme + valeur; 
            }
            
            System.out.println("La somme est de " + somme + " .");
            list.add(somme);
        }
        
        return list;
    }
    
    public void afficherPourcentage(String key, Portefeuille wallet)
    {
        double pourcentage ;
        
        try {
            Fonds fonds = wallet.rechercheFonds(key);
           
            for (HashMap.Entry<String,Instrument> entry : wallet.getHmapInstru().entrySet())
            {
                pourcentage = 0.0 ;
                Instrument instru = entry.getValue();
                ArrayList<Fonds> instruList = instru.getStringList();
                
                int somme = 0 ;
                Boolean fondsPlace = false ;
                   
                for(int j = 0 ; j < instruList.size() ; j++)
                {
                    somme += instruList.get(j).getAmount();
                    if(instruList.get(j).getKey().equals(key))
                    {
                        fondsPlace = true;
                    }
                }
                  
                if(fondsPlace && somme != 0) 
                    pourcentage = fonds.getAmount()*100/somme ;
                
                
                System.out.println("Le pourcentage du fonds pour l'instrument " + instru.getKey() + " est de " + pourcentage );
            }
        } 
        catch (ExceptionExistence ex) {
            //ne exception est générée, message d'erreur
            System.out.println(ex.getMessage());
            
                
        }
    }
    
    
}