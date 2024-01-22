class User {

    private transient String userFirstName;
    private transient String userLastName;
    private transient String userGender;
    private transient int userAge;
    private transient String userEmail;

    //Creating a User Constructor
    public User(String userFirstName, String userLastName, String userGender, int userAge, String userEmail) {

        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userGender = userGender;
        this.userAge = userAge;
        this.userEmail = userEmail;
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
