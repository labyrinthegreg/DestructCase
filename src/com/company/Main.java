package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Déclaration des variables
        String pseudoJ1;
        String pseudoJ2;
        String joueur1;
        String joueur2;
        int place;
        int place2;

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

        FonctionDestructCase.remplirCaseDepart(plateau);

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
            //Le joueur1 bouge
            //Demande de la case à détruire
            System.out.println("Choisis la case que tu veux détruire. (Elles sont numérotés");
            while (true){ // Vérification que c'est bien un nombre et entre 1 et 110
                if (scan.hasNextInt()){
                    place = scan.nextInt();
                    if (place<1 || place>110){
                        System.out.println("Tu vois que c'est entre 1 et 110");
                    }
                    break;
                }
                else {
                    System.out.println("Tu vois les numéros que tu peux taper ");
                }
            }
            FonctionDestructCase.detruireCase(plateau, place);

            Scanner scan2 = new Scanner(System.in);
            System.out.println("C'est à " + joueur2);
            //Le joueur2 bouge
            while (true){ // Vérification que c'est bien un nombre et entre 1 et 110
                if (scan2.hasNextInt()){
                    place2 = scan2.nextInt();
                    if (place<1 || place>110){
                        System.out.println("Tu vois que c'est entre 1 et 110");
                    }
                    break;
                }
                else {
                    System.out.println("Tu vois les numéros que tu peux taper ");
                }
            }
            FonctionDestructCase.detruireCase(plateau, place2);
        }


    }
}
