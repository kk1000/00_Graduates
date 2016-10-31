package com.xpple.graduates.ui.gameFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xpple.graduates.CustomApplication;
import com.xpple.graduates.R;
import com.xpple.graduates.ui.StroyActivity;
import com.xpple.graduates.util.SpScoreUtil;
import com.xpple.graduates.view.BaseFragment;


public class HouseFragment extends BaseFragment implements View.OnClickListener {
    @SuppressLint("StaticFieldLeak")
    private static HouseFragment instance = new HouseFragment();
    private View parentView;
    private ImageView iv_house;
    private TextView text_house, tv_house, tv_house_0, tv_house_1, tv_house_2, tv_house_3, tv_house_4, tv_house_5, tv_house_6, tv_house_7;
    private ImageView btn_house_0, btn_house_1, btn_house_2, btn_house_3, btn_house_4, btn_house_5, btn_house_6, btn_house_7;
    private SpScoreUtil mSharedScoreUtil;
    private Integer my_house;
    private Integer index_house;
    private Integer partner_xy;
    private Integer money_0, money_1, money_2, money_3, money_4, money_5, money_6, money_7;
    private int[] house_text = {R.string.text_house_00, R.string.text_house_01, R.string.text_house_02,
            R.string.text_house_03, R.string.text_house_04, R.string.text_house_05,
            R.string.text_house_06, R.string.text_house_07, R.string.text_house_08,
            R.string.text_house_09, R.string.text_house_10, R.string.text_house_11,
            R.string.text_house_12, R.string.text_house_13, R.string.text_house_14,
            R.string.text_house_15, R.string.text_house_16, R.string.text_house_17,
            R.string.text_house_18, R.string.text_house_19, R.string.text_house_20,
            R.string.text_house_21, R.string.text_house_22, R.string.text_house_23,
            R.string.text_house_24, R.string.text_house_25, R.string.text_house_26,
            R.string.text_house_27, R.string.text_house_28, R.string.text_house_29,
            R.string.text_house_30, R.string.text_house_31, R.string.text_house_32,
            R.string.text_house_33, R.string.text_house_34, R.string.text_house_35,
            R.string.text_house_36, R.string.text_house_37, R.string.text_house_38,
            R.string.text_house_39, R.string.text_house_40, R.string.text_house_41,
            R.string.text_house_42, R.string.text_house_43, R.string.text_house_44,
            R.string.text_house_45, R.string.text_house_46, R.string.text_house_47,
            R.string.text_house_48, R.string.text_house_49, R.string.text_house_50,
            R.string.text_house_51, R.string.text_house_52, R.string.text_house_53,
            R.string.text_house_54, R.string.text_house_55, R.string.text_house_56,
            R.string.text_house_57, R.string.text_house_58, R.string.text_house_59,
            R.string.text_house_60, R.string.text_house_61, R.string.text_house_62,
            R.string.text_house_63, R.string.text_house_64, R.string.text_house_65,
            R.string.text_house_66, R.string.text_house_67, R.string.text_house_68,
            R.string.text_house_69, R.string.text_house_70, R.string.text_house_71,
            R.string.text_house_72, R.string.text_house_73, R.string.text_house_74,
            R.string.text_house_75, R.string.text_house_76, R.string.text_house_77,
            R.string.text_house_78, R.string.text_house_79, R.string.text_house_80,
            R.string.text_house_81, R.string.text_house_82, R.string.text_house_83,
            R.string.text_house_84, R.string.text_house_85, R.string.text_house_86,
            R.string.text_house_87, R.string.text_house_88, R.string.text_house_89,
            R.string.text_house_90, R.string.text_house_91, R.string.text_house_92,
            R.string.text_house_93, R.string.text_house_94, R.string.text_house_95,
            R.string.text_house_96, R.string.text_house_97, R.string.text_house_98,
            R.string.text_house_99
    };

    public HouseFragment() {

    }

    public static HouseFragment newInstance() {
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_house, container, false);
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
        text_house = (TextView) parentView.findViewById(R.id.text_house);
        iv_house = (ImageView) parentView.findViewById(R.id.iv_house);
        tv_house = (TextView) parentView.findViewById(R.id.tv_index);
        tv_house_0 = (TextView) parentView.findViewById(R.id.tv_house_0);
        tv_house_1 = (TextView) parentView.findViewById(R.id.tv_house_1);
        tv_house_2 = (TextView) parentView.findViewById(R.id.tv_house_2);
        tv_house_3 = (TextView) parentView.findViewById(R.id.tv_house_3);
        tv_house_4 = (TextView) parentView.findViewById(R.id.tv_house_4);
        tv_house_5 = (TextView) parentView.findViewById(R.id.tv_house_5);
        tv_house_6 = (TextView) parentView.findViewById(R.id.tv_house_6);
        tv_house_7 = (TextView) parentView.findViewById(R.id.tv_house_7);
        btn_house_0 = (ImageView) parentView.findViewById(R.id.btn_house_0);
        btn_house_1 = (ImageView) parentView.findViewById(R.id.btn_house_1);
        btn_house_2 = (ImageView) parentView.findViewById(R.id.btn_house_2);
        btn_house_3 = (ImageView) parentView.findViewById(R.id.btn_house_3);
        btn_house_4 = (ImageView) parentView.findViewById(R.id.btn_house_4);
        btn_house_5 = (ImageView) parentView.findViewById(R.id.btn_house_5);
        btn_house_6 = (ImageView) parentView.findViewById(R.id.btn_house_6);
        btn_house_7 = (ImageView) parentView.findViewById(R.id.btn_house_7);
        setListener();
    }

    private void setListener() {
        iv_house.setOnClickListener(this);
        btn_house_0.setOnClickListener(this);
        btn_house_1.setOnClickListener(this);
        btn_house_2.setOnClickListener(this);
        btn_house_3.setOnClickListener(this);
        btn_house_4.setOnClickListener(this);
        btn_house_5.setOnClickListener(this);
        btn_house_6.setOnClickListener(this);
        btn_house_7.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSharedScoreUtil = mApplication.getSpScoreUtil();
        my_house = mSharedScoreUtil.getHouse();
        index_house = mSharedScoreUtil.getIndexHouse();
        partner_xy = mSharedScoreUtil.getPartnerXy();
        onViewShow(my_house);
    }

    private void onViewShow(Integer my_house) {
        if (partner_xy > 90) {
            iv_house.setImageResource(R.mipmap.house_3);
            text_house.setText(house_text[98]);
            if (partner_xy > 97) {
                partner_xy = 98;
            }
        } else {
            text_house.setText(house_text[0]);
        }
        switch (my_house) {
            case 0:
                btn_house_0.setVisibility(View.VISIBLE);
                btn_house_1.setVisibility(View.VISIBLE);
                btn_house_2.setVisibility(View.VISIBLE);
                btn_house_3.setVisibility(View.VISIBLE);
                btn_house_4.setVisibility(View.VISIBLE);
                btn_house_5.setVisibility(View.VISIBLE);
                btn_house_6.setVisibility(View.VISIBLE);
                btn_house_7.setVisibility(View.VISIBLE);
                break;
            case 1:
                btn_house_0.setVisibility(View.VISIBLE);
                btn_house_0.setImageResource(R.mipmap.btn_sale);
                break;
            case 2:
                btn_house_1.setVisibility(View.VISIBLE);
                btn_house_1.setImageResource(R.mipmap.btn_sale);
                break;
            case 3:
                btn_house_2.setVisibility(View.VISIBLE);
                btn_house_2.setImageResource(R.mipmap.btn_sale);
                break;
            case 4:
                btn_house_3.setVisibility(View.VISIBLE);
                btn_house_3.setImageResource(R.mipmap.btn_sale);
                break;
            case 5:
                btn_house_4.setVisibility(View.VISIBLE);
                btn_house_4.setImageResource(R.mipmap.btn_sale);
                break;
            case 6:
                btn_house_5.setVisibility(View.VISIBLE);
                btn_house_5.setImageResource(R.mipmap.btn_sale);
                break;
            case 7:
                btn_house_6.setVisibility(View.VISIBLE);
                btn_house_6.setImageResource(R.mipmap.btn_sale);
                break;
            case 8:
                btn_house_7.setVisibility(View.VISIBLE);
                btn_house_7.setImageResource(R.mipmap.btn_sale);
                break;
            default:
                break;
        }
        tv_house.setText("本月房价指数：" + (index_house) + "%");
        money_0 = (80000 * index_house) / 100;
        money_1 = (100000 * index_house) / 100;
        money_2 = (200000 * index_house) / 100;
        money_3 = (240000 * index_house) / 100;
        money_4 = (300000 * index_house) / 100;
        money_5 = (360000 * index_house) / 100;
        money_6 = (1500000 * index_house) / 100;
        money_7 = (3000000 * index_house) / 100;
        tv_house_0.setText("" + money_0);
        tv_house_1.setText("" + money_1);
        tv_house_2.setText("" + money_2);
        tv_house_3.setText("" + money_3);
        tv_house_4.setText("" + money_4);
        tv_house_5.setText("" + money_5);
        tv_house_6.setText("" + money_6);
        tv_house_7.setText("" + money_7);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_house:
                partner_xy++;
                text_house.setText(house_text[partner_xy]);
                switch (partner_xy) {
                    case 1:
                        iv_house.setImageResource(R.mipmap.house_1);
                        break;
                    case 4:
                        iv_house.setClickable(false);
                        break;
                    case 5:
                        iv_house.setImageResource(R.mipmap.house_2);
                        break;
                    case 8:
                        iv_house.setClickable(false);
                        break;
                    case 9:
                        iv_house.setImageResource(R.mipmap.house_1);
                        break;
                    case 12:
                        iv_house.setClickable(false);
                        break;
                    case 13:
                        iv_house.setImageResource(R.mipmap.house_2);
                        break;
                    case 15:
                        iv_house.setClickable(false);
                        break;
                    case 16:
                        iv_house.setImageResource(R.mipmap.house_2);
                        break;
                    case 19:
                        iv_house.setClickable(false);
                        break;
                    case 20:
                        iv_house.setImageResource(R.mipmap.house_0);
                        break;
                    case 21:
                        iv_house.setClickable(false);
                        break;
                    case 22:
                        iv_house.setImageResource(R.mipmap.house_1);
                        break;
                    case 23:
                        iv_house.setClickable(false);
                        break;
                    case 24:
                        iv_house.setImageResource(R.mipmap.house_2);
                        break;
                    case 26:
                        iv_house.setClickable(false);
                        break;
                    case 27:
                        iv_house.setImageResource(R.mipmap.house_2);
                        break;
                    case 28:
                        iv_house.setClickable(false);
                        break;
                    case 29:
                        iv_house.setImageResource(R.mipmap.house_2);
                        break;
                    case 30:
                        iv_house.setClickable(false);
                        break;
                    case 31:
                        iv_house.setImageResource(R.mipmap.house_0);
                        break;
                    case 33:
                        iv_house.setClickable(false);
                        break;
                    case 34:
                        iv_house.setImageResource(R.mipmap.house_1);
                        break;
                    case 35:
                        iv_house.setClickable(false);
                        break;
                    case 36:
                        iv_house.setImageResource(R.mipmap.house_1);
                        break;
                    case 38:
                        iv_house.setClickable(false);
                        break;
                    case 39:
                        iv_house.setImageResource(R.mipmap.house_2);
                        break;
                    case 40:
                        iv_house.setClickable(false);
                        break;
                    case 41:
                        iv_house.setImageResource(R.mipmap.house_2);
                        break;
                    case 43:
                        iv_house.setClickable(false);
                        break;
                    case 44:
                        iv_house.setImageResource(R.mipmap.house_0);
                        break;
                    case 45:
                        iv_house.setClickable(false);
                        break;
                    case 46:
                        iv_house.setImageResource(R.mipmap.house_1);
                        break;
                    case 48:
                        iv_house.setClickable(false);
                        break;
                    case 49:
                        iv_house.setImageResource(R.mipmap.house_2);
                        break;
                    case 50:
                        iv_house.setClickable(false);
                        break;
                    case 51:
                        iv_house.setImageResource(R.mipmap.house_0);
                        break;
                    case 53:
                        iv_house.setClickable(false);
                        break;
                    case 54:
                        iv_house.setImageResource(R.mipmap.house_0);
                        break;
                    case 55:
                        iv_house.setClickable(false);
                        break;
                    case 56:
                        iv_house.setImageResource(R.mipmap.house_0);
                        break;
                    case 57:
                        iv_house.setClickable(false);
                        break;
                    case 58:
                        iv_house.setImageResource(R.mipmap.house_1);
                        break;
                    case 59:
                        iv_house.setClickable(false);
                        break;
                    case 60:
                        iv_house.setImageResource(R.mipmap.house_0);
                        break;
                    case 61:
                        iv_house.setClickable(false);
                        break;
                    case 62:
                        iv_house.setImageResource(R.mipmap.house_0);
                        break;
                    case 63:
                        iv_house.setClickable(false);
                        break;
                    case 64:
                        iv_house.setImageResource(R.mipmap.house_1);
                        break;
                    case 65:
                        iv_house.setClickable(false);
                        break;
                    case 66:
                        iv_house.setImageResource(R.mipmap.house_0);
                        break;
                    case 67:
                        iv_house.setClickable(false);
                        break;
                    case 68:
                        iv_house.setImageResource(R.mipmap.house_0);
                        break;
                    case 69:
                        iv_house.setClickable(false);
                        break;
                    case 70:
                        iv_house.setImageResource(R.mipmap.house_1);
                        break;
                    case 71:
                        iv_house.setClickable(false);
                        break;
                    case 72:
                        iv_house.setImageResource(R.mipmap.house_2);
                        break;
                    case 73:
                        iv_house.setClickable(false);
                        break;
                    case 74:
                        iv_house.setImageResource(R.mipmap.house_2);
                        break;
                    case 75:
                        iv_house.setClickable(false);
                        break;
                    case 76:
                        iv_house.setImageResource(R.mipmap.house_1);
                        break;
                    case 78:
                        iv_house.setClickable(false);
                        break;
                    case 79:
                        iv_house.setImageResource(R.mipmap.house_2);
                        break;
                    case 82:
                        iv_house.setClickable(false);
                        break;
                    case 83:
                        iv_house.setImageResource(R.mipmap.house_1);
                        break;
                    case 86:
                        iv_house.setClickable(false);
                        break;
                    case 87:
                        iv_house.setImageResource(R.mipmap.house_2);
                        break;
                    case 90:
                        iv_house.setClickable(false);
                        mSharedScoreUtil.setPartnerStory(0);
                        startAnimActivity(StroyActivity.class);
                        getActivity().finish();
                        break;
                    case 92:
                        iv_house.setClickable(false);
                        partner_xy = 97;
                        break;
                    case 94:
                        iv_house.setClickable(false);
                        break;
                    case 97:
                        iv_house.setClickable(false);
                        break;
                    case 99:
                        iv_house.setClickable(false);
                        break;
                    default:
                        break;
                }
                mSharedScoreUtil.setPartnerXy(partner_xy);
                break;
            case R.id.btn_house_0:
                onBuyOrSell(1, money_0, 200, 5, 1);
                break;
            case R.id.btn_house_1:
                onBuyOrSell(2, money_1, 300, 5, 1);
                break;
            case R.id.btn_house_2:
                onBuyOrSell(3, money_2, 350, 5, 1);
                break;
            case R.id.btn_house_3:
                onBuyOrSell(4, money_3, 400, 8, 2);
                break;
            case R.id.btn_house_4:
                onBuyOrSell(5, money_4, 450, 8, 2);
                break;
            case R.id.btn_house_5:
                onBuyOrSell(6, money_5, 500, 8, 2);
                break;
            case R.id.btn_house_6:
                onBuyOrSell(7, money_6, 2000, 10, 3);
                break;
            case R.id.btn_house_7:
                onBuyOrSell(8, money_7, 4000, 15, 3);
                break;
            default:
                break;
        }
    }

    private void onBuyOrSell(Integer house, Integer money, Integer income, Integer value, Integer monthly) {
        CustomApplication.playSound(R.raw.money);
        Integer mMoney = mSharedScoreUtil.getMoney();
        if (my_house.equals(house)) {
            mSharedScoreUtil.setHouse(0);
            mSharedScoreUtil.setMoney(money);
            mSharedScoreUtil.setIncome(income);
            mSharedScoreUtil.setHappyMonthly(-monthly);
            getActivity().getSupportFragmentManager().popBackStack();
        } else {
            if (mMoney < money) {
                showToast(R.string.house_no_money, false);
            } else {
                mSharedScoreUtil.setHouse(house);
                mSharedScoreUtil.setMoney(-money);
                mSharedScoreUtil.setIncome(-income);
                mSharedScoreUtil.setAbility(value);
                mSharedScoreUtil.setExperience(value);
                mSharedScoreUtil.setHappy(value);
                mSharedScoreUtil.setHappyMonthly(monthly);
                getActivity().getSupportFragmentManager().popBackStack();
            }
        }
    }
}
