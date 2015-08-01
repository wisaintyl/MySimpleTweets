package com.codepath.apps.mysimpletweets.models;

/*

    [



    ]

 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.jar.JarException;

// Parse the JSON + Store the data, encapsulate state logic or display logic
public class Tweet {
    // List out the attributes
    private  String body;
    private long wid; // unique id for the tweet
    private User user; // store embedodded user object
    private  String createdAt;

    public User getUser() {
        return user;
    }

    public String getBody() {
        return body;
    }

    public long getWid() {
        return wid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    // Deserialize the json and build tweet objects
    // Tweet.fromJSON("{ ...... }") => <Tweet>
    public static Tweet fromJSON(JSONObject jsonObject){
        Tweet tweet = new Tweet();
        // Extract the values from the json
        try {
            tweet.body = jsonObject.getString("text");
            tweet.wid = jsonObject.getLong("id");
            tweet.createdAt = jsonObject.getString("created_at");
            tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
        }catch (JSONException e){
            e.printStackTrace();
        }
        // Return the tweet object
        return tweet;
    }

    // Tweet.fromJSONArray([{ ... }, { ... }] => List<tweet>
    public static ArrayList<Tweet> fromJSONArray(JSONArray jsonArray){
        ArrayList<Tweet> tweets = new ArrayList<>();
        // Itarate the json array and create tweet
        for (int i=0; i< jsonArray.length(); i++ ){
            try {
                JSONObject tweetjson = jsonArray.getJSONObject(i);
                Tweet tweet = Tweet.fromJSON(tweetjson);
                if(tweet != null){
                    tweets.add(tweet);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                continue;
            }
        }

        // Return the finished list
        return tweets;

    }
}
