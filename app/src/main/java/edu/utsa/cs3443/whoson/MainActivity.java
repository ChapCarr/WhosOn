package edu.utsa.cs3443.whoson;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.whoson.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private boolean areButtonsEnabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Initially disable the buttons
        Button friendListButton = findViewById(R.id.friendList_button);
        Button addFriendButton = findViewById(R.id.addFriend_button);
        Button loginButton = findViewById(R.id.login_button);

        friendListButton.setEnabled(true); // Disable initially
        addFriendButton.setEnabled(areButtonsEnabled); // Disable initially

        // Button to open Settings
        ImageButton settingButton = findViewById(R.id.setting_button);
        settingButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });


        loginButton.setOnClickListener(v -> {
            areButtonsEnabled = true;
            friendListButton.setEnabled(true);  // Enable  Button
            addFriendButton.setEnabled(true);
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        // Friend List Button
        friendListButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FriendListActivity.class);
            startActivity(intent);
        });

        // Add Friend Button
        addFriendButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddFriendActivity.class);
            startActivity(intent);
        });
    }
}
