import java.io.OptionalDataException;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Supprimer un livre");
        System.out.println("3. Modifier un livre par son identifiant");
        System.out.println("4. Rechercher un livre par son nom");
        System.out.println("5. Lister les livres en saisissant une lettre alphabétique");
        System.out.println("6. Afficher le nombre de livres");
        System.out.println("7. Afficher les livres par catégorie");
        System.out.println("8. Afficher les détails d'un livre par son identifiant");
        System.out.println("9. Rechercher un livre par son Identifiant");
        System.out.println("10.Trier les livres par Id");
        int choix = scanner.nextInt();
        switch (choix) {
            case 1:
                BookStorage(scanner);
                break;
            case 2:
                deleteBookTitle(scanner);
                break;
            case 3:
                modifyBookTitle(scanner);
                break;
            case 4:
                searchBookTitle(scanner);
                break;
            case 5:
                listBooksByFirstLetter(scanner);
                break;
            case 6:
                displayBookCount(scanner);
                break;
            case 7:
                displayBooksByCategory(scanner);
                break;
            case 8:
                displayBookDetails(scanner);
                break;
            case 9:
                searchBookTitle(scanner);
                break;
            case 10:
                sortBooksByTitle(scanner);
                break;
        }
    }

    public static void displayBooksByCategory(Scanner scanner) {
        String[] bookTitles = {"Livre 1", "Le Grand Livre", "Livre 3", "Manuel de Programmation", "Livre 5"};
        String[] bookCategories = {"Fiction", "Non-Fiction", "Fiction", "Technique", "Fiction"};
        displayBooksByCategory(bookTitles, bookCategories);
    }

    private static void displayBooksByCategory(String[] bookTitles, String[] bookCategories) {
    }

    public static void BookStorage(Scanner scanner) {
        System.out.println("Combien de livres voulez-vous enregister?");
        int numBooks = scanner.nextInt();
        String[] bookTitles = new String[numBooks];
        System.out.println("Veillez entrer les titres des livres:");
        for (int i = 0; i < numBooks; i++) {
            System.out.print("Livre " + (i + 1) + " : ");
            bookTitles[i] = scanner.nextLine();
        }
        System.out.println("Les livres suivants sont stokés avec succès");
        for (String title : bookTitles) {
            System.out.println("- " + title);
        }
    }
        public static void deleteBookTitle(Scanner scanner) {
        System.out.print("Quel livre voulez-vous supprimer ? ");
        String bookToDelete = scanner.nextLine();

        boolean found = false;
        String[] bookTitles = new String[0];
        for (int i = 0; i < bookTitles.length; i++) {
            if (bookTitles[i].equalsIgnoreCase(bookToDelete)) {
                found = true;
                // Décaler tous les éléments à droite vers la gauche
                for (int j = i; j < bookTitles.length - 1; j++) {
                    bookTitles[j] = bookTitles[j + 1];
                }
                // Réduire la taille du tableau de 1
                bookTitles = Arrays.copyOf(bookTitles, bookTitles.length - 1);
                System.out.println("Le livre '" + bookToDelete + "' a été supprimé.");
                break;
            }
        }

        if (!found) {
            System.out.println("Le livre '" + bookToDelete + "' n'a pas été trouvé dans la liste.");
        }
        deleteBookTitle(scanner);
    }
    public static void modifyBookTitle(Scanner scanner) {
        System.out.print("Quel livre voulez-vous modifier ? ");
        String bookToModify = scanner.nextLine();

        boolean found = false;
        String[] bookTitles = new String[0];
        for (int i = 0; i < bookTitles.length; i++) {
            if (bookTitles[i].equalsIgnoreCase(bookToModify)) {
                found = true;
                System.out.print("Entrez le nouveau titre : ");
                bookTitles[i] = scanner.nextLine();
                System.out.println("Le titre du livre a été modifié avec succès.");
                break;
            }
        }

        if (!found) {
            System.out.println("Le livre '" + bookToModify + "' n'a pas été trouvé dans la liste.");
        }
        modifyBookTitle(scanner);
    }
    public static void searchBookTitle(Scanner scanner) {
        System.out.print("Quel livre voulez-vous rechercher ? ");
        String bookToSearch = scanner.nextLine();

        boolean found = false;
        String[] bookTitles = new String[0];
        for (int i = 0; i < bookTitles.length; i++) {
            if (bookTitles[i].toLowerCase().contains(bookToSearch.toLowerCase())) {
                if (!found) {
                    System.out.println("Livres trouvés :");
                }
                found = true;
                System.out.println("- " + bookTitles[i]);
            }
        }

        if (!found) {
            System.out.println("Aucun livre correspondant n'a été trouvé.");
        }
        searchBookTitle(scanner);
    }

    public static void listBooksByFirstLetter(Scanner scanner) {
        System.out.print("Entrez une lettre pour lister les livres : ");
        char firstLetter = scanner.nextLine().toLowerCase().charAt(0);

        System.out.println("Livres commençant par la lettre '" + firstLetter + "' :");

        boolean found = false;
        String[] bookTitles = new String[0];
        for (String title : bookTitles) {
            if (title.toLowerCase().charAt(0) == firstLetter) {
                System.out.println("- " + title);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Aucun livre ne commence par cette lettre.");
        }
        listBooksByFirstLetter(scanner);
    }
    public static void displayBookCount(Scanner scanner){
        OptionalDataException bookTitles = null;
        int bookCount = bookTitles.length;
        System.out.println("Nombre de livres enregistrés : " + bookCount);
    }
    public static void displayBookDetails(Scanner scanner) {
        int index = -1;
        Object[] bookTitles = new Object[0];
        for (int i = 0; i < bookTitles.length; i++) {
            if (bookTitles[i].equals(bookTitles)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Désolé, aucun livre avec le titre \"" + bookTitles + "\" n'a été trouvé.");
            return;
        }

        System.out.println("Détails du livre:");
        System.out.println("Titre: " + bookTitles[index]);
    }
    public static void sortBooksByTitle(Scanner scanner) {
        // Créer un tableau d'index pour garder la trace des indices d'origine
        Comparable<Object>[] bookTitles = new Comparable[0];
        int[] indices = new int[bookTitles.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        // Trier le tableau d'indices en fonction des titres de livre
        Comparable<Object>[] finalBookTitles = bookTitles;
        Arrays.sort(indices);

        // Réorganiser les tableaux en fonction des indices triés
        String[] sortedBookTitles = new String[bookTitles.length];
        for (int i = 0; i < indices.length; i++) {
            int originalIndex = indices[i];
        }
        // Afficher les livres triés
        System.out.println("Livres triés par ordre alphabétique des titres :");
        for (int i = 0; i < bookTitles.length; i++) {
            System.out.println("Titre: " + bookTitles[i]);
            System.out.println();
        }
    }
}