package com.xpple.graduates.ui.mainFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xpple.graduates.CustomApplication;
import com.xpple.graduates.R;
import com.xpple.graduates.config.Config;
import com.xpple.graduates.util.SpSettingsUtil;
import com.xpple.graduates.view.BaseFragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DecimalFormat;

import c.b.BP;
import c.b.PListener;


public class SuggestFragment extends BaseFragment implements
        RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    @SuppressLint("StaticFieldLeak")
    private static SuggestFragment instance = new SuggestFragment();
    private View parentView;
    private SpSettingsUtil mSharedSettingsUtil;
    private EditText price;
    private ImageView go;
    private RadioGroup type;
    private RelativeLayout rl_switch_suggest;
    private ImageView iv_open_suggest, iv_close_suggest;
    private TextView tv_suggest;
    private Integer suggest_money;

    public SuggestFragment() {

    }

    public static SuggestFragment newInstance() {
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_suggest, container, false);
        setUpViews();
        return parentView;
    }

    private void setUpViews() {
        BP.init(getContext(), Config.BMOB_KEY);
        ImageView iv_back = (ImageView) parentView.findViewById(R.id.btn_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        price = (EditText) parentView.findViewById(R.id.price);
        go = (ImageView) parentView.findViewById(R.id.go);
        type = (RadioGroup) parentView.findViewById(R.id.type);
        rl_switch_suggest = (RelativeLayout) parentView.findViewById(R.id.rl_switch_suggest);
        iv_close_suggest = (ImageView) parentView.findViewById(R.id.iv_close_suggest);
        iv_open_suggest = (ImageView) parentView.findViewById(R.id.iv_open_suggest);
        tv_suggest = (TextView) parentView.findViewById(R.id.tv_suggest);
        setListener();
    }

    private void setListener() {
        rl_switch_suggest.setOnClickListener(this);
        type.setOnCheckedChangeListener(this);
        go.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSharedSettingsUtil = mApplication.getSpSettingsUtil();
        suggest_money = mSharedSettingsUtil.getUserSuggestMoney();
        boolean isUserSuggest = mSharedSettingsUtil.isUserSuggest();
        if (isUserSuggest) {
            iv_open_suggest.setVisibility(View.VISIBLE);
            iv_close_suggest.setVisibility(View.INVISIBLE);
        } else {
            iv_open_suggest.setVisibility(View.INVISIBLE);
            iv_close_suggest.setVisibility(View.VISIBLE);
        }

        DecimalFormat df = new DecimalFormat("0.00");
        String mSuggestMoney = df.format(suggest_money / 100);
        tv_suggest.setText(mSuggestMoney);

    }

    /**
     * 调用支付
     *
     * @param alipayOrWechatPay 支付类型，true为支付宝支付,false为微信支付
     */
    private void pay(final boolean alipayOrWechatPay, String descript, double price, Context mContext) {
        int pluginVersion = BP.getPluginVersion();
        int PLUGINVERSION = 7;
        if (pluginVersion < PLUGINVERSION && pluginVersion != 0) {// 为0说明未安装支付插件, 否则就是支付插件的版本低于官方最新版
            showToast("监测到您的支付安全控件不是最新版, 请先更新(无流量消耗)", true);
            installBmobPayPlugin("bp.db", mContext);
        }
        BP.ForceFree();
        BP.pay("打赏", descript, price, alipayOrWechatPay, new PListener() {

            // 因为网络等原因,支付结果未知(小概率事件),出于保险起见稍后手动查询
            @Override
            public void unknow() {
                showToast("打赏结果未知,请稍后手动查询", true);
            }

            // 支付成功,如果金额较大请手动查询确认
            @Override
            public void succeed() {
                showToast("打赏成功", true);
            }

            // 无论成功与否,返回订单号
            @Override
            public void orderId(String orderId) {
                // 此处应该保存订单号,比如保存进数据库等,以便以后查询
            }

            // 支付失败,原因可能是用户中断支付操作,也可能是网络原因
            @Override
            public void fail(int code, String reason) {
                // 当code为-2,意味着用户中断了操作
                // code为-3意味着没有安装BmobPlugin插件
                if (code == -3) {

                    installBmobPayPlugin("bp.db", getActivity());

                }
                showToast("打赏中斷", false);
                Log.e("xx", "打赏" + "'s pay status is fail, error code is " + code
                        + " ,reason is " + reason + "\n\n");
            }
        });
    }


    private void installBmobPayPlugin(String fileName, Context mContext) {
        try {
            InputStream is = mContext.getAssets().open(fileName);
            File file = new File(Environment.getExternalStorageDirectory()
                    + File.separator + fileName + ".apk");
            if (file.exists())
                file.delete();
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            byte[] temp = new byte[1024];
            int i;
            while ((i = is.read(temp)) > 0) {
                fos.write(temp, 0, i);
            }
            fos.close();
            is.close();

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.parse("file://" + file),
                    "application/vnd.android.package-archive");
            mContext.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 以下仅为控件操作，可以略过
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.alipay:
                // 以下仅为控件操作，可以略过
                go.setImageResource(R.mipmap.btn_zfbzz);
                break;
            case R.id.wxpay:
                // 以下仅为控件操作，可以略过
                go.setImageResource(R.mipmap.btn_wxzz);
                break;
            default:
                break;
        }
    }

    // 默认为0.1
    private double getPrice() {
        double price = 1;
        try {
            price = Double.parseDouble(this.price.getText().toString());
        } catch (NumberFormatException ignored) {
        }
        return price;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.go:
                // 当选择的是支付宝支付时
                if (type.getCheckedRadioButtonId() == R.id.alipay) {
                    pay(true, "打赏", getPrice(), getActivity());
                } else {
                    // 调用插件用微信支付
                    pay(false, "打赏", getPrice(), getActivity());
                }
                break;
            case R.id.rl_switch_suggest:
                CustomApplication.playSound(R.raw.button_1);
                if (suggest_money > 0) {
                    if (iv_open_suggest.getVisibility() == View.VISIBLE) {
                        iv_open_suggest.setVisibility(View.INVISIBLE);
                        iv_close_suggest.setVisibility(View.VISIBLE);
                        mSharedSettingsUtil.setUserSuggestEnable(false);
                    } else {
                        iv_open_suggest.setVisibility(View.VISIBLE);
                        iv_close_suggest.setVisibility(View.INVISIBLE);
                        mSharedSettingsUtil.setUserSuggestEnable(true);
                    }
                    onActivityCreated(null);
                } else {
                    showToast(R.string.suggest_0, true);
                }
                break;
        }
    }
}
