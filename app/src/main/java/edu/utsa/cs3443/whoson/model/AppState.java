package edu.utsa.cs3443.whoson.model;

public class AppState {
    // Step 1: Create a static variable to hold the single instance
    private static AppState instance;

    // Step 2: Private constructor to prevent instantiation from other classes
    private AppState() {
        // Initialize any fields or state here, if needed
    }

    // Step 3: Provide a public static method to access the instance
    public static AppState getInstance() {
        // If the instance is null, create it
        if (instance == null) {
            instance = new AppState();
        }
        return instance;
    }

    // Example of a state variable, such as login state
    private boolean isLoggedIn;

    // Getter and Setter for login state
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.isLoggedIn = loggedIn;
    }
}
