package util;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by ZHANGSHIXIAN on 2016/11/2.
 */
public class Myapplication extends Application {

    private static Context context;

    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

    public static RequestQueue getRequestQueue(){
        if (requestQueue==null){
            requestQueue= Volley.newRequestQueue(Myapplication.getContext());
        }
        return requestQueue;
    }
}
