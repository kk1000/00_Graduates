package com.xpple.graduates.ui.gameFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.xpple.graduates.R;
import com.xpple.graduates.util.SpScoreUtil;
import com.xpple.graduates.view.BaseFragment;


public class StockFragment extends BaseFragment implements View.OnClickListener {
    @SuppressLint("StaticFieldLeak")
    private static StockFragment instance = new StockFragment();
    private View parentView;
    private TextView tv_index, tv_money, tv_value, tv_rate;
    private ImageView iv_rate;
    private EditText et_buy, et_sell;
    private ImageView btn_buy, btn_sell;
    private SpScoreUtil mSharedScoreUtil;
    private Integer mMoney, mStock;

    public StockFragment() {
    }

    public static StockFragment newInstance() {
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_stock, container, false);
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
        tv_index = (TextView) parentView.findViewById(R.id.tv_index);
        tv_money = (TextView) parentView.findViewById(R.id.tv_money);
        tv_value = (TextView) parentView.findViewById(R.id.tv_value);
        tv_rate = (TextView) parentView.findViewById(R.id.tv_rate);
        iv_rate = (ImageView) parentView.findViewById(R.id.iv_rate);
        et_buy = (EditText) parentView.findViewById(R.id.et_buy);
        et_sell = (EditText) parentView.findViewById(R.id.et_sell);
        btn_buy = (ImageView) parentView.findViewById(R.id.btn_buy);
        btn_sell = (ImageView) parentView.findViewById(R.id.btn_sell);
        setListener();
    }

    private void setListener() {
        btn_buy.setOnClickListener(this);
        btn_sell.setOnClickListener(this);
        setRandom();
    }

    private void setRandom() {
        mSharedScoreUtil = mApplication.getSpScoreUtil();
        Integer RandomStock = mSharedScoreUtil.getRandomStock();
        Integer indexStock = mSharedScoreUtil.getIndexStock();
        tv_index.setText("" + indexStock);
        tv_rate.setText("" + (RandomStock - 100) + "%");
        if (RandomStock < 100) {
            iv_rate.setImageResource(R.mipmap.die);
        } else if (RandomStock > 100) {
            iv_rate.setImageResource(R.mipmap.zhang);
        } else {
            iv_rate.setImageResource(R.mipmap.ping);
        }
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMoney = mSharedScoreUtil.getMoney();
        mStock = mSharedScoreUtil.getStock();
        tv_money.setText("" + mMoney);
        tv_value.setText("" + mStock);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_buy:
                int mBuy = 0;
                if (!TextUtils.isEmpty(et_buy.getText())) {
                    mBuy = Integer.valueOf(et_buy.getText().toString());
                }
                if (mBuy > mMoney) {
                    showToast(R.string.stock_no_money, false);
                } else if (mBuy < 100) {
                    showToast(R.string.stock_min_money, false);
                } else {
                    mSharedScoreUtil.setMoney(-(int) (mBuy * 1.005));
                    mSharedScoreUtil.setStock(+mBuy);
                    onActivityCreated(null);
                }
                break;
            case R.id.btn_sell:
                int mSell = 0;
                if (!TextUtils.isEmpty(et_sell.getText())) {
                    mSell = Integer.valueOf(et_sell.getText().toString());
                }
                if (mSell > mStock) {
                    showToast(R.string.stock_no_stock, false);
                } else if (mSell < 100) {
                    showToast(R.string.stock_min_money, false);
                } else {
                    mSharedScoreUtil.setMoney(+(int) (mSell * 0.995));
                    mSharedScoreUtil.setStock(-mSell);
                    onActivityCreated(null);
                }
                break;
            default:
                break;
        }

    }
}
