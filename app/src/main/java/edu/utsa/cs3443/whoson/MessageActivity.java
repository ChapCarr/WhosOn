package edu.utsa.cs3443.whoson;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class MessageActivity extends AppCompatActivity {

    private EditText Enter_Text;

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

        Enter_Text = findViewById(R.id.MessageText);

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

        ImageButton send_button = findViewById(R.id.SendButton);
        // OnClickListener
        send_button.setOnClickListener(v -> {
            String name = Enter_Text.getText().toString();
            WriteMessage(this, name);
        });

    }

    public void WriteMessage(MessageActivity activity, String message)
    {
        try {

            File file = new File("assets/messagelog.csv"); // Looks up file
            // Open the CSV file
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(message); // Writes the message into the file.
            bw.newLine();
            Toast.makeText(this, "Message successfully sent!", Toast.LENGTH_SHORT).show();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
              Toast.makeText(this, "Error writing into CSV file.", Toast.LENGTH_SHORT).show();
        }
    }

}