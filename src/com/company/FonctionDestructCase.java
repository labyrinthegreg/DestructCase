package com.company;

import java.util.*;

public class FonctionDestructCase {

    static ArrayList<Integer> placeX = new ArrayList<Integer>();

    public static void afficherRègles() {
        // Initialisation de la variable regle
        String regles = "Règles du jeu : \n\n" + "Pendant son tour un joueur peut déplacer son pion d’une case (verticalement ou horizontalement), ensuite à la fin de son tour il devra détruire une case du plateau.\n" +
                "Une fois la case détruite plus aucun joueur ne pourra se déplacer dessus\n" +
                "Le but du jeu est d'enfermer ses adversaires pour les empêcher de se déplacer\n" +
                "Le dernier joueur pouvant encore se déplacer gagne.\n" +
                "Attention :\n" +
                "- Un joueur ne peut pas détruire une case qui est actuellement occupée par un autre joueur.\n" +
                "- Un joueur ne peut pas occuper une case détruite ou une case déjà occupée par un autre joueur.\n- Un joueur bloqué pendant un tour est déclaré perdant.";

        // Affichage des règles
        System.out.println(regles);
        // Réaffiche le menu
        afficherMenu();
    }


    public static void afficherMenu() {
        // Présentation du menu
        System.out.println("Si tu veux connaître les règles, tape '1'");
        System.out.println("Pour commencer une partie, tape '2'");
        System.out.println("Pour quitter le jeu, tape '3'");
        // Déclaration des varaibles
        int retourMenu;
        while (true) { // Phase de vérification si c'est bien un nombre entier
            Scanner scan1 = new Scanner(System.in);
            if (scan1.hasNextInt()) {
                retourMenu = scan1.nextInt();
                break;
            } else {
                System.out.println("Essaye de pas faire n'importe quoi");
                System.out.println("Si tu veux connaître les règles, tape '1'");
                System.out.println("Pour commencer une partie, tape '2'");
                System.out.println("Pour quitter le jeu, tape '3'");
            }
        }
        while (true) { // Vérification si c'est bien un nombre entier entre 1 et 3
            Scanner scan1 = new Scanner(System.in);
            if (retourMenu >= 1 && retourMenu <= 3) {
                if (retourMenu == 1) { //Afficher les règles
                    afficherRègles();
                    break;
                } else if (retourMenu == 2) { //Commencer la partie
                    System.out.println("Tu peux jouer");
                    break;
                } else if (retourMenu == 3) { //Quitter le jeu
                    System.out.println("Au revoir");
                    System.exit(1);
                }
            } else {
                System.out.println("Le nombre est entre 1, 2 et 3");
                retourMenu = scan1.nextInt();
            }

        }


    }


    public static String demandePseudo1() {
        // Affichage de la demande de pseudo
        System.out.println("Tu es le premier joueur. Donne-moi le pseudo de ton joueur(pas que des nombres)");
        String pseudoJ1;
        while (true) { // Vérification si il est approprié
            Scanner pseudoScan = new Scanner(System.in);
            if (pseudoScan.hasNextInt()) {
                System.out.println("Fais-moi quelquechose de cohérent s'il te plaît");
            } else {
                pseudoJ1 = pseudoScan.next();
                break;
            }
        }
        return (pseudoJ1);
    }

    public static String demandePseudo2() {
        // Affichage de la demande de pseudo
        System.out.println("Tu es le second joueur. Donne-moi le pseudo de ton joueur(pas que des nombres)");
        String pseudoJ2;
        while (true) { // Vérification si il est approprié
            Scanner pseudoScan = new Scanner(System.in);
            if (pseudoScan.hasNextInt()) {
                System.out.println("Fais-moi quelquechose de cohérent s'il te plaît");
            } else {
                pseudoJ2 = pseudoScan.next();
                break;
            }
        }
        return (pseudoJ2);
    }


    public static String aleaPremierjoueur(String pseudoJ1, String pseudoJ2) {
        // Création d'une liste avec les pseudos des joueurs
        List<String> joueurs = Arrays.asList(pseudoJ1, pseudoJ2);
        Random rand = new Random();
        int tailleListe = rand.nextInt(joueurs.size());// Choix index aléatoire dans la liste
        String joueur1 = joueurs.get(tailleListe);// Récupération de la valeur de la index pris
        return joueur1;
    }

    public static void afficherPlateau(int abscisse, int ordonnée) {
        for (abscisse = 0; abscisse < 11; abscisse++) {
            for (ordonnée = 0; ordonnée < 10; ordonnée++) {
                System.out.print(" | ");
            }
            System.out.println(" | ");
        }
    }

    public static void remplirCaseDepart(String[][] plateau){
        int numéroCase = 0;
        for(int abcisse=0;abcisse<10;abcisse++) {
            System.out.println();
            System.out.print(" | ");
            for(int ordonne=0;ordonne<11;ordonne++) {
                numéroCase++;
                plateau[abcisse][ordonne] = String.valueOf(numéroCase);
                // La position précise des joueurs A et B
                plateau[4][5] = "A";
                plateau[5][5] = "B";
                System.out.print(plateau[abcisse][ordonne] + " | ");
            }
            System.out.println();
        }
    }

    static public void detruireCase(String[][] plateau, int place){
        String croix = " X ";

        switch (place){

        }
    }
}