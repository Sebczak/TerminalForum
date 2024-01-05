class User {

    private String userFirstName;
    private String userLastName;
    private String userGender;
    private int userAge;
    private String userEmail;

    //Creating a User Constructor
    public User(String userFirstName, String userLastName, String userGender, int userAge, String userEmail) {

        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userGender = userGender;
        this.userAge = userAge;
        this.userEmail = userEmail;
    }

    //delete User Account - Need to create a Scanner class in order to verify the deletion method
    public void deleteUserAccount(String userFirstName, String userLastName, String userEmail) {

        if (userFirstName.equals(getUserFirstName()) && userLastName.equals(getUserLastName()) && userEmail.equals(getUserEmail())) {

            System.out.print("Konto użytkowanika zostało usunięte" + "\n");
        } else {

            System.out.print("Niepoprane dane do usunięcia konta" + "\n");
        }
    }

    public String getUserFirstName() {
        return this.userFirstName;
    }

    public String getUserLastName() {
        return this.userLastName;
    }

    public String getUserGender() {
        return this.userGender;
    }

    public int getUserAge() {
        return this.userAge;
    }

    public String getUserEmail() {
        return this.userEmail;
    }
}
