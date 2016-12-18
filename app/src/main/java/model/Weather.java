package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZHANGSHIXIAN on 2016/12/18.
 */

public class Weather {

    private List<HeWeather5Bean> HeWeather5;

    public static Weather objectFromData(String str) {

        return new Gson().fromJson(str, Weather.class);
    }

    public static List<Weather> arrayWeatherFromData(String str) {

        Type listType = new TypeToken<ArrayList<Weather>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public List<HeWeather5Bean> getHeWeather5() {
        return HeWeather5;
    }

    public void setHeWeather5(List<HeWeather5Bean> HeWeather5) {
        this.HeWeather5 = HeWeather5;
    }

    public static class HeWeather5Bean {
        /**
         * aqi : {"city":{"aqi":"254","co":"3","no2":"111","o3":"17","pm10":"123","pm25":"254","qlty":"重度污染","so2":"33"}}
         * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","update":{"loc":"2016-12-18 16:51","utc":"2016-12-18 08:51"}}
         * daily_forecast : [{"astro":{"mr":"21:45","ms":"10:45","sr":"07:30","ss":"16:51"},"cond":{"code_d":"502","code_n":"502","txt_d":"霾","txt_n":"霾"},"date":"2016-12-18","hum":"51","pcpn":"0.0","pop":"0","pres":"1024","tmp":{"max":"7","min":"-4"},"uv":"2","vis":"10","wind":{"deg":"151","dir":"北风","sc":"微风","spd":"2"}},{"astro":{"mr":"22:46","ms":"11:22","sr":"07:31","ss":"16:51"},"cond":{"code_d":"502","code_n":"502","txt_d":"霾","txt_n":"霾"},"date":"2016-12-19","hum":"47","pcpn":"0.0","pop":"0","pres":"1025","tmp":{"max":"8","min":"-3"},"uv":"2","vis":"10","wind":{"deg":"140","dir":"南风","sc":"微风","spd":"4"}},{"astro":{"mr":"23:47","ms":"11:55","sr":"07:31","ss":"16:52"},"cond":{"code_d":"502","code_n":"404","txt_d":"霾","txt_n":"雨夹雪"},"date":"2016-12-20","hum":"50","pcpn":"0.0","pop":"0","pres":"1026","tmp":{"max":"7","min":"-1"},"uv":"1","vis":"10","wind":{"deg":"124","dir":"南风","sc":"微风","spd":"0"}},{"astro":{"mr":"null","ms":"12:25","sr":"07:32","ss":"16:52"},"cond":{"code_d":"502","code_n":"100","txt_d":"霾","txt_n":"晴"},"date":"2016-12-21","hum":"65","pcpn":"0.0","pop":"47","pres":"1028","tmp":{"max":"3","min":"-2"},"uv":"1","vis":"10","wind":{"deg":"122","dir":"北风","sc":"微风","spd":"2"}},{"astro":{"mr":"00:44","ms":"12:55","sr":"07:32","ss":"16:53"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2016-12-22","hum":"43","pcpn":"0.0","pop":"0","pres":"1029","tmp":{"max":"4","min":"-5"},"uv":"1","vis":"10","wind":{"deg":"18","dir":"北风","sc":"微风","spd":"1"}},{"astro":{"mr":"01:42","ms":"13:25","sr":"07:33","ss":"16:53"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2016-12-23","hum":"46","pcpn":"0.0","pop":"0","pres":"1029","tmp":{"max":"5","min":"-4"},"uv":"-999","vis":"10","wind":{"deg":"184","dir":"北风","sc":"微风","spd":"1"}},{"astro":{"mr":"02:37","ms":"13:55","sr":"07:33","ss":"16:54"},"cond":{"code_d":"104","code_n":"502","txt_d":"阴","txt_n":"霾"},"date":"2016-12-24","hum":"38","pcpn":"0.0","pop":"0","pres":"1029","tmp":{"max":"2","min":"-5"},"uv":"-999","vis":"10","wind":{"deg":"131","dir":"南风","sc":"微风","spd":"4"}}]
         * hourly_forecast : [{"cond":{"code":"502","txt":"霾"},"date":"2016-12-18 19:00","hum":"49","pop":"0","pres":"1025","tmp":"3","wind":{"deg":"198","dir":"北风","sc":"微风","spd":"4"}},{"cond":{"code":"502","txt":"霾"},"date":"2016-12-18 22:00","hum":"58","pop":"0","pres":"1025","tmp":"2","wind":{"deg":"193","dir":"北风","sc":"微风","spd":"2"}}]
         * now : {"cond":{"code":"502","txt":"霾"},"fl":"5","hum":"52","pcpn":"0","pres":"1022","tmp":"6","vis":"6","wind":{"deg":"210","dir":"西南风","sc":"3-4","spd":"12"}}
         * status : ok
         * suggestion : {"air":{"brf":"很差","txt":"气象条件不利于空气污染物稀释、扩散和清除，请尽量避免在室外长时间活动。"},"comf":{"brf":"较舒适","txt":"白天天气阴沉，会感到有点儿凉，但大部分人完全可以接受。"},"cw":{"brf":"不宜","txt":"不宜洗车，未来24小时内有霾，如果在此期间洗车，会弄脏您的爱车。"},"drsg":{"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"},"flu":{"brf":"易发","txt":"昼夜温差大，且空气湿度较大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。"},"sport":{"brf":"较不宜","txt":"有扬沙或浮尘，建议适当停止户外运动，选择在室内进行运动，以避免吸入更多沙尘，有损健康。"},"trav":{"brf":"较不宜","txt":"空气质量差，不适宜旅游"},"uv":{"brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"}}
         */

        private AqiBean aqi;
        private BasicBean basic;
        private NowBean now;
        private String status;
        private SuggestionBean suggestion;
        private List<DailyForecastBean> daily_forecast;
        private List<HourlyForecastBean> hourly_forecast;

        public static HeWeather5Bean objectFromData(String str) {

            return new Gson().fromJson(str, HeWeather5Bean.class);
        }

        public static List<HeWeather5Bean> arrayHeWeather5BeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<HeWeather5Bean>>() {
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
             * city : {"aqi":"254","co":"3","no2":"111","o3":"17","pm10":"123","pm25":"254","qlty":"重度污染","so2":"33"}
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
                /**
                 * aqi : 254
                 * co : 3
                 * no2 : 111
                 * o3 : 17
                 * pm10 : 123
                 * pm25 : 254
                 * qlty : 重度污染
                 * so2 : 33
                 */

                private String aqi;
                private String co;
                private String no2;
                private String o3;
                private String pm10;
                private String pm25;
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
            /**
             * city : 北京
             * cnty : 中国
             * id : CN101010100
             * lat : 39.904000
             * lon : 116.391000
             * update : {"loc":"2016-12-18 16:51","utc":"2016-12-18 08:51"}
             */

            private String city;
            private String cnty;
            private String id;
            private String lat;
            private String lon;
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
                /**
                 * loc : 2016-12-18 16:51
                 * utc : 2016-12-18 08:51
                 */

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
             * cond : {"code":"502","txt":"霾"}
             * fl : 5
             * hum : 52
             * pcpn : 0
             * pres : 1022
             * tmp : 6
             * vis : 6
             * wind : {"deg":"210","dir":"西南风","sc":"3-4","spd":"12"}
             */

            private CondBean cond;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
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
                /**
                 * code : 502
                 * txt : 霾
                 */

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
                /**
                 * deg : 210
                 * dir : 西南风
                 * sc : 3-4
                 * spd : 12
                 */

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
             * air : {"brf":"很差","txt":"气象条件不利于空气污染物稀释、扩散和清除，请尽量避免在室外长时间活动。"}
             * comf : {"brf":"较舒适","txt":"白天天气阴沉，会感到有点儿凉，但大部分人完全可以接受。"}
             * cw : {"brf":"不宜","txt":"不宜洗车，未来24小时内有霾，如果在此期间洗车，会弄脏您的爱车。"}
             * drsg : {"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"}
             * flu : {"brf":"易发","txt":"昼夜温差大，且空气湿度较大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。"}
             * sport : {"brf":"较不宜","txt":"有扬沙或浮尘，建议适当停止户外运动，选择在室内进行运动，以避免吸入更多沙尘，有损健康。"}
             * trav : {"brf":"较不宜","txt":"空气质量差，不适宜旅游"}
             * uv : {"brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"}
             */

            private AirBean air;
            private ComfBean comf;
            private CwBean cw;
            private DrsgBean drsg;
            private FluBean flu;
            private SportBean sport;
            private TravBean trav;
            private UvBean uv;

            public static SuggestionBean objectFromData(String str) {

                return new Gson().fromJson(str, SuggestionBean.class);
            }

            public static List<SuggestionBean> arraySuggestionBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<SuggestionBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public AirBean getAir() {
                return air;
            }

            public void setAir(AirBean air) {
                this.air = air;
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

            public static class AirBean {
                /**
                 * brf : 很差
                 * txt : 气象条件不利于空气污染物稀释、扩散和清除，请尽量避免在室外长时间活动。
                 */

                private String brf;
                private String txt;

                public static AirBean objectFromData(String str) {

                    return new Gson().fromJson(str, AirBean.class);
                }

                public static List<AirBean> arrayAirBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<AirBean>>() {
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

            public static class ComfBean {
                /**
                 * brf : 较舒适
                 * txt : 白天天气阴沉，会感到有点儿凉，但大部分人完全可以接受。
                 */

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
                /**
                 * brf : 不宜
                 * txt : 不宜洗车，未来24小时内有霾，如果在此期间洗车，会弄脏您的爱车。
                 */

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
                /**
                 * brf : 较冷
                 * txt : 建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。
                 */

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
                /**
                 * brf : 易发
                 * txt : 昼夜温差大，且空气湿度较大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。
                 */

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
                /**
                 * brf : 较不宜
                 * txt : 有扬沙或浮尘，建议适当停止户外运动，选择在室内进行运动，以避免吸入更多沙尘，有损健康。
                 */

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
                /**
                 * brf : 较不宜
                 * txt : 空气质量差，不适宜旅游
                 */

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
                /**
                 * brf : 最弱
                 * txt : 属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。
                 */

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
             * astro : {"mr":"21:45","ms":"10:45","sr":"07:30","ss":"16:51"}
             * cond : {"code_d":"502","code_n":"502","txt_d":"霾","txt_n":"霾"}
             * date : 2016-12-18
             * hum : 51
             * pcpn : 0.0
             * pop : 0
             * pres : 1024
             * tmp : {"max":"7","min":"-4"}
             * uv : 2
             * vis : 10
             * wind : {"deg":"151","dir":"北风","sc":"微风","spd":"2"}
             */

            private AstroBean astro;
            private CondBeanX cond;
            private String date;
            private String hum;
            private String pcpn;
            private String pop;
            private String pres;
            private TmpBean tmp;
            private String uv;
            private String vis;
            private WindBeanX wind;

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

            public CondBeanX getCond() {
                return cond;
            }

            public void setCond(CondBeanX cond) {
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

            public String getUv() {
                return uv;
            }

            public void setUv(String uv) {
                this.uv = uv;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindBeanX getWind() {
                return wind;
            }

            public void setWind(WindBeanX wind) {
                this.wind = wind;
            }

            public static class AstroBean {
                /**
                 * mr : 21:45
                 * ms : 10:45
                 * sr : 07:30
                 * ss : 16:51
                 */

                private String mr;
                private String ms;
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

                public String getMr() {
                    return mr;
                }

                public void setMr(String mr) {
                    this.mr = mr;
                }

                public String getMs() {
                    return ms;
                }

                public void setMs(String ms) {
                    this.ms = ms;
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

            public static class CondBeanX {
                /**
                 * code_d : 502
                 * code_n : 502
                 * txt_d : 霾
                 * txt_n : 霾
                 */

                private String code_d;
                private String code_n;
                private String txt_d;
                private String txt_n;

                public static CondBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, CondBeanX.class);
                }

                public static List<CondBeanX> arrayCondBeanXFromData(String str) {

                    Type listType = new TypeToken<ArrayList<CondBeanX>>() {
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
                /**
                 * max : 7
                 * min : -4
                 */

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

            public static class WindBeanX {
                /**
                 * deg : 151
                 * dir : 北风
                 * sc : 微风
                 * spd : 2
                 */

                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public static WindBeanX objectFromData(String str) {

                    return new Gson().fromJson(str, WindBeanX.class);
                }

                public static List<WindBeanX> arrayWindBeanXFromData(String str) {

                    Type listType = new TypeToken<ArrayList<WindBeanX>>() {
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
            /**
             * cond : {"code":"502","txt":"霾"}
             * date : 2016-12-18 19:00
             * hum : 49
             * pop : 0
             * pres : 1025
             * tmp : 3
             * wind : {"deg":"198","dir":"北风","sc":"微风","spd":"4"}
             */

            private CondBeanXX cond;
            private String date;
            private String hum;
            private String pop;
            private String pres;
            private String tmp;
            private WindBeanXX wind;

            public static HourlyForecastBean objectFromData(String str) {

                return new Gson().fromJson(str, HourlyForecastBean.class);
            }

            public static List<HourlyForecastBean> arrayHourlyForecastBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<HourlyForecastBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public CondBeanXX getCond() {
                return cond;
            }

            public void setCond(CondBeanXX cond) {
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

            public WindBeanXX getWind() {
                return wind;
            }

            public void setWind(WindBeanXX wind) {
                this.wind = wind;
            }

            public static class CondBeanXX {
                /**
                 * code : 502
                 * txt : 霾
                 */

                private String code;
                private String txt;

                public static CondBeanXX objectFromData(String str) {

                    return new Gson().fromJson(str, CondBeanXX.class);
                }

                public static List<CondBeanXX> arrayCondBeanXXFromData(String str) {

                    Type listType = new TypeToken<ArrayList<CondBeanXX>>() {
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

            public static class WindBeanXX {
                /**
                 * deg : 198
                 * dir : 北风
                 * sc : 微风
                 * spd : 4
                 */

                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public static WindBeanXX objectFromData(String str) {

                    return new Gson().fromJson(str, WindBeanXX.class);
                }

                public static List<WindBeanXX> arrayWindBeanXXFromData(String str) {

                    Type listType = new TypeToken<ArrayList<WindBeanXX>>() {
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
