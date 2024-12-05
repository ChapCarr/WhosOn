package edu.utsa.cs3443.whoson.model;

public class Friend {
    private String abc;
    private String name;
    private String status;

    public Friend(String abc, String name, String status){
        this.abc = abc;
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getAbc() {
        return abc;
    }

    public String getStatus() {
        return status;
    }

}
