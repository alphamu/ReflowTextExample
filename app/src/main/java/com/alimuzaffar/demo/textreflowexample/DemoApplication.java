package com.alimuzaffar.demo.textreflowexample;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/roboto-mono-regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
