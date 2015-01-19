package org.arguman.app.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

import static android.content.SharedPreferences.*;

public class ObjectCache {

    private static ObjectCache objectCache;
    private Context context;
    private SharedPreferences preferences;
    private Editor editor;
    private static Gson GSON = new Gson();
    private static final String LOG_TAG = "ObjectCache";
    private static final String PREFERENCES_NAME = "org.arguman.app";
    private static final int    PREFERENCES_MODE = Activity.MODE_PRIVATE;

    private ObjectCache(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCES_NAME, PREFERENCES_MODE);
        editor = preferences.edit();
    }

    public static ObjectCache getInstance(Context context) {
        if (objectCache == null)
            objectCache = new ObjectCache(context);
        return objectCache;
    }

    public void putObject(String key, Object object) {
        if (object == null) {
            Log.d(LOG_TAG, "putObject/Object is null.");
        }
        if (key.isEmpty() || key == null) {
            Log.d(LOG_TAG, "putObject/Key is empty.");
        }
        editor.putString(key, GSON.toJson(object));
    }

    public void commit() {
        editor.commit();
    }

    public <T> T getObject(String key, Class<T> a) {
        String gson = preferences.getString(key, null);
        if (gson == null) {
            return null;
        } else {
            try {
                return GSON.fromJson(gson, a);
            } catch (Exception e) {
                throw e;
            }
        }
    }

    public void removeObject(String key) {
        editor.remove(key);
    }

}
