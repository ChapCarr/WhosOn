package edu.utsa.cs3443.whoson.model;

public class AppState {

    private static AppState instance;


    private AppState() {

    }


    public static AppState getInstance() {

        if (instance == null) {
            instance = new AppState();
        }
        return instance;
    }


    private boolean isLoggedIn;


    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.isLoggedIn = loggedIn;
    }
}
