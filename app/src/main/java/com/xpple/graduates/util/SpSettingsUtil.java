package com.xpple.graduates.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 首选项管理
 */
public class SpSettingsUtil {
    private static final String SETTING_FIRST = "setting_first";
    private static final String SETTING_MUSIC = "setting_music";
    private static final String SETTING_SOUND = "setting_sound";
    private static final String USER_PHONE = "user_phone";
    private static final String USER_NICK = "user_nick";
    private static final String USER_SEX = "user_sex";
    private static final String USER_SUGGEST = "user_suggest";
    private static final String USER_SUGGEST_MONEY = "user_suggest_money";
    private static SharedPreferences.Editor editor;
    private SharedPreferences mSharedPreferences;

    @SuppressLint("CommitPrefEdits")
    public SpSettingsUtil(Context context, String name) {
        mSharedPreferences = context.getSharedPreferences(name,
                Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
    }

    public void cleanSharedPreference() {
        editor.clear();
        editor.commit();
    }

    // 首次导航
    public boolean isAllowFirst() {
        return mSharedPreferences.getBoolean(SETTING_FIRST, true);
    }

    public void setAllowFirstEnable(boolean isFirst) {
        editor.putBoolean(SETTING_FIRST, isFirst);
        editor.commit();
    }

    // 允许声音
    public boolean isAllowMusic() {
        return mSharedPreferences.getBoolean(SETTING_MUSIC, true);
    }

    public void setAllowMusicEnable(boolean isChecked) {
        editor.putBoolean(SETTING_MUSIC, isChecked);
        editor.commit();
    }

    // 允许音效
    public boolean isAllowSound() {
        return mSharedPreferences.getBoolean(SETTING_SOUND, true);
    }

    public void setAllowSoundEnable(boolean isChecked) {
        editor.putBoolean(SETTING_SOUND, isChecked);
        editor.commit();
    }

    // 玩家手机号码
    public String getUserPhone() {
        return mSharedPreferences.getString(USER_PHONE, "未设置手机号码");
    }

    public void setUserPhone(String userPhone) {
        editor.putString(USER_PHONE, userPhone);
        editor.commit();
    }

    // 玩家昵称
    public String getUserNick() {
        return mSharedPreferences.getString(USER_NICK, "点击修改昵称");
    }

    public void setUserNick(String userNick) {
        editor.putString(USER_NICK, userNick);
        editor.commit();
    }

    // 玩家性别-true-男
    public boolean isUserSex() {
        return mSharedPreferences.getBoolean(USER_SEX, true);
    }

    public void setUserSexEnable(boolean isUserSex) {
        editor.putBoolean(USER_SEX, isUserSex);
        editor.commit();
    }

    // 玩家是否赞助-true-是
    public boolean isUserSuggest() {
        return mSharedPreferences.getBoolean(USER_SUGGEST, false);
    }

    public void setUserSuggestEnable(boolean isUserSuggest) {
        editor.putBoolean(USER_SUGGEST, isUserSuggest);
        editor.commit();
    }

    // 玩家赞助金额
    public Integer getUserSuggestMoney() {
        return mSharedPreferences.getInt(USER_SUGGEST_MONEY, 0);
    }

    public void setUserSuggestMoney(Integer isUserSuggestMoney) {
        editor.putInt(USER_SUGGEST_MONEY, isUserSuggestMoney);
        editor.commit();
    }
}
