package com.example.android;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.tool_bar));
        initViews();

        // 预加载 FlutterEngine
        FlutterTools.preWarmFlutterEngine(this);
    }

    private void initViews() {
        findViewById(R.id.button_page_a).setOnClickListener(this);
        findViewById(R.id.button_page_b).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_page_a:
                AndroidFlutterActivity.open(this, FlutterTools.ROUTE_PAGE_A);
                break;

            case R.id.button_page_b:
                AndroidFlutterActivity.open(this, FlutterTools.ROUTE_PAGE_B);
                break;

            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 释放资源
        FlutterTools.destroyEngine();
    }
}
