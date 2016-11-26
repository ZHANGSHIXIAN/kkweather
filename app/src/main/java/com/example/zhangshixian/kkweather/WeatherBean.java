package com.example.zhangshixian.kkweather;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZHANGSHIXIAN on 2016/10/23.
 */
public class WeatherBean {


    /**
     * aqi : {"city":{"aqi":"50","co":"0","no2":"39","o3":"14","pm10":"50","pm25":"26","qlty":"优","so2":"2"}}
     * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","update":{"loc":"2016-10-22 21:55","utc":"2016-10-22 13:55"}}
     * daily_forecast : [{"astro":{"sr":"06:32","ss":"17:25"},"cond":{"code_d":"103","code_n":"101","txt_d":"晴间多云","txt_n":"多云"},"date":"2016-10-22","hum":"67","pcpn":"0.0","pop":"6","pres":"1024","tmp":{"max":"15","min":"6"},"vis":"10","wind":{"deg":"42","dir":"无持续风向","sc":"微风","spd":"7"}},{"astro":{"sr":"06:33","ss":"17:23"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2016-10-23","hum":"50","pcpn":"0.0","pop":"9","pres":"1022","tmp":{"max":"15","min":"5"},"vis":"10","wind":{"deg":"184","dir":"无持续风向","sc":"微风","spd":"7"}},{"astro":{"sr":"06:34","ss":"17:22"},"cond":{"code_d":"104","code_n":"104","txt_d":"阴","txt_n":"阴"},"date":"2016-10-24","hum":"65","pcpn":"6.4","pop":"97","pres":"1018","tmp":{"max":"13","min":"6"},"vis":"9","wind":{"deg":"175","dir":"无持续风向","sc":"微风","spd":"9"}},{"astro":{"sr":"06:35","ss":"17:21"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2016-10-25","hum":"77","pcpn":"0.0","pop":"0","pres":"1017","tmp":{"max":"17","min":"8"},"vis":"10","wind":{"deg":"178","dir":"无持续风向","sc":"微风","spd":"8"}},{"astro":{"sr":"06:36","ss":"17:19"},"cond":{"code_d":"101","code_n":"104","txt_d":"多云","txt_n":"阴"},"date":"2016-10-26","hum":"62","pcpn":"0.0","pop":"0","pres":"1025","tmp":{"max":"17","min":"8"},"vis":"10","wind":{"deg":"139","dir":"无持续风向","sc":"微风","spd":"1"}},{"astro":{"sr":"06:38","ss":"17:18"},"cond":{"code_d":"104","code_n":"100","txt_d":"阴","txt_n":"晴"},"date":"2016-10-27","hum":"79","pcpn":"5.2","pop":"90","pres":"1026","tmp":{"max":"16","min":"10"},"vis":"9","wind":{"deg":"146","dir":"北风","sc":"3-4","spd":"12"}},{"astro":{"sr":"06:39","ss":"17:17"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2016-10-28","hum":"39","pcpn":"0.3","pop":"31","pres":"1030","tmp":{"max":"14","min":"5"},"vis":"10","wind":{"deg":"347","dir":"无持续风向","sc":"微风","spd":"8"}}]
     * hourly_forecast : [{"date":"2016-10-22 22:00","hum":"57","pop":"5","pres":"1026","tmp":"10","wind":{"deg":"171","dir":"南风","sc":"微风","spd":"8"}}]
     * now : {"cond":{"code":"104","txt":"阴"},"fl":"7","hum":"59","pcpn":"0","pres":"1025","tmp":"10","vis":"10","wind":{"deg":"110","dir":"东南风","sc":"4-5","spd":"24"}}
     * status : ok
     * suggestion : {"comf":{"brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"},"cw":{"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"drsg":{"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"},"flu":{"brf":"较易发","txt":"天气较凉，较易发生感冒，请适当增加衣服。体质较弱的朋友尤其应该注意防护。"},"sport":{"brf":"较适宜","txt":"天气较好，但考虑气温较低，推荐您进行室内运动，若户外适当增减衣物并注意防晒。"},"trav":{"brf":"适宜","txt":"天气较好，温度适宜，是个好天气哦。这样的天气适宜旅游，您可以尽情地享受大自然的风光。"},"uv":{"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}}
     */

    private List<HeWeatherdataserviceBean> HeWeatherdataservice;

    public static WeatherBean objectFromData(String str) {

        return new Gson().fromJson(str, WeatherBean.class);
    }

    public static List<WeatherBean> arrayWeatherBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<WeatherBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public List<HeWeatherdataserviceBean> getHeWeatherdataservice() {
        return HeWeatherdataservice;
    }

    public void setHeWeatherdataservice(List<HeWeatherdataserviceBean> HeWeatherdataservice) {
        this.HeWeatherdataservice = HeWeatherdataservice;
    }

    public static class HeWeatherdataserviceBean {
        /**
         * city : {"aqi":"50","co":"0","no2":"39","o3":"14","pm10":"50","pm25":"26","qlty":"优","so2":"2"}
         */

        private AqiBean aqi;
        /**
         * city : 北京
         * cnty : 中国
         * id : CN101010100
         * lat : 39.904000
         * lon : 116.391000
         * update : {"loc":"2016-10-22 21:55","utc":"2016-10-22 13:55"}
         */

        private BasicBean basic;
        /**
         * cond : {"code":"104","txt":"阴"}
         * fl : 7
         * hum : 59
         * pcpn : 0
         * pres : 1025
         * tmp : 10
         * vis : 10
         * wind : {"deg":"110","dir":"东南风","sc":"4-5","spd":"24"}
         */

        private NowBean now;
        private String status;
        /**
         * comf : {"brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"}
         * cw : {"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
         * drsg : {"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"}
         * flu : {"brf":"较易发","txt":"天气较凉，较易发生感冒，请适当增加衣服。体质较弱的朋友尤其应该注意防护。"}
         * sport : {"brf":"较适宜","txt":"天气较好，但考虑气温较低，推荐您进行室内运动，若户外适当增减衣物并注意防晒。"}
         * trav : {"brf":"适宜","txt":"天气较好，温度适宜，是个好天气哦。这样的天气适宜旅游，您可以尽情地享受大自然的风光。"}
         * uv : {"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}
         */

        private SuggestionBean suggestion;
        /**
         * astro : {"sr":"06:32","ss":"17:25"}
         * cond : {"code_d":"103","code_n":"101","txt_d":"晴间多云","txt_n":"多云"}
         * date : 2016-10-22
         * hum : 67
         * pcpn : 0.0
         * pop : 6
         * pres : 1024
         * tmp : {"max":"15","min":"6"}
         * vis : 10
         * wind : {"deg":"42","dir":"无持续风向","sc":"微风","spd":"7"}
         */

        private List<DailyForecastBean> daily_forecast;
        /**
         * date : 2016-10-22 22:00
         * hum : 57
         * pop : 5
         * pres : 1026
         * tmp : 10
         * wind : {"deg":"171","dir":"南风","sc":"微风","spd":"8"}
         */

        private List<HourlyForecastBean> hourly_forecast;

        public static HeWeatherdataserviceBean objectFromData(String str) {

            return new Gson().fromJson(str, HeWeatherdataserviceBean.class);
        }

        public static List<HeWeatherdataserviceBean> arrayHeWeatherdataserviceBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<HeWeatherdataserviceBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public AqiBean getAqi() {
            return aqi;
        }

        public void setAqi(AqiBean aqi) {
            this.aqi = aqi;
        }

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public SuggestionBean getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(SuggestionBean suggestion) {
            this.suggestion = suggestion;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<HourlyForecastBean> getHourly_forecast() {
            return hourly_forecast;
        }

        public void setHourly_forecast(List<HourlyForecastBean> hourly_forecast) {
            this.hourly_forecast = hourly_forecast;
        }

        public static class AqiBean {
            /**
             * aqi : 50
             * co : 0
             * no2 : 39
             * o3 : 14
             * pm10 : 50
             * pm25 : 26
             * qlty : 优
             * so2 : 2
             */

            private CityBean city;

            public static AqiBean objectFromData(String str) {

                return new Gson().fromJson(str, AqiBean.class);
            }

            public static List<AqiBean> arrayAqiBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<AqiBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public CityBean getCity() {
                return city;
            }

            public void setCity(CityBean city) {
                this.city = city;
            }

            public static class CityBean {
                private String aqi="无数据";
                private String co;
                private String no2;
                private String o3;
                private String pm10;
                private String pm25="无数据";
                private String qlty;
                private String so2;

                public static CityBean objectFromData(String str) {

                    return new Gson().fromJson(str, CityBean.class);
                }

                public static List<CityBean> arrayCityBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<CityBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public String getAqi() {
                    return aqi;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public String getCo() {
                    return co;
                }

                public void setCo(String co) {
                    this.co = co;
                }

                public String getNo2() {
                    return no2;
                }

                public void setNo2(String no2) {
                    this.no2 = no2;
                }

                public String getO3() {
                    return o3;
                }

                public void setO3(String o3) {
                    this.o3 = o3;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getQlty() {
                    return qlty;
                }

                public void setQlty(String qlty) {
                    this.qlty = qlty;
                }

                public String getSo2() {
                    return so2;
                }

                public void setSo2(String so2) {
                    this.so2 = so2;
                }
            }
        }

        public static class BasicBean {
            private String city;
            private String cnty;
            private String id;
            private String lat;
            private String lon;
            /**
             * loc : 2016-10-22 21:55
             * utc : 2016-10-22 13:55
             */

            private UpdateBean update;

            public static BasicBean objectFromData(String str) {

                return new Gson().fromJson(str, BasicBean.class);
            }

            public static List<BasicBean> arrayBasicBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<BasicBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public UpdateBean getUpdate() {
                return update;
            }

            public void setUpdate(UpdateBean update) {
                this.update = update;
            }

            public static class UpdateBean {
                private String loc;
                private String utc;

                public static UpdateBean objectFromData(String str) {

                    return new Gson().fromJson(str, UpdateBean.class);
                }

                public static List<UpdateBean> arrayUpdateBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<UpdateBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public String getLoc() {
                    return loc;
                }

                public void setLoc(String loc) {
                    this.loc = loc;
                }

                public String getUtc() {
                    return utc;
                }

                public void setUtc(String utc) {
                    this.utc = utc;
                }
            }
        }

        public static class NowBean {
            /**
             * code : 104
             * txt : 阴
             */

            private CondBean cond;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            /**
             * deg : 110
             * dir : 东南风
             * sc : 4-5
             * spd : 24
             */

            private WindBean wind;

            public static NowBean objectFromData(String str) {

                return new Gson().fromJson(str, NowBean.class);
            }

            public static List<NowBean> arrayNowBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<NowBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public CondBean getCond() {
                return cond;
            }

            public void setCond(CondBean cond) {
                this.cond = cond;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public static class CondBean {
                private String code;
                private String txt;

                public static CondBean objectFromData(String str) {

                    return new Gson().fromJson(str, CondBean.class);
                }

                public static List<CondBean> arrayCondBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<CondBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class WindBean {
                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public static WindBean objectFromData(String str) {

                    return new Gson().fromJson(str, WindBean.class);
                }

                public static List<WindBean> arrayWindBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<WindBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }

        public static class SuggestionBean {
            /**
             * brf : 舒适
             * txt : 白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。
             */

            private ComfBean comf;
            /**
             * brf : 较适宜
             * txt : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
             */

            private CwBean cw;
            /**
             * brf : 较冷
             * txt : 建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。
             */

            private DrsgBean drsg;
            /**
             * brf : 较易发
             * txt : 天气较凉，较易发生感冒，请适当增加衣服。体质较弱的朋友尤其应该注意防护。
             */

            private FluBean flu;
            /**
             * brf : 较适宜
             * txt : 天气较好，但考虑气温较低，推荐您进行室内运动，若户外适当增减衣物并注意防晒。
             */

            private SportBean sport;
            /**
             * brf : 适宜
             * txt : 天气较好，温度适宜，是个好天气哦。这样的天气适宜旅游，您可以尽情地享受大自然的风光。
             */

            private TravBean trav;
            /**
             * brf : 中等
             * txt : 属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。
             */

            private UvBean uv;

            public static SuggestionBean objectFromData(String str) {

                return new Gson().fromJson(str, SuggestionBean.class);
            }

            public static List<SuggestionBean> arraySuggestionBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<SuggestionBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public ComfBean getComf() {
                return comf;
            }

            public void setComf(ComfBean comf) {
                this.comf = comf;
            }

            public CwBean getCw() {
                return cw;
            }

            public void setCw(CwBean cw) {
                this.cw = cw;
            }

            public DrsgBean getDrsg() {
                return drsg;
            }

            public void setDrsg(DrsgBean drsg) {
                this.drsg = drsg;
            }

            public FluBean getFlu() {
                return flu;
            }

            public void setFlu(FluBean flu) {
                this.flu = flu;
            }

            public SportBean getSport() {
                return sport;
            }

            public void setSport(SportBean sport) {
                this.sport = sport;
            }

            public TravBean getTrav() {
                return trav;
            }

            public void setTrav(TravBean trav) {
                this.trav = trav;
            }

            public UvBean getUv() {
                return uv;
            }

            public void setUv(UvBean uv) {
                this.uv = uv;
            }

            public static class ComfBean {
                private String brf;
                private String txt;

                public static ComfBean objectFromData(String str) {

                    return new Gson().fromJson(str, ComfBean.class);
                }

                public static List<ComfBean> arrayComfBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<ComfBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class CwBean {
                private String brf;
                private String txt;

                public static CwBean objectFromData(String str) {

                    return new Gson().fromJson(str, CwBean.class);
                }

                public static List<CwBean> arrayCwBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<CwBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class DrsgBean {
                private String brf;
                private String txt;

                public static DrsgBean objectFromData(String str) {

                    return new Gson().fromJson(str, DrsgBean.class);
                }

                public static List<DrsgBean> arrayDrsgBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<DrsgBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class FluBean {
                private String brf;
                private String txt;

                public static FluBean objectFromData(String str) {

                    return new Gson().fromJson(str, FluBean.class);
                }

                public static List<FluBean> arrayFluBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<FluBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class SportBean {
                private String brf;
                private String txt;

                public static SportBean objectFromData(String str) {

                    return new Gson().fromJson(str, SportBean.class);
                }

                public static List<SportBean> arraySportBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<SportBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class TravBean {
                private String brf;
                private String txt;

                public static TravBean objectFromData(String str) {

                    return new Gson().fromJson(str, TravBean.class);
                }

                public static List<TravBean> arrayTravBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<TravBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class UvBean {
                private String brf;
                private String txt;

                public static UvBean objectFromData(String str) {

                    return new Gson().fromJson(str, UvBean.class);
                }

                public static List<UvBean> arrayUvBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<UvBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }
        }

        public static class DailyForecastBean {
            /**
             * sr : 06:32
             * ss : 17:25
             */

            private AstroBean astro;
            /**
             * code_d : 103
             * code_n : 101
             * txt_d : 晴间多云
             * txt_n : 多云
             */

            private CondBean cond;
            private String date;
            private String hum;
            private String pcpn;
            private String pop;
            private String pres;
            /**
             * max : 15
             * min : 6
             */

            private TmpBean tmp;
            private String vis;
            /**
             * deg : 42
             * dir : 无持续风向
             * sc : 微风
             * spd : 7
             */

            private WindBean wind;

            public static DailyForecastBean objectFromData(String str) {

                return new Gson().fromJson(str, DailyForecastBean.class);
            }

            public static List<DailyForecastBean> arrayDailyForecastBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<DailyForecastBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public AstroBean getAstro() {
                return astro;
            }

            public void setAstro(AstroBean astro) {
                this.astro = astro;
            }

            public CondBean getCond() {
                return cond;
            }

            public void setCond(CondBean cond) {
                this.cond = cond;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public TmpBean getTmp() {
                return tmp;
            }

            public void setTmp(TmpBean tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public static class AstroBean {
                private String sr;
                private String ss;

                public static AstroBean objectFromData(String str) {

                    return new Gson().fromJson(str, AstroBean.class);
                }

                public static List<AstroBean> arrayAstroBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<AstroBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public String getSr() {
                    return sr;
                }

                public void setSr(String sr) {
                    this.sr = sr;
                }

                public String getSs() {
                    return ss;
                }

                public void setSs(String ss) {
                    this.ss = ss;
                }
            }

            public static class CondBean {
                private String code_d;
                private String code_n;
                private String txt_d;
                private String txt_n;

                public static CondBean objectFromData(String str) {

                    return new Gson().fromJson(str, CondBean.class);
                }

                public static List<CondBean> arrayCondBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<CondBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public String getCode_d() {
                    return code_d;
                }

                public void setCode_d(String code_d) {
                    this.code_d = code_d;
                }

                public String getCode_n() {
                    return code_n;
                }

                public void setCode_n(String code_n) {
                    this.code_n = code_n;
                }

                public String getTxt_d() {
                    return txt_d;
                }

                public void setTxt_d(String txt_d) {
                    this.txt_d = txt_d;
                }

                public String getTxt_n() {
                    return txt_n;
                }

                public void setTxt_n(String txt_n) {
                    this.txt_n = txt_n;
                }
            }

            public static class TmpBean {
                private String max;
                private String min;

                public static TmpBean objectFromData(String str) {

                    return new Gson().fromJson(str, TmpBean.class);
                }

                public static List<TmpBean> arrayTmpBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<TmpBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }
            }

            public static class WindBean {
                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public static WindBean objectFromData(String str) {

                    return new Gson().fromJson(str, WindBean.class);
                }

                public static List<WindBean> arrayWindBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<WindBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }

        public static class HourlyForecastBean {
            private String date;
            private String hum;
            private String pop;
            private String pres;
            private String tmp;
            /**
             * deg : 171
             * dir : 南风
             * sc : 微风
             * spd : 8
             */

            private WindBean wind;

            public static HourlyForecastBean objectFromData(String str) {

                return new Gson().fromJson(str, HourlyForecastBean.class);
            }

            public static List<HourlyForecastBean> arrayHourlyForecastBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<HourlyForecastBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public static class WindBean {
                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public static WindBean objectFromData(String str) {

                    return new Gson().fromJson(str, WindBean.class);
                }

                public static List<WindBean> arrayWindBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<WindBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }
    }
}
