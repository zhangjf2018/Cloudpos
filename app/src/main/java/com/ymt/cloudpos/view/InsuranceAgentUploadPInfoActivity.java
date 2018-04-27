package com.ymt.cloudpos.view;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ymt.cloudpos.MainActivity;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.InsuranceAgentAdapter;
import com.ymt.cloudpos.adapter.InsuranceAgentUploadItemAdapter;
import com.ymt.cloudpos.adapter.InsuranceSelectedAgentAdapter;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewDivider;
import com.ymt.cloudpos.core.adaper.RecyclerViewHolder;
import com.ymt.cloudpos.model.IdUploadModel;
import com.ymt.cloudpos.model.InsuranceAgentModel;
import com.ymt.cloudpos.test.PhotoAdapter;
import com.ymt.cloudpos.test.RecyclerItemClickListener;
import com.ymt.cloudpos.util.CommonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.iwf.photopicker.PhotoPicker;
import me.iwf.photopicker.PhotoPreview;

public class InsuranceAgentUploadPInfoActivity extends BaseActivity {
    private ArrayList<String> selectedPhotos = new ArrayList<>();
    private ArrayList<IdUploadModel> mIdUploadModelList = new ArrayList<>();
    private PhotoAdapter photoAdapter;
    private InsuranceSelectedAgentAdapter mInsuranceSelectedAgentAdapter;
    private InsuranceAgentUploadItemAdapter insuranceAgentUploadItemAdapter;
    private int MAX=1;
    private int currentPos;

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

        findViewById(R.id.btn_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhotoPicker.builder()
                        .setPhotoCount(1)
                        .setShowCamera(true)
                        .setShowGif(true)
                        .setPreviewEnabled(true)
                        .start(InsuranceAgentUploadPInfoActivity.this, PhotoPicker.REQUEST_CODE);
            }
        });
//
//        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recycler_view);
//        photoAdapter = new PhotoAdapter(this, selectedPhotos);
//
//        recyclerView2.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
//        recyclerView2.setAdapter(photoAdapter);
//        recyclerView2.addOnItemTouchListener(new RecyclerItemClickListener(this,
//                new RecyclerItemClickListener.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(View view, int position) {
//                        if (photoAdapter.getItemViewType(position) == PhotoAdapter.TYPE_ADD) {
//                            PhotoPicker.builder()
//                                    .setPhotoCount(PhotoAdapter.MAX)
//                                    .setShowCamera(true)
//                                    .setPreviewEnabled(false)
//                                    .setSelected(selectedPhotos)
//                                    .start(InsuranceAgentUploadPInfoActivity.this);
//                        } else {
//                            PhotoPreview.builder()
//                                    .setPhotos(selectedPhotos)
//                                    .setCurrentItem(position)
//                                    .start(InsuranceAgentUploadPInfoActivity.this);
//                        }
//                    }
//                }));

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
}
