/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.*;
import Vue.*;
import java.util.*;

/**
 *
 * @author Rim, Camille
 */
public class TestPortefeuille {
    
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        Portefeuille wallet = new Portefeuille();
        Affichage display = new Affichage();
        
        /*
        Lire au clavier la valeur de clé d’un fonds et son montant ; 
        Appeler la méthode de recherche d’un fonds de la question 1.3 avec la clé saisie en paramètre ; 
        Si l’exception FondsInexistant est générée, instancier et ajouter le fonds à la HashMap des fonds ; 
        sinon générer l’exception Fonds 
        */
        
        System.out.println("Entrez le nom du fonds");
        String keyF = sc.nextLine();
        System.out.println("Entrez le montant du fonds");
        double amount = sc.nextDouble();
        
        Fonds fonds = new Fonds(keyF, amount);
        
        sc.nextLine();
        
        wallet.ajoutHmapFonds(keyF, fonds);
       
        /*
        Lire au clavier la valeur de clé d’un instrument ;
        Appeler la méthode de recherche d’un instrument de la question 1.4 avec la clé saisie en paramètre ;
        Si l’exception InstrumentInexistant est générée, instancier l’instrument et l’ajouter à la HashMap des instruments.
        Appeler la méthode de la question 1.2 pour ajouter le nouveau fonds dans la collection de l’instrument.
        */
        
        System.out.println("Entrez le nom de l'instrument");
        String keyI = sc.nextLine();
        
        Instrument instru = new Instrument(keyI);
        
        wallet.ajoutHmapInstrument(keyI, instru);
        wallet.ajoutFondsInstrument(keyI, fonds);
        
        /* Tester les méthodes de suppression de fonds et d'instrument */
        
        System.out.println("Entrez le nom du fonds à supprimer");
        String keySuppF = sc.nextLine();
        
        wallet.supprimerHmapFonds(keySuppF);
        
        System.out.println("Entrez le nom de l'instrument à supprimer");
        String keySuppI = sc.nextLine();
        
        wallet.supprimerHmapInstrument(keySuppI);
       
        
        /* Testez votre tri en affichant dans la « Vue » les fonds d’un instrument, triés par montant. */
        System.out.println("Entrez la cle de l'instrument a trier");
        String keyInstruTri = sc.nextLine();
        
        Instrument aTrier = new Instrument(keyInstruTri) ;
        wallet.ajoutHmapInstrument(keyInstruTri, aTrier);
        
        System.out.println("Entrez le nombre de fonds à placer dans l'instrument");
        int nb = sc.nextInt();

        for(int i=0 ; i < nb ; i++)
        {
            sc.nextLine();
            System.out.println("Entrez le nom du fonds");
            String keyList = sc.nextLine();
            System.out.println("Entrez le montant du fonds");
            double amountList = sc.nextDouble();
            
            Fonds fondsTri = new Fonds(keyList,amountList);
            
            wallet.ajoutHmapFonds(keyList, fondsTri);
            wallet.ajoutFondsInstrument(keyInstruTri, fondsTri);
        }
        
        
        display.afficherTriFondsInstrument(aTrier);
        
        /* Tester les méthodes de la vue */
        
        System.out.println(display.afficherInstrument(wallet.getHmapInstru()));
        
        sc.nextLine() ;
        
        System.out.println("Entrez la cle d'un fonds") ;
        String keyPourcent = sc.nextLine();
        
        display.afficherPourcentage(keyPourcent, wallet);
    }
    
}

