package org.arguman.app.rest.service;

import org.arguman.app.rest.model.Response;

import retrofit.Callback;
import retrofit.http.GET;

public interface PremiseService {

    @GET("/premises")
    public void getPremises(Callback<Response> callback);

}
