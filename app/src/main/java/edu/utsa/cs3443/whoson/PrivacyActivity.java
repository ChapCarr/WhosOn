package edu.utsa.cs3443.whoson;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrivacyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_privacy);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.settingActivity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton sbutton = findViewById(R.id.p_setting_button);
        // Set OnClickListener
        sbutton.setOnClickListener(v -> {
            Intent intent = new Intent(PrivacyActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        ImageButton hbutton = findViewById(R.id.p_home_button);
        // Set OnClickListener
        hbutton.setOnClickListener(v -> {

            Intent intent = new Intent(PrivacyActivity.this, MainActivity.class);
            startActivity(intent);
        });





    }
}