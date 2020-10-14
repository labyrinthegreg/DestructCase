package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Déclaration des variables
        String pseudoJ1;
        String pseudoJ2;
        String joueur1;
        String joueur2;
        char ouVeuxTuTeDeplacer;
        int place;
        int place2;
        int ordonneJ1 = 5;
        int abscisseJ1 = 4;
        int ordonneJ2 = 5;
        int abscisseJ2 = 5;

        // Création du plateau
        // Déclaration des variables
        int abscisse = 0;
        int ordonne = 0;
        String[][] plateau = new String[10][11];


        //Menu puis demande des pseudos une fois la demande de commencer la partie
        FonctionDestructCase.afficherMenu();
        pseudoJ1 = FonctionDestructCase.demandePseudo1();
        System.out.println("Joueur1: " + pseudoJ1);
        pseudoJ2 = FonctionDestructCase.demandePseudo2();
        System.out.println("Joueur2: " + pseudoJ2);

        FonctionDestructCase.remplirCaseDepart(plateau, ordonneJ1, abscisseJ1, ordonneJ2, abscisseJ2);

        // choix du premier joueur aléatoirement
        joueur1 = FonctionDestructCase.aleaPremierjoueur(pseudoJ1, pseudoJ2);
        joueur2 = pseudoJ2;
        // Faire en sorte que les pseudos soit attribués aux joueurs
        if (joueur1 == joueur2){
            joueur2 = pseudoJ1;
        }

        System.out.println("Le premier à jouer sera " + joueur1 + " suivi de " + joueur2);
        System.out.println(joueur1 + " tu seras A et " + joueur2 + " tu seras B");
        FonctionDestructCase.remplirCaseDepart(plateau, ordonneJ1, abscisseJ1, ordonneJ2, abscisseJ2);

        //Mouvement des joueurs
        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("C'est à " + joueur1);
            //Le joueur1 bouge
            System.out.println(" Ou voulez-vous vous déplacez ? (z q s d)");
            Scanner scanDeplacement = new Scanner(System.in);
            ouVeuxTuTeDeplacer = scanDeplacement.next().charAt(0);
            while (true){
                if (ouVeuxTuTeDeplacer != 'z' && ouVeuxTuTeDeplacer != 'q' && ouVeuxTuTeDeplacer != 'd' && ouVeuxTuTeDeplacer != 's'){
                    System.out.println("T'as que 4 choix");
                    ouVeuxTuTeDeplacer = scanDeplacement.next().charAt(0);
                }
                else {
                    break;
                }
            }
            if (ouVeuxTuTeDeplacer == 'z'){
                // Déplacement vers le haut

                abscisseJ1--;
            }
            else if (ouVeuxTuTeDeplacer == 'q'){
                // Déplacement vers la gauche

                ordonneJ1++;
            }
            else if (ouVeuxTuTeDeplacer == 's'){
                // Déplacement vers le bas

                abscisseJ1++;
            }
            else if (ouVeuxTuTeDeplacer == 'd'){
                // Déplacement vers la droite

                ordonneJ1--;
            }
            FonctionDestructCase.remplirCaseDepart(plateau, ordonneJ1, abscisseJ1, ordonneJ2, abscisseJ2);
            //Demande de la case à détruire
            System.out.println("Choisissez la case que vous voulez détruire. (Elles sont numérotés)");
            while (true){ // Vérification que c'est bien un nombre et entre 1 et 110
                if (scan.hasNextInt()){
                    place = scan.nextInt();
                    while (true){

                        if (place<1 || place>110){
                            System.out.println("Vous voyez que c'est entre 1 et 110");
                            place = scan.nextInt();
                        }
                        else {
                            break;
                        }
                    }
                    break;
                }
                else {
                    System.out.println("Vous voyez les numéros que vous pouvez taper ");
                }
            }
            FonctionDestructCase.detruireCase(plateau, place);

            Scanner scan2 = new Scanner(System.in);
            System.out.println("C'est à " + joueur2);
            System.out.println(" Ou voulez-vous vous déplacez ? (z q s d)");
            ouVeuxTuTeDeplacer = scanDeplacement.next().charAt(0);
            while (true){
                if (ouVeuxTuTeDeplacer != 'z' && ouVeuxTuTeDeplacer != 'q' && ouVeuxTuTeDeplacer != 'd' && ouVeuxTuTeDeplacer != 's'){
                    System.out.println("T'as que 4 choix");
                    ouVeuxTuTeDeplacer = scanDeplacement.next().charAt(0);
                }
                else {
                    break;
                }
            }
            if (ouVeuxTuTeDeplacer == 'z'){
                // Déplacement vers le haut

                abscisseJ2--;
            }
            else if (ouVeuxTuTeDeplacer == 'q'){
                // Déplacement vers la gauche

                ordonneJ2++;
            }
            else if (ouVeuxTuTeDeplacer == 's'){
                // Déplacement vers le bas

                abscisseJ2++;
            }
            else if (ouVeuxTuTeDeplacer == 'd'){
                // Déplacement vers la droite

                ordonneJ2--;
            }
            System.out.println("Choisissez la case que vous voulez détruire. (Elles sont numérotés)");

            //Le joueur2 bouge
            while (true){ // Vérification que c'est bien un nombre et entre 1 et 110
                if (scan2.hasNextInt()){
                    place2 = scan2.nextInt();
                    if (place<1 || place>110){
                        System.out.println("Vous voyez que c'est entre 1 et 110");
                    }
                    break;
                }
                else {
                    System.out.println("Vous voyez les numéros que vous pouvez taper ");
                }
            }
            FonctionDestructCase.detruireCase(plateau, place2);
        }


    }
}
