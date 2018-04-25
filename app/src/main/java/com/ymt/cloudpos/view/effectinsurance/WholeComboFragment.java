package com.ymt.cloudpos.view.effectinsurance;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.ExpandAdapter;
import com.ymt.cloudpos.adapter.MyAdapter;
import com.ymt.cloudpos.core.BaseFragment;
import com.ymt.cloudpos.model.WholeComboItemModel;
import com.ymt.cloudpos.model.WholeComboModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjifeng on 2018/4/24.
 * email : 414512194@qq.com
 * desc  :
 */

public class WholeComboFragment  extends BaseFragment {

    private String mTitle;

    private ExpandableListView expandableListView;
    private MyAdapter myAdapter;
    private List<String> groupList;
    private List<List<String>> childList;

    public static WholeComboFragment getInstance(String title) {
        WholeComboFragment sf = new WholeComboFragment();
        sf.mTitle = title;
        return sf;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_whole_combo_insurance, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        expandableListView = (ExpandableListView) view.findViewById(R.id.expandablelistview);
        groupList = new ArrayList<>();
        childList = new ArrayList<>();
        addData("幼稚园同学",new String[]{"周杰伦","江一燕 ","佟丽娅","高圆圆","刘诗诗","刘亦菲","angleBaby","张静初","张含韵",});
        addData("小学同学",new String[]{"光头强","熊大","熊二","妙蛙种子","比卡丘","双蛋瓦斯","贪吃蛇"});
        addData("初中同学",new String[]{"苍井空","小泽玛利亚","吉泽明步","波多野结衣","爱川美里菜","小川阿佐美","桃谷绘里香","泷泽萝拉","北原多香子","石川施恩惠","北条麻妃","麻仓优","羽田爱","保坂绘里"});
        addData("高中同学",new String[]{"习近平","胡锦涛","江泽民","毛泽东","秦始皇","李世民","武则天","曹操","刘备","孙权"});
        addData("大学同学",new String[]{"周杰伦","江一燕 ","佟丽娅","高圆圆","刘诗诗","刘亦菲","angleBaby","张静初","张含韵",});
        addData("研究生同学",new String[]{"光头强","熊大","熊二","妙蛙种子","比卡丘","双蛋瓦斯","贪吃蛇"});
        addData("博士同学",new String[]{"苍井空","小泽玛利亚","吉泽明步","波多野结衣","爱川美里菜","小川阿佐美","桃谷绘里香","泷泽萝拉","北原多香子","石川施恩惠","北条麻妃","麻仓优","羽田爱","保坂绘里"});
        addData("教授同事",new String[]{"习近平","胡锦涛","江泽民","毛泽东","秦始皇","李世民","武则天","曹操","刘备","孙权"});
        addData("众仙家名册",new String[]{"苍井空","小泽玛利亚","吉泽明步","波多野结衣","爱川美里菜","小川阿佐美","桃谷绘里香","泷泽萝拉","北原多香子","石川施恩惠","北条麻妃","麻仓优","羽田爱","保坂绘里","习近平","胡锦涛","江泽民","毛泽东","秦始皇","李世民","武则天","曹操","刘备","孙权"});
//        myAdapter = new MyAdapter(getContext(),groupList,childList);
//        expandableListView.setAdapter(myAdapter);

        List<WholeComboModel> glist = new ArrayList<>();
        List<WholeComboItemModel> l1 = new ArrayList<>();
        l1.add(new WholeComboItemModel("机动车损失险", null, "1", false , true));
        l1.add(new WholeComboItemModel("机动车第三者责任保险", null, "1", false , false));
        l1.add(new WholeComboItemModel("机动车车上人员责任保险", "司机", "1", true , true));
        l1.add(new WholeComboItemModel("机动车车上人员责任保险", "乘客", "1", false , true));
        l1.add(new WholeComboItemModel("机动车全车盗窃保险", null, "1", false , true));
        l1.add(new WholeComboItemModel("玻璃单独破碎险", null, "1", false , true));
        l1.add(new WholeComboItemModel("车身划痕损失险", null, "1", false , true));
        glist.add(new WholeComboModel("幼稚园同学", R.mipmap.b1,l1));

        List<WholeComboItemModel> l2 = new ArrayList<>();
        l2.add(new WholeComboItemModel("机动车损失险", null, "1", false , true));
        l2.add(new WholeComboItemModel("机动车第三者责任保险", null, "1", false , false));
        l2.add(new WholeComboItemModel("机动车车上人员责任保险", "司机", "1", true , true));
        l2.add(new WholeComboItemModel("机动车车上人员责任保险", "乘客", "1", false , true));
        l2.add(new WholeComboItemModel("机动车全车盗窃保险", null, "1", false , true));
        l2.add(new WholeComboItemModel("玻璃单独破碎险", null, "1", false , true));
        l2.add(new WholeComboItemModel("车身划痕损失险", null, "1", false , true));
        glist.add(new WholeComboModel("幼稚园同学", R.mipmap.b2,l2));

        List<WholeComboItemModel> l3 = new ArrayList<>();
        l3.add(new WholeComboItemModel("机动车损失险", null, "1", false , true));
        l3.add(new WholeComboItemModel("机动车第三者责任保险", null, "1", false , false));
        l3.add(new WholeComboItemModel("机动车车上人员责任保险", "司机", "1", true , true));
        l3.add(new WholeComboItemModel("机动车车上人员责任保险", "乘客", "1", false , true));
        l3.add(new WholeComboItemModel("机动车全车盗窃保险", null, "1", false , true));
        l3.add(new WholeComboItemModel("玻璃单独破碎险", null, "1", false , true));
        l3.add(new WholeComboItemModel("车身划痕损失险", null, "1", false , true));
        glist.add(new WholeComboModel("教授同事", R.mipmap.b3,l3));

        ExpandAdapter expandAdapter = new ExpandAdapter(getContext(),glist);
        expandableListView.setAdapter(expandAdapter);
        expandableListView.expandGroup(glist.size()-1);
        expandableListView.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
    }

    /**
     * 用来添加数据的方法
     */
    private void addData(String group, String[] friend) {
        groupList.add(group);
        //每一个item打开又是一个不同的list集合
        List<String> childitem = new ArrayList<>();
        for (int i = 0; i < friend.length; i++) {
            childitem.add(friend[i]);
        }
        childList.add(childitem);
    }
}
