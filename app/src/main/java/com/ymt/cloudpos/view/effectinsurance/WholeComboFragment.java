package com.ymt.cloudpos.view.effectinsurance;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.ExpandAdapter;
import com.ymt.cloudpos.adapter.MyAdapter;
import com.ymt.cloudpos.core.BaseFragment;
import com.ymt.cloudpos.model.WholeComboItemModel;
import com.ymt.cloudpos.model.WholeComboItemSelectListModel;
import com.ymt.cloudpos.model.WholeComboModel;
import com.ymt.cloudpos.view.SelectInsuranceAgentActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjifeng on 2018/4/24.
 * email : 414512194@qq.com
 * desc  :
 */

public class WholeComboFragment  extends BaseFragment implements View.OnClickListener {

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

        Button subOrder = (Button) view.findViewById(R.id.btn_subOrder);
        subOrder.setOnClickListener(this);
        return view;
    }

    private void initView(View view) {
        expandableListView = (ExpandableListView) view.findViewById(R.id.expandablelistview);
        groupList = new ArrayList<>();
        childList = new ArrayList<>();
     //        myAdapter = new MyAdapter(getContext(),groupList,childList);
//        expandableListView.setAdapter(myAdapter);

        List<WholeComboItemSelectListModel> pr = new ArrayList<>();
        pr.add(new WholeComboItemSelectListModel("1W",""));
        pr.add(new WholeComboItemSelectListModel("2W",""));
        pr.add(new WholeComboItemSelectListModel("4W",""));
        pr.add(new WholeComboItemSelectListModel("5W",""));
        pr.add(new WholeComboItemSelectListModel("6W",""));
        pr.add(new WholeComboItemSelectListModel("6W",""));

        List<WholeComboModel> glist = new ArrayList<>();
        List<WholeComboItemModel> l1 = new ArrayList<>();
        l1.add(new WholeComboItemModel("机动车损失险", null, "1", false , true));
        l1.add(new WholeComboItemModel("机动车第三者责任保险", null, "1", false , false));
        l1.add(new WholeComboItemModel("机动车车上人员责任保险", "司机",pr.get(0).getName(), true , true, pr));
        l1.add(new WholeComboItemModel("机动车车上人员责任保险", "乘客", pr.get(0).getName(), false , true, pr));
        l1.add(new WholeComboItemModel("机动车全车盗窃保险", null, "1", false , true));
        l1.add(new WholeComboItemModel("玻璃单独破碎险", null, "1", false , true));
        l1.add(new WholeComboItemModel("车身划痕损失险", null, "1", false , true));
        glist.add(new WholeComboModel("交强险", R.mipmap.b1,l1));

        List<WholeComboItemModel> l2 = new ArrayList<>();
        l2.add(new WholeComboItemModel("机动车损失险", null, "1", false , true));
        l2.add(new WholeComboItemModel("机动车第三者责任保险", null, "1", false , false));
        l2.add(new WholeComboItemModel("机动车车上人员责任保险", "司机", "1", true , true));
        l2.add(new WholeComboItemModel("机动车车上人员责任保险", "乘客", "1", false , true));
        l2.add(new WholeComboItemModel("机动车全车盗窃保险", null, "1", false , true));
        l2.add(new WholeComboItemModel("玻璃单独破碎险", null, "1", false , true));
        l2.add(new WholeComboItemModel("车身划痕损失险", null, "1", false , true));
        glist.add(new WholeComboModel("车船税 （买交强险且未完税者必买）", R.mipmap.b2,l2));

        List<WholeComboItemModel> l3 = new ArrayList<>();
        l3.add(new WholeComboItemModel("机动车损失险", null, "1", false , true));
        l3.add(new WholeComboItemModel("机动车第三者责任保险", null, "1", false , false));
        l3.add(new WholeComboItemModel("机动车车上人员责任保险", "司机", pr.get(0).getName(), true , true,pr));
        l3.add(new WholeComboItemModel("机动车车上人员责任保险", "乘客", pr.get(0).getName(), false , true,pr));
        l3.add(new WholeComboItemModel("机动车全车盗窃保险", null, "1", false , true));
        l3.add(new WholeComboItemModel("玻璃单独破碎险", null, "1", false , true));
        l3.add(new WholeComboItemModel("车身划痕损失险", null, "1", false , true));
        glist.add(new WholeComboModel("商业险", R.mipmap.b3,l3));

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

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(getContext(), SelectInsuranceAgentActivity.class);
        startActivity(intent);
    }
}
