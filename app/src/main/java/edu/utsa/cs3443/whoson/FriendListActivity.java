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
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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
        ArrayList<Friend> friendlies = new ArrayList<>();
        friendlies = friendList.getFriendsList();





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










        for (Friend friend : friendlies) {



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
            int imageResource = getResources().getIdentifier(friend.getStatus(), "drawable", getPackageName());
            imageView.setImageResource(imageResource); // Set your image resource here
            imageView.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    200
            ));
            imageView.setPadding(10, 10, 10, 10);

            horizontalLayout.addView(imageView);

            // Creating and adding a TextView to the horizontal LinearLayout
            TextView textView2 = new TextView(this);
            textView2.setText(friend.getName());
            textView2.setTextSize(18);
            textView2.setTextColor(Color.BLACK);
            textView2.setPadding(10, 10, 10, 10);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    1 // Weight for equal distribution
            ));
            horizontalLayout.addView(textView2);

            // Creating and adding a Button to the horizontal LinearLayout
            Button button = new Button(this);
            button.setText("View profile");  // Set the button text
            button.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            button.setPadding(20, 10, 20, 10);  // Optional padding for the button

            // Optional: Set a click listener to handle button click events
            button.setOnClickListener(v -> {
                // Add your button click logic here
                Toast.makeText(this, "Button clicked for " + friend.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FriendListActivity.this, FriendProfileActivity.class);
                intent.putExtra("name", friend.getName());
                intent.putExtra("status", friend.getStatus());
                startActivity(intent);
            });

            // Adding the button to the horizontal layout
            horizontalLayout.addView(button);


            // Adding the horizontal LinearLayout to the vertical LinearLayout
            verticalLayout.addView(horizontalLayout);



        }


    }
}