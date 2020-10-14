package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Déclaration des variables
        String pseudoJ1;
        String pseudoJ2;
        String joueur1;
        String joueur2;

        // Création du plateau
        // Déclaration des variables
        int abscisse = 0;
        int ordonnée = 0;
        String[][] plateau = new String[10][11];


        //Menu puis demande des pseudos une fois la demande de commencer la partie
        FonctionDestructCase.afficherMenu();
        pseudoJ1 = FonctionDestructCase.demandePseudo1();
        System.out.println("Joueur1: " + pseudoJ1);
        pseudoJ2 = FonctionDestructCase.demandePseudo2();
        System.out.println("Joueur2: " + pseudoJ2);

        FonctionDestructCase.afficherPlateau(abscisse, ordonnée);

        // choix du premier joueur aléatoirement
        joueur1 = FonctionDestructCase.aleaPremierjoueur(pseudoJ1, pseudoJ2);
        joueur2 = pseudoJ2;
        // Faire en sorte que les pseudos soit attribués aux joueurs
        if (joueur1 == joueur2){
            joueur2 = pseudoJ1;
        }

        System.out.println("Le premier à jouer sera " + joueur1 + " suivi de " + joueur2);
        System.out.println(joueur1 + " tu seras A et " + joueur2 + " tu seras B");
        FonctionDestructCase.remplirCaseDepart(plateau);

        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("C'est à " + joueur1);
            System.out.println("Choisis ta case.");
            int place = scan.nextInt();

            //FonctionDestructCase.deplacement(plateau, place, "joueur1");


            Scanner scan2 = new Scanner(System.in);
            System.out.println("C'est à " + joueur2);
            System.out.println("Choisis ta case.");
            int place2 = scan2.nextInt();
            //FonctionDestructCase.deplacement(plateau, place2, "joueur2");

            FonctionDestructCase.afficherPlateau(abscisse, ordonnée);



        }


    }
}
