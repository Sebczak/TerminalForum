import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        forumUser forumSebastian = new forumUser("Sebastian", "Łachut", "Mężczyna", 25, "sebastianlachut@gmail.com", "Sebczak", 0, true);
        String menu = """
                1. Wyświetl Menu
                2. Dane użytkownika\s
                3. Dodaj komentarz\s
                4. Sprawdź liczbę postów\s
                5. Usuń konto
                6. Wyjdź z aplikacji\s
                """;

        System.out.print("Podaj nazwę użytkownika: ");
        String userName = scanner.nextLine();
        boolean loopValue = false;
        if (userName.equals("Sebczak")) {
            System.out.print("Wtiaj: " + forumSebastian.getUserName() + "\n");
            System.out.print(menu);
            while (!loopValue) {
                try {
                    System.out.print("Wybierz opcję z Menu: "
                    );
                    int selectOption = scanner.nextInt();
                    switch (selectOption) {
                        case 1:
                            System.out.print(menu);
                            break;
                        case 2:
                            forumSebastian.isUserLogged(userName);
                            break;
                        case 3:
                            System.out.print("Dodaj komentarz: ");
                            scanner.nextLine();
                            String comment = scanner.nextLine();

                            forumSebastian.comments.add(comment);

                            System.out.print("Komentarze: " + forumSebastian.comments + "\n");
                            break;
                        case 4:
                            int commentCount = forumSebastian.comments.size();
                            System.out.print("Liczba postów użytkownika jest równa: " + commentCount + "\n");
                            break;
                        case 5:
                            System.out.print("Podaj imię: ");
                            String firstName = scanner.next();
                            System.out.print("Podaj nazwisko: ");
                            String lastName = scanner.next();
                            System.out.print("Podaj adres email: ");
                            String Email = scanner.next();

                            forumSebastian.deleteUserAccount(firstName, lastName, Email);
                            break;
                        case 6:
                            loopValue = true;
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
}