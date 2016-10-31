package com.xpple.graduates.ui.gameFragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.xpple.graduates.CustomApplication;
import com.xpple.graduates.R;
import com.xpple.graduates.util.SpScoreUtil;
import com.xpple.graduates.view.BaseFragment;
import com.xpple.graduates.view.FlakeView;

import java.util.Random;


public class LotteryFragment extends BaseFragment {
    @SuppressLint("StaticFieldLeak")
    private static LotteryFragment instance = new LotteryFragment();
    private View parentView;
    private ImageView btn_lottery;
    private SpScoreUtil mSharedScoreUtil;
    private Integer n;
    //金币掉落动画的主体动画
    private FlakeView flakeView;
    private PopupWindow pop;

    public LotteryFragment() {
    }

    public static LotteryFragment newInstance() {
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_lottery, container, false);
        setUpViews();
        return parentView;
    }

    private void setUpViews() {
        ImageView iv_back = (ImageView) parentView.findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        btn_lottery = (ImageView) parentView.findViewById(R.id.btn_lottery);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        flakeView = new FlakeView(getActivity());
        mSharedScoreUtil = mApplication.getSpScoreUtil();
        Random random = new Random();
        n = random.nextInt(1000) + 1;
        btn_lottery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSharedScoreUtil.setLottery(true);
                mSharedScoreUtil.setMoney(-100);
                if (n.equals(1)) {
                    CustomApplication.playSound(R.raw.lottery);
                    showPopWindows(btn_lottery, "一等奖", "5000000");

                } else if (n.equals(11) || n.equals(12)) {
                    CustomApplication.playSound(R.raw.lottery);
                    showPopWindows(btn_lottery, "二等奖", "500000");

                } else if (11 >= n && n <= 20) {
                    CustomApplication.playSound(R.raw.lottery);
                    showPopWindows(btn_lottery, "三等奖", "50000");

                } else {
                    CustomApplication.playSound(R.raw.money);
                    showToast("您本月没有中奖，欢迎下月再来~", false);
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });
    }

    private PopupWindow showPopWindows(View v, String lotteryStr, String moneyStr) {
        mSharedScoreUtil.setMoney(Integer.valueOf(moneyStr));
        getActivity().getSupportFragmentManager().popBackStack();
        View view = getActivity().getLayoutInflater().inflate(R.layout.view_login_reward, null);
        TextView tvTips = (TextView) view.findViewById(R.id.tv_tip);
        TextView money = (TextView) view.findViewById(R.id.tv_money);
        tvTips.setText("恭喜您中得" + lotteryStr + ",奖金" + moneyStr + ",请领取！");
        money.setText(moneyStr);
        final LinearLayout container = (LinearLayout) view.findViewById(R.id.container);
        //将flakeView 添加到布局中
        container.addView(flakeView);
        //设置背景
        getActivity().getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        //设置同时出现在屏幕上的金币数量  建议64以内 过多会引起卡顿
        flakeView.addFlakes(8);
        /**
         * 绘制的类型
         * @see View.LAYER_TYPE_HARDWARE
         * @see View.LAYER_TYPE_SOFTWARE
         * @see View.LAYER_TYPE_NONE
         */
        flakeView.setLayerType(View.LAYER_TYPE_NONE, null);
        view.findViewById(R.id.btn_ikow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                container.removeAllViews();
                pop.dismiss();
            }
        });
        pop = new PopupWindow(view, FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        ColorDrawable dw = new ColorDrawable(getResources().getColor(R.color.color_half_transparent));
        pop.setBackgroundDrawable(dw);
        pop.setOutsideTouchable(true);
        pop.setFocusable(true);
        pop.showAtLocation(v, Gravity.CENTER, 0, 0);
        MediaPlayer player = MediaPlayer.create(getActivity(), R.raw.shake);
        player.start();
        return pop;
    }
}
