package edu.utsa.cs3443.whoson.model;

import android.content.res.AssetManager;
import android.util.Log;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import edu.utsa.cs3443.whoson.FriendListActivity;
import edu.utsa.cs3443.whoson.R;

public class FriendsList {

    private ArrayList<Friend> friendsList = new ArrayList<Friend>();
    private ArrayList<String> abcList = new ArrayList<String>();
    private ArrayList<String> nameList = new ArrayList<String>();
    private ArrayList<String> statusList = new ArrayList<String>();

    public void loadFriendsList(FriendListActivity activity) {
        AssetManager manager = activity.getAssets();
        Scanner scan = null;
        String fileName = "friends.csv";
        try {
            // Open the file from assets
            InputStream file = manager.open(fileName);
            scan = new Scanner(file);

            // Initialize lists if not already initialized
            if (this.friendsList == null) this.friendsList = new ArrayList<>();
            if (this.abcList == null) this.abcList = new ArrayList<>();
            if (this.nameList == null) this.nameList = new ArrayList<>();
            if (this.statusList == null) this.statusList = new ArrayList<>();

            // Skip the header line if necessary (or remove this line if no header)
            if (scan.hasNextLine()) {
                String header = scan.nextLine();  // Skips the header
            }

            // Read through the CSV file line by line
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] friend = line.split(",");

                // Check if the line contains exactly 3 fields
                if (friend.length == 3) {
                    Friend person = new Friend(friend[0], friend[1], friend[2]);
                    this.friendsList.add(person);
                    this.abcList.add(friend[0]);
                    this.nameList.add(friend[1]);
                    this.statusList.add(friend[2]);
                } else {
                    // Log a warning if the line does not have 3 fields
                    Log.w("loadFriendsList", "Skipping invalid line: " + line);
                }
            }
        } catch (Exception e) {
            // Log the exception for debugging purposes
            Log.e("loadFriendsList", "Error loading friends list", e);
        } finally {
            // Close the scanner to avoid resource leaks
            if (scan != null) {
                scan.close();
            }
        }
    }


    public ArrayList<Friend> getFriendsList() {

        return this.friendsList;
    }

    public ArrayList<String> getAbcList() {
        return this.abcList;
    }

    public ArrayList<String> getNameList() {
        return this.nameList;
    }

    public ArrayList<String> getStatusList() {
        return this.statusList;
    }
}
