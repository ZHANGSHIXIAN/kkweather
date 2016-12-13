package model;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;

import util.Myapplication;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by ZHANGSHIXIAN on 2016/5/19.
 */
public class NetQuest {

    public static String getCityJson(Context context,String cityname){
                Map<String,String> citymap;

                citymap=JsonJx.getCityMap();

                String cityid = citymap.get(cityname);
                String cityIdhead = "https://api.heweather.com/x3/weather?cityid=";
                String cityIdlast = "&key=0137e4ea121e4f2ba49c7aa176dd68a8";
                String cityUrl = cityIdhead + cityid + cityIdlast;
                String result=null;
                try {
                    URL url=new URL(cityUrl);
                    HttpsURLConnection connection=(HttpsURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();
                    InputStream is=connection.getInputStream();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(is,"UTF-8"));
                    StringBuilder response=new StringBuilder();
                    String strRead=null;
                    while((strRead=reader.readLine())!=null){
                        response.append(strRead);
                    }
                    reader.close();
                    is.close();
                    result=response.toString();
                    result=result.replace(" ","");
                    result=result.replace("3.0","");

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
        return result;
    }



/*
    public static String getAllCityJsonInfo(){
        HttpsURLConnection connection = null;
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL("https://api.heweather.com/x3/citylist?search=allchina&key=0137e4ea121e4f2ba49c7aa176dd68a8");
            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));

            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();

            }
        }




        return response.toString();
    }
    */

    public static boolean NetworkIsAvailable(){
        ConnectivityManager con=(ConnectivityManager) Myapplication.getContext().getSystemService(Activity.CONNECTIVITY_SERVICE);
        boolean wifi=con.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
        boolean internet=con.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
        if(wifi|internet){
            return true;
        }else{
            return false;
        }
    }

}
