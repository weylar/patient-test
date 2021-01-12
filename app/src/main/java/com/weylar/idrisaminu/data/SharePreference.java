package com.weylar.idrisaminu.data;

public interface SharePreference {

    void saveString(String key, String data);
    String getString(String key);
    void saveInt(String key, int data);
    int getInt(String key);
}
