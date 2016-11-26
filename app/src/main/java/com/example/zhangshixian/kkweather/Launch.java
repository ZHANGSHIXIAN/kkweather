package com.example.zhangshixian.kkweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by ZHANGSHIXIAN on 2016/7/24.
 */
public class Launch extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                Intent mainIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();

    }


}