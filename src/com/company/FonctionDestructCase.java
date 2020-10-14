package com.company;

import java.util.Scanner;

public class FonctionDestructCase {

    public static void afficherMenu() {
        // Présentation du menu
        System.out.println("Si tu veux connaître les règles, tape '1'");
        System.out.println("Pour commencer une partie, tape '2'");
        System.out.println("Pour quitter le jeu, tape '3'");
        // Déclaration des varaibles
        int retourMenu;
        while (true){ // Phase de vérification si c'est bien rentré
            Scanner scan1 = new Scanner(System.in);
            if (scan1.hasNextInt()){
                retourMenu = scan1.nextInt();
                break;
            }
            else{
                System.out.println("Essaye de pas faire n'importe quoi");
                System.out.println("Si tu veux connaître les règles, tape '1'");
                System.out.println("Pour commencer une partie, tape '2'");
                System.out.println("Pour quitter le jeu, tape '3'");
            }
        }
        while (true){
            Scanner scan1 = new Scanner(System.in);
            if (retourMenu >=1 && retourMenu <=3){
                if (retourMenu == 1){ //Afficher les règles
                    System.out.println("Voilà les règles");
                    break;
                }
                else if (retourMenu == 2){ //Commencer la partie
                    System.out.println("Tu peux jouer");
                }
                else if (retourMenu == 3){ //Quitter le jeu
                    System.exit(1);
                    break;
                }
            }
            else {
                System.out.println("Le nombre est entre 1, 2 et 3");
                retourMenu = scan1.nextInt();
            }

        }


    }

}


