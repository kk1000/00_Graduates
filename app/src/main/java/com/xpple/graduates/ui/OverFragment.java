package com.xpple.graduates.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ktplay.open.KTAccountManager;
import com.ktplay.open.KTError;
import com.ktplay.open.KTLeaderboard;
import com.ktplay.open.KTPlay;
import com.xpple.graduates.R;
import com.xpple.graduates.util.SpScoreUtil;
import com.xpple.graduates.view.BaseFragment;

import java.io.FileOutputStream;
import java.io.IOException;

public class OverFragment extends BaseFragment implements View.OnClickListener {
    private static String[] mPositionString = {"国内中小公司基层员工", "国内知名公司基层员工", "海外驻华公司基层员工",
            "国内中小公司基层主管", "国内知名公司基层主管", "海外驻华公司基层主管",
            "国内中小公司中层经理", "国内知名公司中层经理", "海外驻华公司中层经理",
            "国内中小公司高层老总", "国内知名公司高层老总", "海外驻华公司高层老总"};
    private static String[] mCarString = {"你还没有买车", "你有一辆小型节油低档车", "你有一辆经济实用中档车",
            "你有一辆豪华舒适中档车", "你有一辆超豪华享受高档车", "你有一辆时尚拉风跑车"};
    private static String[] mHouseString = {"你还没有买房", "你有1室1厅的房子"
            , "你有2室1厅的房子", "你有2室2厅的房子", "你有3室1厅的房子", "你有3室2厅的房子", "你有4室2厅的房子",
            "你有市郊豪华小别墅", "你有城区超豪华别墅"};
    private static String[] mPartnerString = {"你还没有女朋友", "你的女友是施施", "你的女友是阿禅",
            "你的女友是昭君", "你的女友是玉环", "你的女友是圆圆", "你的女友是香香",
            "你的女友是十娘", "你的女友是小小", "你的女友是飞燕", "你的女友是莺莺"};
    @SuppressLint("StaticFieldLeak")
    private static OverFragment instance = new OverFragment();
    //创建回调
    private KTLeaderboard.OnReportScoreListener onReportScoreListener =
            new KTLeaderboard.OnReportScoreListener() {
                @Override
                public void onReportScoreResult(boolean isSuccess,
                                                String leaderboardId, long score, String scoreTag, KTError error) {
                    if (isSuccess) {
                        showToast("上传分数成功", true);
                    } else {
                        showToast(error.description, false);
                    }
                }
            };
    private View parentView;
    private TextView mHealthyValueView, mMoneyValueView, mAbilityValueView,
            mExperienceValueView, mHappyValueView, mMoralityValueView,
            mCommunicationValueView,
            mPositionView, mCarView, mHouseView, mPartnerView;
    private ImageView tv_over;
    private TextView tv_over_1, tv_over_0;
    private Integer mStockValue, mIndexStockValue, mIndexHouseValue, mIncomeValue,
            mCommunicationMonthlyValue, mHappyMonthlyValue,
            mLoadValue, mHealthyValue, mMoneyValue, mAbilityValue,
            mExperienceValue, mHappyValue, mMoralityValue,
            mCommunicationValue, mPositionValue, mCarValue, mHouseValue,
            mPartnerValue, mCareerValue, mLoveValue;

    public OverFragment() {
    }

    public static OverFragment newInstance() {
        return instance;
    }

    // 获取指定Activity的截屏，保存到png文件
    private static Bitmap takeScreenShot(Activity activity) {
        // View是你需要截图的View
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();

        // 获取状态栏高度
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;

        // 获取屏幕长和高
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay()
                .getHeight();
        // 去掉标题栏
        Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        return b;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_over, container, false);
        setUpViews();
        return parentView;
    }

    private void setUpViews() {
        mHealthyValueView = (TextView) parentView.findViewById(R.id.tv_healthy);
        mMoneyValueView = (TextView) parentView.findViewById(R.id.tv_money);
        mAbilityValueView = (TextView) parentView.findViewById(R.id.tv_ability);
        mExperienceValueView = (TextView) parentView.findViewById(R.id.tv_experience);
        mHappyValueView = (TextView) parentView.findViewById(R.id.tv_happy);
        mMoralityValueView = (TextView) parentView.findViewById(R.id.tv_morality);
        mCommunicationValueView = (TextView) parentView.findViewById(R.id.tv_communication);
        mPositionView = (TextView) parentView.findViewById(R.id.tv_position);
        mCarView = (TextView) parentView.findViewById(R.id.tv_car);
        mHouseView = (TextView) parentView.findViewById(R.id.tv_house);
        mPartnerView = (TextView) parentView.findViewById(R.id.tv_partner);
        tv_over = (ImageView) parentView.findViewById(R.id.tv_over);
        tv_over_0 = (TextView) parentView.findViewById(R.id.tv_over_0);
        tv_over_1 = (TextView) parentView.findViewById(R.id.tv_over_1);
    }

    //总分计算公式：
    //健康*1.5+金钱分+经验/4+能力/4+快乐+道德*2+交际/魅力*1.5+职位分+车子分+房子分+女/男友分

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setValue();
    }

    private void setValue() {
        SpScoreUtil mSharedScoreUtil = mApplication.getSpScoreUtil();
        mLoadValue = mSharedScoreUtil.getLoad();
        mHealthyValue = mSharedScoreUtil.getHealthy();
        mMoneyValue = mSharedScoreUtil.getMoney();
        mAbilityValue = mSharedScoreUtil.getAbility();
        mExperienceValue = mSharedScoreUtil.getExperience();
        mHappyValue = mSharedScoreUtil.getHappy();
        mMoralityValue = mSharedScoreUtil.getMorality();
        mCommunicationValue = mSharedScoreUtil.getCommunication();
        mCommunicationMonthlyValue = mSharedScoreUtil.getCommunicationMonthly();
        mHappyMonthlyValue = mSharedScoreUtil.getHappyMonthly();

        mCareerValue = mSharedScoreUtil.getCareer();
        mLoveValue = mSharedScoreUtil.getLove();

        mCarValue = mSharedScoreUtil.getCar();
        mPartnerValue = mSharedScoreUtil.getPartner();
        mPositionValue = mSharedScoreUtil.getPosition();
        mHouseValue = mSharedScoreUtil.getHouse();
        mIncomeValue = mSharedScoreUtil.getIncome();
        mStockValue = mSharedScoreUtil.getStock();
        mIndexStockValue = mSharedScoreUtil.getIndexStock();
        mIndexHouseValue = mSharedScoreUtil.getIndexHouse();
        mHealthyValueView.setText("" + mHealthyValue);
        mMoneyValueView.setText("" + mMoneyValue);
        mAbilityValueView.setText("" + mAbilityValue);
        mExperienceValueView.setText("" + mExperienceValue);
        mHappyValueView.setText("" + mHappyValue);
        mMoralityValueView.setText("" + mMoralityValue);
        mCommunicationValueView.setText("" + mCommunicationValue);


        mPositionView.setText(mPositionString[mPositionValue]);

        mCarView.setText(mCarString[mCarValue]);

        mHouseView.setText(mHouseString[mHouseValue]);

        mPartnerView.setText(mPartnerString[mPartnerValue]);
        tv_over_0.setText(makeScoreInfo());
        tv_over_1.setText("总分：" + getScore());
        tv_over.setOnClickListener(this);

    }

    private Integer getScore() {
        return (int) (mHealthyValue * 1.5 + getMoneyScore()
                + mAbilityValue / 4 + mExperienceValue / 4
                + mHappyValue + mMoralityValue / 2 + mCommunicationValue * 1.5
                + ((mPositionValue + 1) * 1000)
                + (mCarValue ^ 2 * 100)
                + (mHouseValue ^ 2 * 100)
                + ((mPartnerValue.equals(0)) ? 0 : 100000)
                + ((mLoveValue + mCareerValue) * 10000));
    }

    //金钱分值
    //1亿之内，金钱分=金钱/1000
    //超过1亿  金钱分=100000+（金钱-100000000）/10000
    private Integer getMoneyScore() {
        Integer mMoneyScore;
        if (mMoneyValue > 100000000) {
            mMoneyScore = 100000 + (mMoneyValue - 100000000) / 10000;
        } else {
            mMoneyScore = mMoneyValue / 1000;
        }
        return mMoneyScore;
    }

    /**
     * 上传分数
     */
    private void uploadScore() {
        //使用上传分数功能时需要登录
        boolean isLoggedIn = KTAccountManager.isLoggedIn();
        if (isLoggedIn) {
            KTLeaderboard.reportScore(getScore(), "_Score", "scoreTag", onReportScoreListener);
        } else {
            KTAccountManager.showLoginView(true, null);
        }
        savePic(takeScreenShot(getActivity()), "sdcard/xx.png");
    }

    // 保存到sdcard
    private void savePic(Bitmap b, String strFileName) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(strFileName);
            b.compress(Bitmap.CompressFormat.PNG, 90, fos);
            fos.flush();
            fos.close();
            showToast("保存成功", true);
            KTPlay.shareImageToKT("sdcard/xx.png", "大家来看看我的黄金岁月哈～～～");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 转换分数信息数据为普通文本
     */
    private String makeScoreInfo() {
        return "你现在是" + mPositionString[mPositionValue] + "。"
                + mHouseString[mHouseValue] + "，"
                + mCarString[mCarValue] + "。"
                + mPartnerString[mPartnerValue] + "。"
                + ((mLoveValue > 10) ? "你的真诚与关爱打动了你的女友，和她一起走进了婚姻的殿堂。" : "在你三十岁之际，希望你找到了真爱，能和她共赴婚姻的殿坛。")
                + ((mHealthyValue > 500) ? "你的健康程度一般，大病没有，小病不断。 你的健康程度很差，身体弱不禁风，经常感冒，经常熬夜和饮食起居不规律带来身体的许多疾病。   你的健康程度很差，三十岁就开始秃顶掉头发，身体也已将发福，高血压高血脂带来身体的许多疾病。" : "你非常强壮，健康状态超级棒！")
                + ((mHealthyValue > 800) ? "要注意多运动和有规律的生活。" : "你很注意自己的健康，大量系统的健身运动加上平时的良好生活习惯造就了你运动员般的体魄！")
                + ((mHealthyValue > 5) ? "要注意养成健康的生活方式，多运动提高体质同时保持良好的心态。  你非常注意消费和积累的平衡，通过勤奋工作和不断学习提升自己以谋求更好的待遇和职位，" : "你平时很注意消费和积累的平衡，由于勤奋工作获得升职加薪，")
                + ((mCareerValue > 10) ? "你平时出手大方，花钱也没什么计划，投资也可能碰到失败，所以经济方面存款不多，仅够糊口。 好运气加上大胆的投资，经济方面可以说是非常富有，钱对你来说只是个符号。好运气加上大胆的投资，经济方面可以列入富豪阶层，" : "投资方面颇有头脑，经济方面可以过上小资的生活。")
                + ((mExperienceValue > 4000) ? "你非常注意消费和积累的平衡，通过勤奋工作和不断学习提升自己以谋求更好的待遇和职位，好运气加上大胆的投资，经济方面可以说是辉煌，年纪轻轻就成为亿万富翁！ 你平时也注意消费和积累的平衡，但总是心有余力不足，你埋怨自己不太走运，所以经济方面存款不多，只能温饱。" : "你通过勤奋工作、健身运动、阅读大量书籍、参加众多的学习培训来提升自己，")
                + ((mAbilityValue > 4000) ? "能力方面比较强，可以独当一面，开拓守成，经验方面比较丰富。" : "在能力方面非常强，世界上几乎没有什么事情你办不了，经验方面非常丰富，")
                + ((mPositionValue > 4) ? "也担任经理一级的职务" : "就算是总经理的位子你也可以胜任。)")
                + ((mPositionValue > 8) ? " 虽然你还在替别人打工，" : "你通过努力扩大人脉和积累资本，终于创立了属于自己的公司。")
                + ((mHealthyValue > 5) ? "" : "但你对自己的将来还是充满期待。你的生活和工作平衡处理得非常好，")
                + ((mHappyValue > 800) ? "长时间和大工作量的工作学习使你的生活压力很大，经常愁眉不展，觉得整个世界都是灰色的。为了避免你以后忧郁过度而自杀，一定要注意保持快乐的心态。" : "特喜欢玩和喜欢热闹，每天都开开心心的，笑容常在，并给周围的人带来欢乐，")
                + ((mMoralityValue > 500) ? "你平时喜欢赚小便宜，在对待金钱和欲望的问题上不能很好的把握自己，当然，你有时间也会抽空回家看看父母。" : "所有的人都羡慕和喜欢你！你为人非常正直，酒色财气几乎不沾，对自己欲望的控制和把握做得非常好，")
                + ((mMoralityValue > 800) ? "你为人比较正直，能很好的把握和控制自己的欲望，还时常献一下爱心。经常回家看看，对父母还是能尽到必要的孝道。" : "你为人比较正直，能很好的把握和控制自己的欲望，还时常献一下爱心。 对父母则孝敬有加，富有爱心，是个人人称道的好人！你在人际关系方面可以说得上是个中高手，情商非常高哦！")
                + ((mCommunicationValue > 800) ? "你的人际关系方面处理得很糟糕，身边没有几个朋友，经常是行单影孤的。你应该尝试着大方一点，毕竟在这个社会中有朋友才能相互温暖。  你在人际处理方面一般，来来去去也就那么几个酒肉朋友。你可以多参加一点集体活动，增加自己的人际接触面" : "有众多朋友同事的帮助，你如鱼得水，左右逢源。可谓是人见人爱，花见花开，车见车载。")
                + (("根据你的各项属性和各项资产最后得出你的综合成就总分为：") + getScore())
                + ("这段黄金岁月的含金量为：56 %");
//       健康 1598 金钱+股票市值 85215809 能力 6873 经验 6215 快乐 1606
// 道德 821 交际 851 海外驻华公司高层老总 你有一辆时尚拉风跑车 你有城区超豪华别墅
// 你的女友是十娘 婚姻成功 创业成功 总分 107909 岁月含金量 97%
// 游戏难度：现实最难 游戏版本V2.5
    }

    @Override
    public void onClick(View v) {
        uploadScore();
    }
}