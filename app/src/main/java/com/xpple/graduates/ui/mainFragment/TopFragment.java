package com.xpple.graduates.ui.mainFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ktplay.open.KTError;
import com.ktplay.open.KTLeaderboard;
import com.ktplay.open.KTLeaderboardPaginator;
import com.ktplay.open.KTUser;
import com.xpple.graduates.R;
import com.xpple.graduates.adapter.LazyAdapter;
import com.xpple.graduates.view.BaseFragment;
import com.xpple.graduates.view.CustomProgressDialog;

import java.util.ArrayList;

public class TopFragment extends BaseFragment {
    @SuppressLint("StaticFieldLeak")
    private static TopFragment instance = new TopFragment();
    private View parentView;
    private CustomProgressDialog dialog;
    private ArrayList<KTUser> items = new ArrayList<>();
    private LazyAdapter adapter;
    private TextView my_rank, my_score, count;
    //创建回调
    private KTLeaderboard.OnGetLeaderboardListener onGetLeaderboardListener =
            new KTLeaderboard.OnGetLeaderboardListener() {

                @Override
                public void onGetLeaderboardResult(boolean isSuccess,
                                                   String leaderboardId, KTLeaderboardPaginator leaderboard, KTError error) {
                    handleLeaderboardResult(isSuccess, leaderboardId, leaderboard, error);
                    dialog.dismiss();
                }
            };

    public TopFragment() {
    }

    public static TopFragment newInstance() {
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_top, container, false);
        iniXListView();
        return parentView;
    }

    private void iniXListView() {
        ImageView iv_back = (ImageView) parentView.findViewById(R.id.btn_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        KTLeaderboard.globalLeaderboard("_Score", 0, 10, onGetLeaderboardListener);
        dialog = new CustomProgressDialog(getActivity(), R.string.loading);
        dialog.show();
        ListView mlist = (ListView) parentView.findViewById(R.id.id_top);
        adapter = new LazyAdapter(getActivity(), items);
        mlist.setAdapter(adapter);
        my_rank = (TextView) parentView.findViewById(R.id.my_rank);
        my_score = (TextView) parentView.findViewById(R.id.my_score);
        count = (TextView) parentView.findViewById(R.id.count);
    }

    private void handleLeaderboardResult(boolean isSuccess,
                                         String leaderboardId,
                                         KTLeaderboardPaginator leaderboard,
                                         KTError error) {
        if (isSuccess) {
            items = leaderboard.getUsers();
            showLeaderboardInfo(leaderboard);
            int size = items.size();
            if (size == 0) {
                showToast("排行榜暂无数据", true);
            } else {
                adapter.addAll(items);
            }
        } else {
            showToast("获取" + leaderboardId + "排行榜数据失败" + error, false);
        }
        items.clear();
    }


    private void showLeaderboardInfo(KTLeaderboardPaginator paginator) {
        count.setText("上榜人数:" + paginator.getItemCount());
        Integer myRank = paginator.getMyRank();
        if (myRank == 0) {
            my_rank.setText("登陆后可查看我的排名");
            my_score.setText("登陆后可查看我的分数");
        } else {
            my_rank.setText("我的排名：" + myRank);
            my_score.setText("我的分数：" + paginator.getMyScore());
        }

    }
}
