import java.util.ArrayList;
import java.util.List;

class forumUser extends User {

    private String userName;
    private boolean isUserLogged = false;
    private final String newline = "\n";

    public List<String> comments = new ArrayList<>();

    public forumUser(String userFirstName, String userLastName, String userGender, int userAge, String userEmail, String userName) {

        super(userFirstName, userLastName, userGender, userAge, userEmail);
        this.userName = userName;
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


    public String getUserName() {

        return this.userName;
    }

    public int getAmountOfPosts() {

        return this.comments.size();
    }
}
