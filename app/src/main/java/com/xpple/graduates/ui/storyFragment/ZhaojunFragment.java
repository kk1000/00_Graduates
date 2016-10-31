package com.xpple.graduates.ui.storyFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.xpple.graduates.R;
import com.xpple.graduates.ui.GameActivity;
import com.xpple.graduates.util.SpScoreUtil;
import com.xpple.graduates.view.BaseFragment;

public class ZhaojunFragment extends BaseFragment implements View.OnClickListener {
    private static int[] zj_talk_0 = {R.string.zhaojun_0_00, R.string.zhaojun_0_01, R.string.zhaojun_0_02,
            R.string.zhaojun_0_03, R.string.zhaojun_0_04, R.string.zhaojun_0_05,
            R.string.zhaojun_0_06, R.string.zhaojun_0_07, R.string.zhaojun_0_08,
            R.string.zhaojun_0_09, R.string.zhaojun_0_10, R.string.zhaojun_0_11,
            R.string.zhaojun_0_12, R.string.zhaojun_0_13, R.string.zhaojun_0_14,
            R.string.zhaojun_0_15, R.string.zhaojun_0_16};
    private static int[] zj_talk_1 = {R.string.zhaojun_1_00, R.string.zhaojun_1_01, R.string.zhaojun_1_02,
            R.string.zhaojun_1_03, R.string.zhaojun_1_04, R.string.zhaojun_1_05,
            R.string.zhaojun_1_06, R.string.zhaojun_1_07, R.string.zhaojun_1_08,
            R.string.zhaojun_1_09, R.string.zhaojun_1_10, R.string.zhaojun_1_11,
            R.string.zhaojun_1_12, R.string.zhaojun_1_13, R.string.zhaojun_1_14,
            R.string.zhaojun_1_15, R.string.zhaojun_1_16, R.string.zhaojun_1_17,
            R.string.zhaojun_1_18, R.string.zhaojun_1_19, R.string.zhaojun_1_20,
            R.string.zhaojun_1_21, R.string.zhaojun_1_22, R.string.zhaojun_1_23,
            R.string.zhaojun_1_24, R.string.zhaojun_1_25, R.string.zhaojun_1_26,
            R.string.zhaojun_1_27, R.string.zhaojun_1_28, R.string.zhaojun_1_29,
            R.string.zhaojun_1_30, R.string.zhaojun_1_31, R.string.zhaojun_1_32,
            R.string.zhaojun_1_33, R.string.zhaojun_1_34, R.string.zhaojun_1_35,
            R.string.zhaojun_1_36, R.string.zhaojun_1_37, R.string.zhaojun_1_38,
            R.string.zhaojun_1_39,};
    private static int[] zj_talk_2 = {R.string.zhaojun_2_00, R.string.zhaojun_2_01, R.string.zhaojun_2_02,
            R.string.zhaojun_2_03, R.string.zhaojun_2_04, R.string.zhaojun_2_05,
            R.string.zhaojun_2_06, R.string.zhaojun_2_07, R.string.zhaojun_2_08,
            R.string.zhaojun_2_09, R.string.zhaojun_2_10, R.string.zhaojun_2_11,
            R.string.zhaojun_2_12, R.string.zhaojun_2_13, R.string.zhaojun_2_14,
            R.string.zhaojun_2_15, R.string.zhaojun_2_16, R.string.zhaojun_2_17,
            R.string.zhaojun_2_18, R.string.zhaojun_2_19, R.string.zhaojun_2_20,
            R.string.zhaojun_2_21, R.string.zhaojun_2_22, R.string.zhaojun_2_23,
            R.string.zhaojun_2_24, R.string.zhaojun_2_25, R.string.zhaojun_2_26,
            R.string.zhaojun_2_27, R.string.zhaojun_2_28, R.string.zhaojun_2_29,
            R.string.zhaojun_2_30, R.string.zhaojun_2_31, R.string.zhaojun_2_32,
            R.string.zhaojun_2_33, R.string.zhaojun_2_34, R.string.zhaojun_2_35,
            R.string.zhaojun_2_36, R.string.zhaojun_2_37, R.string.zhaojun_2_38,
            R.string.zhaojun_2_39, R.string.zhaojun_2_40, R.string.zhaojun_2_41,
            R.string.zhaojun_2_42, R.string.zhaojun_2_43, R.string.zhaojun_2_44,
            R.string.zhaojun_2_45, R.string.zhaojun_2_46, R.string.zhaojun_2_47,
            R.string.zhaojun_2_48, R.string.zhaojun_2_49, R.string.zhaojun_2_50,
            R.string.zhaojun_2_51, R.string.zhaojun_2_52, R.string.zhaojun_2_53,
            R.string.zhaojun_2_54, R.string.zhaojun_2_55, R.string.zhaojun_2_56,
            R.string.zhaojun_2_57, R.string.zhaojun_2_58, R.string.zhaojun_2_59,
            R.string.zhaojun_2_60, R.string.zhaojun_2_61, R.string.zhaojun_2_62,
            R.string.zhaojun_2_63, R.string.zhaojun_2_64, R.string.zhaojun_2_65,
            R.string.zhaojun_2_66, R.string.zhaojun_2_67, R.string.zhaojun_2_68,
            R.string.zhaojun_2_69, R.string.zhaojun_2_70, R.string.zhaojun_2_71,
            R.string.zhaojun_2_72, R.string.zhaojun_2_73, R.string.zhaojun_2_74
    };
    @SuppressLint("StaticFieldLeak")
    private static ZhaojunFragment instance = new ZhaojunFragment();
    private View parentView;
    private ImageView iv_story;
    private TextView tv_talk;
    private RadioGroup rg_story;
    private RadioButton rb_yes, rb_no;
    private Integer mStroy, mStroyMax;
    private SpScoreUtil mSharedScoreUtil;
    private Integer mPartnerStory;

    public ZhaojunFragment() {

    }

    public static ZhaojunFragment newInstance() {
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_story, container, false);
        setUpViews();
        return parentView;
    }

    private void setUpViews() {
        iv_story = (ImageView) parentView.findViewById(R.id.iv_story);
        tv_talk = (TextView) parentView.findViewById(R.id.tv_talk);
        rg_story = (RadioGroup) parentView.findViewById(R.id.rg_story);
        rb_yes = (RadioButton) parentView.findViewById(R.id.rb_yes);
        rb_no = (RadioButton) parentView.findViewById(R.id.rb_no);
        setListener();
    }

    private void setListener() {
        tv_talk.setOnClickListener(this);
        rb_yes.setOnClickListener(this);
        rb_no.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSharedScoreUtil = mApplication.getSpScoreUtil();
        mPartnerStory = mSharedScoreUtil.getPartnerStory();
        //说明：首先满足条件——女友是昭君，
        // 然后在计划安排时选择“参加学习培训”，可触发“女友情节：昭君?第一幕”；
        // 接下来（当月即可）选择“逛街购物吃饭”，可触发“女友情节：昭君?第二幕”；
        // 接下来（仍当月即可）选择“出门旅游度假”，可触发“女友情节：昭君?第三幕”。
        // 三个情节触发后，再后来我就没有发现第四幕了，知道的朋友帮下忙哈~~
        // Thank you！
        switch (mPartnerStory) {
            case 1:
                //第一幕
                mStroyMax = 16;
                tv_talk.setText(zj_talk_0[0]);
                iv_story.setBackgroundResource(R.mipmap.zj00);
                break;
            case 2:
                //第二幕
                mStroyMax = 39;
                tv_talk.setText(zj_talk_1[0]);
                iv_story.setBackgroundResource(R.mipmap.zj01);
                break;
            case 3:
                //第三幕
                mStroyMax = 74;
                tv_talk.setText(zj_talk_2[0]);
                iv_story.setBackgroundResource(R.mipmap.zj05);
                break;
            default:
                break;
        }
        mStroy = 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_talk:
                mStroy++;
                switch (mPartnerStory) {
                    case 1:
                        //第一幕
                        if (mStroy <= mStroyMax) {
                            tv_talk.setText(zj_talk_0[mStroy]);
                        } else {
                            mSharedScoreUtil.setPartnerZj(1);
                            startAnimActivity(GameActivity.class);
                            getActivity().finish();
                        }
                        break;
                    case 2:
                        //第二幕
                        if (mStroy <= mStroyMax) {
                            tv_talk.setText(zj_talk_1[mStroy]);
                        } else {
                            mSharedScoreUtil.setPartnerZj(2);
                            startAnimActivity(GameActivity.class);
                            getActivity().finish();
                        }

                        switch (mStroy) {
                            case 21:
                                iv_story.setBackgroundResource(R.mipmap.zj02);
                                break;
                            case 29:
                                iv_story.setBackgroundResource(R.mipmap.zj03);
                                break;
                            case 36:
                                iv_story.setBackgroundResource(R.mipmap.zj04);
                                break;
                            default:
                                break;
                        }
                        break;
                    case 3:
                        //第三幕
                        if (mStroy <= mStroyMax) {
                            tv_talk.setText(zj_talk_2[mStroy]);
                        } else {
                            startAnimActivity(GameActivity.class);
                            getActivity().finish();
                        }
                        switch (mStroy) {
                            case 12:
                                iv_story.setBackgroundResource(R.mipmap.zj06);
                                break;
                            case 20:
                                iv_story.setBackgroundResource(R.mipmap.zj07);
                                break;
                            case 34:
                                tv_talk.setClickable(false);
                                rb_yes.setText(zj_talk_2[35]);
                                rb_no.setText(zj_talk_2[45]);
                                rg_story.setVisibility(View.VISIBLE);
                                break;
                            case 36:
                                iv_story.setBackgroundResource(R.mipmap.zj12);
                                break;
                            case 40:
                                iv_story.setBackgroundResource(R.mipmap.zj13);
                                break;
                            case 44:
                                showToast("你和女友昭君的感情加深了，爱情机遇指数+2", true);
                                mSharedScoreUtil.setLove(2);
                                break;
                            case 47:
                                iv_story.setBackgroundResource(R.mipmap.zj09);
                                break;
                            case 51:
                                iv_story.setBackgroundResource(R.mipmap.zj10);
                                break;
                            case 60:
                                iv_story.setBackgroundResource(R.mipmap.zj11);
                                break;
                            case 74:
                                showToast("你和女友昭君分手了", false);
                                mSharedScoreUtil.setPartner(0);
                                //TODO:红娘会馆删除昭君信息
                                mSharedScoreUtil.setPartnerZj(3);
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;
            case R.id.rb_yes:
                rg_story.setVisibility(View.GONE);
                tv_talk.setClickable(true);
                mStroy = 35;
                mStroyMax = 44;
                break;
            case R.id.rb_no:
                rg_story.setVisibility(View.GONE);
                tv_talk.setClickable(true);
                mStroy = 45;
                mStroyMax = 74;
                break;
            default:
                break;
        }
    }
}
