package edu.utsa.cs3443.whoson;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SearchFriendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_friend);

        ImageButton sfHomeButton = findViewById(R.id.sf_home_button);
        sfHomeButton.setOnClickListener(v -> {
            Intent intent = new Intent(SearchFriendActivity.this, MainActivity.class);
            startActivity(intent);
        });

        ImageButton sfSettingButton = findViewById(R.id.sf_setting_button);
        sfSettingButton.setOnClickListener(v -> {
            Intent intent = new Intent(SearchFriendActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        TextInputEditText searchEditText = findViewById(R.id.sf_abc_input);
        Button searchButton = findViewById(R.id.sf_request_button);

        // Search Button functionality
        searchButton.setOnClickListener(v -> {
            String userInput = searchEditText.getText().toString().trim();
            if (userInput.isEmpty()) {
                Toast.makeText(this, "Please enter a friend's code", Toast.LENGTH_SHORT).show();
            } else {
                String result = searchFriendByCode(userInput);
                if (result != null) {
                    Toast.makeText(this, "Friend Found: " + result, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "No friend found with code: " + userInput, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String searchFriendByCode(String code) {
        try {
            // Open the CSV file
            InputStream is = getResources().openRawResource(R.raw.friends1);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(","); // Assuming CSV format is "ABC123,Friend Name"
                if (tokens.length > 1 && tokens[0].equalsIgnoreCase(code)) {
                    return tokens[1].trim(); // Return the friend's name
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error reading the CSV file.", Toast.LENGTH_SHORT).show();
        }
        return null; // Return null if no match found
    }
}
