package edu.utsa.cs3443.whoson;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FriendProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_friend_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


//        ImageButton fpHomeButton = findViewById(R.id.fp_home_button);
//        //  OnClickListener
//        fpHomeButton.setOnClickListener(v -> {
//            Intent intent = new Intent(FriendProfileActivity.this, SettingsActivity.class);
//            startActivity(intent);
//        });
//
//        ImageButton fpSettingButton = findViewById(R.id.sf_home_button);
//        // OnClickListener
//        fpSettingButton.setOnClickListener(v -> {
//
//            Intent intent = new Intent(FriendProfileActivity.this, MainActivity.class);
//            startActivity(intent);
//        });
    }
}