package com.xpple.graduates.ui.gameFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xpple.graduates.CustomApplication;
import com.xpple.graduates.R;
import com.xpple.graduates.util.SpScoreUtil;
import com.xpple.graduates.view.BaseFragment;

public class PositionFragment extends BaseFragment implements View.OnClickListener {
    @SuppressLint("StaticFieldLeak")
    private static PositionFragment instance = new PositionFragment();
    private View parentView;
    private ImageView btn_position_0, btn_position_1, btn_position_2, btn_position_3, btn_position_4, btn_position_5, btn_position_6, btn_position_7, btn_position_8, btn_position_9, btn_position_10, btn_position_11;
    private SpScoreUtil mSharedScoreUtil;
    private Integer mOldPositionIncome;

    public PositionFragment() {
    }

    public static PositionFragment newInstance() {
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_position, container, false);
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
        btn_position_0 = (ImageView) parentView.findViewById(R.id.btn_position_0);
        btn_position_1 = (ImageView) parentView.findViewById(R.id.btn_position_1);
        btn_position_2 = (ImageView) parentView.findViewById(R.id.btn_position_2);
        btn_position_3 = (ImageView) parentView.findViewById(R.id.btn_position_3);
        btn_position_4 = (ImageView) parentView.findViewById(R.id.btn_position_4);
        btn_position_5 = (ImageView) parentView.findViewById(R.id.btn_position_5);
        btn_position_6 = (ImageView) parentView.findViewById(R.id.btn_position_6);
        btn_position_7 = (ImageView) parentView.findViewById(R.id.btn_position_7);
        btn_position_8 = (ImageView) parentView.findViewById(R.id.btn_position_8);
        btn_position_9 = (ImageView) parentView.findViewById(R.id.btn_position_9);
        btn_position_10 = (ImageView) parentView.findViewById(R.id.btn_position_10);
        btn_position_11 = (ImageView) parentView.findViewById(R.id.btn_position_11);
        setListener();
    }

    private void setListener() {
        btn_position_0.setOnClickListener(this);
        btn_position_1.setOnClickListener(this);
        btn_position_2.setOnClickListener(this);
        btn_position_3.setOnClickListener(this);
        btn_position_4.setOnClickListener(this);
        btn_position_5.setOnClickListener(this);
        btn_position_6.setOnClickListener(this);
        btn_position_7.setOnClickListener(this);
        btn_position_8.setOnClickListener(this);
        btn_position_9.setOnClickListener(this);
        btn_position_10.setOnClickListener(this);
        btn_position_11.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSharedScoreUtil = mApplication.getSpScoreUtil();
        switch (mSharedScoreUtil.getPosition()) {
            case 0:
                mOldPositionIncome = 2200;
                break;
            case 1:
                mOldPositionIncome = 3300;
                break;
            case 2:
                mOldPositionIncome = 4400;
                break;
            case 3:
                mOldPositionIncome = 4400;
                break;
            case 4:
                mOldPositionIncome = 6600;
                break;
            case 5:
                mOldPositionIncome = 8800;
                break;
            case 6:
                mOldPositionIncome = 8800;
                break;
            case 7:
                mOldPositionIncome = 13200;
                break;
            case 8:
                mOldPositionIncome = 17600;
                break;
            case 9:
                mOldPositionIncome = 17600;
                break;
            case 10:
                mOldPositionIncome = 26400;
                break;
            case 11:
                mOldPositionIncome = 35200;
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        mSharedScoreUtil.setPosition(true);
        switch (v.getId()) {
            case R.id.btn_position_0:
                setValue(100, -500, 1, 1, 1, 1, 0, 2200);
                break;
            case R.id.btn_position_1:
                setValue(400, -1000, 2, 2, 2, 2, 1, 3300);
                break;
            case R.id.btn_position_2:
                setValue(800, -1500, 3, 3, 3, 3, 2, 4400);
                break;
            case R.id.btn_position_3:
                setValue(1000, -2000, 3, 3, 3, 3, 3, 4400);
                break;
            case R.id.btn_position_4:
                setValue(1500, -2500, 4, 4, 4, 4, 4, 6600);
                break;
            case R.id.btn_position_5:
                setValue(2000, -3000, 5, 5, 5, 5, 5, 8800);
                break;
            case R.id.btn_position_6:
                setValue(2500, -3500, 5, 5, 5, 5, 6, 8800);
                break;
            case R.id.btn_position_7:
                setValue(3000, -4000, 6, 6, 6, 6, 7, 13200);
                break;
            case R.id.btn_position_8:
                setValue(3500, -4500, 7, 7, 7, 7, 8, 17600);
                break;
            case R.id.btn_position_9:
                setValue(4000, -5000, 7, 7, 7, 7, 9, 17600);
                break;
            case R.id.btn_position_10:
                setValue(4500, -5500, 8, 8, 8, 8, 10, 26400);
                break;
            case R.id.btn_position_11:
                setValue(5000, -6000, 9, 9, 9, 9, 11, 35200);
                break;
            default:
                break;
        }
    }

    private void setValue(Integer value, Integer mMoneyValue, Integer mAbilityValue, Integer mExperienceValue,
                          Integer mHappyValue, Integer mCommunicationValue, Integer mPosition, Integer mIncome) {
        if (mSharedScoreUtil.getAbility() > value && mSharedScoreUtil.getExperience() > value) {
            CustomApplication.playSound(R.raw.appreciation);
            mSharedScoreUtil.setMoney(mMoneyValue);
            mSharedScoreUtil.setAbility(mAbilityValue);
            mSharedScoreUtil.setExperience(mExperienceValue);
            mSharedScoreUtil.setHappy(mHappyValue);
            mSharedScoreUtil.setCommunication(mCommunicationValue);
            mSharedScoreUtil.setPosition(mPosition);
            mSharedScoreUtil.setIncome(mIncome - mOldPositionIncome);
            showToast(R.string.position_su, true);
        } else {
            showToast(R.string.position_no_ae, false);
        }
        getActivity().getSupportFragmentManager().popBackStack();
    }
}
