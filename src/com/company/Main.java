package com.company;

import javax.management.MBeanRegistration;
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
            while (true){
                if (ouVeuxTuTeDeplacer == 'z' && abscisseJ1>0){
                    // Déplacement vers le haut

                    abscisseJ1--;
                    if (abscisseJ1 == abscisseJ2){
                        System.out.println("Vous ne pouvez pas vous faier du rentre-dedans comme ça");
                    }
                    break;
                }
                else if (ouVeuxTuTeDeplacer == 'q' && ordonneJ1>0){
                    // Déplacement vers la gauche

                    ordonneJ1--;
                    break;
                }
                else if (ouVeuxTuTeDeplacer == 's'&& abscisseJ1<10){
                    // Déplacement vers le bas

                    abscisseJ1++;
                    break;
                }
                else if (ouVeuxTuTeDeplacer == 'd' && ordonneJ1<11){
                    // Déplacement vers la droite

                    ordonneJ1++;
                    break;
                }
                else {
                    System.out.println("Vous ne pouvez pas sortir des limites");
                    ouVeuxTuTeDeplacer = scan.next().charAt(0);
                }
            }

            FonctionDestructCase.remplirCaseDepart(plateau, ordonneJ1, abscisseJ1, ordonneJ2, abscisseJ2);

            //Demande de la case à détruire
            System.out.println("Choisissez la case que vous voulez détruire. (Elles sont numérotés)");
            while (true){ // Vérification que c'est bien un nombre et entre 1 et 110
                Scanner scanDetruire1 = new Scanner(System.in);
                if (scanDetruire1.hasNextInt()){
                    place = scanDetruire1.nextInt();
                    while (true){

                        if (place<1 || place>110){
                            System.out.println("Vous voyez que c'est entre 1 et 110");
                            place = scanDetruire1.nextInt();
                        }
                        else {
                            break;
                        }
                    }
                    break;
                }
                else {
                    System.out.println("Vous ne voyez que les numéros que vous pouvez taper ");
                }
            }

            FonctionDestructCase.detruireCase(plateau, place);
            FonctionDestructCase.afficherMenuEnPartie();
            FonctionDestructCase.remplirCaseDepart(plateau, ordonneJ1, abscisseJ1, ordonneJ2, abscisseJ2);

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
            while (true){
                if (ouVeuxTuTeDeplacer == 'z' && abscisseJ2>0){
                    // Déplacement vers le haut

                    abscisseJ2--;
                    break;
                }
                else if (ouVeuxTuTeDeplacer == 'q' && ordonneJ2>0){
                    // Déplacement vers la gauche

                    ordonneJ2--;
                    break;
                }
                else if (ouVeuxTuTeDeplacer == 's' && abscisseJ2<10){
                    // Déplacement vers le bas

                    abscisseJ2++;
                    break;
                }
                else if (ouVeuxTuTeDeplacer == 'd' && ordonneJ2<11){
                    // Déplacement vers la droite

                    ordonneJ2++;
                    break;
                }
                else {
                    System.out.println("Vous ne pouvez pas sortir des limites");
                    ouVeuxTuTeDeplacer = scan.next().charAt(0);
                }
            }

            FonctionDestructCase.remplirCaseDepart(plateau, ordonneJ1, abscisseJ1, ordonneJ2, abscisseJ2);


            System.out.println("Choisissez la case que vous voulez détruire. (Elles sont numérotés)");


            while (true){ // Vérification que c'est bien un nombre et entre 1 et 110
                Scanner scanDetruire2 = new Scanner(System.in);
                if (scanDetruire2.hasNextInt()){
                    place = scanDetruire2.nextInt();
                    if (place<1 || place>110){
                        System.out.println("Vous voyez que c'est entre 1 et 110");
                    }
                    break;
                }
                else {
                    System.out.println("Vous ne voyez que les numéros que vous pouvez taper ");
                }
            }
            FonctionDestructCase.detruireCase(plateau, place);
            FonctionDestructCase.remplirCaseDepart(plateau, ordonneJ1, abscisseJ1, ordonneJ2, abscisseJ2);
        }


    }
}
