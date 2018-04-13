package com.ymt.cloudpos.view;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.CarServiceAdapter;
import com.ymt.cloudpos.adapter.RecommendGoodAdapter;
import com.ymt.cloudpos.adapter.RecommendServiceAdapter;
import com.ymt.cloudpos.core.BaseFragment;
import com.ymt.cloudpos.model.CarServiceModel;
import com.ymt.cloudpos.model.RecommendGoodModel;
import com.ymt.cloudpos.model.RecommendServiceModel;
import com.ymt.cloudpos.util.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjifeng on 2018/4/12.
 * email : 414512194@qq.com
 * desc  :
 */

public class HomeFragment extends BaseFragment implements OnBannerListener {

    private final int BANNERDELAYTIME = 3 * 1000;
    private CarServiceAdapter mCarServiceAdapter;
    private List<CarServiceModel> mCarServiceModelList;

    private RecommendServiceAdapter mRecommendServiceAdapter;
    private List<RecommendServiceModel> mRecommendServiceModelList;

    private RecommendGoodAdapter mRecommendGoodAdapter;
    private List<RecommendGoodModel> mRecommendGoodModelList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initBanner(view);

        mCarServiceModelList = new ArrayList<>();
        setData();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mCarServiceAdapter = new CarServiceAdapter(mCarServiceModelList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        recyclerView.setAdapter(mCarServiceAdapter);

        setRecServiceData(view);
        setRecGoodData(view);

        return view;
    }

    private void setData(){
        mCarServiceModelList.add(new CarServiceModel(R.mipmap.png2, "一键投保"));
        mCarServiceModelList.add(new CarServiceModel(R.mipmap.png_xubao, "一键续保"));
        mCarServiceModelList.add(new CarServiceModel(R.mipmap.png_lipei, "一键理赔"));
        mCarServiceModelList.add(new CarServiceModel(R.mipmap.png_order, "订单跟进"));
        mCarServiceModelList.add(new CarServiceModel(R.mipmap.png_car, "违章查询"));
        mCarServiceModelList.add(new CarServiceModel(R.mipmap.png_year, "年审服务"));
        mCarServiceModelList.add(new CarServiceModel(R.mipmap.png_other, "其他"));
        mCarServiceModelList.add(new CarServiceModel(R.mipmap.png_other, "其他"));
    }

    private void setRecServiceData(View view){
        mRecommendServiceModelList = new ArrayList<>();

        mRecommendServiceModelList.add(new RecommendServiceModel(R.mipmap.app1, "应用1"));
        mRecommendServiceModelList.add(new RecommendServiceModel(R.mipmap.app2, "应用2"));
        mRecommendServiceModelList.add(new RecommendServiceModel(R.mipmap.app3, "应用3"));
        mRecommendServiceModelList.add(new RecommendServiceModel(R.mipmap.app4, "应用4"));

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewRecommend);
        mRecommendServiceAdapter = new RecommendServiceAdapter(mRecommendServiceModelList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        recyclerView.setAdapter(mRecommendServiceAdapter);
    }

    private void setRecGoodData(View view){
        mRecommendGoodModelList = new ArrayList<>();

        mRecommendGoodModelList.add(new RecommendGoodModel(R.mipmap.g1, "轮毂"));
        mRecommendGoodModelList.add(new RecommendGoodModel(R.mipmap.g2, "轮胎"));
        mRecommendGoodModelList.add(new RecommendGoodModel(R.mipmap.g1, "应用3"));
        mRecommendGoodModelList.add(new RecommendGoodModel(R.mipmap.g2, "应用4"));
        mRecommendGoodModelList.add(new RecommendGoodModel(R.mipmap.g1, "应用3"));
        mRecommendGoodModelList.add(new RecommendGoodModel(R.mipmap.g2, "应用4"));

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewRecommendGood);
        mRecommendGoodAdapter = new RecommendGoodAdapter(mRecommendGoodModelList);

//        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2) {
//            @Override
//            public boolean canScrollVertically() {
//                // 直接禁止垂直滑动
//                return false;
//            }
//        };

        recyclerView.setLayoutManager( new GridLayoutManager(getContext(),2) );
        recyclerView.setAdapter( mRecommendGoodAdapter );
        recyclerView.setNestedScrollingEnabled(false);
    }

    @BindingAdapter({"resImgId"})
    public static void loadImage(ImageView imageView, int id) {
        imageView.setImageResource(id);
    }

    private void initBanner(View view){
        List<Integer> images=new ArrayList<>();
        images.add(R.mipmap.banner1);
        images.add(R.mipmap.banner2);
        images.add(R.mipmap.banner3);
        images.add(R.mipmap.banner4);

        Banner banner = (Banner) view.findViewById(R.id.banner);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(images);
        banner.isAutoPlay(true);
        banner.setDelayTime(BANNERDELAYTIME);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setBackgroundColor(Color.WHITE);
        banner.setOnBannerListener(this);
        banner.start();
    }
    @Override
    public void OnBannerClick(int position) {
        Log.e("OnBannerClick", position+"");
    }
}
