package com.example.guidetouristique2;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Log;

import java.util.Locale;

public class Language {

    private static final String TAG = "Language";

    // Get the saved language from SharedPreferences
    public static String getLanguage(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String language = prefs.getString("Language", "fr"); // Default is French
        Log.d(TAG, "getLanguage: Current language is " + language); // Log current language
        return language;
    }

    // Set the locale for the application and update SharedPreferences
    public static Context setLocale(Context context, String langCode) {
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);

        Configuration config = context.getResources().getConfiguration();
        // For Android N and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            config.setLocale(locale);
            context = context.createConfigurationContext(config);
        } else {
            config.locale = locale;
            context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        }

        // Save the language to SharedPreferences
        SharedPreferences.Editor editor = context.getSharedPreferences("Settings", Context.MODE_PRIVATE).edit();
        editor.putString("Language", langCode);
        editor.apply();

        Log.d(TAG, "setLocale: Language set to " + langCode); // Log language set
        return new ContextWrapper(context);
    }
}
