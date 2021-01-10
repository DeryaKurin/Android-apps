package net.mcamigos.petfinder.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import net.mcamigos.petfinder.App;
import net.mcamigos.petfinder.data.model.OauthResponse;


public class PrefManager {

    private static final String TOKEN_DATA="token_data";
    private static Gson gson = new Gson();


    private static SharedPreferences getPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(App.getInstance()
                .getApplicationContext());
    }

    public static int getInt(String preferenceKey, int preferenceDefaultValue) {
        return getPreferences().getInt(preferenceKey, preferenceDefaultValue);
    }



    public static boolean getBoolean(String preferenceKey, boolean preferenceDefaultValue) {
        return getPreferences().getBoolean(preferenceKey, preferenceDefaultValue);
    }

    public static void putBoolean(String preferenceKey, boolean preferenceValue) {
        getPreferences().edit().putBoolean(preferenceKey, preferenceValue).apply();
    }


    public static String getString(String preferenceKey, String preferenceDefaultValue) {
        return getPreferences().getString(preferenceKey, preferenceDefaultValue);
    }

    public static void putString(String preferenceKey, String preferenceValue) {
        getPreferences().edit().putString(preferenceKey, preferenceValue).apply();
    }

    public static void clearPrefs() {
        getPreferences().edit().clear().apply();
    }


    public static long getLong(String preferenceKey, long preferenceValue){
        return getPreferences().getLong(preferenceKey,preferenceValue);
    }

    public static void putLong(String preferenceKey, long preferenceValue){
        getPreferences().edit().putLong(preferenceKey,preferenceValue).apply();
    }
    /**
     * Store token details
     * @param data
     */
    public static void saveTokenDetails( OauthResponse data ){
        putString(TOKEN_DATA, new Gson().toJson( data ) );
    }

    /**
     * Fetch token details
     * @return Oauth2Response
     */
    public static OauthResponse fetchTokenDetails(){
        return gson.fromJson(getString(TOKEN_DATA, null), OauthResponse.class);
    }


}