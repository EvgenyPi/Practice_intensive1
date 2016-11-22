package com.evgeny.practice_intensive1.data.managers;

import android.content.SharedPreferences;

import com.evgeny.practice_intensive1.utils.ConstantManager;
import com.evgeny.practice_intensive1.utils.DevintensiveApplication;

import java.util.ArrayList;
import java.util.List;

public class PreferencesManager {

    private SharedPreferences mSharedPreferences;

    private static final String[] USER_FIELDS = {ConstantManager.USER_PHONE_KEY, ConstantManager.USER_EMAIL_KEY, ConstantManager.USER_VK_KEY, ConstantManager.USER_GIT_KEY, ConstantManager.USER_BIO_KEY};

    public PreferencesManager() {
        this.mSharedPreferences = DevintensiveApplication.getSharedPreferences();
    }

    public void saveUserProfileData(List<String> userFields) {

        SharedPreferences.Editor editor = mSharedPreferences.edit();

        for (int i = 0; i < USER_FIELDS.length; i++) {
            editor.putString(USER_FIELDS[i], userFields.get(i));
        }

        editor.apply();
    }

    public List<String> loadUserProfileData() {
        List<String> userFields = new ArrayList<>();

        userFields.add(mSharedPreferences.getString(ConstantManager.USER_PHONE_KEY, "Phone"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_EMAIL_KEY, "Email"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_VK_KEY, "VK"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_GIT_KEY, "Github"));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_BIO_KEY, "About"));

        return userFields;
    }
}
