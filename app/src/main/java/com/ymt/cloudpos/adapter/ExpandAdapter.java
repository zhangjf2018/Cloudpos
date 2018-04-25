package com.ymt.cloudpos.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.suke.widget.SwitchButton;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.wegit.SpinnerEditText;
import com.ymt.cloudpos.core.wegit.spinner.NiceSpinner;
import com.ymt.cloudpos.model.WholeComboModel;
import com.ymt.cloudpos.util.CommonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by zhangjifeng on 2018/4/24.
 * email : 414512194@qq.com
 * desc  :
 */

public class ExpandAdapter extends BaseExpandableListAdapter {
    private List<WholeComboModel> groupList;//外层的数据源
    private Context context;

    public ExpandAdapter(Context context, List<WholeComboModel> groupList ){
        this.context = context;
        this.groupList = groupList;
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
        return groupList.get(groupPosition).getWholeComboItemModels().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupList.get(groupPosition).getWholeComboItemModels().get(childPosition);
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
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_pro);
        //子元素的个数
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        tvName.setText(groupList.get(groupPosition).getName());
        tvName.setTextSize(22);
        imageView.setImageDrawable(ContextCompat.getDrawable(context,groupList.get(groupPosition).getResImgId()));
        return convertView;
    }
    public static class BaseBean {
        public String Name;
        public int Id;

        @Override
        public String toString() {
            return Name;
        }
    }
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.combo_group_item, null);
        TextView textView = (TextView) view.findViewById(R.id.tv_name);
        //外层的分组名字
        textView.setText(groupList.get(groupPosition).getWholeComboItemModels().get(childPosition).getName());

        final SpinnerEditText spinnerEditText = (SpinnerEditText<BaseBean>) view.findViewById(R.id.set_dropList);
        spinnerEditText.setRightCompoundDrawable(R.mipmap.drop_arr);

        spinnerEditText.setText(groupList.get(groupPosition).getWholeComboItemModels().get(childPosition).getPrice());

        final int groupPositionf = groupPosition;
        final int childPositionf = childPosition;

        spinnerEditText.setOnItemClickListener(new SpinnerEditText.OnItemClickListener<BaseBean>() {
            @Override
            public void onItemClick(BaseBean baseBean, SpinnerEditText<BaseBean> var1, View var2, int position, long var4, String selectContent) {
               // showToast("名称:" + baseBean.Name + " Id:" + baseBean.Id);
                groupList.get(groupPositionf).getWholeComboItemModels().get(childPositionf).setPrice(selectContent);
            }
        });

        spinnerEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                groupList.get(groupPositionf).getWholeComboItemModels().get(childPositionf).setPrice(spinnerEditText.getText().toString());
            }
        });

        List<BaseBean> baseBeanList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            BaseBean baseBean = new BaseBean();
            baseBean.Name = "学生:" + i;
            baseBean.Id = i;
            baseBeanList.add(baseBean);
        }

        spinnerEditText.setList(baseBeanList);

       // spinnerEditText.setRightNullCompoundDrawable();
//        NiceSpinner niceSpinner = (NiceSpinner) view.findViewById(R.id.nice_spinner);
//        List<String> dataset = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
//        niceSpinner.attachDataSource(dataset);
//
//
//
//        niceSpinner.hideArrow();
//        niceSpinner.setEnabled(true);
//        niceSpinner.setFocusable(true);

     //   NiceSpinner niceSpinner = (NiceSpinner) view.findViewById(R.id.nice_spinner);

        SwitchButton switchButton = (SwitchButton) view.findViewById(R.id.switch_button);
        switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                groupList.get(groupPositionf).getWholeComboItemModels().get(childPositionf).setSwitchOn(isChecked);
            }
        });
        switchButton.setChecked(groupList.get(groupPositionf).getWholeComboItemModels().get(childPositionf).isSwitchOn());

        CheckBox ck = (CheckBox) view.findViewById(R.id.cb_isCheck);
        ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                groupList.get(groupPositionf).getWholeComboItemModels().get(childPositionf).setCheckOn(isChecked);
            }
        });
        ck.setChecked(groupList.get(groupPositionf).getWholeComboItemModels().get(childPositionf).isCheckOn());

        TextView subName = (TextView) view.findViewById(R.id.tv_subName);
        if(groupList.get(groupPositionf).getWholeComboItemModels().get(childPositionf).getSubName() != null &&
                !"".equals(groupList.get(groupPositionf).getWholeComboItemModels().get(childPositionf).getSubName())){
            subName.setText(groupList.get(groupPositionf).getWholeComboItemModels().get(childPositionf).getSubName());
            view.findViewById(R.id.ll_subName).setVisibility(View.VISIBLE);
        }

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
