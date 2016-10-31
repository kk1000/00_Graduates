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

public class ShiniangFragment extends BaseFragment implements View.OnClickListener {
    private static int[] sn_talk_0 = {R.string.shiniang_0_00, R.string.shiniang_0_01, R.string.shiniang_0_02,
            R.string.shiniang_0_03, R.string.shiniang_0_04, R.string.shiniang_0_05,
            R.string.shiniang_0_06, R.string.shiniang_0_07, R.string.shiniang_0_08,
            R.string.shiniang_0_09, R.string.shiniang_0_10, R.string.shiniang_0_11,
            R.string.shiniang_0_12, R.string.shiniang_0_13, R.string.shiniang_0_14,
            R.string.shiniang_0_15, R.string.shiniang_0_16, R.string.shiniang_0_17,
            R.string.shiniang_0_18, R.string.shiniang_0_19, R.string.shiniang_0_20};
    private static int[] sn_talk_1 = {R.string.shiniang_1_00, R.string.shiniang_1_01, R.string.shiniang_1_02,
            R.string.shiniang_1_03, R.string.shiniang_1_04, R.string.shiniang_1_05,
            R.string.shiniang_1_06, R.string.shiniang_1_07, R.string.shiniang_1_08,
            R.string.shiniang_1_09, R.string.shiniang_1_10, R.string.shiniang_1_11,
            R.string.shiniang_1_12, R.string.shiniang_1_13, R.string.shiniang_1_14,
            R.string.shiniang_1_15, R.string.shiniang_1_16, R.string.shiniang_1_17,
            R.string.shiniang_1_18};
    private static int[] sn_talk_2 = {R.string.shiniang_2_00, R.string.shiniang_2_01, R.string.shiniang_2_02,
            R.string.shiniang_2_03, R.string.shiniang_2_04, R.string.shiniang_2_05,
            R.string.shiniang_2_06, R.string.shiniang_2_07, R.string.shiniang_2_08,
            R.string.shiniang_2_09, R.string.shiniang_2_10, R.string.shiniang_2_11,
            R.string.shiniang_2_12, R.string.shiniang_2_13, R.string.shiniang_2_14,
            R.string.shiniang_2_15, R.string.shiniang_2_16, R.string.shiniang_2_17,
            R.string.shiniang_2_18, R.string.shiniang_2_19, R.string.shiniang_2_20,
            R.string.shiniang_2_21, R.string.shiniang_2_22, R.string.shiniang_2_23,
            R.string.shiniang_2_24, R.string.shiniang_2_25, R.string.shiniang_2_26,
            R.string.shiniang_2_27, R.string.shiniang_2_28};
    private static int[] sn_talk_3 = {R.string.shiniang_3_00, R.string.shiniang_3_01, R.string.shiniang_3_02,
            R.string.shiniang_3_03, R.string.shiniang_3_04, R.string.shiniang_3_05,
            R.string.shiniang_3_06, R.string.shiniang_3_07, R.string.shiniang_3_08,
            R.string.shiniang_3_09, R.string.shiniang_3_10, R.string.shiniang_3_11,
            R.string.shiniang_3_12, R.string.shiniang_3_13, R.string.shiniang_3_14,
            R.string.shiniang_3_15, R.string.shiniang_3_16, R.string.shiniang_3_17};
    private static int[] sn_talk_4 = {R.string.shiniang_4_00, R.string.shiniang_4_01, R.string.shiniang_4_02,
            R.string.shiniang_4_03, R.string.shiniang_4_04, R.string.shiniang_4_05,
            R.string.shiniang_4_06, R.string.shiniang_4_07, R.string.shiniang_4_08,
            R.string.shiniang_4_09, R.string.shiniang_4_10, R.string.shiniang_4_11,
            R.string.shiniang_4_12, R.string.shiniang_4_13, R.string.shiniang_4_14};
    private static int[] sn_talk_5_a = {R.string.shiniang_5_a_00, R.string.shiniang_5_a_01, R.string.shiniang_5_a_02,
            R.string.shiniang_5_a_03, R.string.shiniang_5_a_04, R.string.shiniang_5_a_05,
            R.string.shiniang_5_a_06, R.string.shiniang_5_a_07, R.string.shiniang_5_a_08,
            R.string.shiniang_5_a_09, R.string.shiniang_5_a_10, R.string.shiniang_5_a_11,
            R.string.shiniang_5_a_12, R.string.shiniang_5_a_13, R.string.shiniang_5_a_14,
            R.string.shiniang_5_a_15, R.string.shiniang_5_a_16, R.string.shiniang_5_a_17,
            R.string.shiniang_5_a_18, R.string.shiniang_5_a_19, R.string.shiniang_5_a_20,
            R.string.shiniang_5_a_21, R.string.shiniang_5_a_22, R.string.shiniang_5_a_23,
            R.string.shiniang_5_a_24, R.string.shiniang_5_a_25, R.string.shiniang_5_a_26,
            R.string.shiniang_5_a_27, R.string.shiniang_5_a_28, R.string.shiniang_5_a_29,
            R.string.shiniang_5_a_30};
    private static int[] sn_talk_5_b = {R.string.shiniang_5_b_00, R.string.shiniang_5_b_01, R.string.shiniang_5_b_02,
            R.string.shiniang_5_b_03, R.string.shiniang_5_b_04, R.string.shiniang_5_b_05,
            R.string.shiniang_5_b_06, R.string.shiniang_5_b_07, R.string.shiniang_5_b_08,
            R.string.shiniang_5_b_09, R.string.shiniang_5_b_10, R.string.shiniang_5_b_11,
            R.string.shiniang_5_b_12, R.string.shiniang_5_b_13, R.string.shiniang_5_b_14,
            R.string.shiniang_5_b_15, R.string.shiniang_5_b_16, R.string.shiniang_5_b_17,
            R.string.shiniang_5_b_18, R.string.shiniang_5_b_19, R.string.shiniang_5_b_20,
            R.string.shiniang_5_b_21, R.string.shiniang_5_b_22, R.string.shiniang_5_b_23,
            R.string.shiniang_5_b_24, R.string.shiniang_5_b_25, R.string.shiniang_5_b_26,
            R.string.shiniang_5_b_27, R.string.shiniang_5_b_28, R.string.shiniang_5_b_29,
            R.string.shiniang_5_b_30, R.string.shiniang_5_b_31, R.string.shiniang_5_b_32,
            R.string.shiniang_5_b_33, R.string.shiniang_5_b_34, R.string.shiniang_5_b_35,
            R.string.shiniang_5_b_36, R.string.shiniang_5_b_37, R.string.shiniang_5_b_38,
            R.string.shiniang_5_b_39, R.string.shiniang_5_b_40, R.string.shiniang_5_b_41,
            R.string.shiniang_5_b_42, R.string.shiniang_5_b_43, R.string.shiniang_5_b_44,
            R.string.shiniang_5_b_45, R.string.shiniang_5_b_46, R.string.shiniang_5_b_47,
            R.string.shiniang_5_b_48
    };
    @SuppressLint("StaticFieldLeak")
    private static ShiniangFragment instance = new ShiniangFragment();
    private View parentView;
    private ImageView iv_story;
    private TextView tv_talk;
    private RadioGroup rg_story;
    private RadioButton rb_yes, rb_no;
    private Integer mStroy, mStroyMax;
    private SpScoreUtil mSharedScoreUtil;
    private Integer mPartnerStory;

    public ShiniangFragment() {

    }

    public static ShiniangFragment newInstance() {
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
        //如果你的女友是十娘在你28岁时开始会有剧情，注意如果剩余时间不够24个月将无法触发十娘的所有剧情。
        //第二幕在四个月后
        //第三幕在四个月后
        //第四幕在四个月后
        //第五幕在四个月后
        //第六幕A在六个月后
        //第六幕B在六个月后
        switch (mPartnerStory) {
            case 4:
                //第一幕
                mStroyMax = 20;
                tv_talk.setText(sn_talk_0[0]);
                iv_story.setBackgroundResource(R.mipmap.sn00);
                break;
            case 5:
                //第二幕
                mStroyMax = 18;
                tv_talk.setText(sn_talk_1[0]);
                iv_story.setBackgroundResource(R.mipmap.sn02);
                break;
            case 6:
                //第三幕
                mStroyMax = 28;
                tv_talk.setText(sn_talk_2[0]);
                iv_story.setBackgroundResource(R.mipmap.sn04);
                break;
            case 7:
                //第四幕
                mStroyMax = 17;
                tv_talk.setText(sn_talk_3[0]);
                iv_story.setBackgroundResource(R.mipmap.sn06);
                break;
            case 8:
                //第五幕
                mStroyMax = 14;
                tv_talk.setText(sn_talk_4[0]);
                iv_story.setBackgroundResource(R.mipmap.sn09);
                break;
            case 9:
                //第六幕--A
                mStroyMax = 30;
                tv_talk.setText(sn_talk_5_a[0]);
                iv_story.setBackgroundResource(R.mipmap.sn12);

                break;
            case 10:
                //第六幕--B
                mStroyMax = 48;
                tv_talk.setText(sn_talk_5_b[0]);
                iv_story.setBackgroundResource(R.mipmap.sn14);
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
                    case 4:
                        //第一幕
                        if (mStroy <= mStroyMax) {
                            tv_talk.setText(sn_talk_0[mStroy]);
                        } else {
                            mSharedScoreUtil.setPartnerSn(1);
                            mSharedScoreUtil.setPartnerSnTime(0);
                            startAnimActivity(GameActivity.class);
                            getActivity().finish();
                        }
                        switch (mStroy) {
                            case 6:
                                iv_story.setBackgroundResource(R.mipmap.sn01);
                                break;
                            default:
                                break;
                        }
                        break;
                    case 5:
                        //第二幕
                        if (mStroy <= mStroyMax) {
                            tv_talk.setText(sn_talk_1[mStroy]);
                        } else {
                            mSharedScoreUtil.setPartnerSn(2);
                            mSharedScoreUtil.setPartnerSnTime(0);
                            startAnimActivity(GameActivity.class);
                            getActivity().finish();
                        }
                        switch (mStroy) {
                            case 5:
                                iv_story.setBackgroundResource(R.mipmap.sn03);
                                break;
                            default:
                                break;
                        }
                        break;
                    case 6:
                        //第三幕
                        if (mStroy <= mStroyMax) {
                            tv_talk.setText(sn_talk_2[mStroy]);
                        } else {
                            mSharedScoreUtil.setPartnerSn(3);
                            mSharedScoreUtil.setPartnerSnTime(0);
                            startAnimActivity(GameActivity.class);
                            getActivity().finish();
                        }
                        switch (mStroy) {
                            case 4:
                                iv_story.setBackgroundResource(R.mipmap.sn05);
                                break;
                            default:
                                break;
                        }
                        break;
                    case 7:
                        //第四幕
                        if (mStroy <= mStroyMax) {
                            tv_talk.setText(sn_talk_3[mStroy]);
                        } else {
                            mSharedScoreUtil.setPartnerSn(4);
                            mSharedScoreUtil.setPartnerSnTime(0);
                            startAnimActivity(GameActivity.class);
                            getActivity().finish();
                        }
                        switch (mStroy) {
                            case 4:
                                iv_story.setBackgroundResource(R.mipmap.sn07);
                                break;
                            default:
                                break;
                        }
                        break;
                    case 8:
                        //第五幕
                        if (mStroy <= mStroyMax) {
                            tv_talk.setText(sn_talk_3[mStroy]);
                        } else {
                            mSharedScoreUtil.setPartnerSnTime(0);
                            startAnimActivity(GameActivity.class);
                            getActivity().finish();
                        }
                        switch (mStroy) {
                            case 4:
                                iv_story.setBackgroundResource(R.mipmap.sn10);
                                break;
                            case 7:
                                iv_story.setBackgroundResource(R.mipmap.sn11);
                                break;
                            case 12:
                                tv_talk.setClickable(false);
                                rb_yes.setText(sn_talk_4[13]);
                                rb_no.setText(sn_talk_4[14]);
                                rg_story.setVisibility(View.VISIBLE);
                                break;
                            default:
                                break;
                        }
                        break;
                    case 9:
                        //第六幕--A
                        if (mStroy <= mStroyMax) {
                            tv_talk.setText(sn_talk_5_a[mStroy]);
                        } else {
                            startAnimActivity(GameActivity.class);
                            getActivity().finish();
                        }
                        switch (mStroy) {
                            case 6:
                                mSharedScoreUtil.setAbility(500);
                                mSharedScoreUtil.setExperience(500);
                                mSharedScoreUtil.setHappy(100);
                                mSharedScoreUtil.setMoney(100000);
                                break;
                            case 13:
                                iv_story.setBackgroundResource(R.mipmap.sn13);
                                break;
                            case 30:
                                showToast("你和女友十娘的感情加深了，爱情机遇指数+2", true);
                                mSharedScoreUtil.setLove(2);
                                break;
                            default:
                                break;
                        }
                        break;
                    case 10:
                        //第六幕--B
                        if (mStroy <= mStroyMax) {
                            tv_talk.setText(sn_talk_5_b[mStroy]);
                        } else {
                            startAnimActivity(GameActivity.class);
                            getActivity().finish();
                        }
                        switch (mStroy) {
                            case 3:
                                iv_story.setBackgroundResource(R.mipmap.sn19);
                                break;
                            case 5:
                                iv_story.setBackgroundResource(R.mipmap.sn18);
                                break;
                            case 8:
                                iv_story.setBackgroundResource(R.mipmap.sn08);
                                break;
                            case 14:
                                iv_story.setBackgroundResource(R.mipmap.sn15);
                                break;
                            case 16:
                                iv_story.setBackgroundResource(R.mipmap.sn16);
                                break;
                            case 22:
                                iv_story.setBackgroundResource(R.mipmap.sn17);
                                break;
                            case 74:
                                showToast("你和女友十娘分手了", false);
                                mSharedScoreUtil.setPartner(0);
                                //TODO:红娘会馆删除十娘信息
                                mSharedScoreUtil.setPartnerSn(7);
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
                mStroy = 14;
                //TODO：yes
                mSharedScoreUtil.setPartnerSn(5);
                break;
            case R.id.rb_no:
                rg_story.setVisibility(View.GONE);
                tv_talk.setClickable(true);
                mStroy = 14;
                //TODO：no
                mSharedScoreUtil.setPartnerSn(6);
                break;
            default:
                break;
        }
    }
}
