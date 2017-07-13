package com.example.hp.easystore.activity.Utility;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hp on 13-Jul-17.
 */

public class SharedPref {
    private static final String PREF_FIRST = "PREF_FIRST";
    private static final String PREF_SECOND = "PREF_SECOND";
    private static final String PREF_THIRD = "PREF_THIRD";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static String STORE_NAME = "STORE_NAME";
    private static String STORE_PHONE_NO = "STORE_PHONE_NO";
    private static String STORE_CATEGORY = "STORE_CATEGORY";
    private static String STORE_TAG_LINE = "STORE_TAG_LINE";
    private static String STORE_ADDRESS = "STORE_ADDRESS";

    String storeName, storePhoneNo, storeCategory, storeTagLine;


    public SharedPref(Context context, int pos) {
        switch (pos) {
            case 1:
                sharedPreferences = context.getSharedPreferences(PREF_FIRST, Context.MODE_PRIVATE);

                break;
            case 2:
                sharedPreferences = context.getSharedPreferences(PREF_SECOND, Context.MODE_PRIVATE);

                break;
            case 3:
                sharedPreferences = context.getSharedPreferences(PREF_THIRD, Context.MODE_PRIVATE);

                break;
        }
    }

    /*
    *FIRST
     */
    public String getStoreName() {
        return sharedPreferences.getString(STORE_NAME, "null");
    }

    public String getStorePhoneNo() {
        return sharedPreferences.getString(STORE_PHONE_NO, "null");
    }

    public String getStoreCategory() {
        return sharedPreferences.getString(STORE_CATEGORY, "null");
    }

    public String getStoreTagLine() {
        return sharedPreferences.getString(STORE_TAG_LINE, "null");
    }

    public String getStoreAddress() {
        return sharedPreferences.getString(STORE_ADDRESS, "null");
    }


    public void setBussinessDetails(String storeName, String storePhoneNo, String storeCategory, String storeTagLine, String storeAddress) {
        editor = sharedPreferences.edit();
        editor.putString(STORE_NAME, storeName);
        editor.putString(STORE_PHONE_NO, storePhoneNo);
        editor.putString(STORE_CATEGORY, storeCategory);
        editor.putString(STORE_TAG_LINE, storeTagLine);
        editor.putString(STORE_ADDRESS, storeAddress);
        editor.apply();
    }

    /*
    * SECOND
     */
    public String getStoreNameSecond() {
        return sharedPreferences.getString(STORE_NAME, "null");
    }

    public String getStorePhoneNoSecond() {
        return sharedPreferences.getString(STORE_PHONE_NO, "null");
    }

    public String getStoreCategorySecond() {
        return sharedPreferences.getString(STORE_CATEGORY, "null");
    }

    public String getStoreTagLineSecond() {
        return sharedPreferences.getString(STORE_TAG_LINE, "null");
    }

    public String getStoreAddressSecond() {
        return sharedPreferences.getString(STORE_ADDRESS, "null");
    }


    public void setBussinessDetailsSecond(String storeName, String storePhoneNo, String storeCategory, String storeTagLine, String storeAddress) {
        editor = sharedPreferences.edit();
        editor.putString(STORE_NAME, storeName);
        editor.putString(STORE_PHONE_NO, storePhoneNo);
        editor.putString(STORE_CATEGORY, storeCategory);
        editor.putString(STORE_TAG_LINE, storeTagLine);
        editor.putString(STORE_ADDRESS, storeAddress);
        editor.apply();
    }

    /*
    *THIRD
     */
    public String getStoreNameThird() {
        return sharedPreferences.getString(STORE_NAME, "null");
    }

    public String getStorePhoneNoThird() {
        return sharedPreferences.getString(STORE_PHONE_NO, "null");
    }

    public String getStoreCategoryThird() {
        return sharedPreferences.getString(STORE_CATEGORY, "null");
    }

    public String getStoreTagLineThird() {
        return sharedPreferences.getString(STORE_TAG_LINE, "null");
    }

    public String getStoreAddressThird() {
        return sharedPreferences.getString(STORE_ADDRESS, "null");
    }


    public void setBussinessDetailsThird(String storeName, String storePhoneNo, String storeCategory, String storeTagLine, String storeAddress) {
        editor = sharedPreferences.edit();
        editor.putString(STORE_NAME, storeName);
        editor.putString(STORE_PHONE_NO, storePhoneNo);
        editor.putString(STORE_CATEGORY, storeCategory);
        editor.putString(STORE_TAG_LINE, storeTagLine);
        editor.putString(STORE_ADDRESS, storeAddress);
        editor.apply();
    }


}
