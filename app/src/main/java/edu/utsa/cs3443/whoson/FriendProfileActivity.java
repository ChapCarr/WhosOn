package edu.utsa.cs3443.whoson;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

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

        String name = getIntent().getStringExtra("name");
        String status = getIntent().getStringExtra("status");

        TextView text1 = findViewById(R.id.profileText);
        text1.setText(name);

        Button button1 = findViewById(R.id.statusButton);
        if(Objects.equals(status, "green")){
            button1.setText("On Campus");
        }




        ImageView statusPic = findViewById(R.id.statusPicture);
        int imageResource = getResources().getIdentifier(status, "drawable", getPackageName());
        statusPic.setImageResource(imageResource); // Set your image resource here

        ImageButton fpHomeButton = findViewById(R.id.fp_home_button);
        //  OnClickListener
        fpHomeButton.setOnClickListener(v -> {
            Intent intent = new Intent(FriendProfileActivity.this, MainActivity.class);
            startActivity(intent);
        });

        ImageButton fpSettingButton = findViewById(R.id.fp_setting_button);
        // OnClickListener
        fpSettingButton.setOnClickListener(v -> {

            Intent intent = new Intent(FriendProfileActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        Button fpMessageButton = findViewById(R.id.fp_message_button);

        fpMessageButton.setOnClickListener(v -> {
            Intent intent = new Intent(FriendProfileActivity.this, MessageActivity.class);
            startActivity(intent);
        });
    }
}