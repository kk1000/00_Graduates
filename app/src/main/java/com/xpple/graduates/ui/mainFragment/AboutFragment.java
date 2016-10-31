package com.xpple.graduates.ui.mainFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xpple.graduates.R;
import com.xpple.graduates.view.BaseFragment;


public class AboutFragment extends BaseFragment {

    @SuppressLint("StaticFieldLeak")
    private static AboutFragment instance = new AboutFragment();

    public AboutFragment() {
    }

    public static AboutFragment newInstance() {
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_about, container, false);
        ImageView iv_back = (ImageView) parentView.findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        return parentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        SpSettingsUtil mSharedSettingsUtil = mApplication.getSpSettingsUtil();
//        boolean isUserSuggest = mSharedSettingsUtil.isUserSuggest();
//        if (!isUserSuggest) {
//            // 设置插屏竖屏展示与展示动画设置
//            SpotManager.getInstance(getActivity()).setSpotOrientation(
//                    SpotManager.ORIENTATION_PORTRAIT);
//            // 插屏广告展示测试
//            SpotManager.getInstance(getActivity()).showSpotAds(getActivity());
//        }
    }


}
