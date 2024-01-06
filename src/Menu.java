import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;

public class Menu {

    public String showMenu() {
        return """
                1. Wyświetl Menu
                2. Dane użytkownika\s
                3. Dodaj komentarz\s
                4. Sprawdź liczbę postów\s
                5. Usuń konto
                6. Wyjdź z aplikacji\s
                """;
    }

    public void performAction(forumUser user) {
        Scanner scanner = new Scanner(System.in);

        boolean loopValue = false;
        if (user.getUserName().equals(user.getUserName())) {
            user.userLogin();
            System.out.print("Wtiaj: " + user.getUserName() + "\n");
            System.out.print(showMenu());

            while (!loopValue) {
                try {
                    System.out.print("Wybierz opcję z Menu: ");
                    int selectOption = scanner.nextInt();

                    switch (selectOption) {
                        case 1:
                            System.out.print(showMenu());
                            break;
                        case 2:
                            user.userData();
                            break;
                        case 3:
                            System.out.print("Dodaj komentarz: ");
                            scanner.nextLine();
                            String comment = scanner.nextLine();

                            user.comments.add(comment);

                            System.out.print("Komentarze: " + user.comments + "\n");
                            break;
                        case 4:
                            System.out.print("Liczba postów użytkownika jest równa: " + user.getAmountOfPosts() + "\n");
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
                            loopValue = true;
                            user.userLogin();
                            System.out.print("Wylogowano z aplikacji");
                            break;
                        default:
                            System.out.print("Wybrałeś niepoprawną opcję." + "\n");
                    }
                } catch (InputMismatchException e) {
                    System.out.print("Wprowadź poprawny numer opcji.\n");
                    scanner.nextLine();
                }
            }
        } else {
            System.out.print("Zły login");
        }
        scanner.close();
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
