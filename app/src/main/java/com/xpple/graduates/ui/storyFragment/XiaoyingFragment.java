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

public class XiaoyingFragment extends BaseFragment implements View.OnClickListener {
    private static int[] xy_talk_0 = {R.string.xiaoying_0_00, R.string.xiaoying_0_01, R.string.xiaoying_0_02,
            R.string.xiaoying_0_03, R.string.xiaoying_0_04, R.string.xiaoying_0_05,
            R.string.xiaoying_0_06, R.string.xiaoying_0_07, R.string.xiaoying_0_08,
            R.string.xiaoying_0_09, R.string.xiaoying_0_10, R.string.xiaoying_0_11,
            R.string.xiaoying_0_12, R.string.xiaoying_0_13, R.string.xiaoying_0_14,
            R.string.xiaoying_0_15, R.string.xiaoying_0_16, R.string.xiaoying_0_17,
            R.string.xiaoying_0_18, R.string.xiaoying_0_19, R.string.xiaoying_0_20,
            R.string.xiaoying_0_21, R.string.xiaoying_0_22, R.string.xiaoying_0_23,
            R.string.xiaoying_0_24, R.string.xiaoying_0_25, R.string.xiaoying_0_26,
            R.string.xiaoying_0_27, R.string.xiaoying_0_28, R.string.xiaoying_0_29,
            R.string.xiaoying_0_30, R.string.xiaoying_0_31, R.string.xiaoying_0_32,
            R.string.xiaoying_0_33, R.string.xiaoying_0_34, R.string.xiaoying_0_35,
            R.string.xiaoying_0_36, R.string.xiaoying_0_37, R.string.xiaoying_0_38,
            R.string.xiaoying_0_39, R.string.xiaoying_0_40, R.string.xiaoying_0_41,
            R.string.xiaoying_0_42, R.string.xiaoying_0_43, R.string.xiaoying_0_44,
            R.string.xiaoying_0_45, R.string.xiaoying_0_46, R.string.xiaoying_0_47,
            R.string.xiaoying_0_48, R.string.xiaoying_0_49, R.string.xiaoying_0_50,
            R.string.xiaoying_0_51, R.string.xiaoying_0_52, R.string.xiaoying_0_53,
            R.string.xiaoying_0_54, R.string.xiaoying_0_55, R.string.xiaoying_0_56,
            R.string.xiaoying_0_57, R.string.xiaoying_0_58, R.string.xiaoying_0_59,
            R.string.xiaoying_0_60, R.string.xiaoying_0_61, R.string.xiaoying_0_62,
            R.string.xiaoying_0_63, R.string.xiaoying_0_64, R.string.xiaoying_0_65,
            R.string.xiaoying_0_66, R.string.xiaoying_0_67, R.string.xiaoying_0_68,
            R.string.xiaoying_0_69, R.string.xiaoying_0_70, R.string.xiaoying_0_71,
            R.string.xiaoying_0_72
    };
    @SuppressLint("StaticFieldLeak")
    private static XiaoyingFragment instance = new XiaoyingFragment();
    private View parentView;
    private ImageView iv_story;
    private TextView tv_talk;
    private RadioGroup rg_story;
    private RadioButton rb_yes, rb_no;
    private Integer mStroy, mStroyMax;
    private SpScoreUtil mSharedScoreUtil;

    public XiaoyingFragment() {
    }

    public static XiaoyingFragment newInstance() {
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
        mStroy = 0;
        mStroyMax = 100;
        tv_talk.setText(xy_talk_0[0]);
        iv_story.setBackgroundResource(R.mipmap.xy00);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_talk:
                mStroy++;
                if (mStroy <= mStroyMax) {
                    tv_talk.setText(xy_talk_0[mStroy]);
                } else {
                    startAnimActivity(GameActivity.class);
                    getActivity().finish();
                }
                switch (mStroy) {
                    case 15:
                        iv_story.setBackgroundResource(R.mipmap.xy01);
                        break;
                    case 32:
                        iv_story.setBackgroundResource(R.mipmap.xy02);
                        break;
                    case 55:
                        iv_story.setBackgroundResource(R.mipmap.xy03);
                        break;
                    case 60:
                        iv_story.setBackgroundResource(R.mipmap.xy04);
                        break;
                    case 62:
                        tv_talk.setClickable(false);
                        rb_yes.setText(xy_talk_0[63]);
                        rb_no.setText(xy_talk_0[64]);
                        rg_story.setVisibility(View.VISIBLE);
                        break;
                    case 64:
                        iv_story.setBackgroundResource(R.mipmap.xy05);
                        break;
                    case 65:
                        iv_story.setBackgroundResource(R.mipmap.xy06);
                        break;
                    case 72:
                        iv_story.setBackgroundResource(R.mipmap.xy07);
                        break;
                    default:
                        break;
                }

                break;
            case R.id.rb_yes:
                rg_story.setVisibility(View.GONE);
                tv_talk.setClickable(true);
                mStroy = 63;
                mStroyMax = 66;
                mSharedScoreUtil.setPartnerXy(91);
                break;
            case R.id.rb_no:
                rg_story.setVisibility(View.GONE);
                tv_talk.setClickable(true);
                mStroy = 67;
                mStroyMax = 72;
                mSharedScoreUtil.setPartnerXy(93);
                break;
            default:
                break;
        }
    }
}
