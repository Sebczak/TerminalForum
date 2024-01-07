import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;

public class Menu {
    private boolean innerLoopValue = false;
    private boolean outerLoopValue = false;
    private String newline = "\n";

    public String showMenu() {
        return """
                1. Wyświetl Menu
                2. Dane użytkownika\s
                3. Dodaj komentarz\s
                4. Sprawdź liczbę postów\s
                5. Usuń konto
                6. Wyloguj z aplikacji\s
                ===""";
    }

    public String showRegisterMenu() {
        return """
            Wybierz opcję z Menu Rejestracji:
            1. Rejestracja
            2. Logowanie
            3. Wyjdz z aplikacji
            ===""";
    }

    private List<forumUser> listOfUsers = new ArrayList<>();

    public void performAction(forumUser user) {
        Scanner scanner = new Scanner(System.in);

        while(!outerLoopValue) {
            System.out.println(showRegisterMenu());
            try {
                System.out.print("Wybrano opcje: ");
                int selectLoginOption = scanner.nextInt();
                switch (selectLoginOption) {
                    case 1:
                        listOfUsers.add(user.createUser());
                        for (forumUser listOfUser : listOfUsers) {
                            System.out.println(listOfUser);
                        }
                        break;
                    case 2:

                        System.out.println("Podaj nazwę użytkownika: ");
                        Scanner usernameScanner = new Scanner(System.in);
                        String usernameToSearch = usernameScanner.nextLine().trim();

                        forumUser foundUser = searchUserByUsername(listOfUsers, usernameToSearch);

                        if (foundUser != null) {
                            loggedInActions(foundUser);
                        } else {
                            System.out.println("Użytkownik o podanej nazwie nie został znaleziony.");
                        }
                        break;
                    case 3:
                        System.out.print("Wylaczono aplikacje");
                        outerLoopValue = true;
                        break;
                    default:
                        System.out.print("Wybrałeś niepoprawną opcję." + newline);

                }
            } catch (InputMismatchException e) {
                System.out.print("Wprowadź poprawny numer opcji." + newline);
                scanner.nextLine();

            }
        }
        scanner.close();
    }


    public void loggedInActions(forumUser user) {

        Scanner scanner = new Scanner(System.in);
        if (user.getUserName().equals(user.getUserName())) {
            user.userLogin();
            System.out.print("Wtiaj: " + user.getUserName() + newline);
            System.out.println(showMenu());

            while (!innerLoopValue) {
                try {
                    System.out.print("Wybierz opcję z Menu: ");
                    int selectLoggedOption = scanner.nextInt();

                    switch (selectLoggedOption) {
                        case 1:
                            System.out.println(showMenu());
                            break;
                        case 2:
                            user.userData();
                            break;
                        case 3:
                            System.out.print("Dodaj komentarz: ");
                            scanner.nextLine();
                            String comment = scanner.nextLine();

                            user.comments.add(comment);

                            System.out.print("Komentarze: " + user.comments + newline);
                            break;
                        case 4:
                            System.out.print("Liczba postów użytkownika jest równa: " + user.getAmountOfPosts() + newline);
                            break;
                        case 5:
                            System.out.print("Podaj imię: ");
                            String firstName = scanner.next();
                            System.out.print("Podaj nazwisko: ");
                            String lastName = scanner.next();
                            System.out.print("Podaj adres email: ");
                            String email = scanner.next();

                            user.deleteUserAccount(firstName, lastName, email);
                            break;
                        case 6:
                            innerLoopValue = true;
                            user.userLogin();
                            System.out.print("Wylogowano z aplikacji" + newline);
                            break;
                        default:
                            System.out.print("Wybrałeś niepoprawną opcję." + newline);
                    }
                } catch (InputMismatchException e) {
                    System.out.print("Wprowadź poprawny numer opcji." + newline);
                    scanner.nextLine();
                }
            }
            innerLoopValue = false;
        } else {
            System.out.print("Zły login");
        }
    }
    public forumUser searchUserByUsername(List<forumUser> listOfUsers, String usernameToSearch) {
        for (forumUser user : listOfUsers) {
            if (user.getUserName().equals(usernameToSearch)) {
                return user;
            }
        }
        return null; // Return null if the user is not found
    }
}
