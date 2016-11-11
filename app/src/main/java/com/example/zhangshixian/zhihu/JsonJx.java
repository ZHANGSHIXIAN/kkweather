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

        public static Map<String,String> parseCityWeatherInfo(String jsonData){
            Map<String,String> weatherInfo=new HashMap<String, String>();
            try{
                JSONObject jsonObject=new JSONObject(jsonData);
                JSONArray jsonArray=jsonObject.getJSONArray("HeWeather data service 3.0");
                JSONObject jsonObject1=jsonArray.getJSONObject(0);

                JSONObject aqi=null;
                String pm25="无数据";String qlty="无数据";
                if (!jsonObject1.isNull("aqi")) {
                    aqi= jsonObject1.getJSONObject("aqi");
                    JSONObject city = aqi.getJSONObject("city");
                    pm25 = city.getString("pm25").toString();
                    qlty = city.getString("qlty").toString();
                }


                JSONArray daily=jsonObject1.getJSONArray("daily_forecast");
                JSONObject d1=daily.getJSONObject(0);
                JSONObject tmp=d1.getJSONObject("tmp");
                String max=tmp.getString("max");
                String min=tmp.getString("min");

                JSONObject wind=d1.getJSONObject("wind");
                String spd=wind.getString("spd");

                JSONObject now=jsonObject1.getJSONObject("now");
                String cur_tmp=now.getString("tmp").toString();

                String hum=d1.getString("hum").toString();
                JSONObject astro=d1.getJSONObject("astro");
                String ss=astro.getString("ss").toString();
                String sr=astro.getString("sr").toString();

                JSONObject suggestion=jsonObject1.getJSONObject("suggestion");
                JSONObject drsg=suggestion.getJSONObject("drsg");
                JSONObject flu=suggestion.getJSONObject("flu");
                JSONObject trav=suggestion.getJSONObject("trav");
                JSONObject sport=suggestion.getJSONObject("sport");
                String drsg_brf=drsg.getString("brf").toString();
                String drsg_txt=drsg.getString("txt").toString();
                String flu_brf=flu.getString("brf").toString();
                String flu_txt=flu.getString("txt").toString();
                String sport_brf=sport.getString("brf").toString();
                String sport_txt=sport.getString("txt").toString();
                String trav_brf=trav.getString("brf").toString();
                String trav_txt=trav.getString("txt").toString();


                for(int i=0;i<daily.length();i++){
                    String day="df"+i+"_";
                    JSONObject d=daily.getJSONObject(i);
                    JSONObject cond=d.getJSONObject("cond");
                    String df_text_d=cond.getString("txt_d").toString();
                    JSONObject df_wind=d.getJSONObject("wind");
                    String df_sc=df_wind.getString("sc").toString();
                    String df_spd=df_wind.getString("spd").toString();
                    JSONObject df_tmp=d.getJSONObject("tmp");
                    String df_max=df_tmp.getString("max").toString();
                    String df_min=df_tmp.getString("min").toString();
                    String df_date=d.getString("date").toString();
                    String df_pop=d.getString("pop").toString();
                    JSONObject df_astro=d.getJSONObject("astro");
                    String df_sr=df_astro.getString("sr").toString();
                    String df_ss=df_astro.getString("ss").toString();

                    weatherInfo.put(day+"txt_d",df_text_d);
                    weatherInfo.put(day+"sc",df_sc);
                    weatherInfo.put(day+"spd",df_spd);
                    weatherInfo.put(day+"max",df_max);
                    weatherInfo.put(day+"min",df_min);
                    weatherInfo.put(day+"date",df_date);
                    weatherInfo.put(day+"pop",df_pop);
                    weatherInfo.put(day+"sr",df_sr);
                    weatherInfo.put(day+"ss",df_ss);



                }



                weatherInfo.put("pm25",pm25);
                weatherInfo.put("qlty",qlty);
                weatherInfo.put("max",max);
                weatherInfo.put("min",min);
                weatherInfo.put("spd",spd);
                weatherInfo.put("tmp",cur_tmp);
                weatherInfo.put("hum",hum);
                weatherInfo.put("ss",ss);
                weatherInfo.put("sr",sr);
                weatherInfo.put("drsg_brf",drsg_brf);
                weatherInfo.put("drsg_txt",drsg_txt);
                weatherInfo.put("flu_brf",flu_brf);
                weatherInfo.put("flu_txt",flu_txt);
                weatherInfo.put("sport_brf",sport_brf);
                weatherInfo.put("sport_txt",sport_txt);
                weatherInfo.put("trav_brf",trav_brf);
                weatherInfo.put("trav_txt",trav_txt);


            }catch (Exception e)
            {
                e.printStackTrace();
            }finally {

            }

            return weatherInfo;

        }



    public static List<String> getCityList(String jsondata){

        List<String> list= new ArrayList<String>();
        try {
            JSONObject jsob = new JSONObject(jsondata);
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



    public static Map<String,String> getCityMap(String jsondata) {

        Map<String,String> citymap=new HashMap<String, String>();

        try {
            JSONObject jsob = new JSONObject(jsondata);
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
