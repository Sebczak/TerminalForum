import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        forumUser forumSebastian = new forumUser("Sebastian", "Łachut", "Mężczyna", 25, "sebastianlachut@gmail.com", "Sebczak", 0, true);
        Menu operation = new Menu();
        operation.performAction(forumSebastian);

    }
}