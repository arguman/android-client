package org.arguman.app.application;

import android.app.Application;
import android.content.res.Configuration;

import org.arguman.app.controller.UserController;
import org.arguman.app.library.ObjectCache;

public class At extends Application {

    private static At at;

    public At getInstance() {
        return at;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        at = this;
        initSingletons();
    }

    private void initSingletons() {
        ObjectCache.getInstance(getApplicationContext());
        UserController.getInstance(getApplicationContext()).initializeSession();
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