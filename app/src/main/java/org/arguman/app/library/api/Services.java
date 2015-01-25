package org.arguman.app.library.api;

import retrofit.Callback;
import retrofit.http.GET;

public interface Services {

    @GET("/premises")
    public void getItems(Callback<Response> callback);

}
