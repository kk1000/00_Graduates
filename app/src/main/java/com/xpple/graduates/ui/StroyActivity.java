package com.xpple.graduates.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.xpple.graduates.CustomApplication;
import com.xpple.graduates.R;
import com.xpple.graduates.ui.storyFragment.ShiniangFragment;
import com.xpple.graduates.ui.storyFragment.XiaoyingFragment;
import com.xpple.graduates.ui.storyFragment.ZhaojunFragment;
import com.xpple.graduates.util.SpScoreUtil;
import com.xpple.graduates.view.BaseActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class StroyActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        setUpFragment(savedInstanceState);
    }

    private void setUpFragment(Bundle savedInstanceState) {
        SpScoreUtil mSharedScoreUtil = mApplication.getSpScoreUtil();
        Integer mPartnerStory = mSharedScoreUtil.getPartnerStory();
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (mPartnerStory.equals(0)) {//小樱
                XiaoyingFragment fragment = new XiaoyingFragment();
                transaction.replace(R.id.fragment_story, fragment);
            } else if (mPartnerStory.equals(1) || mPartnerStory.equals(2) || mPartnerStory.equals(3)) {//昭君
                ZhaojunFragment fragment = new ZhaojunFragment();
                transaction.replace(R.id.fragment_story, fragment);
            } else if (mPartnerStory.equals(4) || mPartnerStory.equals(5) || mPartnerStory.equals(6) || mPartnerStory.equals(7) || mPartnerStory.equals(8) || mPartnerStory.equals(9) || mPartnerStory.equals(10)) {//十娘
                ShiniangFragment fragment = new ShiniangFragment();
                transaction.replace(R.id.fragment_story, fragment);
            }
            transaction.commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        CustomApplication.destroyMusic();
        CustomApplication.startMusic(2);
//        CustomApplication.startMusic(mPartnerStory + 2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        CustomApplication.resumeMusic(2);
//        CustomApplication.resumeMusic(mPartnerStory + 2);
    }


    @Override
    protected void onPause() {
        super.onPause();
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

