package com.xpple.graduates.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.xpple.graduates.CustomApplication;
import com.xpple.graduates.R;
import com.xpple.graduates.ui.gameFragment.GameFragment;
import com.xpple.graduates.ui.gameFragment.StartFragmentA;
import com.xpple.graduates.util.SpScoreUtil;
import com.xpple.graduates.view.BaseActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class GameActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setUpFragment(savedInstanceState);
    }

    private void setUpFragment(Bundle savedInstanceState) {
        SpScoreUtil mSharedScoreUtil = mApplication.getSpScoreUtil();
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (mSharedScoreUtil.isScore()) {
                GameFragment fragment = new GameFragment();
                transaction.replace(R.id.fragment_game, fragment);
            } else {
                StartFragmentA fragment = new StartFragmentA();
                transaction.replace(R.id.fragment_game, fragment);
            }
            transaction.commit();
        }
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
        CustomApplication.resumeMusic(1);
    }


    @Override
    protected void onPause() {
        super.onPause();
        CustomApplication.pauseMusic();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
