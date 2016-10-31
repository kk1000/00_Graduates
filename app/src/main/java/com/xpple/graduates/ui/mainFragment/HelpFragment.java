package com.xpple.graduates.ui.mainFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.xpple.graduates.R;
import com.xpple.graduates.view.BaseFragment;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class HelpFragment extends BaseFragment {
    @SuppressLint("StaticFieldLeak")
    private static HelpFragment instance = new HelpFragment();
    private View parentView;
    private ListView mListView;

    public HelpFragment() {
    }

    public static HelpFragment newInstance() {
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_help, container, false);
        setUpViews();
        return parentView;
    }

    private void setUpViews() {
        mListView = (ListView) parentView.findViewById(R.id.listView);
        ImageView iv_back = (ImageView) parentView.findViewById(R.id.btn_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        initView();
    }

    private void initView() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                getCalendarData());
        mListView.setAdapter(arrayAdapter);

    }

    private ArrayList<String> getCalendarData() {
        ArrayList<String> calendarList = new ArrayList<>();
        calendarList.add("1.当你的按住活动按钮上时，会显示活动需要的时间数。");
        calendarList.add("2.每个月会发生一件随机事件，每个随机事件的不同处理会有不同的结果。");
        calendarList.add("3.游戏中的健康、快乐值每个月会有2点的自然减少，需要注意哦。");
        calendarList.add("4.注意要保持自己的健康、快乐和道德值为正数，否则会提前中断游戏。");
        calendarList.add("5.灵活用好工作时间与空闲时间的滑条，可以使你获得更多的空闲时间或者更高的工资收入。");
        calendarList.add("6.你每个月最少要工作4天，最多30天，你可以通过时间滑条调整，调整当月的工资也会相应调整。");
        calendarList.add("7.最大限度的利用你每月的空间时间，如果空闲时间只剩20个小时了，做不了其他活动，你可以选择“在家睡觉休息”");
        calendarList.add("8.游戏前期提高经验和能力是必要的，这样可以为你谋求更好的职位和更好的待遇。提高了待遇才能有更高的收入。有足够的钱才能够买车买房。");
        calendarList.add("9.房价每月有波动，总体的趋势是上涨的，所以房子具有可投资性，炒炒房也不错哦！当然需要你有足够的资金。");
        calendarList.add("10.每个月买点彩票，也许能够有意外的惊喜，但是需要运气和耐心。");
        calendarList.add("11.如果买彩票中了大奖，的确是要少奋斗很多年的。（可惜现实中的彩票没有这么高的中奖几率）");
        calendarList.add("12.如果你买了房子或车子，那么你每月就会相应多一些花销，根据房子和车子的档次不同花销也不同。");
        calendarList.add("13.经常去人才市场跳槽，虽然会使你多增加一些属性，但是也会消耗你相应的金钱，这是“跳槽成本”。");
        calendarList.add("14.当你当上公司的高层老总以后，某些随机事件就会相应改变，细心的你可以在游戏中体会和发现。");
        calendarList.add("15.游戏中的股票市场属于中长线投资场所，类似申购赎回基金的操作模式，碰到随机事件中的短线个股机会时不能立即变现，只能用现有的资金来交易。");
        calendarList.add("16.游戏中的股票指数变化遵循：长线增长趋势+意外事件影响+短期随机变量影响+长期随机变量影响。所以每一盘游戏里的股市走势都会不一样。");
        calendarList.add("17.游戏的活动中有一些情景模式，你会在某个时间做某项活动时触发特殊的情景。经历一段不寻常的情节。比如女生版中第二个月去旅游，会触发一个缘分情节。");
        calendarList.add("18.如果你的女友是昭君在特定场景中可能触发相关剧情，剧情有不同的结局。");
        calendarList.add("19.如果你的女友是十娘在你28岁时开始会有剧情，注意如果剩余时间不够24个月将无法触发十娘的所有剧情。");
        calendarList.add("20.房产中介里的客服小樱隐藏着缘分情节，在房产中介里点击她的头像图片会有相应的对话。不过你需要有耐心哦！");
        calendarList.add("21.不同的男友和不同的女友，对应的成就分数参数也是不一样的，难度高的分数参数也会相应高。");
        calendarList.add("22.金钱在岁月含金量中有固定比例，含金量不会随金钱无限提高而提高。只有通过全方面发展才能提高岁月含金量。");
        calendarList.add("23.游戏的结局有数据反作弊验证，通过反复存取档还有修改游戏存档获得结局，是不显示最后分数的。");
        calendarList.add("24.游戏中的事业机遇指数决定最后能否创立自己的公司，爱情机遇指数决定最后能否与女友走向婚姻。");
        calendarList.add("25.要开启机遇之窗，需要你每项活动上进行过一定次数,加班、上网、派对所需次数20次，其他的活动所需次数30次。");
        calendarList.add("26.好好把握机遇之窗的选择，每次开启机遇之窗可以最多增加两点的机遇指数（可能是单项增2点，也可能是各增一点）。");
        calendarList.add("27.最后要想创业与婚姻同时成功，需要爱情与事业机遇指数都达到10点及以上（指数最高值为20，过半即达成）。");
        calendarList.add("28.创业成功除了事业机遇指数达到10点，还需要至少500万以上的创业资金和750以上的交际值。超过1000万和超过2000万的创业资金，公司规模和局面会更大。");
        calendarList.add("29.所在公司IPO上市时，内部员工申购原始股，职位级别不同，能申购到的份额也不同，职位级别越高，能申购的份额也越高，获得的财富增值也愈多。");
        calendarList.add("30.如果你工作的公司已经IPO过了，不论成功与否，以后都不会再出现IPO上市的事件，除非你跳槽换一家公司工作。");
        calendarList.add("31.赌石时，要触发人品大爆发赌中翡翠的事件，必要条件是道德在500以上。");
        calendarList.add("32.淘古董时，要触发200元捡到百万以上的大漏，必要条件是经验在5000以上。");
        calendarList.add("33.游戏中金钱最高限值是21亿，超过21亿后会造成数值溢出错误，玩梦幻完美难度和修改游戏存档的玩家请注意。");
        return calendarList;
    }
}
