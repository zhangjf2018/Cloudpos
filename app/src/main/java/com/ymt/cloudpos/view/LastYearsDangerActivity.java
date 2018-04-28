package com.ymt.cloudpos.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.ExpandAdapter;
import com.ymt.cloudpos.adapter.ExpandLastYearDangerAdapter;
import com.ymt.cloudpos.adapter.MyAdapter;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.model.InsuranceAgentModel;
import com.ymt.cloudpos.model.LastYearsDangerItemModel;
import com.ymt.cloudpos.model.LastYearsDangerModel;
import com.ymt.cloudpos.model.WholeComboItemModel;
import com.ymt.cloudpos.model.WholeComboItemSelectListModel;
import com.ymt.cloudpos.model.WholeComboModel;

import java.util.ArrayList;
import java.util.List;

import me.iwf.photopicker.PhotoPicker;
import me.iwf.photopicker.PhotoPreview;

public class LastYearsDangerActivity extends BaseActivity {

    private ExpandableListView expandableListView;
    private List<LastYearsDangerModel> groupList;
    private ExpandLastYearDangerAdapter expandAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("同上年险种");
        Bundle bundle = getIntent().getExtras();
        final InsuranceAgentModel insuranceAgentModel = (InsuranceAgentModel) bundle.getSerializable("insuranceAgentModel");
        ImageView imageView = (ImageView) findViewById(R.id.iv_selectInsuranceAgent);
        imageView.setImageResource(insuranceAgentModel.getResImgId());
        initView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_last_years_danger;
    }

    private void initView( ) {
        expandableListView = (ExpandableListView) findViewById(R.id.expandablelistview);

        groupList = new ArrayList<>();
        groupList.add(new LastYearsDangerModel("购买车船税 (国家规定需与交强险同时购买)", true, new ArrayList<LastYearsDangerItemModel>()));

        List<LastYearsDangerItemModel> l2 = new ArrayList<>();
        l2.add(new LastYearsDangerItemModel("行驶证",null));
        groupList.add(new LastYearsDangerModel("上一年新车？",true,l2));

        expandAdapter = new ExpandLastYearDangerAdapter(this, LastYearsDangerActivity.this , groupList);
        expandableListView.setAdapter(expandAdapter);
        expandableListView.expandGroup(groupList.size()-1);
        expandableListView.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("onActivityResult", requestCode + ":"+resultCode+"");

        if (resultCode == RESULT_OK &&
                (requestCode == PhotoPicker.REQUEST_CODE || requestCode == PhotoPreview.REQUEST_CODE)) {
            Log.e("currentGroupPos",expandAdapter.getCurrentGroupPos()+":"+expandAdapter.getCurrentChildPos());
            List<String> photos = null;
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                if (photos.size()==0){
                    groupList.get(expandAdapter.getCurrentGroupPos()).getDataList().get(expandAdapter.getCurrentChildPos()).setLocPath(null);
                }else {
                    groupList.get(expandAdapter.getCurrentGroupPos()).getDataList().get(expandAdapter.getCurrentChildPos()).setLocPath(photos.get(0));
                }
                expandAdapter.notifyDataSetChanged();
            }
        }
    }
}
