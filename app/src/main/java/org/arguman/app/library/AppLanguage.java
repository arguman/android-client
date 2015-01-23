package org.arguman.app.library;

import android.content.Context;
import android.content.res.Configuration;

import java.util.Locale;

public class AppLanguage {

    private Locale locale;
    private Context context;
    private ObjectCache objectCache;
    public static final String KEY = "AppLanguage";

    public AppLanguage(Context context) {
        this.context = context;
        objectCache = ObjectCache.getInstance(context);
    }

    public void changeLanguage(String language) {
        if (language.equalsIgnoreCase(""))
            return;
        locale = new Locale(language);
        saveLocale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        saveLocale(language);
    }

    public void saveLocale(String language) {
        objectCache.putObject(KEY, language);
        objectCache.commit();
    }

    public void loadLocale() {
        String language = objectCache.getObject(KEY, String.class);
        changeLanguage(language);
    }

    public String getLanguage() {
        String language = objectCache.getObject(KEY, String.class);
        if (language.isEmpty())
            return Locale.getDefault().getLanguage();
        return language;
    }

}
