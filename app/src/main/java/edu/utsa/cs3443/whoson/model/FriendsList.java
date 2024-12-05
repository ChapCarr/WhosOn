package edu.utsa.cs3443.whoson.model;

import android.content.res.AssetManager;

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

    public void loadFriendsList(FriendListActivity activity){
        AssetManager manager = activity.getAssets();
        Scanner scan = null;
        String fileName = "friends2.csv";
        try{
            InputStream file = manager.open("friends2.csv");
            scan = new Scanner(file);
            Friend test = new Friend("asd123", "test", "green");
            this.friendsList.add(test);
            String useless = scan.nextLine();
            String line;
            String[] friend;
            while(scan.hasNextLine()){
                line = scan.nextLine();
                friend = line.split(",");
                if (friend.length == 3) {
                    Friend person = new Friend(friend[0], friend[1], friend[2]);
                    this.friendsList.add(person);
                    this.abcList.add(friend[0]);
                    this.nameList.add(friend[1]);
                    this.statusList.add(friend[2]);
                }
            }
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
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
