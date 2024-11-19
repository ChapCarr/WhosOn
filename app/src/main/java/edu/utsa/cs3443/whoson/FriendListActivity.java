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

public class FriendListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_friend_list);

        ImageButton sbutton = findViewById(R.id.fl_setting_button);
        // Set OnClickListener
        sbutton.setOnClickListener(v -> {
            Intent intent = new Intent(FriendListActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        ImageButton hbutton = findViewById(R.id.fl_home_button);
        // Set OnClickListener
        hbutton.setOnClickListener(v -> {

            Intent intent = new Intent(FriendListActivity.this, MainActivity.class);
            startActivity(intent);
        });

        Button timMsg = findViewById(R.id.tim_button);
        timMsg.setOnClickListener(v ->{
            Intent intent = new Intent(FriendListActivity.this, FriendProfileActivity.class);
            startActivity(intent);
        });



    }
}