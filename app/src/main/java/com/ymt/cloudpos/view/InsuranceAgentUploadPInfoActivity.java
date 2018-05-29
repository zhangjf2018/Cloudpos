package com.ymt.cloudpos.view;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ymt.cloudpos.MainActivity;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.InsuranceAgentUploadItemAdapter;
import com.ymt.cloudpos.adapter.InsuranceSelectedAgentAdapter;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.model.IdUploadModel;
import com.ymt.cloudpos.model.InsuranceAgentModel;
import com.ymt.cloudpos.test.PhotoAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.iwf.photopicker.PhotoPicker;
import me.iwf.photopicker.PhotoPreview;

public class InsuranceAgentUploadPInfoActivity extends BaseActivity implements View.OnClickListener {
    private ArrayList<String> selectedPhotos = new ArrayList<>();
    private ArrayList<IdUploadModel> mIdUploadModelList = new ArrayList<>();
    private InsuranceSelectedAgentAdapter mInsuranceSelectedAgentAdapter;
    private InsuranceAgentUploadItemAdapter insuranceAgentUploadItemAdapter;
    private int MAX=1;
    private int currentPos;
    private int MAXRequirementWords = 60;
    private int countWords = 0;
    private EditText etRequirement;
    private TextView tvInputCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("选择保险公司");

        Bundle bundle = getIntent().getExtras();
        final List<InsuranceAgentModel> insuranceAgentModelList = (List<InsuranceAgentModel>) bundle.getSerializable("InsuranceAgentModel");
        Log.e("InsuranceAgentModel", Arrays.asList(insuranceAgentModelList).toString());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_select_insurance_agent);
        mInsuranceSelectedAgentAdapter = new InsuranceSelectedAgentAdapter(insuranceAgentModelList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(mInsuranceSelectedAgentAdapter);

        RecyclerView recyclerView3 = (RecyclerView) findViewById(R.id.recyclerAgentUploadId);

        mIdUploadModelList.add(new IdUploadModel("车辆行驶证",null,true));
        mIdUploadModelList.add(new IdUploadModel("身份证",null,true));
        mIdUploadModelList.add(new IdUploadModel("车船税见面/完税声明",null,false));
        mIdUploadModelList.add(new IdUploadModel("验车照/车辆登记证",null,false));

        insuranceAgentUploadItemAdapter = new InsuranceAgentUploadItemAdapter(mIdUploadModelList);
        recyclerView3.setLayoutManager(new GridLayoutManager(this,2) );
        recyclerView3.setAdapter(insuranceAgentUploadItemAdapter);
        insuranceAgentUploadItemAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                currentPos = position;
                IdUploadModel idUploadModel = mIdUploadModelList.get(position);
                if(idUploadModel.getLocPath() != null && !"".equals(idUploadModel.getLocPath())){
                    selectedPhotos.clear();
                    selectedPhotos.add(idUploadModel.getLocPath());
                    PhotoPreview.builder()
                                    .setPhotos(selectedPhotos)
                                    .setCurrentItem(position)
                                    .start(InsuranceAgentUploadPInfoActivity.this);
                }else {
                    PhotoPicker.builder()
                            .setPhotoCount(MAX)
                            .setShowCamera(true)
                            .setPreviewEnabled(true)
                            .setSelected(selectedPhotos)
                            .start(InsuranceAgentUploadPInfoActivity.this);
                }
            }
        });

        tvInputCount = (TextView) findViewById(R.id.tv_inputCount);
        tvInputCount.setText(countWords+"/"+MAXRequirementWords);
        etRequirement = (EditText) findViewById(R.id.et_otherRequirement);
        etRequirement.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                countWords = s.length();
                tvInputCount.setText(countWords+"/"+MAXRequirementWords);
                int editStart = etRequirement.getSelectionStart();
                int editEnd = etRequirement.getSelectionEnd();
                if (countWords > MAXRequirementWords) {
                    s.delete(MAXRequirementWords, countWords);
                    etRequirement.setText(s);
                    etRequirement.setSelection(MAXRequirementWords);
                }
            }
        });

        findViewById(R.id.btn_subOrder).setOnClickListener(this);
    }

    @BindingAdapter({"locPath"})
    public static void locPath(ImageView imageView, String locPath) {
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

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("onActivityResult", requestCode + ":"+resultCode+"");

        if (resultCode == RESULT_OK &&
                (requestCode == PhotoPicker.REQUEST_CODE || requestCode == PhotoPreview.REQUEST_CODE)) {

            List<String> photos = null;
            if (data != null) {

                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                if (photos.size()==0){
                    mIdUploadModelList.get(currentPos).setLocPath(null);
                }else {
                    mIdUploadModelList.get(currentPos).setLocPath(photos.get(0));
                }
                insuranceAgentUploadItemAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_insurance_agent_upload_pinfo;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_subOrder:
                boolean flag = checkIdPhoto();
                if(flag){
                    goTo();
                }
                break;
            default:
                break;
        }
    }

    private void goTo() {
        showSuccess("订单已提交成功！");
        Intent intent = new Intent(InsuranceAgentUploadPInfoActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public boolean checkIdPhoto(){
        boolean flag = true;

        for(IdUploadModel model : mIdUploadModelList){
            if (model.isMust()){
                if(model.getLocPath() == null || "".equals(model.getLocPath())){
                    showToastError("请选择 "+model.getName()+ " 照片");
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
