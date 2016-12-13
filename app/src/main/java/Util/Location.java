package util;

import android.content.Context;
import android.preference.PreferenceManager;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

/**
 * Created by ZHANGSHIXIAN on 2016/10/22.
 */
public class Location implements AMapLocationListener,PreferenceManager.OnActivityDestroyListener {
   AMapLocationClient mLocationClient=null;
   AMapLocationClientOption mLocationOption=null;
    public String cityname = null;
    Context context=null;

    public void getlocation(Context context) {
        //初始化定位
        mLocationClient = new AMapLocationClient(context);
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();

        /*this.mLocationClient=mLocationClient;
        this.mLocationOption=mLocationOption;*/
        this.context=context;
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(false);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(1000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //声明和设置定位回调监听器
        mLocationClient.setLocationListener(this);
        mLocationClient.startLocation();

    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation!=null&&aMapLocation.getErrorCode()==0){
            //定位成功回调信息，设置相关消息
            cityname=aMapLocation.getCity();//城市信息
            if (cityname!=null||!cityname.equals(""))
                cityname=cityname.replace("市","");
        }
    }


    @Override
    public void onActivityDestroy() {
        mLocationClient.onDestroy();
    }
}



  /*      new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent mainIntent = new Intent(getApplicationContext(),ScrollingActivity.class);
                if (s4==null||s4.equals(""))
                    s4="定位失败";
                mainIntent.putExtra("cityname",s4);
                startActivity(mainIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                mLocationClient.stopLocation();
                finish();
            }

        }, 1500);
    }*/


