package org.arguman.app.library.api;

import retrofit.RestAdapter;

public class Client {

    private static final String URL = "http://arguman.org/api/v1";
    private Services services;

    public Client() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(URL)
                .build();
        services = restAdapter.create(Services.class);
    }

    public String getUrl() {
        return URL;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

}
