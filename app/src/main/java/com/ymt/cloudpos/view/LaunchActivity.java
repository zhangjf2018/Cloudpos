package com.ymt.cloudpos.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ymt.cloudpos.MainActivity;
import com.ymt.cloudpos.R;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        Intent intent = new Intent();
        intent.setClass(LaunchActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
