package org.arguman.app.application;

import android.app.Application;
import android.content.res.Configuration;

import org.arguman.app.controller.UserController;
import org.arguman.app.util.ObjectCache;
import org.arguman.app.rest.ArgumanClient;

public class At extends Application {

    private static At at;
    private static ArgumanClient argumanClient;

    public At getInstance() {
        return at;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        at = this;
        initialize();
    }

    private void initialize() {
        ObjectCache.getInstance(getApplicationContext());
        UserController.getInstance(getApplicationContext()).initializeSession();
        argumanClient = new ArgumanClient();
    }

    public ArgumanClient getArgumanClient() {
        return argumanClient;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}