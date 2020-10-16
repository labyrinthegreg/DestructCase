package com.company;

import java.util.*;

public class FonctionsDestructCase {
    public static class VariablesGlobales {

        // Déclaration de toutes les variables golbales
        public static String[][] plateau = new String[10][11];
        public static String joueur1;
        public static String joueur2;
        public static String pseudoJ1;
        public static String pseudoJ2;
        public static int ordonneJ1 = 5;
        public static int abscisseJ1 = 4;
        public static int ordonneJ2 = 5;
        public static int abscisseJ2 = 5;
        public static String symboleJoueur1 = "🅰️";
        public static String symboleJoueur2 = "🅱️";
        public static String symboleCaseDetruite = "❎";
        public static char ouVeuxTuTeDeplacer;
        public static String croix = "❎";
        public static String vainqueur;

    }

    public static ArrayList<Integer> placeX = new ArrayList<Integer>();

    /**
     * Fonction pour afficher les règles du jeu depuis le menu
     */

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

    /**
     * Fonction pour afficher le menu du jeu lorsqu'on le lance
     */

    public static void afficherMenu() {
        // Présentation du menu
        System.out.println("Si tu veux connaître les règles, tape '1'");
        System.out.println("Pour commencer une partie, tape '2'");
        System.out.println("Pour quitter le jeu, tape '3'");
        // Déclaration des varaibles
        int retourMenu;
        // Phase de vérification si c'est bien un nombre entier
        while (true) {
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
        // Vérification si c'est bien un nombre entier entre 1 et 3
        while (true) {
            Scanner scan1 = new Scanner(System.in);
            if (retourMenu >= 1 && retourMenu <= 3) {
                //Afficher les règles
                if (retourMenu == 1) {
                    afficherRegles();
                    break;
                }
                //Commencer la partie
                else if (retourMenu == 2) {
                    System.out.println("Tu peux jouer");
                    break;
                }
                //Quitter le jeu
                else if (retourMenu == 3) {
                    System.out.println("Au revoir");
                    System.exit(1);
                }
            } else {
                System.out.println("Le nombre est entre 1, 2 et 3");
                retourMenu = scan1.nextInt();
            }

        }


    }

    /**
     * Fonction qui demande son pseudo au joueur1
     * @return enregistre le pseudo1 et l'attribue au joueur1
     */

    public static String demandePseudo1() {
        // Affichage de la demande de pseudo
        System.out.println("Tu es le premier joueur. Donne-moi le pseudo de ton joueur(pas que des nombres)");
        // Vérification si il est approprié
        while (true) {
            Scanner pseudoScan = new Scanner(System.in);
            if (pseudoScan.hasNextInt()) {
                System.out.println("Fais-moi quelquechose de cohérent s'il te plaît");
            } else {
                FonctionsDestructCase.VariablesGlobales.pseudoJ1 = pseudoScan.next();
                break;
            }
        }
        return (FonctionsDestructCase.VariablesGlobales.pseudoJ1);
    }

    /**
     * Fonction qui demande son pseudo au joueur2
     * @return enregistre le pseudo 2 et l'attribue au joueur2
     */

    public static String demandePseudo2() {
        // Affichage de la demande de pseudo
        System.out.println("Tu es le second joueur. Donne-moi le pseudo de ton joueur(pas que des nombres)");
        // Vérification si il est approprié
        while (true) {
            Scanner pseudoScan = new Scanner(System.in);
            if (pseudoScan.hasNextInt()) {
                System.out.println("Fais-moi quelquechose de cohérent s'il te plaît");
            } else {
                FonctionsDestructCase.VariablesGlobales.pseudoJ2 = pseudoScan.next();
                break;
            }
        }
        return (FonctionsDestructCase.VariablesGlobales.pseudoJ2);
    }

    /**
     * Fonction qui choisit aléatoirement qui jouera en premier entre le joueur1 et le joueur2
     * @return le joueur qui jouera en premier
     */

    public static String aleaPremierjoueur() {
        // Création d'une liste avec les pseudos des joueurs
        List<String> joueurs = Arrays.asList(FonctionsDestructCase.VariablesGlobales.pseudoJ1, FonctionsDestructCase.VariablesGlobales.pseudoJ2);
        Random rand = new Random();
        int tailleListe = rand.nextInt(joueurs.size());// Choix index aléatoire dans la liste
        String joueur1 = joueurs.get(tailleListe);// Récupération de la valeur de la index pris
        return joueur1;
    }

    /**
     * Fonction qui gère les déplacements du joueur1
     */

    public static void deplacerJoueur1() {
        Scanner scan = new Scanner(System.in);
        System.out.println("C'est à " + FonctionsDestructCase.VariablesGlobales.joueur1);
        //Le joueur1 bouge
        System.out.println(" Ou voulez-vous vous déplacez ? (z q s d)");
        Scanner scanDeplacement = new Scanner(System.in);
        FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement.next().charAt(0);
        // Vérification de ce qui est écrit
        while (true) {
            if (FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer != 'z' && FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer != 'q' && FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer != 'd' && FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer != 's') {
                System.out.println("T'as que 4 choix");
                FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement.next().charAt(0);
            } else {
                break;
            }
        }
        // Vérification collision
        while (true) {
            if (FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer == 'z' && FonctionsDestructCase.VariablesGlobales.abscisseJ1 > 0) {
                // Déplacement vers le haut
                FonctionsDestructCase.VariablesGlobales.abscisseJ1--;
                if (FonctionsDestructCase.VariablesGlobales.abscisseJ1 == FonctionsDestructCase.VariablesGlobales.abscisseJ2 && FonctionsDestructCase.VariablesGlobales.ordonneJ1 == FonctionsDestructCase.VariablesGlobales.ordonneJ2) {
                    System.out.println("Vous ne pouvez pas vous faire du rentre-dedans comme ça");
                    FonctionsDestructCase.VariablesGlobales.abscisseJ1++;
                    FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement.next().charAt(0);
                } else if (VariablesGlobales.plateau[VariablesGlobales.abscisseJ1][VariablesGlobales.ordonneJ1].equals(VariablesGlobales.croix)) {
                    System.out.println("Cette case est détruite tu ne peux pas y aller");
                    FonctionsDestructCase.VariablesGlobales.abscisseJ1++;
                    FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement.next().charAt(0);
                } else {
                    break;
                }

            } else if (FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer == 'q' && FonctionsDestructCase.VariablesGlobales.ordonneJ1 > 0) {
                // Déplacement vers la gauche
                FonctionsDestructCase.VariablesGlobales.ordonneJ1--;
                if (FonctionsDestructCase.VariablesGlobales.ordonneJ1 == FonctionsDestructCase.VariablesGlobales.ordonneJ2 && FonctionsDestructCase.VariablesGlobales.abscisseJ1 == FonctionsDestructCase.VariablesGlobales.abscisseJ2) {
                    System.out.println("Vous ne pouvez pas vous faire du rentre-dedans comme ça");
                    FonctionsDestructCase.VariablesGlobales.ordonneJ1++;
                    FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement.next().charAt(0);
                } else if (VariablesGlobales.plateau[VariablesGlobales.abscisseJ1][VariablesGlobales.ordonneJ1].equals(VariablesGlobales.croix)) {
                    System.out.println("Cette case est détruite tu ne peux pas y aller");
                    VariablesGlobales.ordonneJ1++;
                    FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement.next().charAt(0);
                } else {
                    break;
                }
            } else if (FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer == 's' && FonctionsDestructCase.VariablesGlobales.abscisseJ1 < 10) {
                // Déplacement vers le bas
                FonctionsDestructCase.VariablesGlobales.abscisseJ1++;
                if (FonctionsDestructCase.VariablesGlobales.abscisseJ1 == FonctionsDestructCase.VariablesGlobales.abscisseJ2 && FonctionsDestructCase.VariablesGlobales.ordonneJ1 == FonctionsDestructCase.VariablesGlobales.ordonneJ2) {
                    System.out.println("Vous ne pouvez pas vous faire du rentre-dedans comme ça");
                    FonctionsDestructCase.VariablesGlobales.abscisseJ1--;
                    FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement.next().charAt(0);
                } else if (VariablesGlobales.plateau[VariablesGlobales.abscisseJ1][VariablesGlobales.ordonneJ1].equals(VariablesGlobales.croix)) {
                    System.out.println("Cette case est détruite tu ne peux pas y aller");
                    FonctionsDestructCase.VariablesGlobales.abscisseJ1--;
                    FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement.next().charAt(0);
                } else {
                    break;
                }

            } else if (FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer == 'd' && FonctionsDestructCase.VariablesGlobales.ordonneJ1 < 11) {
                // Déplacement vers la droite
                FonctionsDestructCase.VariablesGlobales.ordonneJ1++;
                if (FonctionsDestructCase.VariablesGlobales.ordonneJ1 == FonctionsDestructCase.VariablesGlobales.ordonneJ2 && FonctionsDestructCase.VariablesGlobales.abscisseJ1 == FonctionsDestructCase.VariablesGlobales.abscisseJ2) {
                    System.out.println("Vous ne pouvez pas vous faire du rentre-dedans comme ça");
                    FonctionsDestructCase.VariablesGlobales.ordonneJ1--;
                    FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement.next().charAt(0);
                } else if (VariablesGlobales.plateau[VariablesGlobales.abscisseJ1][VariablesGlobales.ordonneJ1].equals(VariablesGlobales.croix)) {
                    System.out.println("Cette case est détruite tu ne peux pas y aller");
                    VariablesGlobales.ordonneJ1--;
                    FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement.next().charAt(0);
                } else {
                    break;
                }
            } else {
                System.out.println("Vous ne pouvez pas sortir des limites");
                FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scan.next().charAt(0);
            }
        }
    }

    /**
     * Fonction qui gère les déplacements du joueur2
     */

    public static void deplacerJoueur2() {
        Scanner scanDeplacement2 = new Scanner(System.in);
        System.out.println("C'est à " + FonctionsDestructCase.VariablesGlobales.joueur2);
        System.out.println(" Ou voulez-vous vous déplacez ? (z q s d)");
        FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement2.next().charAt(0);
        // Vérification de ce qui est écrit
        while (true) {
            if (FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer != 'z' && FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer != 'q' && FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer != 'd' && FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer != 's') {
                System.out.println("T'as que 4 choix");
                FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement2.next().charAt(0);
            } else {
                break;
            }
        }
        // Vérification collision
        while (true) {
            if (FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer == 'z' && FonctionsDestructCase.VariablesGlobales.abscisseJ2 > 0) {
                // Déplacement vers le haut
                FonctionsDestructCase.VariablesGlobales.abscisseJ2--;
                if (FonctionsDestructCase.VariablesGlobales.ordonneJ1 == FonctionsDestructCase.VariablesGlobales.ordonneJ2 && FonctionsDestructCase.VariablesGlobales.abscisseJ1 == FonctionsDestructCase.VariablesGlobales.abscisseJ2) {
                    System.out.println("Vous ne pouvez pas vous faire du rentre-dedans comme ça");
                    FonctionsDestructCase.VariablesGlobales.abscisseJ2++;
                    FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement2.next().charAt(0);
                } else if (VariablesGlobales.plateau[VariablesGlobales.abscisseJ2][VariablesGlobales.ordonneJ2].equals(VariablesGlobales.croix)) {
                    System.out.println("Cette case est détruite tu ne peux pas y aller");
                    VariablesGlobales.abscisseJ2++;
                    FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement2.next().charAt(0);
                } else {
                    break;
                }
            } else if (FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer == 'q' && FonctionsDestructCase.VariablesGlobales.ordonneJ2 > 0) {
                // Déplacement vers la gauche
                FonctionsDestructCase.VariablesGlobales.ordonneJ2--;
                if (FonctionsDestructCase.VariablesGlobales.ordonneJ1 == FonctionsDestructCase.VariablesGlobales.ordonneJ2 && FonctionsDestructCase.VariablesGlobales.abscisseJ1 == FonctionsDestructCase.VariablesGlobales.abscisseJ2) {
                    System.out.println("Vous ne pouvez pas vous faire du rentre-dedans comme ça");
                    FonctionsDestructCase.VariablesGlobales.ordonneJ2++;
                    FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement2.next().charAt(0);
                } else if (VariablesGlobales.plateau[VariablesGlobales.abscisseJ2][VariablesGlobales.ordonneJ2].equals(VariablesGlobales.croix)) {
                    System.out.println("Cette case est détruite tu ne peux pas y aller");
                    VariablesGlobales.ordonneJ2++;
                    FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement2.next().charAt(0);
                } else {
                    break;
                }
            } else if (FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer == 's' && FonctionsDestructCase.VariablesGlobales.abscisseJ2 < 10) {
                // Déplacement vers le bas
                FonctionsDestructCase.VariablesGlobales.abscisseJ2++;
                if (FonctionsDestructCase.VariablesGlobales.ordonneJ1 == FonctionsDestructCase.VariablesGlobales.ordonneJ2 && FonctionsDestructCase.VariablesGlobales.abscisseJ1 == FonctionsDestructCase.VariablesGlobales.abscisseJ2) {
                    System.out.println("Vous ne pouvez pas vous faire du rentre-dedans comme ça");
                    FonctionsDestructCase.VariablesGlobales.abscisseJ2--;
                    FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement2.next().charAt(0);
                } else if (VariablesGlobales.plateau[VariablesGlobales.abscisseJ2][VariablesGlobales.ordonneJ2].equals(VariablesGlobales.croix)) {
                    System.out.println("Cette case est détruite tu ne peux pas y aller");
                    VariablesGlobales.abscisseJ2--;
                    FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement2.next().charAt(0);
                } else {
                    break;
                }
            } else if (FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer == 'd' && FonctionsDestructCase.VariablesGlobales.ordonneJ2 < 11) {
                // Déplacement vers la droite
                FonctionsDestructCase.VariablesGlobales.ordonneJ2++;
                if (FonctionsDestructCase.VariablesGlobales.ordonneJ1 == FonctionsDestructCase.VariablesGlobales.ordonneJ2 && FonctionsDestructCase.VariablesGlobales.abscisseJ1 == FonctionsDestructCase.VariablesGlobales.abscisseJ2) {
                    System.out.println("Vous ne pouvez pas vous faire du rentre-dedans comme ça");
                    FonctionsDestructCase.VariablesGlobales.ordonneJ2--;
                    FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement2.next().charAt(0);
                } else if (VariablesGlobales.plateau[VariablesGlobales.abscisseJ2][VariablesGlobales.ordonneJ2].equals(VariablesGlobales.croix)) {
                    System.out.println("Cette case est détruite tu ne peux pas y aller");
                    VariablesGlobales.ordonneJ2++;
                    FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement2.next().charAt(0);
                } else {
                    break;
                }
            } else {
                System.out.println("Vous ne pouvez pas sortir des limites");
                FonctionsDestructCase.VariablesGlobales.ouVeuxTuTeDeplacer = scanDeplacement2.next().charAt(0);
            }
        }
    }

    /**
     * Fonction qui sert à afficher et remplir le plateau de jeu
     */

    public static void remplirCaseDepart() {
        int numéroCase = 0;
        for (int abcisse = 0; abcisse < 10; abcisse++) {
            System.out.println();
            System.out.print(" | ");
            for (int ordonne = 0; ordonne < 11; ordonne++) {
                // Numéro pour chaque case
                numéroCase++;
                FonctionsDestructCase.VariablesGlobales.plateau[abcisse][ordonne] = String.valueOf(numéroCase);
                if (placeX.contains(numéroCase)) {
                    FonctionsDestructCase.VariablesGlobales.plateau[abcisse][ordonne] = VariablesGlobales.symboleCaseDetruite;
                }
                FonctionsDestructCase.VariablesGlobales.plateau[FonctionsDestructCase.VariablesGlobales.abscisseJ1][FonctionsDestructCase.VariablesGlobales.ordonneJ1] = FonctionsDestructCase.VariablesGlobales.symboleJoueur1;
                FonctionsDestructCase.VariablesGlobales.plateau[FonctionsDestructCase.VariablesGlobales.abscisseJ2][FonctionsDestructCase.VariablesGlobales.ordonneJ2] = FonctionsDestructCase.VariablesGlobales.symboleJoueur2;
                System.out.print(FonctionsDestructCase.VariablesGlobales.plateau[abcisse][ordonne] + " | ");
            }
            System.out.println();
        }
    }

    /**
     * Fonction qui sert à afficher le menu au cours de la partie au cas ou un joueur voudrait relir les règles du jeu ou abandonner
     */

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

    /**
     * Fonction qui sert à détruire la case voulue a la fin du tour du joueur
     * @param plateau
     * @param place
     */

    static public void detruireCase(String[][] plateau, int place) {
        placeX.add(place);

        switch (place) {
            case 1:
                plateau[0][0] = VariablesGlobales.croix;
                break;
            case 2:
                plateau[0][1] = VariablesGlobales.croix;
                break;
            case 3:
                plateau[0][2] = VariablesGlobales.croix;
                break;
            case 4:
                plateau[0][3] = VariablesGlobales.croix;
                break;
            case 5:
                plateau[0][4] = VariablesGlobales.croix;
                break;
            case 6:
                plateau[0][5] = VariablesGlobales.croix;
                break;
            case 7:
                plateau[0][6] = VariablesGlobales.croix;
                break;
            case 8:
                plateau[0][7] = VariablesGlobales.croix;
                break;
            case 9:
                plateau[0][8] = VariablesGlobales.croix;
                break;
            case 10:
                plateau[0][9] = VariablesGlobales.croix;
                break;
            case 11:
                plateau[0][10] = VariablesGlobales.croix;
                break;
            case 12:
                plateau[1][0] = VariablesGlobales.croix;
                break;
            case 13:
                plateau[1][1] = VariablesGlobales.croix;
                break;
            case 14:
                plateau[1][2] = VariablesGlobales.croix;
                break;
            case 15:
                plateau[1][3] = VariablesGlobales.croix;
                break;
            case 16:
                plateau[1][4] = VariablesGlobales.croix;
                break;
            case 17:
                plateau[1][5] = VariablesGlobales.croix;
                break;
            case 18:
                plateau[1][6] = VariablesGlobales.croix;
                break;
            case 19:
                plateau[1][7] = VariablesGlobales.croix;
                break;
            case 20:
                plateau[1][8] = VariablesGlobales.croix;
                break;
            case 21:
                plateau[1][9] = VariablesGlobales.croix;
                break;
            case 22:
                plateau[1][10] = VariablesGlobales.croix;
                break;
            case 23:
                plateau[2][0] = VariablesGlobales.croix;
                break;
            case 24:
                plateau[2][1] = VariablesGlobales.croix;
                break;
            case 25:
                plateau[2][2] = VariablesGlobales.croix;
                break;
            case 26:
                plateau[2][3] = VariablesGlobales.croix;
                break;
            case 27:
                plateau[2][4] = VariablesGlobales.croix;
                break;
            case 28:
                plateau[2][5] = VariablesGlobales.croix;
                break;
            case 29:
                plateau[2][6] = VariablesGlobales.croix;
                break;
            case 30:
                plateau[2][7] = VariablesGlobales.croix;
                break;
            case 31:
                plateau[2][8] = VariablesGlobales.croix;
                break;
            case 32:
                plateau[2][9] = VariablesGlobales.croix;
                break;
            case 33:
                plateau[2][10] = VariablesGlobales.croix;
                break;
            case 34:
                plateau[3][0] = VariablesGlobales.croix;
                break;
            case 35:
                plateau[3][1] = VariablesGlobales.croix;
                break;
            case 36:
                plateau[3][2] = VariablesGlobales.croix;
                break;
            case 37:
                plateau[3][3] = VariablesGlobales.croix;
                break;
            case 38:
                plateau[3][4] = VariablesGlobales.croix;
                break;
            case 39:
                plateau[3][5] = VariablesGlobales.croix;
                break;
            case 40:
                plateau[3][6] = VariablesGlobales.croix;
                break;
            case 41:
                plateau[3][7] = VariablesGlobales.croix;
                break;
            case 42:
                plateau[3][8] = VariablesGlobales.croix;
                break;
            case 43:
                plateau[3][9] = VariablesGlobales.croix;
                break;
            case 44:
                plateau[3][10] = VariablesGlobales.croix;
                break;
            case 45:
                plateau[4][0] = VariablesGlobales.croix;
                break;
            case 46:
                plateau[4][1] = VariablesGlobales.croix;
                break;
            case 47:
                plateau[4][2] = VariablesGlobales.croix;
                break;
            case 48:
                plateau[4][3] = VariablesGlobales.croix;
                break;
            case 49:
                plateau[4][4] = VariablesGlobales.croix;
                break;
            case 50:
                plateau[4][5] = VariablesGlobales.croix;
                break;
            case 51:
                plateau[4][6] = VariablesGlobales.croix;
                break;
            case 52:
                plateau[4][7] = VariablesGlobales.croix;
                break;
            case 53:
                plateau[4][8] = VariablesGlobales.croix;
                break;
            case 54:
                plateau[4][9] = VariablesGlobales.croix;
                break;
            case 55:
                plateau[4][10] = VariablesGlobales.croix;
                break;
            case 56:
                plateau[5][0] = VariablesGlobales.croix;
                break;
            case 57:
                plateau[5][1] = VariablesGlobales.croix;
                break;
            case 58:
                plateau[5][2] = VariablesGlobales.croix;
                break;
            case 59:
                plateau[5][3] = VariablesGlobales.croix;
                break;
            case 60:
                plateau[5][4] = VariablesGlobales.croix;
                break;
            case 61:
                plateau[5][5] = VariablesGlobales.croix;
                break;
            case 62:
                plateau[5][6] = VariablesGlobales.croix;
                break;
            case 63:
                plateau[5][7] = VariablesGlobales.croix;
                break;
            case 64:
                plateau[5][8] = VariablesGlobales.croix;
                break;
            case 65:
                plateau[5][9] = VariablesGlobales.croix;
                break;
            case 66:
                plateau[5][10] = VariablesGlobales.croix;
                break;
            case 67:
                plateau[6][0] = VariablesGlobales.croix;
                break;
            case 68:
                plateau[6][1] = VariablesGlobales.croix;
                break;
            case 69:
                plateau[6][2] = VariablesGlobales.croix;
                break;
            case 70:
                plateau[6][3] = VariablesGlobales.croix;
                break;
            case 71:
                plateau[6][4] = VariablesGlobales.croix;
                break;
            case 72:
                plateau[6][5] = VariablesGlobales.croix;
                break;
            case 73:
                plateau[6][6] = VariablesGlobales.croix;
                break;
            case 74:
                plateau[6][7] = VariablesGlobales.croix;
                break;
            case 75:
                plateau[6][8] = VariablesGlobales.croix;
                break;
            case 76:
                plateau[6][9] = VariablesGlobales.croix;
                break;
            case 77:
                plateau[6][10] = VariablesGlobales.croix;
                break;
            case 78:
                plateau[7][0] = VariablesGlobales.croix;
                break;
            case 79:
                plateau[7][1] = VariablesGlobales.croix;
                break;
            case 80:
                plateau[7][2] = VariablesGlobales.croix;
                break;
            case 81:
                plateau[7][3] = VariablesGlobales.croix;
                break;
            case 82:
                plateau[7][4] = VariablesGlobales.croix;
                break;
            case 83:
                plateau[7][5] = VariablesGlobales.croix;
                break;
            case 84:
                plateau[7][6] = VariablesGlobales.croix;
                break;
            case 85:
                plateau[7][7] = VariablesGlobales.croix;
                break;
            case 86:
                plateau[7][8] = VariablesGlobales.croix;
                break;
            case 87:
                plateau[7][9] = VariablesGlobales.croix;
                break;
            case 88:
                plateau[7][10] = VariablesGlobales.croix;
                break;
            case 89:
                plateau[8][0] = VariablesGlobales.croix;
                break;
            case 90:
                plateau[8][1] = VariablesGlobales.croix;
                break;
            case 91:
                plateau[8][2] = VariablesGlobales.croix;
                break;
            case 92:
                plateau[8][3] = VariablesGlobales.croix;
                break;
            case 93:
                plateau[8][4] = VariablesGlobales.croix;
                break;
            case 94:
                plateau[8][5] = VariablesGlobales.croix;
                break;
            case 95:
                plateau[8][6] = VariablesGlobales.croix;
                break;
            case 96:
                plateau[8][7] = VariablesGlobales.croix;
                break;
            case 97:
                plateau[8][8] = VariablesGlobales.croix;
                break;
            case 98:
                plateau[8][9] = VariablesGlobales.croix;
                break;
            case 99:
                plateau[8][10] = VariablesGlobales.croix;
                break;
            case 100:
                plateau[9][0] = VariablesGlobales.croix;
                break;
            case 101:
                plateau[9][1] = VariablesGlobales.croix;
                break;
            case 102:
                plateau[9][2] = VariablesGlobales.croix;
                break;
            case 103:
                plateau[9][3] = VariablesGlobales.croix;
                break;
            case 104:
                plateau[9][4] = VariablesGlobales.croix;
                break;
            case 105:
                plateau[9][5] = VariablesGlobales.croix;
                break;
            case 106:
                plateau[9][6] = VariablesGlobales.croix;
                break;
            case 107:
                plateau[9][7] = VariablesGlobales.croix;
                break;
            case 108:
                plateau[9][8] = VariablesGlobales.croix;
                break;
            case 109:
                plateau[9][9] = VariablesGlobales.croix;
                break;
            case 110:
                plateau[9][10] = VariablesGlobales.croix;
                break;
            default:
                break;
        }

    }

    /**
     * Fonction qui sert à savoir si un joueur est bloqué et donc à savoir si un joueur est vainqueur
     */

    public static void verificationPerdant() {
        if (FonctionsDestructCase.VariablesGlobales.plateau[FonctionsDestructCase.VariablesGlobales.abscisseJ1--][FonctionsDestructCase.VariablesGlobales.ordonneJ1].equals(FonctionsDestructCase.VariablesGlobales.croix) && FonctionsDestructCase.VariablesGlobales.plateau[FonctionsDestructCase.VariablesGlobales.abscisseJ1=VariablesGlobales.abscisseJ1+2][FonctionsDestructCase.VariablesGlobales.ordonneJ1].equals(FonctionsDestructCase.VariablesGlobales.croix) && FonctionsDestructCase.VariablesGlobales.plateau[FonctionsDestructCase.VariablesGlobales.abscisseJ1--][FonctionsDestructCase.VariablesGlobales.ordonneJ1--].equals(FonctionsDestructCase.VariablesGlobales.croix) && FonctionsDestructCase.VariablesGlobales.plateau[FonctionsDestructCase.VariablesGlobales.abscisseJ1][FonctionsDestructCase.VariablesGlobales.ordonneJ1=VariablesGlobales.ordonneJ1+2].equals(FonctionsDestructCase.VariablesGlobales.croix)) {
            System.out.println("Il semblerait que " + FonctionsDestructCase.VariablesGlobales.pseudoJ1 + " sois coincé. \n Donc " + FonctionsDestructCase.VariablesGlobales.pseudoJ2 + " est le grand vainqueur");
            FonctionsDestructCase.VariablesGlobales.vainqueur = FonctionsDestructCase.VariablesGlobales.pseudoJ2;
            afficherMenu();
        } else if (FonctionsDestructCase.VariablesGlobales.plateau[FonctionsDestructCase.VariablesGlobales.abscisseJ2--][FonctionsDestructCase.VariablesGlobales.ordonneJ2].equals(FonctionsDestructCase.VariablesGlobales.croix) && FonctionsDestructCase.VariablesGlobales.plateau[FonctionsDestructCase.VariablesGlobales.abscisseJ2=VariablesGlobales.abscisseJ2+2][FonctionsDestructCase.VariablesGlobales.ordonneJ2].equals(FonctionsDestructCase.VariablesGlobales.croix) && FonctionsDestructCase.VariablesGlobales.plateau[FonctionsDestructCase.VariablesGlobales.abscisseJ2--][FonctionsDestructCase.VariablesGlobales.ordonneJ2--].equals(FonctionsDestructCase.VariablesGlobales.croix) && FonctionsDestructCase.VariablesGlobales.plateau[FonctionsDestructCase.VariablesGlobales.abscisseJ2][FonctionsDestructCase.VariablesGlobales.ordonneJ2=VariablesGlobales.ordonneJ2+2].equals(FonctionsDestructCase.VariablesGlobales.croix)) {
            System.out.println("Il semblerait que " + FonctionsDestructCase.VariablesGlobales.pseudoJ2 + " sois coincé. \n Donc " + FonctionsDestructCase.VariablesGlobales.pseudoJ1 + " est le grand vainqueur");
            FonctionsDestructCase.VariablesGlobales.vainqueur = FonctionsDestructCase.VariablesGlobales.pseudoJ1;
            afficherMenu();
        } else {
            VariablesGlobales.abscisseJ1++;
            VariablesGlobales.abscisseJ2++;
        }
    }
    

}