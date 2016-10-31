package com.xpple.graduates;

import android.app.Application;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Environment;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.xpple.graduates.config.Config;
import com.xpple.graduates.ui.MainActivity;
import com.xpple.graduates.util.SpSaveUtil;
import com.xpple.graduates.util.SpScoreUtil;
import com.xpple.graduates.util.SpSettingsUtil;

import java.util.HashMap;
import java.util.Map;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * 自定义全局Application类
 *
 * @author nEdAy
 */
public class CustomApplication extends Application {

    private static final String PREFERENCE_NAME_0 = "_score";
    private static final String PREFERENCE_NAME_1 = "_settings";
    private static final String PREFERENCE_NAME_2 = "_save";
    private static final int[] musicId = {R.raw.bg_start, R.raw.bg_end, R.raw.bg_game};
    private static CustomApplication mInstance;
    private static SoundPool mSoundPool;
    private static MediaPlayer mMediaPlayer;
    //音乐播放位置
    private static int position;
    private static Map<Integer, Integer> soundMap;
    // 单例模式，才能及时返回数据
    private SpScoreUtil mSpScoreUtil;
    private SpSettingsUtil mSpSettingsUtil;
    private SpSaveUtil mSpSaveUtil;

    public static CustomApplication getInstance() {
        return mInstance;
    }

    public static void playSound(int sound) {
        if (isAllowSound()) {
            Integer soundId = soundMap.get(sound);
            if (soundId != null) {
                mSoundPool.play(soundId, 1, 1, 0, 0, 1);
            }
        }
    }

    /**
     * 获得音效开关状态
     */
    private static boolean isAllowSound() {
        return CustomApplication.getInstance().getSpSettingsUtil().isAllowSound();
    }

    /**
     * 设置音效开关
     */
    public static void setAllowSoundEnable(boolean enable) {
        CustomApplication.getInstance().getSpSettingsUtil().setAllowSoundEnable(enable);
    }

    /**
     * 初始化音乐播放器
     */
    private static void initMusic(Integer id) {
        /**创建MediaPlayer对象**/
        mMediaPlayer = MediaPlayer.create(mInstance, musicId[id]);
        /**设置为循环播放**/
        mMediaPlayer.setLooping(true);
    }

    /**
     * 暂停音乐
     */
    public static void pauseMusic() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            position = mMediaPlayer.getCurrentPosition();
            mMediaPlayer.stop();
        }
    }

    /**
     * 播放音乐
     */
    public static void startMusic(Integer id) {
        if (isAllowMusic()) {
            initMusic(id);
            if (!mMediaPlayer.isPlaying()) {
                mMediaPlayer.start();
                mMediaPlayer.
            }
        }
    }

    /**
     * 摧毁音乐
     */
    public static void destroyMusic() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    /**
     * 继续音乐
     */
    public static void resumeMusic(Integer id) {
        if (position > 0 && mMediaPlayer != null) {
            mMediaPlayer.reset();
            initMusic(id);
            mMediaPlayer.start();
            mMediaPlayer.seekTo(position);
            position = 0;
        }
    }

    /**
     * 获得音乐开关状态
     */
    private static boolean isAllowMusic() {
        return CustomApplication.getInstance().getSpSettingsUtil().isAllowMusic();
    }

    /**
     * 设置音乐开关
     */
    public static void setAllowMusicEnable(boolean enable) {
        CustomApplication.getInstance().getSpSettingsUtil().setAllowMusicEnable(enable);
        if (enable) {
            if (position > 0) {
                resumeMusic(0);
            } else {
                startMusic(0);
            }
        } else {
            pauseMusic();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initTextType();
        initSound();
        //初始化Bugly
        initBugly(BuildConfig.LOG_DEBUG);
    }

    private void initTextType() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/myfont.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    private void initSound() {
        /**创建一个声音播放池**/
        //参数1为声音池同时播放的流的最大数量
        //参数2为播放流的类型
        //参数3为音乐播放效果
        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 100);
        //读取音效
        soundMap = new HashMap<>();
        soundMap.put(R.raw.button_0, mSoundPool.load(this, R.raw.button_0, 0));
        soundMap.put(R.raw.button_1, mSoundPool.load(this, R.raw.button_1, 0));
        soundMap.put(R.raw.read, mSoundPool.load(this, R.raw.read, 0));
        soundMap.put(R.raw.train, mSoundPool.load(this, R.raw.train, 0));
        soundMap.put(R.raw.parents, mSoundPool.load(this, R.raw.parents, 0));
        soundMap.put(R.raw.internet, mSoundPool.load(this, R.raw.internet, 0));
        soundMap.put(R.raw.classmate, mSoundPool.load(this, R.raw.classmate, 0));
        soundMap.put(R.raw.exercise, mSoundPool.load(this, R.raw.exercise, 0));
        soundMap.put(R.raw.bar, mSoundPool.load(this, R.raw.bar, 0));
        soundMap.put(R.raw.money, mSoundPool.load(this, R.raw.money, 0));
        soundMap.put(R.raw.hammer, mSoundPool.load(this, R.raw.hammer, 0));
        soundMap.put(R.raw.shopping, mSoundPool.load(this, R.raw.shopping, 0));
        soundMap.put(R.raw.tour, mSoundPool.load(this, R.raw.tour, 0));
        soundMap.put(R.raw.sleep, mSoundPool.load(this, R.raw.sleep, 0));
        soundMap.put(R.raw.lottery, mSoundPool.load(this, R.raw.lottery, 0));
        soundMap.put(R.raw.appreciation, mSoundPool.load(this, R.raw.appreciation, 0));
        soundMap.put(R.raw.next_month, mSoundPool.load(this, R.raw.next_month, 0));
    }

    public synchronized SpScoreUtil getSpScoreUtil() {
        if (mSpScoreUtil == null) {
            mSpScoreUtil = new SpScoreUtil(this, PREFERENCE_NAME_0);
        }
        return mSpScoreUtil;
    }

    public synchronized SpSettingsUtil getSpSettingsUtil() {
        if (mSpSettingsUtil == null) {
            mSpSettingsUtil = new SpSettingsUtil(this, PREFERENCE_NAME_1);
        }
        return mSpSettingsUtil;
    }

    public synchronized SpSaveUtil getSpSaveUtil() {
        if (mSpSaveUtil == null) {
            mSpSaveUtil = new SpSaveUtil(this, PREFERENCE_NAME_2);
        }
        return mSpSaveUtil;
    }

    private void initBugly(boolean logDebug) {
        /***** Beta高级设置 *****/
        /**
         * true表示app启动自动初始化升级模块;
         * false不会自动初始化;
         * 开发者如果担心sdk初始化影响app启动速度，可以设置为false，
         * 在后面某个时刻手动调用Beta.init(getApplicationContext(),false);
         */
        Beta.autoInit = true;

        /**
         * true表示初始化时自动检查升级;
         * false表示不会自动检查升级,需要手动调用Beta.checkUpgrade()方法;
         */
        Beta.autoCheckUpgrade = true;

        /**
         * 设置升级检查周期为60s(默认检查周期为0s)，60s内SDK不重复向后台请求策略);
         */
        Beta.upgradeCheckPeriod = 60 * 1000;

//        /**
//         * 设置启动延时为1s（默认延时3s），APP启动1s后初始化SDK，避免影响APP启动速度;
//         */
//        Beta.initDelay = 1 * 1000;

        /**
         * 设置通知栏大图标，largeIconId为项目中的图片资源;
         */
        Beta.largeIconId = R.mipmap.ic_launcher;

        /**
         * 设置状态栏小图标，smallIconId为项目中的图片资源Id;
         */
        Beta.smallIconId = R.mipmap.ic_launcher;

        /**
         * 设置更新弹窗默认展示的banner，defaultBannerId为项目中的图片资源Id;
         * 当后台配置的banner拉取失败时显示此banner，默认不设置则展示“loading“;
         */
        Beta.defaultBannerId = R.mipmap.ic_update_banner;

        /**
         * 设置sd卡的Download为更新资源保存目录;
         * 后续更新资源会保存在此目录，需要在manifest中添加WRITE_EXTERNAL_STORAGE权限;
         */
        Beta.storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        /**
         * 点击过确认的弹窗在APP下次启动自动检查更新时会再次显示;
         */
        Beta.showInterruptedStrategy = true;

        /**
         * 只允许在MainActivity上显示更新弹窗，其他activity上不显示弹窗;
         * 不设置会默认所有activity都可以显示弹窗;
         */
        Beta.canShowUpgradeActs.add(MainActivity.class);

        /***** 统一初始化Bugly产品，包含Beta *****/
        Bugly.init(this, Config.BUGLY_APP_ID, logDebug);//测试阶段建议设置成true，发布时设置为false。
    }
}
