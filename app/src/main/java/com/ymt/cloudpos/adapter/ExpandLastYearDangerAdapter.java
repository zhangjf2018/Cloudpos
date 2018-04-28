package com.ymt.cloudpos.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.suke.widget.SwitchButton;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.wegit.SpinnerEditText;
import com.ymt.cloudpos.model.IdUploadModel;
import com.ymt.cloudpos.model.LastYearsDangerItemModel;
import com.ymt.cloudpos.model.LastYearsDangerModel;
import com.ymt.cloudpos.model.WholeComboItemSelectListModel;
import com.ymt.cloudpos.model.WholeComboModel;
import com.ymt.cloudpos.view.InsuranceAgentUploadPInfoActivity;

import java.util.ArrayList;
import java.util.List;

import me.iwf.photopicker.PhotoPicker;
import me.iwf.photopicker.PhotoPreview;


/**
 * Created by zhangjifeng on 2018/4/24.
 * email : 414512194@qq.com
 * desc  :
 */

public class ExpandLastYearDangerAdapter extends BaseExpandableListAdapter {
    private List<LastYearsDangerModel> groupList;//外层的数据源
    private Context context;
    private ArrayList<String> selectedPhotos = new ArrayList<>();
    private int MAX = 1;
    private Activity activity;
    private int currentGroupPos;
    private int currentChildPos;

    public ExpandLastYearDangerAdapter(Context context, Activity activity, List<LastYearsDangerModel> groupList ){
        this.context = context;
        this.groupList = groupList;
        this.activity = activity;
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
        return groupList.get(groupPosition).getDataList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupList.get(groupPosition).getDataList().get(childPosition);
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
        convertView = View.inflate(context, R.layout.last_year_danger_group, null);
        //分组名字
        TextView textView = (TextView) convertView.findViewById(R.id.iv_group);
        textView.setText(groupList.get(groupPosition).getName());

        SwitchButton switchButton = (SwitchButton) convertView.findViewById(R.id.switch_button);
        switchButton.setChecked(groupList.get(groupPosition).isSwitchOn());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.last_year_danger_group_item, null);
        TextView textView = (TextView) view.findViewById(R.id.iv_groupItem);
        final int gp = groupPosition;
        final int cp = childPosition;
        currentGroupPos = gp;
        currentChildPos = cp;
        //外层的分组名字
        textView.setText(groupList.get(groupPosition).getDataList().get(childPosition).getName());

        ImageView imageView = (ImageView) view.findViewById(R.id.iv_selectPic);

        String locPath = groupList.get(groupPosition).getDataList().get(childPosition).getLocPath();
        TextView tvSelectIinfo = (TextView) view.findViewById(R.id.tv_selectInfo);
        ImageView ivDelete = (ImageView) view.findViewById(R.id.iv_delete);
        if(locPath !=null && !"".equals(locPath) ){
            tvSelectIinfo.setVisibility(View.GONE);
            ivDelete.setVisibility(View.VISIBLE);
        } else {
            tvSelectIinfo.setVisibility(View.VISIBLE);
            ivDelete.setVisibility(View.GONE);
        }
        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupList.get(gp).getDataList().get(cp).setLocPath(null);
                notifyDataSetChanged();
            }
        });

        loadImage(imageView, groupList.get(groupPosition).getDataList().get(childPosition).getLocPath());

        Log.e("groupPosition", gp+":"+cp);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_imgSelect);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LastYearsDangerItemModel lastYearsDangerItemModel = groupList.get(gp).getDataList().get(cp);
                if(lastYearsDangerItemModel.getLocPath() != null && !"".equals(lastYearsDangerItemModel.getLocPath())){
                    selectedPhotos.clear();
                    selectedPhotos.add(lastYearsDangerItemModel.getLocPath());
                    PhotoPreview.builder()
                            .setPhotos(selectedPhotos)
                            .setCurrentItem(0)
                            .start(activity);

                }else {
                    PhotoPicker.builder()
                            .setPhotoCount(MAX)
                            .setShowCamera(true)
                            .setPreviewEnabled(true)
                            .setSelected(selectedPhotos)
                            .start(activity);
                }
            }
        });
        return view;
    }

    private void loadImage(ImageView imageView, String locPath){
        final RequestOptions options = new RequestOptions();
        options.centerCrop().
                placeholder(R.mipmap.default_pic_xxx)
                .error(R.mipmap.default_pic_xxx);
        Glide.with(imageView.getContext())
                .load(locPath)
                .apply(options)
                .thumbnail(0.8f)
                .into(imageView);

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public int getCurrentGroupPos() {
        return currentGroupPos;
    }

    public void setCurrentGroupPos(int currentGroupPos) {
        this.currentGroupPos = currentGroupPos;
    }

    public int getCurrentChildPos() {
        return currentChildPos;
    }

    public void setCurrentChildPos(int currentChildPos) {
        this.currentChildPos = currentChildPos;
    }
}
