package com.xpple.graduates.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;

import com.xpple.graduates.CustomApplication;
import com.xpple.graduates.util.CommonUtil;


/**
 * Activity基类
 *
 * @author nEdAy
 */
public class BaseActivity extends FragmentActivity {

    protected CustomApplication mApplication;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = CustomApplication.getInstance();
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
    }

    protected void startAnimActivity(Class<?> cla) {
        this.startActivity(new Intent(this, cla));
    }

    protected boolean isNetConnected() {
        return CommonUtil.isNetworkAvailable(this);
    }


}
