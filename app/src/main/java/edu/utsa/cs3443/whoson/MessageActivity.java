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

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_message);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        ImageButton fpHomeButton = findViewById(R.id.m_home_button);
        //  OnClickListener
        fpHomeButton.setOnClickListener(v -> {
            Intent intent = new Intent(MessageActivity.this, MainActivity.class);
            startActivity(intent);
        });

        ImageButton fpSettingButton = findViewById(R.id.m_setting_button);
        // OnClickListener
        fpSettingButton.setOnClickListener(v -> {

            Intent intent = new Intent(MessageActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

    }
}