package com.company;

import java.util.*;

public class FonctionDestructCase {

    public static ArrayList<Integer> placeX = new ArrayList<Integer>();

    public static void afficherRegles() {
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
                    afficherRegles();
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


    public static void remplirCaseDepart(String[][] plateau, int ordonneJ1, int abcisseJ1 , int ordonneJ2, int abcisseJ2){
        int numéroCase = 0;
        for(int abcisse=0;abcisse<10;abcisse++) {
            System.out.println();
            System.out.print(" | ");
            for(int ordonne=0;ordonne<11;ordonne++) {
                // Numéro pour chaque case
                numéroCase++;
                plateau[abcisse][ordonne] = String.valueOf(numéroCase);
                if (placeX.contains(numéroCase)){
                    plateau[abcisse][ordonne]= " X ";
                }

                // La position précise des joueurs A et B
                plateau[abcisseJ1][ordonneJ1] = "A";
                plateau[abcisseJ2][ordonneJ2] = "B";

                System.out.print(plateau[abcisse][ordonne] + " | ");
            }
            System.out.println();
        }
        return;
    }

    public static void afficherMenuEnPartie() {
        // Présentation du menu
        System.out.println("Si tu veux connaître les règles, tape '1'");
        System.out.println("Pour continuer une partie, tape '2'");
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
                System.out.println("Pour continuer une partie, tape '2'");
                System.out.println("Pour quitter le jeu, tape '3'");
            }
        }

        while (true) { // Vérification si c'est bien un nombre entier entre 1 et 3
            Scanner scan1 = new Scanner(System.in);
            if (retourMenu >= 1 && retourMenu <= 3) {
                if (retourMenu == 1) { //Afficher les règles
                    afficherRegles();
                    break;
                } else if (retourMenu == 2) { //Commencer la partie
                    System.out.println("Tu peux continuer à jouer");
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

    static public void detruireCase(String[][] plateau, int place){
        String croix = " X ";
        placeX.add(place);

        switch (place){
            case 1:
                plateau [0][0] = croix;
                break;
            case 2:
                plateau [0][1] = croix;
                break;
            case 3:
                plateau [0][2] = croix;
                break;
            case 4:
                plateau [0][3] = croix;
                break;
            case 5:
                plateau [0][4] = croix;
                break;
            case 6:
                plateau [0][5] = croix;
                break;
            case 7:
                plateau [0][6] = croix;
                break;
            case 8:
                plateau [0][7] = croix;
                break;
            case 9:
                plateau [0][8] = croix;
                break;
            case 10:
                plateau [0][9] = croix;
            break;
            case 11:
                plateau [0][10] = croix;
                break;
            case 12:
                plateau [1][0] = croix;
                break;
            case 13:
                plateau [1][1] = croix;
                break;
            case 14:
                plateau [1][2] = croix;
                break;
            case 15:
                plateau [1][3] = croix;
                break;
            case 16:
                plateau [1][4] = croix;
                break;
            case 17:
                plateau [1][5] = croix;
                break;
            case 18:
                plateau [1][6] = croix;
                break;
            case 19:
                plateau [1][7] = croix;
                break;
            case 20:
                plateau [1][8] = croix;
                break;
            case 21:
                plateau [1][9] = croix;
                break;
            case 22:
                plateau [1][10] = croix;
                break;
            case 23:
                plateau [2][0] = croix;
                break;
            case 24:
                plateau [2][1] = croix;
                break;
            case 25:
                plateau [2][2] = croix;
                break;
            case 26:
                plateau [2][3] = croix;
                break;
            case 27:
                plateau [2][4] = croix;
                break;
            case 28:
                plateau [2][5] = croix;
                break;
            case 29:
                plateau [2][6] = croix;
                break;
            case 30:
                plateau [2][7] = croix;
                break;
            case 31:
                plateau [2][8] = croix;
                break;
            case 32:
                plateau [2][9] = croix;
                break;
            case 33:
                plateau [2][10] = croix;
                break;
            case 34:
                plateau [3][0] = croix;
                break;
            case 35:
                plateau [3][1] = croix;
                break;
            case 36:
                plateau [3][2] = croix;
                break;
            case 37:
                plateau [3][3] = croix;
                break;
            case 38:
                plateau [3][4] = croix;
                break;
            case 39:
                plateau [3][5] = croix;
                break;
            case 40:
                plateau [3][6] = croix;
                break;
            case 41:
                plateau [3][7] = croix;
                break;
            case 42:
                plateau [3][8] = croix;
                break;
            case 43:
                plateau [3][9] = croix;
                break;
            case 44:
                plateau [3][10] = croix;
                break;
            case 45:
                plateau [4][0] = croix;
                break;
            case 46:
                plateau [4][1] = croix;
                break;
            case 47:
                plateau [4][2] = croix;
                break;
            case 48:
                plateau [4][3] = croix;
                break;
            case 49:
                plateau [4][4] = croix;
                break;
            case 50:
                plateau [4][5] = croix;
                break;
            case 51:
                plateau [4][6] = croix;
                break;
            case 52:
                plateau [4][7] = croix;
                break;
            case 53:
                plateau [4][8] = croix;
                break;
            case 54:
                plateau [4][9] = croix;
                break;
            case 55:
                plateau [4][10] = croix;
                break;
            case 56:
                plateau [5][0] = croix;
                break;
            case 57:
                plateau [5][1] = croix;
                break;
            case 59:
                plateau [4][10] = croix;
                break;
            case 58 :
                plateau [6][3] = croix;
                break;
        }

    }
}