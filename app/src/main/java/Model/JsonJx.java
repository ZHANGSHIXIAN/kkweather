package model;

import com.example.zhangshixian.kkweather.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Myapplication;

/**
 * Created by ZHANGSHIXIAN on 2016/5/19.
 */
public class JsonJx {

    static String allcityjaon = Myapplication.getContext().getResources().getString(R.string.allcityjson);
    private static Map<String,String> citymap;
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
        if (citymap==null) {

            citymap = new HashMap<String, String>();

            try {
                JSONObject jsob = new JSONObject(allcityjaon);
                JSONArray jsarry = jsob.getJSONArray("city_info");
                for (int i = 0; i < jsarry.length(); i++) {
                    JSONObject shu = jsarry.getJSONObject(i);
                    citymap.put(shu.getString("city").toString(), shu.getString("id"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return citymap;

    }
    public static String getCityUrl(String name){
        citymap=JsonJx.getCityMap();
        String cityid = citymap.get(name);
        String cityIdhead = "https://free-api.heweather.com/v5/weather?city=";
        String cityIdlast = "&key=0137e4ea121e4f2ba49c7aa176dd68a8";
        String cityUrl = cityIdhead + cityid + cityIdlast;
        return cityUrl;

    }

}
