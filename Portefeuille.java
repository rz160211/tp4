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
 * @author Rim
 */
public class Portefeuille {
    
    public HashMap<String,Fonds> hmapFonds;
    public HashMap<String,Instrument> hmapInstrument;

    public void ajoutFondsInstrument(String cle, Fonds fonds) throws ExceptionExistence 
    {
        try {
            if(rechercheInstrument(cle))
            {
                 Instrument instru = hmapInstrument.get(cle) ;
                 instru.ajoutFonds(fonds);
            }
            else
                throw new ExceptionExistence ("Instrument inexistant");
        }
        catch(ExceptionExistence e)
        {
            System.out.println(e.getMessage());
        }


    }

    public void supprimerHmapFond(String cle) throws ExceptionExistence 
    {
        try {
            if(rechercheFonds(cle))
            {
                hmapFonds.remove(cle);
            }
            else
                throw new ExceptionExistence("Fonds inexistant"); 
        }
        catch(ExceptionExistence e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void supprimerHmapInstrument(String cle) throws ExceptionExistence 
    {
        try {
            if(rechercheInstrument(cle))
            {
                hmapInstrument.remove(cle);
            }
            else
                throw new ExceptionExistence("Instrument inexistant"); 
        }
        catch(ExceptionExistence e)
        {
            System.out.println(e.getMessage());
        }
    }

    //double rechercheFonds(String){return 0;
    //}
    //ArrayList<Fonds> rechercheInstrument(String){}
    //void ajoutHmapFonds(String, double){}


}
