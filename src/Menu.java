
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;

public class Menu {
    private boolean innerLoopValue = false;
    private boolean outerLoopValue = false;
    private String newline = "\n";
    private PostStorage postStorage = new PostStorage();
    private CommentStorage commentStorage = new CommentStorage();
    private Post newPost;

    private PostCommentViewer postCommentViewer = new PostCommentViewer(postStorage, commentStorage);

    FileOutputStream fo = new FileOutputStream("userData.txt", true);

    public Menu() throws IOException {
    }


    public String showMenu() {
        return """
                1. Wyświetl Menu
                2. Dane użytkownika\s
                3. Dodaj Post\s
                4. Sprawdz wszystkie Posty\s
                5. Sprawdz Posty uzytkownika\s
                6. Dodaj komentarz do posta\s
                8. Usuń konto
                9. Wyloguj z aplikacji\s
                =============""";
    }

    public String showRegisterMenu() {
        return """
            Wybierz opcję z Menu Rejestracji:
            1. Rejestracja
            2. Logowanie
            3. Wyjdz z aplikacji
            4. Lista userow
            =============""";
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
                        forumUser newUser = user.createUser();
                        listOfUsers.add(newUser);
                        System.out.println(newUser);
                        fo.write(("First name: " + newUser.getUserFirstName() +
                                " Last name: " + newUser.getUserLastName() +
                                " Gender: " + newUser.getUserGender() +
                                " User age: " + newUser.getUserAge() +
                                " User email: " + newUser.getUserEmail() +
                                " Username: " + newUser.getUserName() +
                                " Amount of posts created by user: " + newUser.getAmountOfPosts() + newline).getBytes());
                        break;
                    case 2:

                        System.out.println("Podaj nazwę użytkownika: ");
                        Scanner usernameScanner = new Scanner(System.in);
                        String usernameToSearch = usernameScanner.nextLine().trim();

                        forumUser foundUser = user.searchUserByUsername(listOfUsers, usernameToSearch);

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
                    case 4:
                        for(forumUser User : listOfUsers) {
                            System.out.println(User);
                        }
                        break;
                    default:
                        System.out.print("Wybrałeś niepoprawną opcję." + newline);

                }
            } catch (InputMismatchException | IOException e) {
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
                            newPost = postStorage.createPost(user.getUserName());
                            postStorage.addPost(newPost);

                            System.out.println("Dodano post: " + newline + newPost);
                            postStorage.movePostToSet(newPost, user.posts);
                            break;
                        case 4:
                            System.out.println("Lista wszystkich Postow");
                            for(Map.Entry<Integer, Post> entry : postStorage.getPosts().entrySet()) {
                                System.out.println(entry.getValue());
                            }
                            break;
                        case 5:
                            System.out.print("Liczba postow uzytkownika jest rowna: " + user.getAmountOfPosts() + newline
                                    + "Lista postow uzytkownika: " + user.getUserName() + newline
                                    + user.posts + newline);
                            break;
                        case 6:
                            postCommentViewer.viewPostsAndComments(user);
                            break;
                        case 7:
                            postCommentViewer.displayPostWithComments();
                            break;
                        case 8:
                            System.out.print("Podaj swoja nazwe uzytkownika aby usunac swoje konto: ");
                            String usernameToDelete = scanner.next();

                            innerLoopValue = user.deleteUserAccount(listOfUsers, usernameToDelete, user.getUserName());
                            break;
                        case 9:
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
}
