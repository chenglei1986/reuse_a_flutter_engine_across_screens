package com.example.android;

import android.content.Context;
import android.content.Intent;

import io.flutter.embedding.android.FlutterActivity;

public class AndroidFlutterActivity extends FlutterActivity {

    static final String EXTRA_CACHED_ENGINE_ID = "cached_engine_id";
    static final String EXTRA_ROUTE = "extra_route";
    static final String EXTRA_DESTROY_ENGINE_WITH_ACTIVITY = "destroy_engine_with_activity";

    public static void open(Context context, String route) {
        Intent intent = new Intent(context, AndroidFlutterActivity.class)
                .putExtra(EXTRA_CACHED_ENGINE_ID, "default_engine_id")
                .putExtra(EXTRA_ROUTE, route)
                .putExtra(EXTRA_DESTROY_ENGINE_WITH_ACTIVITY, false);
        context.startActivity(intent);
    }

    @Override
    public void onFlutterUiDisplayed() {
        super.onFlutterUiDisplayed();

        // 设置 Flutter 界面入口
        String route = getIntent().getStringExtra(EXTRA_ROUTE);
        FlutterTools.setInitRoute(route);
    }
}
