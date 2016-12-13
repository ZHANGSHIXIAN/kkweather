package com.example.zhangshixian.kkweather;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.DataBase;
import model.NetQuest;
import model.WeatherBean;
import util.Myapplication;
import util.SnackbarUtil;

/**
 * Created by ZHANGSHIXIAN on 2016/10/28.
 */
public class OneFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    String cityname;
    ImageView cond;
    TextView cur;
    TextView min;
    TextView max;
    TextView qlt;
    TextView pm25;
    TextView sunrise;
    TextView sunset;
    TextView hum;
    TextView spd;
    TextView drsg_brf;
    TextView sport_brf;
    TextView flu_brf;
    TextView trav_brf;
    TextView drsg_txt;
    TextView sport_txt;
    TextView flu_txt;
    TextView trav_txt;
    ImageView forecast0_image;
    ImageView forecast1_image;
    ImageView forecast2_image;
    ImageView forecast3_image;
    ImageView forecast4_image;
    ImageView forecast5_image;
    ImageView forecast6_image;
    TextView forecast0_maxmin;
    TextView forecast1_maxmin;
    TextView forecast2_maxmin;
    TextView forecast3_maxmin;
    TextView forecast4_maxmin;
    TextView forecast5_maxmin;
    TextView forecast6_maxmin;
    TextView forecast0_date;
    TextView forecast1_date;
    TextView forecast2_date;
    TextView forecast3_date;
    TextView forecast4_date;
    TextView forecast5_date;
    TextView forecast6_date;
    TextView forecast0_info;
    TextView forecast1_info;
    TextView forecast2_info;
    TextView forecast3_info;
    TextView forecast4_info;
    TextView forecast5_info;
    TextView forecast6_info;
    View mview=null;
    SwipeRefreshLayout swipeRefreshLayout;

    private static Gson gson;


    public static OneFragment newInstance(String cityname) {
        OneFragment f = new OneFragment();
        Bundle b = new Bundle();
        b.putString("cityname", cityname);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            cityname = args.getString("cityname");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       if (mview==null) {
           View view = inflater.inflate(R.layout.fragment_one, container, false);
           initData(view);
           swipeRefreshLayout.post(new Runnable() {
               @Override
               public void run() {
                   swipeRefreshLayout.setRefreshing(true);
                   new WeatherAsyncTask().execute(cityname);
               }
           });
           mview=view;
           return view;
       }else {
           return mview;
       }
    }


    private void initData(View view){

        swipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.swipe);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_green_light,android.R.color.holo_blue_light,android.R.color.holo_orange_light,android.R.color.holo_purple);
        swipeRefreshLayout.setOnRefreshListener(this);

        cond=(ImageView) view.findViewById(R.id.cond_image);
        cur=(TextView) view.findViewById(R.id.cur_weather);
        min=(TextView) view.findViewById(R.id.min_weather);
        max=(TextView) view.findViewById(R.id.max_weather);
        qlt=(TextView) view.findViewById(R.id.qlt);
        pm25=(TextView)view.findViewById(R.id.pm25);
        sunrise=(TextView) view.findViewById(R.id.sunrise);
        sunset=(TextView) view.findViewById(R.id.sunset);
        hum=(TextView) view.findViewById(R.id.hum);
        spd=(TextView) view.findViewById(R.id.spd);


        drsg_brf=(TextView ) view.findViewById(R.id.drsg_brf);
        sport_brf=(TextView ) view.findViewById(R.id.sport_brf);
        flu_brf=(TextView ) view.findViewById(R.id.flu_brf);
        trav_brf=(TextView ) view.findViewById(R.id.trav_brf);
        drsg_txt=(TextView ) view.findViewById(R.id.drsg_txt);
        sport_txt=(TextView ) view.findViewById(R.id.sport_txt);
        flu_txt=(TextView ) view.findViewById(R.id.flu_txt);
        trav_txt=(TextView ) view.findViewById(R.id.trav_txt);

        forecast0_image=(ImageView) view.findViewById(R.id.forecast0_image);
        forecast0_date=(TextView) view.findViewById(R.id.forecast0_date);
        forecast0_maxmin=(TextView) view.findViewById(R.id.forecast0_maxmin);
        forecast0_info=(TextView) view.findViewById(R.id.forecast0_info);

        forecast1_image=(ImageView) view.findViewById(R.id.forecast1_image);
        forecast1_date=(TextView) view.findViewById(R.id.forecast1_date);
        forecast1_maxmin=(TextView) view.findViewById(R.id.forecast1_maxmin);
        forecast1_info=(TextView) view.findViewById(R.id.forecast1_info);

        forecast2_image=(ImageView) view.findViewById(R.id.forecast2_image);
        forecast2_date=(TextView) view.findViewById(R.id.forecast2_date);
        forecast2_maxmin=(TextView) view.findViewById(R.id.forecast2_maxmin);
        forecast2_info=(TextView) view.findViewById(R.id.forecast2_info);

        forecast3_image=(ImageView) view.findViewById(R.id.forecast3_image);
        forecast3_date=(TextView) view.findViewById(R.id.forecast3_date);
        forecast3_maxmin=(TextView) view.findViewById(R.id.forecast3_maxmin);
        forecast3_info=(TextView) view.findViewById(R.id.forecast3_info);

        forecast4_image=(ImageView) view.findViewById(R.id.forecast4_image);
        forecast4_date=(TextView) view.findViewById(R.id.forecast4_date);
        forecast4_maxmin=(TextView) view.findViewById(R.id.forecast4_maxmin);
        forecast4_info=(TextView) view.findViewById(R.id.forecast4_info);

        forecast5_image=(ImageView) view.findViewById(R.id.forecast5_image);
        forecast5_date=(TextView) view.findViewById(R.id.forecast5_date);
        forecast5_maxmin=(TextView) view.findViewById(R.id.forecast5_maxmin);
        forecast5_info=(TextView) view.findViewById(R.id.forecast5_info);

        forecast6_image=(ImageView) view.findViewById(R.id.forecast6_image);
        forecast6_date=(TextView) view.findViewById(R.id.forecast6_date);
        forecast6_maxmin=(TextView) view.findViewById(R.id.forecast6_maxmin);
        forecast6_info=(TextView) view.findViewById(R.id.forecast6_info);

    }


    public void updateui(){
        new WeatherAsyncTask().execute(cityname);
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        updateui();
    }


    class WeatherAsyncTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... params) {
            String cityname=params[0];
            DataBase dataBase= new DataBase();
            String cityjsondata="";
            if (NetQuest.NetworkIsAvailable()){
                 cityjsondata=NetQuest.getCityJson(Myapplication.getContext(),cityname);
                    dataBase.save(cityname,cityjsondata);
            }else{
                if (dataBase.fileIsExists(cityname)){
                    cityjsondata=dataBase.restore(cityname);

                }
                SnackbarUtil.ShortSnackbar(mview,"请检查网络连接",SnackbarUtil.Alert).show();
            }

            return cityjsondata;
        }


        @Override
        protected void onPostExecute(String s) {
            try {
            super.onPostExecute(s);
                if (!s.equals("")) {
                    if (gson==null)
                        gson = new Gson();
                    WeatherBean weatherBean = gson.fromJson(s, WeatherBean.class);
                    WeatherBean.HeWeatherdataserviceBean w = weatherBean.getHeWeatherdataservice().get(0);
                    updateui(w);
                    swipeRefreshLayout.setRefreshing(false);
                }else {
                    SnackbarUtil.ShortSnackbar(mview,"更新失败",SnackbarUtil.Alert).show();
                    swipeRefreshLayout.setRefreshing(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        private void updateui(WeatherBean.HeWeatherdataserviceBean w) throws Exception {
            cur.setText(w.getNow().getTmp()+"°C");
            min.setText("↓" + w.getDaily_forecast().get(0).getTmp().getMin() + "°");
            max.setText("↑" + w.getDaily_forecast().get(0).getTmp().getMax() + "°");
            if (w.getAqi()!=null) {
                pm25.setText("PM2.5 : " + w.getAqi().getCity().getPm25()+"ug/m³");
                qlt.setText("空气质量：" + w.getAqi().getCity().getQlty());
                //loctime.setText(""+weatherinfo.get("loc"));
            }else {
                pm25.setText("PM2.5: 暂无数据");
                qlt.setText("空气质量：暂无数据");
            }

            spd.setText(w.getDaily_forecast().get(0).getWind().getSpd()+"km/h");
            sunset.setText(w.getDaily_forecast().get(0).getAstro().getSs() + "");
            hum.setText(w.getNow().getHum() + "%");
            sunrise.setText(w.getDaily_forecast().get(0).getAstro().getSr() + "");

            drsg_brf.setText("穿衣指数--" + w.getSuggestion().getDrsg().getBrf());
            drsg_txt.setText("" + w.getSuggestion().getDrsg().getTxt());
            sport_brf.setText("运动指数--" + w.getSuggestion().getSport().getBrf());
            sport_txt.setText("" + w.getSuggestion().getSport().getTxt());
            flu_brf.setText("感冒指数--" + w.getSuggestion().getFlu().getBrf());
            flu_txt.setText("" + w.getSuggestion().getFlu().getTxt());
            trav_brf.setText("旅行指数--" + w.getSuggestion().getTrav().getBrf());
            trav_txt.setText("" + w.getSuggestion().getTrav().getTxt());

            forecast0_maxmin.setText(w.getDaily_forecast().get(0).getTmp().getMin()+"°~"+w.getDaily_forecast().get(0).getTmp().getMax()+"°");
            forecast0_info.setText("白天:"+w.getDaily_forecast().get(0).getCond().getTxt_d()+" 夜晚:"+w.getDaily_forecast().get(0).getCond().getTxt_n()+"。 "+w.getDaily_forecast().get(0).getWind().getSc()+"："+w.getDaily_forecast().get(0).getWind().getSpd()+"km/h  "+"降水概率: "+w.getDaily_forecast().get(0).getPop()+"% "+
                    "    日出:  "+w.getDaily_forecast().get(0).getAstro().getSr()+"     日落:  "+w.getDaily_forecast().get(0).getAstro().getSs());
            setWeatherImage(w.getDaily_forecast().get(0).getCond().getTxt_d(),forecast0_image);
            setWeatherImage(w.getDaily_forecast().get(0).getCond().getTxt_d(),cond);


            forecast1_maxmin.setText(w.getDaily_forecast().get(1).getTmp().getMin()+"°~"+w.getDaily_forecast().get(1).getTmp().getMax()+"°");
            forecast1_info.setText("白天:"+w.getDaily_forecast().get(1).getCond().getTxt_d()+" 夜晚:"+w.getDaily_forecast().get(1).getCond().getTxt_n()+"。 "+w.getDaily_forecast().get(1).getWind().getSc()+"："+w.getDaily_forecast().get(1).getWind().getSpd()+"km/h  "+"降水概率: "+w.getDaily_forecast().get(1).getPop()+"% "+
                    "    日出:  "+w.getDaily_forecast().get(1).getAstro().getSr()+"     日落:  "+w.getDaily_forecast().get(1).getAstro().getSs());
            setWeatherImage(w.getDaily_forecast().get(1).getCond().getTxt_d(),forecast1_image);

            forecast2_maxmin.setText(w.getDaily_forecast().get(2).getTmp().getMin()+"°~"+w.getDaily_forecast().get(2).getTmp().getMax()+"°");
            forecast2_info.setText("白天:"+w.getDaily_forecast().get(2).getCond().getTxt_d()+" 夜晚:"+w.getDaily_forecast().get(2).getCond().getTxt_n()+"。 "+w.getDaily_forecast().get(2).getWind().getSc()+"："+w.getDaily_forecast().get(2).getWind().getSpd()+"km/h  "+"降水概率: "+w.getDaily_forecast().get(2).getPop()+"% "+
                    "    日出:  "+w.getDaily_forecast().get(2).getAstro().getSr()+"     日落:  "+w.getDaily_forecast().get(2).getAstro().getSs());
            setWeatherImage(w.getDaily_forecast().get(2).getCond().getTxt_d(),forecast2_image);
            forecast2_date.setText(dayForWeek(w.getDaily_forecast().get(2).getDate()));

            forecast3_maxmin.setText(w.getDaily_forecast().get(3).getTmp().getMin()+"°~"+w.getDaily_forecast().get(3).getTmp().getMax()+"°");
            forecast3_info.setText("白天:"+w.getDaily_forecast().get(3).getCond().getTxt_d()+" 夜晚:"+w.getDaily_forecast().get(3).getCond().getTxt_n()+"。 "+w.getDaily_forecast().get(3).getWind().getSc()+"："+w.getDaily_forecast().get(3).getWind().getSpd()+"km/h  "+"降水概率: "+w.getDaily_forecast().get(3).getPop()+"% "+
                    "    日出:  "+w.getDaily_forecast().get(3).getAstro().getSr()+"     日落:  "+w.getDaily_forecast().get(3).getAstro().getSs());
            setWeatherImage(w.getDaily_forecast().get(3).getCond().getTxt_d(),forecast3_image);
            forecast3_date.setText(dayForWeek(w.getDaily_forecast().get(3).getDate()));

            forecast4_maxmin.setText(w.getDaily_forecast().get(4).getTmp().getMin()+"°~"+w.getDaily_forecast().get(4).getTmp().getMax()+"°");
            forecast4_info.setText("白天:"+w.getDaily_forecast().get(4).getCond().getTxt_d()+" 夜晚:"+w.getDaily_forecast().get(4).getCond().getTxt_n()+"。 "+w.getDaily_forecast().get(4).getWind().getSc()+"："+w.getDaily_forecast().get(4).getWind().getSpd()+"km/h  "+"降水概率: "+w.getDaily_forecast().get(4).getPop()+"% "+
                    "    日出:  "+w.getDaily_forecast().get(4).getAstro().getSr()+"     日落:  "+w.getDaily_forecast().get(4).getAstro().getSs());
            setWeatherImage(w.getDaily_forecast().get(4).getCond().getTxt_d(),forecast4_image);
            forecast4_date.setText(dayForWeek(w.getDaily_forecast().get(4).getDate()));

            forecast5_maxmin.setText(w.getDaily_forecast().get(5).getTmp().getMin()+"°~"+w.getDaily_forecast().get(5).getTmp().getMax()+"°");
            forecast5_info.setText("白天:"+w.getDaily_forecast().get(5).getCond().getTxt_d()+" 夜晚:"+w.getDaily_forecast().get(5).getCond().getTxt_n()+"。 "+w.getDaily_forecast().get(5).getWind().getSc()+"："+w.getDaily_forecast().get(5).getWind().getSpd()+"km/h  "+"降水概率: "+w.getDaily_forecast().get(5).getPop()+"% "+
                    "    日出:  "+w.getDaily_forecast().get(5).getAstro().getSr()+"     日落:  "+w.getDaily_forecast().get(5).getAstro().getSs());
            setWeatherImage(w.getDaily_forecast().get(5).getCond().getTxt_d(),forecast5_image);
            forecast5_date.setText(dayForWeek(w.getDaily_forecast().get(5).getDate()));

            forecast6_maxmin.setText(w.getDaily_forecast().get(6).getTmp().getMin()+"°~"+w.getDaily_forecast().get(6).getTmp().getMax()+"°");
            forecast6_info.setText("白天:"+w.getDaily_forecast().get(6).getCond().getTxt_d()+" 夜晚:"+w.getDaily_forecast().get(6).getCond().getTxt_n()+"。 "+w.getDaily_forecast().get(6).getWind().getSc()+"："+w.getDaily_forecast().get(6).getWind().getSpd()+"km/h  "+"降水概率: "+w.getDaily_forecast().get(6).getPop()+"% "+
                    "    日出:  "+w.getDaily_forecast().get(6).getAstro().getSr()+"     日落:  "+w.getDaily_forecast().get(6).getAstro().getSs());
            setWeatherImage(w.getDaily_forecast().get(6).getCond().getTxt_d(),forecast6_image);
            forecast6_date.setText(dayForWeek(w.getDaily_forecast().get(6).getDate()));

        }
        void setWeatherImage(String cond,ImageView imageView)throws Exception{
                /*if (cond.equals("晴天")||cond.equals("晴")) imageView.setImageResource(R.drawable.type_one_sunny);
                else if (cond.equals("多云")||cond.equals("阴")||cond.equals("阴天")) imageView.setImageResource(R.drawable.type_one_cloudy);
                else if (cond.equals("阵雨")||cond.equals("雷阵雨")) imageView.setImageResource(R.drawable.type_one_thunder_rain);
                else if (cond.equals("大雨")||cond.equals("暴雨")||cond.equals("中雨")) imageView.setImageResource(R.drawable.type_one_heavy_rain);
                else if (cond.equals("有风")||cond.equals("和风")||cond.equals("微风")) imageView.setImageResource(R.drawable.type_one_sunny);
                else if (cond.equals("晴间多云")) imageView.setImageResource(R.drawable.type_one_cloudytosunny);
                else if (cond.equals("小雪")||cond.equals("中雪")||cond.equals("大雪")||cond.equals("暴雪")||cond.equals("雨夹雪")) imageView.setImageResource(R.drawable.type_one_snow);
                else if (cond.equals("小雨")) imageView.setImageResource(R.drawable.type_one_light_rain);
                else imageView.setImageResource(R.drawable.type_one_sunny);*/

            if (cond.equals("晴天")||cond.equals("晴")) imageView.setImageBitmap(readBitMap(Myapplication.getContext(),R.drawable.type_one_sunny));
            else if (cond.equals("多云")||cond.equals("阴")||cond.equals("阴天")) imageView.setImageBitmap(readBitMap(Myapplication.getContext(),R.drawable.type_one_cloudy));
            else if (cond.equals("阵雨")||cond.equals("雷阵雨")) imageView.setImageBitmap(readBitMap(Myapplication.getContext(),R.drawable.type_one_thunder_rain));
            else if (cond.equals("大雨")||cond.equals("暴雨")||cond.equals("中雨")) imageView.setImageBitmap(readBitMap(Myapplication.getContext(),R.drawable.type_one_heavy_rain));
            else if (cond.equals("有风")||cond.equals("和风")||cond.equals("微风")) imageView.setImageBitmap(readBitMap(Myapplication.getContext(),R.drawable.type_one_sunny));
            else if (cond.equals("晴间多云")) imageView.setImageBitmap(readBitMap(Myapplication.getContext(),R.drawable.type_one_cloudytosunny));
            else if (cond.equals("小雪")||cond.equals("中雪")||cond.equals("大雪")||cond.equals("暴雪")||cond.equals("雨夹雪")) imageView.setImageBitmap(readBitMap(Myapplication.getContext(),R.drawable.type_one_snow));
            else if (cond.equals("小雨")) imageView.setImageBitmap(readBitMap(Myapplication.getContext(),R.drawable.type_one_light_rain));
            else imageView.setImageBitmap(readBitMap(Myapplication.getContext(),R.drawable.type_one_sunny));
        }

        public  String dayForWeek(String pTime) throws Exception {
            String dayNames[] = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
            Calendar c = Calendar.getInstance();// 获得一个日历的实例
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                c.setTime(sdf.parse(pTime));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return dayNames[c.get(Calendar.DAY_OF_WEEK)-1];
        }

        public  Bitmap readBitMap(Context context, int resId){
            BitmapFactory.Options opt = new BitmapFactory.Options();
            opt.inPreferredConfig = Bitmap.Config.RGB_565;
            opt.inPurgeable = true;
            opt.inInputShareable = true;
            //获取资源图片
            InputStream is = context.getResources().openRawResource(resId);
            return BitmapFactory.decodeStream(is,null,opt);
        }

    }


}
