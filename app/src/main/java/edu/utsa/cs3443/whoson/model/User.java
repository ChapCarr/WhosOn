package edu.utsa.cs3443.whoson.model;

public class User {

    private boolean isLoggedIn;

    public User() {
        this.isLoggedIn = false;  // Default to not logged in
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }


}
