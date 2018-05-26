/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.*;
import java.util.Scanner;

/**
 *
 * @author Rim
 */
public class TestPortefeuille {
    
    public static void main(String args[]) throws FondsInexistant
    {
        /*
        Lire au clavier la valeur de clé d’un fonds et son montant ; 
        Appeler la méthode de recherche d’un fonds de la question 1.3 avec la clé saisie en paramètre ; 
        Si l’exception FondsInexistant est générée, instancier et ajouter le fonds à la HashMap des fonds ; 
        sinon générer l’exception Fonds 
        */
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nom pour le fonds");
        String key = sc.nextLine();
        System.out.println("Entrez le montant pour le fonds");
        double amount = sc.nextDouble();
        
        Fonds fonds = new Fonds(key, amount);
        Portefeuille wallet = new Portefeuille();
        
        wallet.ajoutHmapFonds(key, fonds);
        
        System.out.println(wallet.rechercheFonds(key));
       
    }
    
}
