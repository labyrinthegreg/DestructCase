package com.company;

public class Main {

    public static void main(String[] args) {

        //Déclaration des variables
        String pseudoJ1;
        String pseudoJ2;

        //Menu puis demande des pseudos une fois la demande de commencer la partie
        FonctionDestructCase.afficherMenu();
        pseudoJ1 = FonctionDestructCase.demandePseudo1();
        System.out.println("Joueur1: " + pseudoJ1);
        pseudoJ2 = FonctionDestructCase.demandePseudo2();
        System.out.println("Joueur2: " + pseudoJ2);


    }
}
