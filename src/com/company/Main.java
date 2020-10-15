package com.company;

import javax.management.MBeanRegistration;
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
        FonctionDestructCase.afficherMenu();
        FonctionDestructCase.VariablesGlobales.pseudoJ1 = FonctionDestructCase.demandePseudo1();
        System.out.println("Joueur1: " + FonctionDestructCase.VariablesGlobales.pseudoJ1);
        FonctionDestructCase.VariablesGlobales.pseudoJ2 = FonctionDestructCase.demandePseudo2();
        System.out.println("Joueur2: " + FonctionDestructCase.VariablesGlobales.pseudoJ2);

        // choix du premier joueur aléatoirement
        FonctionDestructCase.VariablesGlobales.joueur1 = FonctionDestructCase.aleaPremierjoueur();
        FonctionDestructCase.VariablesGlobales.joueur2 = FonctionDestructCase.VariablesGlobales.pseudoJ2;
        // Faire en sorte que les pseudos soit attribués aux joueurs
        if (FonctionDestructCase.VariablesGlobales.joueur1 == FonctionDestructCase.VariablesGlobales.joueur2) {
            FonctionDestructCase.VariablesGlobales.joueur2 = FonctionDestructCase.VariablesGlobales.pseudoJ1;
        }

        System.out.println("Le premier à jouer sera " + FonctionDestructCase.VariablesGlobales.joueur1 + " suivi de " + FonctionDestructCase.VariablesGlobales.joueur2);
        System.out.println(FonctionDestructCase.VariablesGlobales.joueur1 + " tu seras A et " + FonctionDestructCase.VariablesGlobales.joueur2 + " tu seras B");
        FonctionDestructCase.remplirCaseDepart();

        //Mouvement des joueurs
        while (true) {

            FonctionDestructCase.deplacerJoueur1();
            FonctionDestructCase.remplirCaseDepart();


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
                        } else if (FonctionDestructCase.placeX.contains(place)) {
                            System.out.println("Cette case à déjà été détruite");
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

            FonctionDestructCase.detruireCase(FonctionDestructCase.VariablesGlobales.plateau, place);
            FonctionDestructCase.afficherMenuEnPartie();
            FonctionDestructCase.remplirCaseDepart();

            FonctionDestructCase.deplacerJoueur2();
            FonctionDestructCase.remplirCaseDepart();

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
            FonctionDestructCase.detruireCase(FonctionDestructCase.VariablesGlobales.plateau, place);
            FonctionDestructCase.afficherMenuEnPartie();
            FonctionDestructCase.remplirCaseDepart();
        }

    }
}

