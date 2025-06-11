
/**
 * Cette classe assure la gestion du fonctionnement d'une petite distributrice 
 * de café payante. 
 * Affiche un menu avec 4 options (commander un café, remplir la distributrice, 
 * afficher l’état, quitter) et lit le choix de l’utilisateur via Clavier.lireCharLn().
 * On peut voir au début du code l'Utilisation de constantes public static final pour les quantités maximales
 * J'ai implémenté une boucle do...while pour pour maintenir le menu actif jusqu’à la sélection de l’option « Quitter ».
 * Les entrées sont validées pour accepter uniquement ‘1’, ‘2’, ‘3’, ou ‘4’, avec un message d’erreur pour les choix invalides.
 * 
 * @author ABDOULAYE SANGARE 
 * @version 09-JUN-2025
 */
public class Distributricecafe {
    //Les quantités maximales 
    public final static int QUANTITE_MAX_COLOMBIEN = 10;
    public final static int QUANTITE_MAX_MAISON = 10; 
    public final static int QUANTITE_MAX_FRANCAIS = 10; 
    public final static int QUANTITE_MAX_LAIT = 15;
    public final static int QUANTITE_MAX_SUCRE = 5;
    public final static int QUANTITE_MAX_VERRES = 3; 
    public static final int NBR_MAX_25 = 6;
    public final static int NBR_MAX_10 = 10;
    public final static int NBR_MAX_5  = 10; 

    //Les quantités nécessaires 
    public final static int QUANTITE_CAFE_NECESSAIRE = 7;
    public final static int QUANTITE_LAIT_NECESSAIRE = 12;
    public final static int QUANTITE_SUCRE_NECESSAIRE = 5;
    public final static int QUANTITE_VERRE_NECESSAIRE = 1; 

    //Les prix de base 
    public final static double PRIX_BASE_CAFE = 1.00;
    public final static double PRIX_BASE_LAIT = 0.10;
    public final static double PRIX_BASE_SUCRE = 0.05;

    public static void main (String [] params) { 
        int cafeColombien = QUANTITE_MAX_COLOMBIEN;
        int cafeMaison = QUANTITE_MAX_MAISON;
        int cafeFrancais = QUANTITE_MAX_FRANCAIS;
        int quantiteLait = QUANTITE_MAX_LAIT;
        int quantiteSucre = QUANTITE_MAX_SUCRE;
        int quantiteVerre = QUANTITE_MAX_VERRES; 
        int nombre25Cents = NBR_MAX_25;
        int nombre10Cents = NBR_MAX_10;
        int nombre5Cents = NBR_MAX_5;

        char choixMenu =' ';
        //Boucle principale 
        do{ 
            System.out.println("DISTRIBUTRICE DE CAFE");
            System.out.println();
            System.out.println("----");
            System.out.println("MENU");
            System.out.println("----");
            System.out.println();
            System.out.println("1.Commander un café");
            System.out.println("2.Remplir la distributrice");
            System.out.println("3.Afficher l'état de la distributrice");
            System.out.println("4.Quitter");
            System.out.println();
            System.out.println("Entrez votre choix au Menu : "); 

            choixMenu = Clavier.lireCharLn(); 
            //Commander un café 
            /**
             * Cette première option permet de choisir une sorte de café disponible, d’ajouter ou non du sucre/lait,
             * de payer avec des pièces (2$, 1$, 25¢, 10¢, 5¢), et de rendre la monnaie (25¢, 10¢, 5¢) si nécessaire.
             * J’ai utilisé Character.toUpperCase() pour simplifier la validation des caractères et 
             * et printf pour un affichage formaté du prix (2 décimales).
             */
            if (choixMenu == '1') { 
                //Lorsque la distributrice est hors service 
                if (cafeColombien < QUANTITE_CAFE_NECESSAIRE || cafeMaison < QUANTITE_CAFE_NECESSAIRE || cafeFrancais < QUANTITE_CAFE_NECESSAIRE
                || quantiteSucre < QUANTITE_SUCRE_NECESSAIRE || quantiteLait < QUANTITE_LAIT_NECESSAIRE || quantiteVerre < QUANTITE_VERRE_NECESSAIRE) {
                    System.out.println("*** Distributrice hors service ! ***");
                    System.out.println();
                    System.out.println("Appuyez sur <ENTREE> pour continuer...");
                    Clavier.lireCharLn();
                } 
                // Les sortes de café disponible      
                System.out.println("SORTES DE CAFE :");
                System.out.println();
                if (cafeColombien >= QUANTITE_CAFE_NECESSAIRE) {
                    System.out.println("(C)olombien");
                }
                if (cafeMaison >= QUANTITE_CAFE_NECESSAIRE) {
                    System.out.println("(M)aison");
                }
                if (cafeFrancais >= QUANTITE_CAFE_NECESSAIRE) {
                    System.out.println("(F)rancais");
                } 

                System.out.println();
                System.out.println("Selectionnez votre sorte de cafe :"); 
                char sorteCafe = Clavier.lireCharLn();
                sorteCafe = Character.toUpperCase(sorteCafe);
                boolean sorteValide = false;
                while (!sorteValide) {
                    if ( sorteCafe == 'C' && cafeColombien >= QUANTITE_CAFE_NECESSAIRE) {
                        System.out.println("Vous avez choisi le café Colombien ");
                        sorteValide = true;
                    } else if ( sorteCafe == 'M' && cafeMaison >= QUANTITE_CAFE_NECESSAIRE) {
                        System.out.println("Vous avez choisi le café Maison  ");
                        sorteValide = true;
                    } else if ( sorteCafe == 'F' && cafeFrancais >= QUANTITE_CAFE_NECESSAIRE) {
                        System.out.println("Vous avez choisi le café Français ");
                        sorteValide = true;
                    } else {
                        System.out.println("Choix invalide ! Recommencez...");
                    }
                } 

                char choixDuSucre = ' ';
                boolean choixSucreValide = false;
                while (!choixSucreValide) {
                    System.out.println("Voulez-vous du sucre oui ou non : ");
                    choixDuSucre = Character.toUpperCase(Clavier.lireCharLn());

                    if (choixDuSucre == 'O') {
                        System.out.println("Vous avez choisi : Avec sucre");
                        choixSucreValide = true; 
                    } else if (choixDuSucre == 'N') {
                        System.out.println("Vous avez choisi : Sans sucre");
                        choixSucreValide = true; 
                    } else {
                        System.out.println("Choix invalide, veuillez recommencer!");
                    }
                } 

                char choixLait= ' ';
                boolean choixLaitValide = false;
                while(!choixLaitValide) {
                    System.out.println("Voulez-vous du lait oui ou non : ");
                    choixLait = Character.toUpperCase(Clavier.lireCharLn());
                    if (choixLait == 'O') {
                        System.out.println("Vous avez choisi : Avec du lait");
                        choixLaitValide = true; 
                    } else if (choixLait == 'N') {
                        System.out.println("Vous avez choisi : Sans lait");
                        choixLaitValide = true; 
                    } else {
                        System.out.println("Choix invalide, veuillez recommencer!");
                    }
                } 

                //Calcul du prix du café 
                double prixCafe = PRIX_BASE_CAFE;
                if (choixDuSucre == 'O' ) {
                    prixCafe = prixCafe + PRIX_BASE_SUCRE;
                } 
                if (choixLait == 'O' ) {
                    prixCafe = prixCafe + PRIX_BASE_LAIT;
                } 
                System.out.printf("Prix du café : %.2f$\n" , prixCafe); 

                //Gestion du paiement 
                int montantPaye = 0;
                int prixCafeEnCents = (int) (prixCafe * 100);
                while (montantPaye < prixCafeEnCents) {
                    System.out.println("Entrez une piece de monnaie (2,1,25,10,5) : ");
                    int piece = 0;
                    piece = Clavier.lireIntLn();
                    if (piece == 2 || piece == 1 || piece == 25 || piece == 10 
                    || piece == 5) {
                        if (piece == 2) {
                            montantPaye += 200;
                        } else if (piece == 1) {
                            montantPaye += 100;
                        } else {
                            montantPaye += piece;
                        }
                    } else {
                        System.out.println("Piece invalide, veuillez recommencer!");
                    }
                } 

                //Calcul de la monnaie a rendre 
                int monnaieARendre = montantPaye - prixCafeEnCents;
                int rendu25Cents = 0, rendu10Cents = 0 , rendu5Cents = 0;
                if( monnaieARendre == 0) {
                    System.out.println("Le café est servi!");
                    System.out.println();
                    System.out.println("Appuyez sur <ENTREE> pour continuer...");
                    Clavier.lireCharLn();
                }
                else {
                    int monnaieRestante = monnaieARendre;
                    while (monnaieRestante >= 25 && nombre25Cents > 0) {
                        rendu25Cents++;
                        nombre25Cents--;
                        monnaieRestante -= 25;
                    } 
                    while (monnaieRestante >= 10 && nombre10Cents > 0) {
                        rendu10Cents++;
                        nombre10Cents--;
                        monnaieRestante -= 10;
                    } 
                    while (monnaieRestante >= 5 && nombre5Cents > 0) {
                        rendu5Cents++;
                        nombre5Cents--;
                        monnaieRestante -= 5;
                    } 

                    if (monnaieARendre == 0 ) {
                        System.out.printf("Montant à remettre : %d cents" , monnaieARendre);
                        System.out.println();
                        System.out.println("*" + rendu25Cents + "piece(s) de 25 cents");
                        System.out.println("*" + rendu10Cents + "piece(s) de 10 cents");
                        System.out.println("*" + rendu5Cents + "piece(s) de 5 cents");
                        System.out.println();
                        System.out.println("Le café est servi"); 
                        System.out.println();
                        System.out.println("Appuyez sur <ENTREE> pour continuer..");
                        Clavier.lireCharLn();
                    } else {
                        System.out.println("*** Impossible de remettre la monnaie exacte ! ***");
                        System.out.println("Votre commande a ete annulee.");
                        System.out.println();
                        System.out.println("Appuyez sur <ENTREE> pour continuer...");
                        Clavier.lireCharLn();
                    }
                }
                //Remplir la distributrice 
                /**
                 * Cette option réinitialise toutes les quantités et affiche l'état mis 
                 * à jour de la distributrice 
                 */
            } else if (choixMenu == '2') { 
                cafeColombien = QUANTITE_MAX_COLOMBIEN;
                cafeMaison = QUANTITE_MAX_MAISON;
                cafeFrancais = QUANTITE_MAX_FRANCAIS;
                quantiteLait = QUANTITE_MAX_LAIT;
                quantiteSucre = QUANTITE_MAX_SUCRE;
                quantiteVerre = QUANTITE_MAX_VERRES; 
                nombre25Cents = NBR_MAX_25;
                nombre10Cents = NBR_MAX_10;
                nombre5Cents = NBR_MAX_5; 

                System.out.println("La distributrice contient maintenant : ");
                System.out.println( "- " + cafeColombien + "grammes de café Colombien");
                System.out.println("- " + cafeMaison + "grammes de café Maison");
                System.out.println("- " + cafeFrancais + "grammes de café Français");
                System.out.println("- " + quantiteLait + "grammes de Lait");
                System.out.println("- " + quantiteSucre + "grammes de sucre");
                System.out.println("- " + quantiteVerre + " verres au total");
                System.out.println("- " + nombre25Cents + " pieces de 25 cents");
                System.out.println("- " + nombre10Cents + " pieces de 10 cents");
                System.out.println("- " + nombre5Cents + " pieces de 5 Cents");
                System.out.println();
                System.out.println("Appuyez sur <ENTREE> pour continuer...");
                Clavier.lireChar();
                //Afficher l'état de la distributrice 
                /**
                 * Affiche les quantités actuelles de chaque ressource (café, sucre, lait, verres, pièces). 
                 */
            } else if (choixMenu == '3') {
               
                System.out.println("-------------------------");
                System.out.println();
                System.out.println("ETAT DE LA DISTRIBUTRICE");
                System.out.println();
                System.out.println("-------------------------");
                System.out.println("Café Colombien : " + cafeColombien + "gramme(s)");
                System.out.println("Café Maison : " + cafeMaison + "gramme(s)");
                System.out.println("Café Français : " + cafeFrancais + "gramme(s)");
                System.out.println("Sucre : " + quantiteSucre + "gramme(s)");
                System.out.println("Lait : " + quantiteLait + "gramme(s)");
                System.out.println("Verres : " + quantiteVerre);
                System.out.println("Pieces de 25 Cents : " + nombre25Cents);
                System.out.println("Pieces de 10 Cents : " + nombre10Cents);
                System.out.println("Pieces de 5 Cents : " + nombre5Cents);
                System.out.println();
                System.out.println("Appuyez sur <ENTREE> pour continuer...");
                Clavier.lireCharLn();
                //Quitter 
                /**
                 * Termine le programme avec un message « FIN DU PROGRAMME ». 
                 */
            } else if ( choixMenu == '4' ) {
                System.out.println("FIN DU PROGRAMME");
                break;
            } else {
                System.out.println("Option invalide, veuillez recommencer!");
                Clavier.lireCharLn();
            }
        } while ( choixMenu != '4');
    }

}