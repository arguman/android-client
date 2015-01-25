package org.arguman.app.model;

import com.google.gson.annotations.SerializedName;

public class PremisesModel {

    public static final String KEY = "premises";

    @SerializedName("id")
    private int id;

    @SerializedName("user")
    private UserModel user;

    @SerializedName("text")
    private String text;

    @SerializedName("sources")
    private String sources;

    @SerializedName("parent")
    private int parent;

    @SerializedName("absolute_url")
    private String absolute_url;

    public PremisesModel() {}

    public static String getKey() {
        return KEY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getAbsolute_url() {
        return absolute_url;
    }

    public void setAbsolute_url(String absolute_url) {
        this.absolute_url = absolute_url;
    }

}
