package org.arguman.app.rest.service;

import org.arguman.app.model.ItemsModel;

import retrofit.Callback;
import retrofit.http.GET;

public interface ArgumentService {

    @GET("/arguments")
    public void getArguments(Callback<ItemsModel> callback);

}
