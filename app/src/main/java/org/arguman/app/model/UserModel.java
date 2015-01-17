package org.arguman.app.model;

import java.util.ArrayList;

public class UserModel {

    private int                  id;
    private String               username
                                ,email
                                ,password
                                ,avatar;
    private ArrayList<UserModel> followingList
                                ,followerList;

    public UserModel() {}

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
}
