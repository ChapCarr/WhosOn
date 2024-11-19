package edu.utsa.cs3443.whoson;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class SearchFriendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_friend);


        ImageButton sfHomeButton = findViewById(R.id.sf_setting_button);
        //  OnClickListener
        sfHomeButton.setOnClickListener(v -> {
            Intent intent = new Intent(SearchFriendActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        ImageButton sfSettingButton = findViewById(R.id.sf_home_button);
        // OnClickListener
        sfSettingButton.setOnClickListener(v -> {

            Intent intent = new Intent(SearchFriendActivity.this, MainActivity.class);
            startActivity(intent);
        });

        TextInputEditText searchEditText = findViewById(R.id.sf_abc_input);
        Button searchButton = findViewById(R.id.sf_request_button);

        // OnClickListener for Search Button
        searchButton.setOnClickListener(v -> {
            String userInput = searchEditText.getText().toString().trim();
            if (userInput.isEmpty()) {
                Toast.makeText(this, "Please enter a friend's name", Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(this, "Request Sent to: " + userInput, Toast.LENGTH_SHORT).show();
            }
        });




    }
}