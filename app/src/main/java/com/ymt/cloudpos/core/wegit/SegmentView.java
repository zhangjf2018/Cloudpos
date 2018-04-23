package com.ymt.cloudpos.core.wegit;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ymt.cloudpos.R;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by zhangjifeng on 2018/4/23.
 * email : 414512194@qq.com
 * desc  :
 */

public class SegmentView extends LinearLayout {
    private TextView textView1;
    private TextView textView2;
    private onSegmentViewClickListener listener;
    public SegmentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SegmentView(Context context) {
        super(context);
        init();
    }

    private void init() {
//		this.setLayoutParams(new LinearLayout.LayoutParams(dp2Px(getContext(), 60), LinearLayout.LayoutParams.WRAP_CONTENT));
        textView1 = new TextView(getContext());
        textView2 = new TextView(getContext());
        textView1.setLayoutParams(new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1));
        textView2.setLayoutParams(new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1));
        textView1.setText("保险产品");
        textView2.setText("汽车用品");
//        XmlPullParser xrp = getResources().getXml(R.drawable.seg_text_color_selector);
//        try {
//            ColorStateList csl = ColorStateList.createFromXml(getResources(), xrp);
//            textView1.setTextColor(csl);
//            textView2.setTextColor(csl);
//        } catch (Exception e) {
//        }
        textView1.setTextColor(ContextCompat.getColor(getContext(),R.color.bg_orig));
        textView1.setGravity(Gravity.CENTER);
        textView2.setGravity(Gravity.CENTER);
        textView1.setPadding(dp2Px(getContext(),25), 10, dp2Px(getContext(),25), 10);
        textView2.setPadding(dp2Px(getContext(),25), 10, dp2Px(getContext(),25), 10);
        setSegmentTextSize(20);
        textView1.setBackgroundResource(R.drawable.seg_left);
        textView2.setBackgroundResource(R.drawable.seg_right);
        textView1.setSelected(true);
        textView2.setTextColor(ContextCompat.getColor(getContext(),R.color.bg_orig));
        textView1.setTextColor(ContextCompat.getColor(getContext(),R.color.white));
        this.removeAllViews();
        this.addView(textView1);
        this.addView(textView2);
        this.invalidate();

        textView1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (textView1.isSelected()) {
                    return;
                }
                textView1.setSelected(true);
                textView2.setSelected(false);
                textView2.setTextColor(ContextCompat.getColor(getContext(),R.color.bg_orig));
                textView1.setTextColor(ContextCompat.getColor(getContext(),R.color.white));
                if (listener != null) {
                    listener.onSegmentViewClick(textView1, 0);
                }
            }
        });
        textView2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (textView2.isSelected()) {
                    return;
                }
                textView2.setSelected(true);
                textView1.setSelected(false);
                textView2.setTextColor(ContextCompat.getColor(getContext(),R.color.white));
                textView1.setTextColor(ContextCompat.getColor(getContext(),R.color.bg_orig));
                if (listener != null) {
                    listener.onSegmentViewClick(textView2, 1);
                }
            }
        });
    }
    /**
     * 设置字体大小 单位dip
     * @param dp
     */
    public void setSegmentTextSize(int dp) {
        textView1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, dp);
        textView2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, dp);
    }

    private static int dp2Px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public void setOnSegmentViewClickListener(onSegmentViewClickListener listener) {
        this.listener = listener;
    }

    /**
     * 设置文字
     * @param text
     * @param position
     */
    public void setSegmentText(CharSequence text,int position) {
        if (position == 0) {
            textView1.setText(text);
        }
        if (position == 1) {
            textView2.setText(text);
        }
    }

    public static interface onSegmentViewClickListener{
        /**
         *
         * @param v
         * @param position 0-左边 1-右边
         */
        public void onSegmentViewClick(View v, int position);
    }
}

