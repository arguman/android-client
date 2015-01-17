package org.arguman.app.library;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

public class FontCache {

    private static Hashtable<String, Typeface> fontCache = new Hashtable<String, Typeface>();

    public static Typeface get(String name, Context context) {
        Typeface mTypeface = fontCache.get(name);
        if (mTypeface == null) {
            try {
                mTypeface = Typeface.createFromAsset(context.getResources().getAssets(), name);
            } catch (Exception e) {
                return null;
            }
            fontCache.put(name, mTypeface);
        }
        return mTypeface;
    }

}