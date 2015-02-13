package org.arguman.app.model;

import android.content.Context;

import com.google.gson.annotations.SerializedName;

import org.arguman.app.library.ObjectCache;

public class UserModel {

    public static final String KEY = "user";

    @SerializedName("id")
    private int id;

    @SerializedName("username")
    private String username;

    @SerializedName("absolute_url")
    private String absolute_url;

    @SerializedName("avatar")
    private String avatar;

    public UserModel() {
    }

    public UserModel(int id, String username, String absolute_url, String avatar) {
        this.id = id;
        this.username = username;
        this.absolute_url = absolute_url;
        this.avatar = avatar;
    }

    public static String getKey() {
        return KEY;
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

    public String getAbsolute_url() {
        return absolute_url;
    }

    public void setAbsolute_url(String absolute_url) {
        this.absolute_url = absolute_url;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
