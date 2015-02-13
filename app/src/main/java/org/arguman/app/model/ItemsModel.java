package org.arguman.app.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemsModel {

    private static final String KEY = "items";

    @SerializedName("count")
    private int count;

    @SerializedName("next")
    private String next;

    @SerializedName("previous")
    private String previous;

    @SerializedName("results")
    private List<ArgumentsModel> results;

    public ItemsModel() {
    }

    public ItemsModel(int count, String next, String previous, List<ArgumentsModel> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public static String getKey() {
        return KEY;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<ArgumentsModel> getResults() {
        return results;
    }

    public void setResults(List<ArgumentsModel> results) {
        this.results = results;
    }

}
