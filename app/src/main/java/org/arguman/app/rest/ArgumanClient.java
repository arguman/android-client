package org.arguman.app.rest;

import org.arguman.app.rest.service.PremiseService;

import retrofit.RestAdapter;

public class ArgumanClient {

    private static final String BASE_URL = "http://arguman.org/api/v1";
    private PremiseService premiseService;

    public ArgumanClient() {
        // TODO: Timestamp parse, encoding, header
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .build();
        premiseService = restAdapter.create(PremiseService.class);
    }

    public PremiseService getPremiseService() {
        return premiseService;
    }

}
