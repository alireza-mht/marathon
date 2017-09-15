package com.example.alireza.marathon;

import android.app.Application;
import android.content.res.Configuration;

/**
 * Created by Novin Pendar on 8/12/2017.
 */

public class PostbankApplication extends Application {

    private static PostbankApplication mInstance;

    public static PostbankApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initFont();

    }

    private void initFont() {
        Configuration config = getBaseContext().getResources().getConfiguration();
        TypeFaceUtil.overrideFont(getApplicationContext(), "SERIF", "assets/Shabnam.ttf");
        TypeFaceUtil.overrideFont(getApplicationContext(), "SANS-SERIF", "assets/Shabnam.ttf");
        TypeFaceUtil.overrideFont(getApplicationContext(), "DEFAULT", "assets/Shabnam.ttf");
        getBaseContext().getResources().updateConfiguration(config, getResources().getDisplayMetrics());

    }

}
