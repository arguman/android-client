package org.arguman.app.model;

import android.content.Context;

import org.arguman.app.library.ObjectCache;

import java.util.ArrayList;

public class UserModel {

    private int id;
    private String username, email, password, avatar;
    private ArrayList<UserModel> followingList, followerList;
    public static final String KEY = "user";

    public UserModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public ArrayList<UserModel> getFollowingList() {
        return followingList;
    }

    public void setFollowingList(ArrayList<UserModel> followingList) {
        this.followingList = followingList;
    }

    public ArrayList<UserModel> getFollowerList() {
        return followerList;
    }

    public void setFollowerList(ArrayList<UserModel> followerList) {
        this.followerList = followerList;
    }

    // TODO: Move this functions to UserController as session state changes.
    public void save(Context context) {
        ObjectCache objectCache = ObjectCache.getInstance(context);
        objectCache.putObject(KEY, this);
        objectCache.commit();
    }

    public void remove(Context context) {
        ObjectCache objectCache = ObjectCache.getInstance(context);
        objectCache.removeObject(KEY);
        objectCache.commit();
    }

}
