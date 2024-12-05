package edu.utsa.cs3443.whoson.model;

import android.content.res.AssetManager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import edu.utsa.cs3443.whoson.FriendListActivity;

public class FriendsList {

    private ArrayList<Friend> friendsList = new ArrayList<Friend>();
    private ArrayList<String> abcList = new ArrayList<String>();
    private ArrayList<String> nameList = new ArrayList<String>();
    private ArrayList<String> statusList = new ArrayList<String>();

    public void loadFriendsList(FriendListActivity activity){
        AssetManager manager = activity.getAssets();
        Scanner scan = null;
        String fileName = "friends.csv";
        try{
            InputStream file = manager.open(fileName);
            scan = new Scanner(file);
            String useless = scan.nextLine();
            String line;
            String[] friend;
            while(scan.hasNextLine()){
                line = scan.nextLine();
                friend = line.split(",");
                Friend person = new Friend(friend[0], friend[1], friend[2]);
                this.friendsList.add(person);
                this.abcList.add(friend[0]);
                this.nameList.add(friend[1]);
                this.statusList.add(friend[2]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Friend> getFriendsList() {
        return friendsList;
    }

    public ArrayList<String> getAbcList() {
        return abcList;
    }

    public ArrayList<String> getNameList() {
        return nameList;
    }

    public ArrayList<String> getStatusList() {
        return statusList;
    }
}
