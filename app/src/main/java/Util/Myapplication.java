package util;

import android.app.Application;
import android.content.Context;

/**
 * Created by ZHANGSHIXIAN on 2016/11/2.
 */
public class Myapplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
