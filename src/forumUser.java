import java.util.ArrayList;
import java.util.List;

class forumUser extends User {

    private String userName;
    private int amountOfPosts;
    private boolean isUserLogged;
    private final String newline = "\n";

    public forumUser(String userFirstName, String userLastName, String userGender, int userAge, String userEmail, String userName, int amountOfPosts, boolean isUserLogged) {

        super(userFirstName, userLastName, userGender, userAge, userEmail);
        this.userName = userName;
        this.amountOfPosts = amountOfPosts;
        this.isUserLogged = isUserLogged;
    }

    public void isUserLogged(String userName) {

        if (userName.equals("Sebczak") && isUserLogged) {
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
        } else {
            System.out.print("Nie zalogowano");
        }
    }

    public List<String> comments = new ArrayList<>();

    public String getUserName() {

        return this.userName;
    }

    public int getAmountOfPosts() {

        return this.amountOfPosts;
    }
}
