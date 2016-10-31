package com.xpple.graduates.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.xpple.graduates.R;

public class CustomProgressDialog extends ProgressDialog {

    private AnimationDrawable mAnimation;
    private ImageView mImageView;
    private int mLoadingTip;
    private TextView mLoadingTv;

    public CustomProgressDialog(Context context, int content) {
        super(context);
        this.mLoadingTip = content;
        setCanceledOnTouchOutside(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        setContentView(R.layout.progress_dialog);
        mLoadingTv = (TextView) findViewById(R.id.loadingTv);
        mImageView = (ImageView) findViewById(R.id.loadingIv);
    }

    private void initData() {
        mImageView.setBackgroundResource(R.drawable.loading_frame);
        // 通过ImageView对象拿到背景显示的AnimationDrawable
        mAnimation = (AnimationDrawable) mImageView.getBackground();
        // 为了防止在onCreate方法中只显示第一帧的解决方案之一
        mImageView.post(new Runnable() {
            @Override
            public void run() {
                mAnimation.start();

            }
        });
        mLoadingTv.setText(mLoadingTip);
    }


}
