package com.xpple.graduates.ui.gameFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.xpple.graduates.CustomApplication;
import com.xpple.graduates.R;
import com.xpple.graduates.util.SpScoreUtil;
import com.xpple.graduates.view.BaseFragment;

public class StartFragmentC extends BaseFragment {
    @SuppressLint("StaticFieldLeak")
    private static StartFragmentC instance = new StartFragmentC();
    private View parentView;
    private SpScoreUtil mSharedScoreUtil;
    private TextView tv_jtbg, tv_xgqx, tv_dxzy, tv_gzfx, tv_yxnd;
    private int jtbg, xgqx, dxzy, gzfx, yxnd;

    public StartFragmentC() {
    }

    public static StartFragmentC newInstance() {
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_start_c, container, false);
        setUpViews();
        return parentView;
    }

    private void setUpViews() {
        ImageView btn_go_game = (ImageView) parentView.findViewById(R.id.btn_go_game);
        btn_go_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playHeartbeatAnimation(v);
                setSharedUtil();
                startGame();
            }
        });

        tv_jtbg = (TextView) parentView.findViewById(R.id.tv_jtbg);
        RadioGroup rg_jtbg = (RadioGroup) parentView.findViewById(R.id.rg_jtbg);
        rg_jtbg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int rBId = arg0.getCheckedRadioButtonId();
                switch (rBId) {
                    case R.id.rb_jtbg_0:
                        jtbg = 0;
                        tv_jtbg.setText(R.string.jtbg_0);
                        break;
                    case R.id.rb_jtbg_1:
                        jtbg = 1;
                        tv_jtbg.setText(R.string.jtbg_1);
                        break;
                    case R.id.rb_jtbg_2:
                        jtbg = 2;
                        tv_jtbg.setText(R.string.jtbg_2);
                        break;
                    case R.id.rb_jtbg_3:
                        jtbg = 3;
                        tv_jtbg.setText(R.string.jtbg_3);
                        break;
                    default:
                        break;
                }
            }
        });
        tv_xgqx = (TextView) parentView.findViewById(R.id.tv_xgqx);
        RadioGroup rg_xgqx = (RadioGroup) parentView.findViewById(R.id.rg_xgqx);
        rg_xgqx.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int rBId = arg0.getCheckedRadioButtonId();
                switch (rBId) {
                    case R.id.rb_xgqx_0:
                        xgqx = 0;
                        tv_xgqx.setText(R.string.xgqx_0);
                        break;
                    case R.id.rb_xgqx_1:
                        xgqx = 1;
                        tv_xgqx.setText(R.string.xgqx_1);
                        break;
                    case R.id.rb_xgqx_2:
                        xgqx = 2;
                        tv_xgqx.setText(R.string.xgqx_2);
                        break;
                    case R.id.rb_xgqx_3:
                        xgqx = 3;
                        tv_xgqx.setText(R.string.xgqx_3);
                        break;
                    default:
                        break;
                }
            }
        });
        tv_dxzy = (TextView) parentView.findViewById(R.id.tv_dxzy);
        RadioGroup rg_dxzy = (RadioGroup) parentView.findViewById(R.id.rg_dxzy);
        rg_dxzy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int rBId = arg0.getCheckedRadioButtonId();
                switch (rBId) {
                    case R.id.rb_dxzy_0:
                        dxzy = 0;
                        tv_dxzy.setText(R.string.dxzy_0);
                        break;
                    case R.id.rb_dxzy_1:
                        dxzy = 1;
                        tv_dxzy.setText(R.string.dxzy_1);
                        break;
                    case R.id.rb_dxzy_2:
                        dxzy = 2;
                        tv_dxzy.setText(R.string.dxzy_2);
                        break;
                    case R.id.rb_dxzy_3:
                        dxzy = 3;
                        tv_dxzy.setText(R.string.dxzy_3);
                        break;
                    default:
                        break;
                }
            }
        });
        tv_gzfx = (TextView) parentView.findViewById(R.id.tv_gzfx);
        RadioGroup rg_gzfx = (RadioGroup) parentView.findViewById(R.id.rg_gzfx);
        rg_gzfx.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int rBId = arg0.getCheckedRadioButtonId();
                switch (rBId) {
                    case R.id.rb_gzfx_0:
                        gzfx = 0;
                        tv_gzfx.setText(R.string.gzfx_0);
                        break;
                    case R.id.rb_gzfx_1:
                        gzfx = 1;
                        tv_gzfx.setText(R.string.gzfx_1);
                        break;
                    case R.id.rb_gzfx_2:
                        gzfx = 2;
                        tv_gzfx.setText(R.string.gzfx_2);
                        break;
                    case R.id.rb_gzfx_3:
                        gzfx = 3;
                        tv_gzfx.setText(R.string.gzfx_3);
                        break;
                    default:
                        break;
                }
            }
        });
        tv_yxnd = (TextView) parentView.findViewById(R.id.tv_yxnd);
        RadioGroup rg_yxnd = (RadioGroup) parentView.findViewById(R.id.rg_yxnd);
        rg_yxnd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int rBId = arg0.getCheckedRadioButtonId();
                switch (rBId) {
                    case R.id.rb_yxnd_0:
                        yxnd = 0;
                        tv_yxnd.setText(R.string.yxnd_0);
                        break;
                    case R.id.rb_yxnd_1:
                        yxnd = 1;
                        tv_yxnd.setText(R.string.yxnd_1);
                        break;
                    case R.id.rb_yxnd_2:
                        yxnd = 2;
                        tv_yxnd.setText(R.string.yxnd_2);
                        break;
                    case R.id.rb_yxnd_3:
                        yxnd = 3;
                        tv_yxnd.setText(R.string.yxnd_3);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void startGame() {
        CustomApplication.playSound(R.raw.button_0);
        mSharedScoreUtil.setScore(true);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_game,
                        GameFragment.newInstance()).commit();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSharedScoreUtil = mApplication.getSpScoreUtil();
    }

    private void setSharedUtil() {
        switch (jtbg) {
            case 0:
                mSharedScoreUtil.setAbility(300);
                mSharedScoreUtil.setExperience(300);
                mSharedScoreUtil.setMorality(100);
                break;
            case 1:
                mSharedScoreUtil.setMoney(20000);
                mSharedScoreUtil.setHealthy(50);
                mSharedScoreUtil.setHappy(50);
                break;
            case 2:
                mSharedScoreUtil.setMoney(100000);
                mSharedScoreUtil.setCommunication(50);
                break;
            case 3:
                mSharedScoreUtil.setMoney(500000);
                mSharedScoreUtil.setPurity(-20);
                break;
            default:
                break;
        }
        switch (xgqx) {
            case 0:
                mSharedScoreUtil.setHealthy(50);
                mSharedScoreUtil.setHappy(50);
                break;
            case 1:
                mSharedScoreUtil.setCommunication(50);
                break;
            case 2:
                mSharedScoreUtil.setMorality(50);
                break;
            case 3:
                mSharedScoreUtil.setAbility(200);
                mSharedScoreUtil.setExperience(200);
                break;
            default:
                break;
        }
        switch (dxzy) {
            case 0:
                mSharedScoreUtil.setAbility(200);
                mSharedScoreUtil.setExperience(200);
                break;
            case 1:
                mSharedScoreUtil.setHappy(50);
                break;
            case 2:
                mSharedScoreUtil.setCommunication(50);
                break;
            case 3:
                mSharedScoreUtil.setHealthy(50);
                break;
            default:
                break;
        }
        switch (gzfx) {
            case 0:
                mSharedScoreUtil.setAbility(200);
                mSharedScoreUtil.setExperience(200);
                break;
            case 1:
                mSharedScoreUtil.setHappy(50);
                break;
            case 2:
                mSharedScoreUtil.setCommunication(50);
                break;
            case 3:
                mSharedScoreUtil.setCareer(1);
                break;
            default:
                break;
        }
        switch (yxnd) {
            case 0:
                mSharedScoreUtil.setPurity(0);
                break;
            case 1:
                mSharedScoreUtil.setCareer(1);
                mSharedScoreUtil.setLove(1);
                mSharedScoreUtil.setPurity(-10);
                break;
            case 2:
                mSharedScoreUtil.setMoney(1000000);
                mSharedScoreUtil.setAbility(1000);
                mSharedScoreUtil.setExperience(1000);
                mSharedScoreUtil.setHappy(200);
                mSharedScoreUtil.setMorality(200);
                mSharedScoreUtil.setCommunication(200);
                mSharedScoreUtil.setPurity(-40);
                break;
            case 3:
                mSharedScoreUtil.setMoney(9998000);
                mSharedScoreUtil.setAbility(4900);
                mSharedScoreUtil.setExperience(4900);
                mSharedScoreUtil.setHappy(800);
                mSharedScoreUtil.setMorality(800);
                mSharedScoreUtil.setCommunication(900);
                mSharedScoreUtil.setPurity(-100);
                break;
            default:
                break;
        }
    }
}
