package org.arguman.app.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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

    @SerializedName("premise_type")
    private String premise_type;

    @SerializedName("date_creation")
    private String date_creation;

    @SerializedName("supporters")
    private List<UserModel> supporters;

    public PremisesModel() {
    }

    public PremisesModel(int id, UserModel user, String text, String sources, int parent, String absolute_url, String premise_type, String date_creation, List<UserModel> supporters) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.sources = sources;
        this.parent = parent;
        this.absolute_url = absolute_url;
        this.premise_type = premise_type;
        this.date_creation = date_creation;
        this.supporters = supporters;
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

    public String getPremise_type() {
        return premise_type;
    }

    public void setPremise_type(String premise_type) {
        this.premise_type = premise_type;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public List<UserModel> getSupporters() {
        return supporters;
    }

    public void setSupporters(List<UserModel> supporters) {
        this.supporters = supporters;
    }

}
