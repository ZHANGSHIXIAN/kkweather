package com.example.zhangshixian.kkweather;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZHANGSHIXIAN on 2016/11/2.
 */
public class DataBase {
    private Context context;
    private SharedPreferences Sp;

    public DataBase(){
        this.context=Myapplication.getContext();
    }

    public void save(String name,String data){

        SharedPreferences.Editor editor =context.getSharedPreferences(name,Context.MODE_PRIVATE).edit();
        editor.putString(name,data);
        editor.commit();

    }

    public String restore(String filename){
        SharedPreferences pref= context.getSharedPreferences(filename,Context.MODE_PRIVATE);
        String data=pref.getString(filename,"");
        return data;
    }
    public void saveCiytList(List<String> list){
        List<String> citylist=new ArrayList<>();
        citylist=list;
        SharedPreferences.Editor editor=context.getSharedPreferences("citytablist",Context.MODE_PRIVATE).edit();
        for (int i = 0; i < citylist.size(); i++) {
            editor.putString(i+"",citylist.get(i));
        }

        editor.commit();
        SharedPreferences.Editor editor1=context.getSharedPreferences("citytablistsize",Context.MODE_PRIVATE).edit();
        editor1.putInt("size",citylist.size());
        editor1.commit();



    }
    public List<String> restoreCityList(){
        List<String> citylist=new ArrayList<>();
        SharedPreferences pref= context.getSharedPreferences("citytablist",Context.MODE_PRIVATE);
        SharedPreferences tabsize= context.getSharedPreferences("citytablistsize",Context.MODE_PRIVATE);
        int size=tabsize.getInt("size",0);
        for (int i = 0; i < size; i++) {
                citylist.add(pref.getString(i+"",""));
        }
        return citylist;
    }

    public boolean fileIsExists(String filename){
        String packagename=context.getPackageName();
        String address="/data/data/"+packagename+"/shared_prefs/"+filename+".xml";
        try{
            File f=new File(address);
            if(f.exists()){
                return true;
            }


        }catch (Exception e) {
            // TODO: handle exception
            return false;
        }finally {

        }
        return false;
    }
}
