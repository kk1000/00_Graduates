package com.xpple.graduates.ui;

import android.content.Context;
import android.os.Bundle;

import com.ktplay.open.KTPlay;
import com.xpple.graduates.CustomApplication;
import com.xpple.graduates.R;
import com.xpple.graduates.view.BaseActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class OverActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over);
    }

    @Override
    protected void onStart() {
        super.onStart();
        CustomApplication.destroyMusic();
        CustomApplication.startMusic(1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        KTPlay.onResume(this);
        CustomApplication.resumeMusic(1);
    }


    @Override
    protected void onPause() {
        super.onPause();
        KTPlay.onPause(this);
        CustomApplication.pauseMusic();
    }

    @Override
    public void onBackPressed() {
        // 屏蔽Back
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}

