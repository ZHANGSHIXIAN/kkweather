package com.example.zhangshixian.kkweather;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import util.Const;

/**
 * Created by ZHANGSHIXIAN on 2016/12/14.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 权限检查方法
     * @param permissions
     * @return
     */
    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String... permissions){
        for (String permission:permissions){
            if (ContextCompat.checkSelfPermission(this,permission)!=
                    PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

    /**
     * 为子类提供一个权限请求方法
     * @param code
     * @param permission
     */
    public void requestPermission(int code,String... permission){
        ActivityCompat.requestPermissions(this,permission,code);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case Const.ACCESS_FINE_LOCATION :
                doLocation();
                break;

        }
    }

    /**
     * 默认定位权限处理
     */
    public void doLocation() {
    }
}
