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
import com.xpple.graduates.view.NiftyDialogBuilder;

public class CarFragment extends BaseFragment implements View.OnClickListener {
    @SuppressLint("StaticFieldLeak")
    private static CarFragment instance = new CarFragment();
    private View parentView;
    private ImageView btn_car_0, btn_car_1, btn_car_2, btn_car_3, btn_car_4, iv_car_0, iv_car_1, iv_car_2, iv_car_3, iv_car_4;
    private SpScoreUtil mSharedScoreUtil;
    private Integer my_car;

    public CarFragment() {
    }

    public static CarFragment newInstance() {
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_car, container, false);
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
        btn_car_0 = (ImageView) parentView.findViewById(R.id.btn_car_0);
        btn_car_1 = (ImageView) parentView.findViewById(R.id.btn_car_1);
        btn_car_2 = (ImageView) parentView.findViewById(R.id.btn_car_2);
        btn_car_3 = (ImageView) parentView.findViewById(R.id.btn_car_3);
        btn_car_4 = (ImageView) parentView.findViewById(R.id.btn_car_4);
        iv_car_0 = (ImageView) parentView.findViewById(R.id.iv_car_0);
        iv_car_1 = (ImageView) parentView.findViewById(R.id.iv_car_1);
        iv_car_2 = (ImageView) parentView.findViewById(R.id.iv_car_2);
        iv_car_3 = (ImageView) parentView.findViewById(R.id.iv_car_3);
        iv_car_4 = (ImageView) parentView.findViewById(R.id.iv_car_4);
        setListener();
    }

    private void setListener() {
        btn_car_0.setOnClickListener(this);
        btn_car_1.setOnClickListener(this);
        btn_car_2.setOnClickListener(this);
        btn_car_3.setOnClickListener(this);
        btn_car_4.setOnClickListener(this);
        iv_car_0.setOnClickListener(this);
        iv_car_1.setOnClickListener(this);
        iv_car_2.setOnClickListener(this);
        iv_car_3.setOnClickListener(this);
        iv_car_4.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSharedScoreUtil = mApplication.getSpScoreUtil();
        my_car = mSharedScoreUtil.getCar();
        onViewShow(my_car);
    }

    private void onViewShow(Integer my_car) {
        btn_car_0.setVisibility(View.INVISIBLE);
        btn_car_1.setVisibility(View.INVISIBLE);
        btn_car_2.setVisibility(View.INVISIBLE);
        btn_car_3.setVisibility(View.INVISIBLE);
        btn_car_4.setVisibility(View.INVISIBLE);
        switch (my_car) {
            case 0:
                btn_car_0.setVisibility(View.VISIBLE);
                btn_car_1.setVisibility(View.VISIBLE);
                btn_car_2.setVisibility(View.VISIBLE);
                btn_car_3.setVisibility(View.VISIBLE);
                btn_car_4.setVisibility(View.VISIBLE);
                btn_car_0.setImageResource(R.mipmap.btn_buy);
                btn_car_1.setImageResource(R.mipmap.btn_buy);
                btn_car_2.setImageResource(R.mipmap.btn_buy);
                btn_car_3.setImageResource(R.mipmap.btn_buy);
                btn_car_4.setImageResource(R.mipmap.btn_buy);
                break;
            case 1:
                btn_car_0.setVisibility(View.VISIBLE);
                btn_car_0.setImageResource(R.mipmap.btn_sale);
                break;
            case 2:
                btn_car_1.setVisibility(View.VISIBLE);
                btn_car_1.setImageResource(R.mipmap.btn_sale);
                break;
            case 3:
                btn_car_2.setVisibility(View.VISIBLE);
                btn_car_2.setImageResource(R.mipmap.btn_sale);
                break;
            case 4:
                btn_car_3.setVisibility(View.VISIBLE);
                btn_car_3.setImageResource(R.mipmap.btn_sale);
                break;
            case 5:
                btn_car_4.setVisibility(View.VISIBLE);
                btn_car_4.setImageResource(R.mipmap.btn_sale);
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        mSharedScoreUtil.setCar(true);
        switch (v.getId()) {
            case R.id.btn_car_0:
                onBuyOrSell(1, 40000, 600, 10, 1);
                break;
            case R.id.btn_car_1:
                onBuyOrSell(2, 120000, 1000, 15, 2);
                break;
            case R.id.btn_car_2:
                onBuyOrSell(3, 350000, 1500, 20, 2);
                break;
            case R.id.btn_car_3:
                onBuyOrSell(4, 1600000, 3000, 30, 3);
                break;
            case R.id.btn_car_4:
                onBuyOrSell(5, 2500000, 4000, 40, 3);
                break;
            case R.id.iv_car_0:
                showBigImageViewDialog(R.mipmap.qc4);
                break;
            case R.id.iv_car_1:
                showBigImageViewDialog(R.mipmap.qc3);
                break;
            case R.id.iv_car_2:
                showBigImageViewDialog(R.mipmap.qc2);
                break;
            case R.id.iv_car_3:
                showBigImageViewDialog(R.mipmap.qc1);
                break;
            case R.id.iv_car_4:
                showBigImageViewDialog(R.mipmap.qc0);
                break;
            default:
                break;
        }
    }

    private void onBuyOrSell(Integer car, Integer money, Integer income, Integer value, Integer monthly) {
        CustomApplication.playSound(R.raw.money);
        Integer mMoney = mSharedScoreUtil.getMoney();
        if (my_car.equals(car)) {
            mSharedScoreUtil.setCar(0);
            mSharedScoreUtil.setMoney(+money / 2);
            mSharedScoreUtil.setIncome(income);
            mSharedScoreUtil.setCommunicationMonthly(-monthly);
        } else {
            if (mMoney < money) {
                showToast(R.string.car_no_money, false);
            } else {
                mSharedScoreUtil.setCar(car);
                mSharedScoreUtil.setMoney(-money);
                mSharedScoreUtil.setIncome(-income);
                mSharedScoreUtil.setAbility(value);
                mSharedScoreUtil.setExperience(value);
                mSharedScoreUtil.setHappy(value);
                mSharedScoreUtil.setCommunicationMonthly(monthly);
                getActivity().getSupportFragmentManager().popBackStack();
            }

        }
        onActivityCreated(null);
    }

    private void showBigImageViewDialog(int id) {
        final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder
                .getInstance(getActivity());
        dialogBuilder.isCancelable(true)
                .withDuration(500).withBigImageView(id)
                .setCustomView(0, getActivity())
                .show();

    }
}
