package org.arguman.app;

import android.app.Application;
import android.content.res.Configuration;

import com.crashlytics.android.Crashlytics;

import org.arguman.app.controller.UserController;
import org.arguman.app.library.ObjectCache;

import io.fabric.sdk.android.Fabric;

public class At extends Application {

    private static At at;

    public At getInstance() {
        return at;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
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