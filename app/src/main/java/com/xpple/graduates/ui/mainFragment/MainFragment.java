package com.xpple.graduates.ui.mainFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ktplay.open.KTPlay;
import com.xpple.graduates.CustomApplication;
import com.xpple.graduates.R;
import com.xpple.graduates.ui.GameActivity;
import com.xpple.graduates.util.SpSaveUtil;
import com.xpple.graduates.util.SpScoreUtil;
import com.xpple.graduates.view.BaseFragment;
import com.xpple.graduates.view.NiftyDialogBuilder;


public class MainFragment extends BaseFragment implements View.OnClickListener {
    @SuppressLint("StaticFieldLeak")
    private static MainFragment instance = new MainFragment();
    private View parentView;
    private ImageView btn_exit, btn_share, btn_top, btn_start,
            btn_replay, btn_options, btn_help, btn_ktplay;
    private SpScoreUtil mSharedScoreUtil;
    private SpSaveUtil mSharedSaveUtil;

    public MainFragment() {

    }

    public static MainFragment newInstance() {
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_main, container, false);
        setUpViews();
        return parentView;
    }


    private void setUpViews() {
        btn_exit = (ImageView) parentView.findViewById(R.id.btn_exit);
        btn_share = (ImageView) parentView.findViewById(R.id.btn_share);
        btn_top = (ImageView) parentView.findViewById(R.id.btn_top);
        btn_start = (ImageView) parentView.findViewById(R.id.btn_start);
        btn_replay = (ImageView) parentView.findViewById(R.id.btn_replay);
        btn_options = (ImageView) parentView.findViewById(R.id.btn_options);
        btn_help = (ImageView) parentView.findViewById(R.id.btn_help);
        btn_ktplay = (ImageView) parentView.findViewById(R.id.btn_ktplay);
        setListener();
    }

    private void setListener() {
        btn_exit.setOnClickListener(this);
        btn_share.setOnClickListener(this);
        btn_top.setOnClickListener(this);
        btn_start.setOnClickListener(this);
        btn_replay.setOnClickListener(this);
        btn_options.setOnClickListener(this);
        btn_help.setOnClickListener(this);
        btn_ktplay.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSharedScoreUtil = mApplication.getSpScoreUtil();
        mSharedSaveUtil = mApplication.getSpSaveUtil();

        Boolean isScore = mSharedScoreUtil.isScore();
        if (isScore) {
            btn_replay.setVisibility(View.VISIBLE);
            btn_start.setImageResource(R.mipmap.btn_continue);
        } else {
            btn_replay.setVisibility(View.GONE);
        }
//        KTPlay.showInterstitialNotification(); //显示插屏通知
    }

    @Override
    public void onResume() {
        super.onResume();
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    // 当back按下
                    showExitDialog();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        CustomApplication.playSound(R.raw.button_0);
        switch (view.getId()) {
            case R.id.btn_exit:
                showExitDialog();
                break;
            case R.id.btn_share:
                showToast("成就系统暂不开放,请分享支持", false);
                Intent toShare = new Intent(Intent.ACTION_SEND);
                toShare.setType("text/plain");
                toShare.putExtra(Intent.EXTRA_SUBJECT, "分享");
                toShare.putExtra(Intent.EXTRA_TEXT, "毕业生之黄金岁月" + "\n"
                        + "测试版上线了，赶紧下载体验吧" + "http://hxxxx.bmob.cn");
                startActivity(Intent.createChooser(toShare, "分享到"));
                break;
            case R.id.btn_top:
                //获取游戏玩家排行榜数据
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_main,
                                TopFragment.newInstance()).addToBackStack(null)
                        .commit();
                break;
            case R.id.btn_start:
//                if (isNetConnected()) {
//                    SpotManager.getInstance(getActivity()).showSplashSpotAds(getActivity(), GameActivity.class);
//                } else {
                startAnimActivity(GameActivity.class);
                getActivity().finish();
//                }
                break;
            case R.id.btn_replay:
                showReStartDialog();
                break;
            case R.id.btn_options:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_main,
                                SettingsFragment.newInstance()).addToBackStack(null)
                        .commit();
                break;
            case R.id.btn_help:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_main,
                                HelpFragment.newInstance()).addToBackStack(null)
                        .commit();
                break;
            case R.id.btn_ktplay:
                KTPlay.show();
                break;
            default:
                break;
        }
    }

    private void showExitDialog() {
        final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder
                .getInstance(getActivity());
        dialogBuilder.withTitle(R.string.exit_or_un)
                .withMessage(R.string.exit_or_un_0).isCancelable(true)
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
                dialogBuilder.closeDialog(dialogBuilder);
                getActivity().finish();
            }
        }).show();
    }

    private void showReStartDialog() {
        final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder
                .getInstance(getActivity());
        dialogBuilder.withTitle(R.string.restart_or_un)
                .withMessage(R.string.restart_or_un_0).isCancelable(true)
                .withDuration(500).withButtonCancle().withButtonOk().setCustomView(0, getActivity())
                .setButtonCancleClick(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogBuilder.getDismiss();
                    }
                }).setButtonOk(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilder.closeDialog(dialogBuilder);
                mSharedScoreUtil.cleanSharedPreference();
                mSharedSaveUtil.cleanSharedPreference();
                startAnimActivity(GameActivity.class);
                getActivity().finish();
            }
        }).show();
    }
}
