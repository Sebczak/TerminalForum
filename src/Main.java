import java.io.IOException;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        forumUser admin = new forumUser();
        Menu operation = new Menu();

        operation.performAction(admin);
    }
}