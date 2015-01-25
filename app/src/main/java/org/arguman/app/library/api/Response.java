package org.arguman.app.library.api;

import com.google.gson.annotations.SerializedName;

import org.arguman.app.model.ItemsModel;

import java.util.List;

public class Response {

    @SerializedName("results")
    private List<ItemsModel> items;

    public Response() {}

    public List<ItemsModel> getItems() {
        return items;
    }

    public void setItems(List<ItemsModel> items) {
        this.items = items;
    }

}
