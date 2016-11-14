package com.example.zhangshixian.zhihu;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZHANGSHIXIAN on 2016/5/19.
 */
public class JsonJx {

    static String allcityjaon =Myapplication.getContext().getResources().getString(R.string.allcityjson);
    public static List<String> getCityList(){

        List<String> list= new ArrayList<String>();
        try {
            JSONObject jsob = new JSONObject(allcityjaon);
            JSONArray jsarry=jsob.getJSONArray("city_info");
            for(int i=0;i<jsarry.length();i++){
                JSONObject shu=jsarry.getJSONObject(i);
                list.add(shu.getString("city").toString());
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }



    public static Map<String,String> getCityMap() {

        Map<String,String> citymap=new HashMap<String, String>();

        try {
            JSONObject jsob = new JSONObject(allcityjaon);
            JSONArray jsarry=jsob.getJSONArray("city_info");
            for(int i=0;i<jsarry.length();i++){
                JSONObject shu=jsarry.getJSONObject(i);
                citymap.put(shu.getString("city").toString(),shu.getString("id"));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return citymap;

    }


}
