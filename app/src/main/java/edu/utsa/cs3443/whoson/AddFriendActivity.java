package edu.utsa.cs3443.whoson;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddFriendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_friend);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton af_settingButton = findViewById(R.id.addFriend_setting_button);
        // Set OnClickListener
        af_settingButton.setOnClickListener(v -> {
            Intent intent = new Intent(AddFriendActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        ImageButton af_settingHomeButton = findViewById(R.id.addFriend_home_button);
        // Set OnClickListener
        af_settingHomeButton.setOnClickListener(v -> {

            Intent intent = new Intent(AddFriendActivity.this, MainActivity.class);
            startActivity(intent);
        });

        Button searchButton = findViewById(R.id.searchABC_button);
        searchButton.setOnClickListener(v -> {
            Intent intent = new Intent(AddFriendActivity.this, SearchFriendActivity.class);
            startActivity(intent);
        });





    }
}