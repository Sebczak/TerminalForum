import java.util.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        forumUser forumUser1 = new forumUser("Sebastian", "Łachut", "Men", 25, "sebastianlachut@gmail.com", "Sebczak");
        forumUser forumUser2 = new forumUser("Jan", "Kowalski", "Men", 15, "jk@mail.com","JK");
        List<forumUser> listOfUsers = new ArrayList<>();
        listOfUsers.add(forumUser1);
        listOfUsers.add(forumUser2);
        Menu operation = new Menu();
        System.out.println("Podaj nazwę użytkownika: ");
        Scanner usernameScanner = new Scanner(System.in);
        String usernameToSearch = usernameScanner.nextLine().trim();

        forumUser foundUser = operation.searchUserByUsername(listOfUsers, usernameToSearch);

        if (foundUser != null) {
            operation.performAction(foundUser);
        } else {
            System.out.println("Użytkownik o podanej nazwie nie został znaleziony.");
        }
    }
}