package edu.utsa.cs3443.whoson;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import edu.utsa.cs3443.whoson.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.settingActivity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Image Button
        ImageButton settingButton = findViewById(R.id.setting_button);

        // Set OnClickListener for Settings Button
        settingButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        // Retrieve login state from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        boolean hasLogin = sharedPreferences.getBoolean("is_logged_in", false);  // Default to false if not found

        // Buttons
        Button friendListButton = findViewById(R.id.friendList_button);
        Button addFriendButton = findViewById(R.id.addFriend_button);
        Button loginButton = findViewById(R.id.login_button);

        // Set them to false until login is true
        friendListButton.setEnabled(hasLogin);
        addFriendButton.setEnabled(hasLogin);

        // Friend List Button
        friendListButton.setOnClickListener(v -> {
            if (hasLogin) {
                Intent intent = new Intent(MainActivity.this, FriendListActivity.class);
                startActivity(intent);
            }
        });

        // Add Friend Button
        addFriendButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddFriendActivity.class);
            startActivity(intent);
        });

        // Login Button
        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}
