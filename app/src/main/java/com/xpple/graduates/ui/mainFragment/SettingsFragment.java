package com.xpple.graduates.ui.mainFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ktplay.open.KTAccountManager;
import com.ktplay.open.KTError;
import com.ktplay.open.KTUser;
import com.tencent.bugly.beta.Beta;
import com.xpple.graduates.CustomApplication;
import com.xpple.graduates.R;
import com.xpple.graduates.util.SpSettingsUtil;
import com.xpple.graduates.util.StringUtils;
import com.xpple.graduates.view.BaseFragment;
import com.xpple.graduates.view.NiftyDialogBuilder;


public class SettingsFragment extends BaseFragment implements View.OnClickListener {
    @SuppressLint("StaticFieldLeak")
    private static SettingsFragment instance = new SettingsFragment();
    private View parentView;
    private ImageView iv_open_music, iv_close_music, iv_open_sound, iv_close_sound;
    private SpSettingsUtil mSharedSettingsUtil;
    private ImageView btn_about, btn_suggest, btn_splash, btn_update;
    private RelativeLayout rl_switch_music, rl_switch_sound, rl_text_phone, rl_text_nick, rl_text_sex;
    private TextView tv_phone, tv_nick, tv_sex;

    public SettingsFragment() {
    }

    public static SettingsFragment newInstance() {
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_settings, container, false);
        setUpViews();
        return parentView;
    }

    private void setUpViews() {
        ImageView iv_back = (ImageView) parentView.findViewById(R.id.btn_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        rl_switch_music = (RelativeLayout) parentView.findViewById(R.id.rl_switch_music);
        rl_switch_sound = (RelativeLayout) parentView.findViewById(R.id.rl_switch_sound);
        rl_text_phone = (RelativeLayout) parentView.findViewById(R.id.rl_text_phone);
        rl_text_nick = (RelativeLayout) parentView.findViewById(R.id.rl_text_nick);
        rl_text_sex = (RelativeLayout) parentView.findViewById(R.id.rl_text_sex);

        iv_open_music = (ImageView) parentView.findViewById(R.id.iv_open_music);
        iv_close_music = (ImageView) parentView.findViewById(R.id.iv_close_music);
        iv_open_sound = (ImageView) parentView.findViewById(R.id.iv_open_sound);
        iv_close_sound = (ImageView) parentView.findViewById(R.id.iv_close_sound);

        tv_phone = (TextView) parentView.findViewById(R.id.tv_phone);
        tv_nick = (TextView) parentView.findViewById(R.id.tv_nick);
        tv_sex = (TextView) parentView.findViewById(R.id.tv_sex);
        btn_splash = (ImageView) parentView.findViewById(R.id.btn_splash);
        btn_about = (ImageView) parentView.findViewById(R.id.btn_abont);
        btn_suggest = (ImageView) parentView.findViewById(R.id.btn_suggent);
        btn_update = (ImageView) parentView.findViewById(R.id.btn_update);
        setListener();
    }

    private void setListener() {
        rl_switch_music.setOnClickListener(this);
        rl_switch_sound.setOnClickListener(this);
        rl_text_phone.setOnClickListener(this);
        rl_text_nick.setOnClickListener(this);
        rl_text_sex.setOnClickListener(this);
        btn_splash.setOnClickListener(this);
        btn_about.setOnClickListener(this);
        btn_suggest.setOnClickListener(this);
        btn_update.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSharedSettingsUtil = mApplication.getSpSettingsUtil();
        boolean isAllowMusic = mSharedSettingsUtil.isAllowMusic();
        if (isAllowMusic) {
            iv_open_music.setVisibility(View.VISIBLE);
            iv_close_music.setVisibility(View.INVISIBLE);
        } else {
            iv_open_music.setVisibility(View.INVISIBLE);
            iv_close_music.setVisibility(View.VISIBLE);
        }
        boolean isAllowSound = mSharedSettingsUtil.isAllowSound();
        if (isAllowSound) {
            iv_open_sound.setVisibility(View.VISIBLE);
            iv_close_sound.setVisibility(View.INVISIBLE);
        } else {
            iv_open_sound.setVisibility(View.INVISIBLE);
            iv_close_sound.setVisibility(View.VISIBLE);
        }
        String userPhone = mSharedSettingsUtil.getUserPhone();
        tv_phone.setText(userPhone);
        String userNick = mSharedSettingsUtil.getUserNick();
        tv_nick.setText(userNick);
        boolean isUserSex = mSharedSettingsUtil.isUserSex();
        tv_sex.setText(isUserSex ? "男" : "女");
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder
                .getInstance(getActivity());
        switch (v.getId()) {
            case R.id.rl_switch_music:
                CustomApplication.playSound(R.raw.button_1);
                if (iv_open_music.getVisibility() == View.VISIBLE) {
                    iv_open_music.setVisibility(View.INVISIBLE);
                    iv_close_music.setVisibility(View.VISIBLE);
                    CustomApplication.setAllowMusicEnable(false);
                } else {
                    iv_open_music.setVisibility(View.VISIBLE);
                    iv_close_music.setVisibility(View.INVISIBLE);
                    CustomApplication.setAllowMusicEnable(true);
                }
                onActivityCreated(null);
                break;
            case R.id.rl_switch_sound:
                CustomApplication.playSound(R.raw.button_1);
                if (iv_open_sound.getVisibility() == View.VISIBLE) {
                    iv_open_sound.setVisibility(View.INVISIBLE);
                    iv_close_sound.setVisibility(View.VISIBLE);
                    CustomApplication.setAllowSoundEnable(false);
                } else {
                    iv_open_sound.setVisibility(View.VISIBLE);
                    iv_close_sound.setVisibility(View.INVISIBLE);
                    CustomApplication.setAllowSoundEnable(true);
                }
                onActivityCreated(null);
                break;
            case R.id.rl_text_phone:
                CustomApplication.playSound(R.raw.button_0);
                dialogBuilder.withTitle("设置手机号")
                        .withMessage(null).withEditText(InputType.TYPE_CLASS_PHONE).isCancelable(true)
                        .withDuration(500).withButtonCancle().withButtonOk()
                        .setCustomView(0, getActivity())
                        .setButtonCancleClick(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialogBuilder.getDismiss();
                            }
                        }).setButtonOk(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String phone = NiftyDialogBuilder.et_player.getText().toString();
                        if (StringUtils.isPhoneNumberValid(phone)) {
                            mSharedSettingsUtil.setUserPhone(phone);
                            dialogBuilder.dismiss();
                            onActivityCreated(null);
                        } else {
                            showToast("手机号不合法，请确认后重新输入！", false);
                        }
                    }
                }).show();
                break;
            case R.id.rl_text_nick:
                CustomApplication.playSound(R.raw.button_0);
                dialogBuilder.withTitle("设置昵称")
                        .withMessage(null).withEditText(InputType.TYPE_CLASS_TEXT).isCancelable(true)
                        .withDuration(500).withButtonCancle().withButtonOk()
                        .setCustomView(0, getActivity())
                        .setButtonCancleClick(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialogBuilder.getDismiss();
                            }
                        }).setButtonOk(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String nickname = NiftyDialogBuilder.et_player.getText().toString();
                        mSharedSettingsUtil.setUserNick(nickname);
                        KTAccountManager.setNickname(nickname, new KTAccountManager.OnSetNicknameListener() {
                            @Override
                            public void onSetNicknameResult(boolean isSuccess, String nickname,
                                                            KTUser user, KTError error) {
                                if (isSuccess) {
                                    showToast("网络帐号昵称同步成功", true);
                                } else {
                                    showToast("网络帐号昵称同步失败", false);
                                }
                            }
                        });
                        dialogBuilder.dismiss();
                        onActivityCreated(null);
                    }
                }).show();
                break;
            case R.id.rl_text_sex:
                if (tv_sex.getText().equals("男")) {
                    mSharedSettingsUtil.setUserSexEnable(false);
                    tv_sex.setText("女");
                } else {
                    mSharedSettingsUtil.setUserSexEnable(true);
                    tv_sex.setText("男");
                }
                onActivityCreated(null);
                break;
            case R.id.btn_splash:
                CustomApplication.playSound(R.raw.button_0);
                mSharedSettingsUtil.cleanSharedPreference();
                onActivityCreated(null);
                break;
            case R.id.btn_abont:
                CustomApplication.playSound(R.raw.button_0);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_main,
                                AboutFragment.newInstance()).addToBackStack(null)
                        .commit();
                break;
            case R.id.btn_suggent:
                CustomApplication.playSound(R.raw.button_0);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_main,
                                SuggestFragment.newInstance()).addToBackStack(null)
                        .commit();
                break;
            case R.id.btn_update:
                /***** 检查更新 *****/
                Beta.checkUpgrade();
                break;
            default:
                break;
        }
    }

}
