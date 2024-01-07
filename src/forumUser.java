import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class forumUser extends User {

    private String userName;
    private boolean isUserLogged = false;
    private final String newline = "\n";

    public List<String> comments = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public forumUser(String userFirstName, String userLastName, String userGender, int userAge, String userEmail, String userName) {

        super(userFirstName, userLastName, userGender, userAge, userEmail);
        this.userName = userName;
    }

    public forumUser createUser() {
        System.out.print("Podaj imię: ");
        String firstName = scanner.next();
        System.out.print("Podaj nazwisko: ");
        String lastName = scanner.next();
        System.out.print("Podaj swoja plec: ");
        String gender = scanner.next();
        System.out.print("Podaj swoj wiek: ");
        int age = scanner.nextInt();
        System.out.print("Podaj swoj email: ");
        String email = scanner.next();
        System.out.print("Podaj swoj username: ");
        String username = scanner.next();
        return new forumUser(firstName, lastName, gender, age, email,username);
    }

    public void userData() {

        isUserLogged = true;
            System.out.print(
                    "Zalogowano użytkownika " + getUserName() + newline
                            + "Nazwa użytkownika: " + getUserName() + newline
                            + "Dane podstawowe: " + newline + getUserFirstName()
                            + " " + getUserLastName() + newline
                            + "Płeć: " + getUserGender() + newline
                            + "Wiek: " + getUserAge() + newline
                            + "Adres Email: " + getUserEmail() + newline
                            + "Ilość postów na platformie: " + comments.size() + newline
            );
        }

        public void userLogin() {
            if(!isUserLogged) {
                isUserLogged = true;
            } else {
                isUserLogged = false;
            }
        }

        @Override
        public String toString() {
            return
                    "Stworzono użytkownika " + getUserName() + newline
                            + "Nazwa użytkownika: " + getUserName() + newline
                            + "Dane podstawowe: " + newline + getUserFirstName()
                            + " " + getUserLastName() + newline
                            + "Płeć: " + getUserGender() + newline
                            + "Wiek: " + getUserAge() + newline
                            + "Adres Email: " + getUserEmail() + newline
                            + "Ilość postów na platformie: " + comments.size() + newline;
        }


    public String getUserName() {

        return this.userName;
    }

    public int getAmountOfPosts() {

        return this.comments.size();
    }
}
