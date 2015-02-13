package org.arguman.app.rest;

import org.arguman.app.rest.service.ArgumentService;

import retrofit.RestAdapter;

public class ArgumanClient {

    private static final String BASE_URL = "http://arguman.org/api/v1";
    private ArgumentService argumentService;

    public ArgumanClient() {
        // TODO: Timestamp parse, encoding, header
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .build();
        argumentService = restAdapter.create(ArgumentService.class);
    }

    public ArgumentService getArgumentService() {
        return argumentService;
    }

}
