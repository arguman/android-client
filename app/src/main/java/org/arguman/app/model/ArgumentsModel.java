package org.arguman.app.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArgumentsModel {

    public static final String KEY = "arguments";

    @SerializedName("id")
    private int id;

    @SerializedName("user")
    private UserModel user;

    @SerializedName("title")
    private String title;

    @SerializedName("slug")
    private String slug;

    @SerializedName("description")
    private String description;

    @SerializedName("owner")
    private String owner;

    @SerializedName("sources")
    private String sources;

    @SerializedName("premises")
    private List<PremisesModel> premises;

    @SerializedName("date_creation")
    private String date_creation;

    @SerializedName("absolute_url")
    private String absolute_url;

    @SerializedName("report_count")
    private int report_count;

    @SerializedName("is_featured")
    private boolean is_featured;

    public ArgumentsModel() {
    }

    public ArgumentsModel(int id, UserModel user, String title, String slug, String description, String owner, String sources, List<PremisesModel> premises, String date_creation, String absolute_url, int report_count, boolean is_featured) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.owner = owner;
        this.sources = sources;
        this.premises = premises;
        this.date_creation = date_creation;
        this.absolute_url = absolute_url;
        this.report_count = report_count;
        this.is_featured = is_featured;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public List<PremisesModel> getPremises() {
        return premises;
    }

    public void setPremises(List<PremisesModel> premises) {
        this.premises = premises;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public String getAbsolute_url() {
        return absolute_url;
    }

    public void setAbsolute_url(String absolute_url) {
        this.absolute_url = absolute_url;
    }

    public int getReport_count() {
        return report_count;
    }

    public void setReport_count(int report_count) {
        this.report_count = report_count;
    }

    public boolean isIs_featured() {
        return is_featured;
    }

    public void setIs_featured(boolean is_featured) {
        this.is_featured = is_featured;
    }

}
