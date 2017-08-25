package zh.ou.movie.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import zh.ou.movie.http.response.Configuration;
import zh.ou.movie.http.response.Genres;

/**
 * Created by etiennelawlor on 12/17/16.
 */

public class MovieHubPrefs {

    // region Constants
    private static final String MOVIE_HUB_PREF = "MOVIE_HUB_PREF";
    private static final String KEY_CONFIGURATION = "KEY_CONFIGURATION";
    private static final String KEY_GENRES_ZH = "KEY_GENRES_ZH";
    private static final String KEY_GENRES_EN = "KEY_GENRES_EN";
    // endregion

    // region Constructors
    private MovieHubPrefs() {
        //no instance
    }
    // endregion

    // region Getters
    public static Configuration getConfiguration(Context context){
        SharedPreferences preferences = getSharedPreferences(context);
        Gson gson = new Gson();
        String json = preferences.getString(KEY_CONFIGURATION, "");
        Configuration configuration = gson.fromJson(json, Configuration.class);
        return configuration;
    }
    // endregion

    // region Setters
    public static void setConfiguration(Context context, Configuration configuration) {
        SharedPreferences.Editor editor = getEditor(context);
        Gson gson = new Gson();
        String json = gson.toJson(configuration);
        editor.putString(KEY_CONFIGURATION, json)
                .apply();
    }
    public static void setGenresZh(Context context, Genres genres) {
        SharedPreferences.Editor editor = getEditor(context);
        Gson gson = new Gson();
        String json = gson.toJson(genres);
        editor.putString(KEY_GENRES_ZH, json)
                .apply();
    }
    public static Genres getGenresZh(Context context){
        SharedPreferences preferences = getSharedPreferences(context);
        Gson gson = new Gson();
        String json = preferences.getString(KEY_GENRES_ZH, "");
        Genres genres = gson.fromJson(json, Genres.class);
        return genres;
    }
    public static void setGenresEn(Context context, Genres genres) {
        SharedPreferences.Editor editor = getEditor(context);
        Gson gson = new Gson();
        String json = gson.toJson(genres);
        editor.putString(KEY_GENRES_EN, json)
                .apply();
    }
    public static Genres getGenresEn(Context context){
        SharedPreferences preferences = getSharedPreferences(context);
        Gson gson = new Gson();
        String json = preferences.getString(KEY_GENRES_EN, "");
        Genres genres = gson.fromJson(json, Genres.class);
        return genres;
    }
    // endregion

    // region Helper Methods
    private static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.edit();
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(MOVIE_HUB_PREF, Context.MODE_PRIVATE);
    }
    // endregion

}
