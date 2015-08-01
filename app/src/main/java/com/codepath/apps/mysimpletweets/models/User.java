package com.codepath.apps.mysimpletweets.models;


import org.json.JSONException;
import org.json.JSONObject;

public class User {
    // List attributes
    private String name;
    private long wid;
    private  String screemName;
    private  String profileImageUrl;


    public String getName() {
        return name;
    }

    public long getWid() {
        return wid;
    }

    public String getScreemName() {
        return screemName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    // Deserialize the user json => User
    public static User fromJSON(JSONObject json){
        User u = new User();
        // Extract and fill the values
        try {
            u.name = json.getString("name");
            u.wid = json.getLong("id");
            u.screemName =json.getString("screen_name");
            u.profileImageUrl = json.getString("profile_image_url");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Return a user
        return u;
    }
}
