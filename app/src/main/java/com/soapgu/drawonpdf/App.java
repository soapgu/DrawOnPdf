package com.soapgu.drawonpdf;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

public class App extends Application {
    private static final String appName = "draw-on-pdf";

    @Override
    public void onCreate() {
        super.onCreate();
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)
                .tag(appName)
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
        int pid = android.os.Process.myPid();
        Logger.i("~~~~~~~%s app startup,pid:%s~~~~~~~~", appName, pid);
    }
}
