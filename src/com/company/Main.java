package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Déclaration des variables
        int place;
        // Création du plateau
        // Déclaration des variables
        int abscisse = 0;
        int ordonne = 0;


        //Menu puis demande des pseudos une fois la demande de commencer la partie
        FonctionsDestructCase.afficherMenu();
        FonctionsDestructCase.VariablesGlobales.pseudoJ1 = FonctionsDestructCase.demandePseudo1();
        System.out.println("Joueur1: " + FonctionsDestructCase.VariablesGlobales.pseudoJ1);
        FonctionsDestructCase.VariablesGlobales.pseudoJ2 = FonctionsDestructCase.demandePseudo2();
        System.out.println("Joueur2: " + FonctionsDestructCase.VariablesGlobales.pseudoJ2);

        // Affichage du plateau
        FonctionsDestructCase.remplirCaseDepart();
        // choix du premier joueur aléatoirement
        FonctionsDestructCase.VariablesGlobales.joueur1 = FonctionsDestructCase.aleaPremierjoueur();
        FonctionsDestructCase.VariablesGlobales.joueur2 = FonctionsDestructCase.VariablesGlobales.pseudoJ2;
        // Faire en sorte que les pseudos soit attribués aux joueurs
        if (FonctionsDestructCase.VariablesGlobales.joueur1 == FonctionsDestructCase.VariablesGlobales.joueur2) {
            FonctionsDestructCase.VariablesGlobales.joueur2 = FonctionsDestructCase.VariablesGlobales.pseudoJ1;
        }

        System.out.println("Le premier à jouer sera " + FonctionsDestructCase.VariablesGlobales.joueur1 + " suivi de " + FonctionsDestructCase.VariablesGlobales.joueur2);
        System.out.println(FonctionsDestructCase.VariablesGlobales.joueur1 + " tu seras A et " + FonctionsDestructCase.VariablesGlobales.joueur2 + " tu seras B");


        //Mouvement des joueurs
        while (true) {

            FonctionsDestructCase.deplacerJoueur1();
            FonctionsDestructCase.remplirCaseDepart();

            //Demande de la case à détruire
            System.out.println("Choisissez la case que vous voulez détruire. (Elles sont numérotés)");
            while (true) { // Vérification que c'est bien un nombre et entre 1 et 110
                Scanner scanDetruire1 = new Scanner(System.in);
                if (scanDetruire1.hasNextInt()) {
                    place = scanDetruire1.nextInt();
                    while (true) {
                        if (place < 1 || place > 110) {
                            System.out.println("Vous voyez que c'est entre 1 et 110");
                            place = scanDetruire1.nextInt();
                        } else if (FonctionsDestructCase.placeX.contains(place)) {
                            System.out.println("Cette case à déjà été détruite");
                            place = scanDetruire1.nextInt();
                        }
                        else if (FonctionsDestructCase.VariablesGlobales.croix.equals(FonctionsDestructCase.VariablesGlobales.symboleJoueur1) || FonctionsDestructCase.VariablesGlobales.croix.equals(FonctionsDestructCase.VariablesGlobales.symboleJoueur2)) {
                            System.out.println("Vous ne pouvez pas détruire les joueurs");
                            place = scanDetruire1.nextInt();
                        }
                        else {
                            break;
                        }
                    }
                    break;
                } else {
                    System.out.println("Vous ne voyez que les numéros que vous pouvez taper ");
                }
            }

            FonctionsDestructCase.detruireCase(FonctionsDestructCase.VariablesGlobales.plateau, place);
            FonctionsDestructCase.afficherMenuEnPartie();
            FonctionsDestructCase.remplirCaseDepart();

            FonctionsDestructCase.deplacerJoueur2();
            FonctionsDestructCase.remplirCaseDepart();

            System.out.println("Choisissez la case que vous voulez détruire. (Elles sont numérotés)");
            while (true) { // Vérification que c'est bien un nombre et entre 1 et 110
                Scanner scanDetruire2 = new Scanner(System.in);
                if (scanDetruire2.hasNextInt()) {
                    place = scanDetruire2.nextInt();
                    if (place < 1 || place > 110) {
                        System.out.println("Vous voyez que c'est entre 1 et 110");
                    }
                    break;
                } else {
                    System.out.println("Vous ne voyez que les numéros que vous pouvez taper ");
                }
            }
            FonctionsDestructCase.detruireCase(FonctionsDestructCase.VariablesGlobales.plateau, place);
            FonctionsDestructCase.afficherMenuEnPartie();
            FonctionsDestructCase.remplirCaseDepart();
        }

    }
}

