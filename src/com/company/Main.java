package com.company;

public class Main {

    public static void main(String[] args) {

        //Déclaration des variables
        String pseudoJ1;
        String pseudoJ2;
        String Joueur1;
        String Joueur2;

        //Menu puis demande des pseudos une fois la demande de commencer la partie
        FonctionDestructCase.afficherMenu();
        pseudoJ1 = FonctionDestructCase.demandePseudo1();
        System.out.println("Joueur1: " + pseudoJ1);
        pseudoJ2 = FonctionDestructCase.demandePseudo2();
        System.out.println("Joueur2: " + pseudoJ2);

        // choix du premier joueur aléatoirement
        Joueur1 = FonctionDestructCase.aleaPremierjoueur(pseudoJ1, pseudoJ2);
        Joueur2 = pseudoJ2;
        // Faire en sorte que les pseudos soit attribués aux joueurs
        if (Joueur1 == Joueur2){
            Joueur2 = pseudoJ1;
        }
        System.out.println("Le premier à jouer sera " + Joueur1 + " suivi de " + Joueur2);


    }
}
