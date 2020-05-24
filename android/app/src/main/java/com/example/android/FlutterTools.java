package com.example.android;

import android.content.Context;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodChannel;

public class FlutterTools {

    public static final String ENGINE_ID = "default_engine_id";

    public static final String ROUTE_PAGE_A = "/page_a";
    public static final String ROUTE_PAGE_B = "/page_b";

    private static final String METHOD_CHANNEL = "com.example/method_channel";

    private static FlutterEngine sFlutterEngine;
    private static MethodChannel sMethodChannel;

    public static void preWarmFlutterEngine(Context context) {
        if (null == sFlutterEngine) {
            sFlutterEngine = new FlutterEngine(context);
            sFlutterEngine.getDartExecutor().executeDartEntrypoint(
                    DartExecutor.DartEntrypoint.createDefault()
            );
            sMethodChannel = new MethodChannel(sFlutterEngine.getDartExecutor(), METHOD_CHANNEL);
            FlutterEngineCache.getInstance().put(ENGINE_ID, sFlutterEngine);
        }
    }

    public static void setInitRoute(String route) {
        sMethodChannel.invokeMethod("setInitRoute", route);
    }

    public static void destroyEngine() {
        if (sFlutterEngine != null) {
            sFlutterEngine.destroy();
        }
    }

}
