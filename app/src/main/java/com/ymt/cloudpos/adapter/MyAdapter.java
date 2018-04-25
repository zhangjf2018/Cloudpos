package com.ymt.cloudpos.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.ymt.cloudpos.R;

import java.util.List;

/**
 * Created by zhangjifeng on 2018/4/24.
 * email : 414512194@qq.com
 * desc  :
 */

public class MyAdapter extends BaseExpandableListAdapter {
    private List<String> groupList;//外层的数据源
    private List<List<String>> childList;//里层的数据源
    private Context context;

    public MyAdapter(Context context, List<String> groupList,List<List<String>> childList ){
        this.context = context;
        this.groupList = groupList;
        this.childList = childList;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    /**
     * 这个返回的一定要是对应外层的item里面的List集合的size
     * @param groupPosition
     * @return
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return childList.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.combo_group, null);
        //分组名字
//        TextView textView = (TextView) convertView.findViewById(R.id.group_textview);
//        //子元素的个数
//        TextView number = (TextView) convertView.findViewById(R.id.group_number);
//        number.setText(childList.get(groupPosition).size()+"个");
//        textView.setText(groupList.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.combo_group_item, null);
        TextView textView = (TextView) view.findViewById(R.id.tv_name);
        //外层的分组名字
        textView.setText(childList.get(groupPosition).get(childPosition));
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
