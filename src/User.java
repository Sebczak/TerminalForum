class User {

    private String userFirstName;
    private String userLastName;
    private String userGender;
    private int userAge;
    private String userEmail;

    //Creating a User Constructor
    public User(String userFirstName, String userLastName, int userAge, String userGender, String userEmail) {

        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAge = userAge;
        this.userGender = userGender;
        this.userEmail = userEmail;
    }

    public User() {

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
