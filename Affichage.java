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
 * @author Rim
 */
public class Affichage {
    
    public Affichage(){}
    
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
            System.out.println(entry.getKey() + "/" + entry.getValue());
            
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
    
    public List<Double> afficherPourcentage(String key, Portefeuille wallet, List<Double> list)
    {
        double pourcentage;
        List<Double> pourcentageList = new ArrayList<>();
        
        try {
            Fonds walletValue = wallet.rechercheFonds(key);
            double value= walletValue.getAmount();
            
            //le pourcentage de chaque instrument pour ce fonds avec resultat de afficherInstrument            
            for(double amount : list){
                pourcentage = amount/value;
                pourcentageList.add(pourcentage);
            }
            
            
        } catch (ExceptionExistence ex) {
            //FondsInexistant est générée, message d'erreur
            System.out.println("ERREUR 404: le fonds est inexistant.");

        }
        
        return pourcentageList;
    }
    
    
}
