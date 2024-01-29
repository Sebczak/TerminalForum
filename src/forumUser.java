import java.util.*;

class forumUser extends User {

    private String userName;
    private boolean isUserLogged = false;
    private final String newline = "\n";

    public Set<Post> posts = new LinkedHashSet<>();

    private Scanner scanner = new Scanner(System.in);

    public forumUser() {
        super();
    }

    public forumUser(String userFirstName, String userLastName, int userAge, String userGender, String userEmail, String userName) {

        super(userFirstName, userLastName, userAge, userGender, userEmail);
        this.userName = userName;
    }

    public forumUser createUser() {
        System.out.print("Podaj swoj username: ");
        String username = scanner.next();
        System.out.print("Podaj imię: ");
        String firstName = scanner.next();
        System.out.print("Podaj nazwisko: ");
        String lastName = scanner.next();
        System.out.print("Podaj swoj wiek: ");
        int age = scanner.nextInt();
        System.out.print("Podaj swoja plec: ");
        String gender = scanner.next();
        System.out.print("Podaj swoj email: ");
        String email = scanner.next();
        forumUser newUser = new forumUser(firstName, lastName, age, gender, email, username);
        System.out.println(newUser);
        return newUser;
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
                            + "Ilość postów na platformie: " + posts.size() + newline
            );
        }

        public void userLogin() {
            isUserLogged = !isUserLogged;
        }

    public forumUser searchUserByUsername(List<forumUser> listOfUsers, String usernameToSearch) {
        for (forumUser user : listOfUsers) {
            if (user.getUserName().equals(usernameToSearch)) {
                return user;
            }
        }
        return null; // Return null if the user is not found
    }

    public boolean deleteUserAccount(List<forumUser> listOfUsers, String usernameToDelete, String userName) {
        forumUser userToDelete = searchUserByUsername(listOfUsers, usernameToDelete);

        if(userToDelete != null && userToDelete.getUserName().equals(userName)) {
            listOfUsers.remove(userToDelete);
            System.out.println("Uzytkownik:" + usernameToDelete + " zostal usuniety.");
            return true;
        } else if (userToDelete != null && !userToDelete.getUserName().equals(userName)) {
            System.out.println("Podales nie swoja nazwe uzytkownika.");
        } else {
            System.out.println("Uzytkownik o takiej nazwie: " + usernameToDelete + " nie istnieje.");
        }
        return false;
    }

        @Override
        public String toString() {
            return "{[" + getUserName() + ',' + getUserFirstName() + ',' + getUserLastName() + ',' + getUserAge() + ',' + getUserGender() + ',' + getUserEmail() + ',' + getAmountOfPosts() + "]}";
        }

    public String getUserName() {

        return this.userName;
    }

    public int getAmountOfPosts() {

        return this.posts.size();
    }
}
