package com.xpple.graduates.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 存档管理
 */
public class SpSaveUtil {
    private static final String SCORE_BOOLEAN = "score_boolean"; //是否有记录
    private static final String SCORE_HEALTHY = "score_healthy"; //健康
    private static final String SCORE_MONEY = "score_money"; //金钱
    private static final String SCORE_ABILITY = "score_ability"; //能力
    private static final String SCORE_EXPERIENCE = "score_experience"; //经验
    private static final String SCORE_HAPPY = "score_happy"; //快乐
    private static final String SCORE_MORALITY = "score_morality"; //道德
    private static final String SCORE_COMMUNICATION = "score_communication"; //交际
    private static final String SCORE_MONTH = "score_month"; //剩余月
    private static final String SCORE_TIME = "score_time"; //剩余时间
    private static final String SCORE_STOCK = "score_stock"; //股票
    private static final String SCORE_POSITION = "score_position"; //职位
    private static final String SCORE_HOUSE = "score_house"; //房产
    private static final String SCORE_CAR = "score_car"; //汽车
    private static final String SCORE_PARTNER = "score_partner"; //伴侣
    private static final String SCORE_CAREER = "score_career"; //事业指数
    private static final String SCORE_LOVE = "score_love"; //爱情指数
    private static final String SCORE_RANDOM_STOCK = "score_random_stock"; //随机股票指数
    private static final String SCORE_INDEX_HOUSE = "score_index_house"; //房价指数
    private static final String SCORE_INDEX_STOCK = "score_index_stock"; //股票指数
    private static final String SCORE_PURITY = "score_purity"; //分数含金量
    private static final String SCORE_INCOME = "score_income"; //月净收益
    private static final String SCORE_COMMUNICATION_MONTHLY = "score_communication_monthly"; //月净交际
    private static final String SCORE_HAPPY_MONTHLY = "score_happy_monthly"; //月净快乐
    private static final String GAME_STOCK = "game_stock"; //股票 0/1
    private static final String GAME_POSITION = "game_position"; //职位 0/1
    private static final String GAME_HOUSE = "game_house"; //房产 0/1
    private static final String GAME_CAR = "game_car"; //汽车 0/1
    private static final String GAME_PARTNER = "game_partner"; //伴侣 0/1
    private static final String GAME_LOTTERY = "game_lottery"; //彩票 0/1
    private static final String GAME_YD = "game_yd"; //30
    private static final String GAME_BL = "game_bl"; //30
    private static final String GAME_TS = "game_ts"; //20
    private static final String GAME_PY = "game_py"; //30
    private static final String GAME_GJ = "game_gj"; //30
    private static final String GAME_CM = "game_cm"; //30
    private static final String GAME_CJ = "game_cj"; //30
    private static final String GAME_ZJ = "game_zj"; //30
    private static final String GAME_JB = "game_jb"; //20
    private static final String GAME_SW = "game_sw"; //20
    private static final String GAME_TY = "game_tx"; //30
    private static final String GAME_HJ = "game_hj"; //30
    private static final String PARTNER_STORY = "partner_story"; //当前剧情人物
    private static final String PARTNER_XY = "partner_xy"; //小樱
    //    private static final String PARTNER_SS = "partner_ss"; //施施
//    private static final String PARTNER_AC = "partner_ac"; //阿婵
    private static final String PARTNER_ZJ = "partner_zj"; //昭君
    private static final String PARTNER_SN = "partner_sn"; //十娘
    private static final String PARTNER_SN_TIME = "partner_sn_time"; //十娘
    private static SharedPreferences.Editor editor;
    private SharedPreferences mSharedPreferences;

    @SuppressLint("CommitPrefEdits")
    public SpSaveUtil(Context context, String name) {
        mSharedPreferences = context.getSharedPreferences(name,
                Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
    }

    public void cleanSharedPreference() {
        editor.clear();
        editor.commit();
    }
//    private static final String PARTNER_FY = "partner_fy"; //飞燕

    // 是否有记录-false-否
    public boolean isSave() {
        return mSharedPreferences.getBoolean(SCORE_BOOLEAN, false);
    }

    public void setSave(boolean isSave) {
        editor.putBoolean(SCORE_BOOLEAN, isSave);
        editor.commit();
    }

    // 健康
    public Integer getHealthy() {
        return mSharedPreferences.getInt(SCORE_HEALTHY, 0);
    }

    public void setHealthy(Integer healthy) {
        editor.putInt(SCORE_HEALTHY, healthy);
        editor.commit();
    }

    // 金钱
    public Integer getMoney() {
        return mSharedPreferences.getInt(SCORE_MONEY, 0);
    }

    public void setMoney(Integer money) {
        editor.putInt(SCORE_MONEY, money);
        editor.commit();
    }

    // 能力
    public Integer getAbility() {
        return mSharedPreferences.getInt(SCORE_ABILITY, 0);
    }

    public void setAbility(Integer ability) {
        editor.putInt(SCORE_ABILITY, ability);
        editor.commit();
    }

    // 经验
    public Integer getExperience() {
        return mSharedPreferences.getInt(SCORE_EXPERIENCE, 0);
    }

    public void setExperience(Integer experience) {
        editor.putInt(SCORE_EXPERIENCE, experience);
        editor.commit();
    }

    // 快乐
    public Integer getHappy() {
        return mSharedPreferences.getInt(SCORE_HAPPY, 0);
    }

    public void setHappy(Integer happy) {
        editor.putInt(SCORE_HAPPY, happy);
        editor.commit();
    }

    // 道德
    public Integer getMorality() {
        return mSharedPreferences.getInt(SCORE_MORALITY, 0);
    }

    public void setMorality(Integer morality) {
        editor.putInt(SCORE_MORALITY, morality);
        editor.commit();
    }

    // 交际
    public Integer getCommunication() {
        return mSharedPreferences.getInt(SCORE_COMMUNICATION, 0);
    }

    public void setCommunication(Integer communication) {
        editor.putInt(SCORE_COMMUNICATION, communication);
        editor.commit();
    }

    // 剩余月
    public Integer getMonth() {
        return mSharedPreferences.getInt(SCORE_MONTH, 0);
    }

    public void setMonth(Integer month) {
        editor.putInt(SCORE_MONTH, month);
        editor.commit();
    }

    // 剩余时间
    public Integer getTime() {
        return mSharedPreferences.getInt(SCORE_TIME, 0);
    }

    public void setTime(Integer time) {
        editor.putInt(SCORE_TIME, time);
        editor.commit();
    }

    // 股票
    public Integer getStock() {
        return mSharedPreferences.getInt(SCORE_STOCK, 0);
    }

    public void setStock(Integer stock) {
        editor.putInt(SCORE_STOCK, stock);
        editor.commit();
    }

    // 职位
    public Integer getPosition() {
        return mSharedPreferences.getInt(SCORE_POSITION, 0);
    }

    public void setPosition(Integer position) {
        editor.putInt(SCORE_POSITION, position);
        editor.commit();
    }

    // 房产
    public Integer getHouse() {
        return mSharedPreferences.getInt(SCORE_HOUSE, 0);
    }

    public void setHouse(Integer house) {
        editor.putInt(SCORE_HOUSE, house);
        editor.commit();
    }

    // 汽车
    public Integer getCar() {
        return mSharedPreferences.getInt(SCORE_CAR, 0);
    }

    public void setCar(Integer car) {
        editor.putInt(SCORE_CAR, car);
        editor.commit();
    }

    // 伴侣
    public Integer getPartner() {
        return mSharedPreferences.getInt(SCORE_PARTNER, 0);
    }

    public void setPartner(Integer partner) {
        editor.putInt(SCORE_PARTNER, partner);
        editor.commit();
    }

    //事业指数
    public Integer getCareer() {
        return mSharedPreferences.getInt(SCORE_CAREER, 0);
    }

    public void setCareer(Integer career) {
        editor.putInt(SCORE_CAREER, career);
        editor.commit();
    }

    //爱情指数
    public Integer getLove() {
        return mSharedPreferences.getInt(SCORE_LOVE, 0);
    }

    public void setLove(Integer love) {
        editor.putInt(SCORE_LOVE, love);
        editor.commit();
    }

    //随机股票指数
    public Integer getRandomStock() {
        return mSharedPreferences.getInt(SCORE_RANDOM_STOCK, 0);
    }

    public void setRandomStock(Integer random_stock) {
        editor.putInt(SCORE_RANDOM_STOCK, random_stock);
        editor.commit();
    }

    //房价指数
    public Integer getIndexHouse() {
        return mSharedPreferences.getInt(SCORE_INDEX_HOUSE, 0);
    }

    public void setIndexHouse(Integer index_house) {
        editor.putInt(SCORE_INDEX_HOUSE, index_house);
        editor.commit();
    }

    //股票指数
    public Integer getIndexStock() {
        return mSharedPreferences.getInt(SCORE_INDEX_STOCK, 0);
    }

    public void setIndexStock(int index_stock) {
        editor.putInt(SCORE_INDEX_STOCK, index_stock);
        editor.commit();
    }

    // 分数含金量
    public Integer getPurity() {
        return mSharedPreferences.getInt(SCORE_PURITY, 0);
    }

    public void setPurity(Integer purity) {
        editor.putInt(SCORE_PURITY, purity);
        editor.commit();
    }

    // 月净收益
    public Integer getIncome() {
        return mSharedPreferences.getInt(SCORE_INCOME, 0);
    }

    public void setIncome(Integer income) {
        editor.putInt(SCORE_INCOME, income);
        editor.commit();
    }


    // 月净交际
    public Integer getCommunicationMonthly() {
        return mSharedPreferences.getInt(SCORE_COMMUNICATION_MONTHLY, 0);
    }

    public void setCommunicationMonthly(Integer communicationMonthly) {
        editor.putInt(SCORE_COMMUNICATION_MONTHLY, communicationMonthly);
        editor.commit();
    }

    // 月净快乐
    public Integer getHappyMonthly() {
        return mSharedPreferences.getInt(SCORE_HAPPY_MONTHLY, 0);
    }

    public void setHappyMonthly(Integer happyMonthly) {
        editor.putInt(SCORE_HAPPY_MONTHLY, happyMonthly);
        editor.commit();
    }

    //股票 0/1
    public boolean isStock() {
        return mSharedPreferences.getBoolean(GAME_STOCK, false);
    }

    public void setStock(boolean isStock) {
        editor.putBoolean(GAME_STOCK, isStock);
        editor.commit();
    }

    //职位 0/1
    public boolean isPosition() {
        return mSharedPreferences.getBoolean(GAME_POSITION, false);
    }

    public void setPosition(boolean isPosition) {
        editor.putBoolean(GAME_POSITION, isPosition);
        editor.commit();
    }

    //房产 0/1
    public boolean isHouse() {
        return mSharedPreferences.getBoolean(GAME_HOUSE, false);
    }

    public void setHouse(boolean isHouse) {
        editor.putBoolean(GAME_HOUSE, isHouse);
        editor.commit();
    }

    //汽车 0/1
    public boolean isCar() {
        return mSharedPreferences.getBoolean(GAME_CAR, false);
    }

    public void setCar(boolean isCar) {
        editor.putBoolean(GAME_CAR, isCar);
        editor.commit();
    }

    //伴侣 0/1
    public boolean isPartner() {
        return mSharedPreferences.getBoolean(GAME_PARTNER, false);
    }

    public void setPartner(boolean isPartner) {
        editor.putBoolean(GAME_PARTNER, isPartner);
        editor.commit();
    }

    //彩票 0/1
    public boolean isLottery() {
        return mSharedPreferences.getBoolean(GAME_LOTTERY, false);
    }

    public void setLottery(boolean isLottery) {
        editor.putBoolean(GAME_LOTTERY, isLottery);
        editor.commit();
    }

    // YD 30
    public Integer getYd() {
        return mSharedPreferences.getInt(GAME_YD, 0);
    }

    public void setYd(Integer yd) {
        editor.putInt(GAME_YD, yd);
        editor.commit();
    }

    // BL 30
    public Integer getBl() {
        return mSharedPreferences.getInt(GAME_BL, 0);
    }

    public void setBl(Integer bl) {
        editor.putInt(GAME_BL, bl);
        editor.commit();
    }

    // TX 20
    public Integer getTs() {
        return mSharedPreferences.getInt(GAME_TS, 0);
    }

    public void setTs(Integer ts) {
        editor.putInt(GAME_TS, ts);
        editor.commit();
    }

    // PY 30
    public Integer getPy() {
        return mSharedPreferences.getInt(GAME_PY, 0);
    }

    public void setPy(Integer py) {
        editor.putInt(GAME_PY, py);
        editor.commit();
    }

    // GJ 30
    public Integer getGj() {
        return mSharedPreferences.getInt(GAME_GJ, 0);
    }

    public void setGj(Integer gj) {
        editor.putInt(GAME_GJ, gj);
        editor.commit();
    }

    // CM 30
    public Integer getCm() {
        return mSharedPreferences.getInt(GAME_CM, 0);
    }

    public void setCm(Integer cm) {
        editor.putInt(GAME_CM, cm);
        editor.commit();
    }

    // CJ 30
    public Integer getCj() {
        return mSharedPreferences.getInt(GAME_CJ, 0);
    }

    public void setCj(Integer cj) {
        editor.putInt(GAME_CJ, cj);
        editor.commit();
    }

    // ZJ 30
    public Integer getZj() {
        return mSharedPreferences.getInt(GAME_ZJ, 0);
    }

    public void setZj(Integer zj) {
        editor.putInt(GAME_ZJ, zj);
        editor.commit();
    }

    // JB 20
    public Integer getJb() {
        return mSharedPreferences.getInt(GAME_JB, 0);
    }

    public void setJb(Integer jb) {
        editor.putInt(GAME_JB, jb);
        editor.commit();
    }

    // SW 20
    public Integer getSw() {
        return mSharedPreferences.getInt(GAME_SW, 0);
    }

    public void setSw(Integer sw) {
        editor.putInt(GAME_SW, sw);
        editor.commit();
    }

    // TY 30
    public Integer getTy() {
        return mSharedPreferences.getInt(GAME_TY, 0);
    }

    public void setTy(Integer ty) {
        editor.putInt(GAME_TY, ty);
        editor.commit();
    }

    // HJ 30
    public Integer getHj() {
        return mSharedPreferences.getInt(GAME_HJ, 0);
    }

    public void setHj(Integer hj) {
        editor.putInt(GAME_HJ, hj);
        editor.commit();
    }

    public Integer getPartnerStory() {
        return mSharedPreferences.getInt(PARTNER_STORY, 0);
    }

    public void setPartnerStory(Integer partner_story) {
        editor.putInt(PARTNER_STORY, partner_story);
        editor.commit();
    }

    public Integer getPartnerXy() {
        return mSharedPreferences.getInt(PARTNER_XY, 0);
    }

    public void setPartnerXy(Integer partner_xy) {
        editor.putInt(PARTNER_XY, partner_xy);
        editor.commit();
    }

//    public Integer getPartnerSs() {
//        return mSharedPreferences.getInt(PARTNER_SS, 0);
//    }
//
//    public void setPartnerSs(Integer partner_ss) {
//        editor.putInt(PARTNER_SS, partner_ss);
//        editor.commit();
//    }

//    public Integer getPartnerAc() {
//        return mSharedPreferences.getInt(PARTNER_AC, 0);
//    }
//
//    public void setPartnerAc(Integer partner_ac) {
//        editor.putInt(PARTNER_AC, partner_ac);
//        editor.commit();
//    }

    public Integer getPartnerZj() {
        return mSharedPreferences.getInt(PARTNER_ZJ, 0);
    }

    public void setPartnerZj(Integer partner_zj) {
        editor.putInt(PARTNER_ZJ, partner_zj);
        editor.commit();
    }

    public Integer getPartnerSn() {
        return mSharedPreferences.getInt(PARTNER_SN, 0);
    }

    public void setPartnerSn(Integer partner_sn) {
        editor.putInt(PARTNER_SN, partner_sn);
        editor.commit();
    }

    public Integer getPartnerSnTime() {
        return mSharedPreferences.getInt(PARTNER_SN_TIME, 0);
    }

    public void setPartnerSnTime(Integer partner_sn_time) {
        editor.putInt(PARTNER_SN_TIME, partner_sn_time);
        editor.commit();
    }
//    public Integer getPartnerFy() {
//        return mSharedPreferences.getInt(PARTNER_FY, 0);
//    }
//
//    public void setPartnerFy(Integer partner_fy) {
//        editor.putInt(PARTNER_FY, partner_fy);
//        editor.commit();
//    }
}
