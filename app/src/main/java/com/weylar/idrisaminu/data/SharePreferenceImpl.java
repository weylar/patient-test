package com.weylar.idrisaminu.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceImpl implements SharePreference {
    SharedPreferences prefs;
    SharePreferenceImpl(Context context){
        prefs = context.getSharedPreferences("my_app", Context.MODE_PRIVATE);
    }

    @Override
    public void saveString(String key, String data) {
        prefs.edit().putString(key, data).apply();
    }

    @Override
    public String getString(String key) {
        return prefs.getString(key, "");
    }

    @Override
    public void saveInt(String key, int data) {
        prefs.edit().putInt(key, data).apply();
    }

    @Override
    public int getInt(String key) {
        return prefs.getInt(key, 5);
    }
}
