package com.mobile.responsi_mobile_programming_dua;

import android.content.Context;
import android.content.SharedPreferences;

public class Sharedprefmanager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public Sharedprefmanager (Context context){
        sharedPreferences = context.getSharedPreferences("ResponsiMP2",context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void saveString(String value){
        editor.putString("string",value);
        editor.commit();
    }
    public String getString(){return sharedPreferences.getString("string","");}

    public String getUsername(){
        return sharedPreferences.getString("sp_username", "gunawan");
    }

    public String getPassword(){
        return sharedPreferences.getString("sp_password", "1976");
    }

    public void saveIsLogin(Boolean value){
        editor.putBoolean("sp_islogin",value);
        editor.commit();
    }

    public Boolean getIsLogin(){
        return sharedPreferences.getBoolean("sp_islogin", false);
    }

}
