package com.xpple.graduates.ui.gameFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.xpple.graduates.CustomApplication;
import com.xpple.graduates.R;
import com.xpple.graduates.view.BaseFragment;
import com.xpple.graduates.view.NiftyDialogBuilder;

public class StartFragmentB extends BaseFragment implements View.OnClickListener {
    @SuppressLint("StaticFieldLeak")
    private static StartFragmentB instance = new StartFragmentB();
    private View parentView;

    public StartFragmentB() {
    }

    public static StartFragmentB newInstance() {
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_start_b, container, false);
        setUpViews();
        return parentView;
    }

    private void setUpViews() {
        ImageView btn_forward = (ImageView) parentView.findViewById(R.id.btn_forward);
        Button rb_start_0 = (Button) parentView.findViewById(R.id.rb_start_0);
        Button rb_start_1 = (Button) parentView.findViewById(R.id.rb_start_1);
        Button rb_start_2 = (Button) parentView.findViewById(R.id.rb_start_2);
        Button rb_start_3 = (Button) parentView.findViewById(R.id.rb_start_3);
        Button rb_start_4 = (Button) parentView.findViewById(R.id.rb_start_4);
        btn_forward.setOnClickListener(this);
        rb_start_0.setOnClickListener(this);
        rb_start_1.setOnClickListener(this);
        rb_start_2.setOnClickListener(this);
        rb_start_3.setOnClickListener(this);
        rb_start_4.setOnClickListener(this);
    }

    private void nextStart() {
        CustomApplication.playSound(R.raw.button_0);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_game,
                        StartFragmentC.newInstance()).addToBackStack(null)
                .commit();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void showImageChooseViewDialog(int title, int message, int iv,
                                           final Button1onClickListener Button1onClickListener, final Button2onClickListener Button2onClickListener) {
        final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder
                .getInstance(getActivity());
        dialogBuilder.withTitle(title)
                .withMessage(message).withImageView(iv).isCancelable(true)
                .withDuration(500).withButtonCancle().withButtonOk()
                .setCustomView(0, getActivity())
                .setButtonCancleClick(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button1onClickListener.onClick();
                        dialogBuilder.closeDialog(dialogBuilder);
                    }
                })
                .setButtonOk(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button2onClickListener.onClick();
                        dialogBuilder.closeDialog(dialogBuilder);
                    }
                }).show();
    }

    private void showTextViewDialog(int title, int message, final Button2onClickListener Button2onClickListener) {
        final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder
                .getInstance(getActivity());
        dialogBuilder.withTitle(title)
                .withMessage(message).isCancelable(false)
                .withDuration(500).withButtonOk()
                .setCustomView(0, getActivity())
                .setButtonOk(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogBuilder.closeDialog(dialogBuilder);
                        Button2onClickListener.onClick();
                    }
                }).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_forward:
                nextStart();
                break;
            case R.id.rb_start_0:
                showImageChooseViewDialog(R.string.start_b_0, R.string.start_b_0_0, R.mipmap.zgz, new Button1onClickListener() {
                    @Override
                    public void onClick() {
                        // TODO Auto-generated method stub
                    }
                }, new Button2onClickListener() {
                    @Override
                    public void onClick() {
                        // TODO Auto-generated method stub
                        showTextViewDialog(R.string.start_b_0, R.string.start_b_0_1, new Button2onClickListener() {
                            @Override
                            public void onClick() {
                                // TODO Auto-generated method stub
                                nextStart();
                            }
                        });
                    }
                });
                break;
            case R.id.rb_start_1:
                showImageChooseViewDialog(R.string.start_b_1, R.string.start_b_1_0, R.mipmap.zjcy, new Button1onClickListener() {
                    @Override
                    public void onClick() {
                        // TODO Auto-generated method stub
                    }
                }, new Button2onClickListener() {
                    @Override
                    public void onClick() {
                        // TODO Auto-generated method stub
                        showTextViewDialog(R.string.start_b_1, R.string.start_b_1_1, new Button2onClickListener() {
                            @Override
                            public void onClick() {
                                // TODO Auto-generated method stub
                            }
                        });
                    }
                });
                break;
            case R.id.rb_start_2:
                showImageChooseViewDialog(R.string.start_b_2, R.string.start_b_2_0, R.mipmap.ky, new Button1onClickListener() {
                    @Override
                    public void onClick() {
                        // TODO Auto-generated method stub
                    }
                }, new Button2onClickListener() {
                    @Override
                    public void onClick() {
                        // TODO Auto-generated method stub
                        showTextViewDialog(R.string.start_b_2, R.string.start_b_2_1, new Button2onClickListener() {
                            @Override
                            public void onClick() {
                                // TODO Auto-generated method stub
                            }
                        });
                    }
                });
                break;
            case R.id.rb_start_3:
                showImageChooseViewDialog(R.string.start_b_3, R.string.start_b_3_0, R.mipmap.gwy, new Button1onClickListener() {
                    @Override
                    public void onClick() {
                        // TODO Auto-generated method stub
                    }
                }, new Button2onClickListener() {
                    @Override
                    public void onClick() {
                        // TODO Auto-generated method stub
                        showTextViewDialog(R.string.start_b_3, R.string.start_b_3_1, new Button2onClickListener() {
                            @Override
                            public void onClick() {
                                // TODO Auto-generated method stub
                            }
                        });
                    }
                });
                break;
            case R.id.rb_start_4:
                showImageChooseViewDialog(R.string.start_b_4, R.string.start_b_4_0, R.mipmap.cg, new Button1onClickListener() {
                    @Override
                    public void onClick() {
                        // TODO Auto-generated method stub
                    }
                }, new Button2onClickListener() {
                    @Override
                    public void onClick() {
                        // TODO Auto-generated method stub
                        showTextViewDialog(R.string.start_b_4, R.string.start_b_4_1, new Button2onClickListener() {
                            @Override
                            public void onClick() {
                                // TODO Auto-generated method stub
                            }
                        });
                    }
                });
                break;
            default:
                break;
        }
    }


    private interface Button1onClickListener {
        void onClick();
    }

    private interface Button2onClickListener {
        void onClick();
    }
}
