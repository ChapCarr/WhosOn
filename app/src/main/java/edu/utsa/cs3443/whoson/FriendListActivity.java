package edu.utsa.cs3443.whoson;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import edu.utsa.cs3443.whoson.model.Friend;
import edu.utsa.cs3443.whoson.model.FriendsList;

public class FriendListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_friend_list);

        FriendsList friendList = new FriendsList();
        friendList.loadFriendsList(this);

        ArrayList<String> abcList = friendList.getAbcList();
        ArrayList<String> nameList = friendList.getNameList();
        ArrayList<String> statusList = friendList.getStatusList();
        int counter = 0;



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

//        Button timMsg = findViewById(R.id.tim_button);
//        timMsg.setOnClickListener(v ->{
//            Intent intent = new Intent(FriendListActivity.this, FriendProfileActivity.class);
//            startActivity(intent);
//        });

        LinearLayout verticalLayout = findViewById(R.id.ll_holder);
        verticalLayout.removeAllViews();

        for (String names : nameList) {



            LinearLayout horizontalLayout = new LinearLayout(this);

            horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
            horizontalLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            horizontalLayout.setPadding(10, 10, 10, 10);
            horizontalLayout.setGravity(Gravity.CENTER);

            // Creating and adding an ImageView to the horizontal LinearLayout
            ImageView imageView = new ImageView(this);
            int imageResource = getResources().getIdentifier(statusList.get(counter), "drawable", getPackageName());
            imageView.setImageResource(imageResource); // Set your image resource here
            imageView.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    200
            ));
            imageView.setPadding(10, 10, 10, 10);

            horizontalLayout.addView(imageView);

            // Creating and adding a TextView to the horizontal LinearLayout
            TextView textView = new TextView(this);
            textView.setText(nameList.get(counter));
            textView.setTextSize(18);
            textView.setTextColor(Color.BLACK);
            textView.setPadding(10, 10, 10, 10);
            textView.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    1 // Weight for equal distribution
            ));
            horizontalLayout.addView(textView);

            // Adding the horizontal LinearLayout to the vertical LinearLayout
            verticalLayout.addView(horizontalLayout);
            counter++;
        }


    }
}