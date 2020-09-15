package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    private final SharedPreferences mSharedPreference;


    public Preferences(Context context) {
        this.mSharedPreference = context.getSharedPreferences("cores",context.MODE_PRIVATE);
    }

    public void storageColor(String chave,String valor){
        this.mSharedPreference.edit().putString(chave,valor).apply();
    }

    public String getcolor(String chave){
        return this.mSharedPreference.getString(chave,"Default");
    }
}
