package com.example.zhangshixian.zhihu;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,AMapLocationListener,View.OnClickListener{
    DrawerLayout drawer;
    CoordinatorLayout coordinator;
    View snackbarView;
    String mcityname=null;
    Toolbar toolbar;
    FloatingActionButton fab;
    Map<String,String> citymap=new HashMap<String, String>();
    List<String> citylist=new ArrayList<String>();
    String cityJson;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption = null;
    DataBase dataBase=new DataBase();



    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(6);
        tabLayout.setupWithViewPager(viewPager);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        setupViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tabLayout.getSelectedTabPosition());
                toolbar.setTitle(adapter.getPageTitle(viewPager.getCurrentItem()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                showLocationDialog(0);
            }

        });
        tabLayout.setVisibility(View.GONE);
        if(NetQuest.NetworkIsAvailable()){
            location();
        }else {
            SnackbarUtil.LongSnackbar(coordinator, "定位失败,请检查网络是否连接", SnackbarUtil.Alert).show();
            toolbar.setTitle("定位失败");
        }

        if (dataBase.fileIsExists("citytablist")) {
            List<String> citytablist = dataBase.restoreCityList();
            for (int i = 0; i < citytablist.size(); i++) {
                adapter.addFragment(new OneFragment().newInstance(citytablist.get(i)), citytablist.get(i));
            }
            adapter.notifyDataSetChanged();
            if (citytablist.size() > 1) {
                tabLayout.setVisibility(View.VISIBLE);
            }
        }

    }

    private void showLocationDialog(int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        switch (i){
            case 0:
                String title="确定要删除"+adapter.getPageTitle(viewPager.getCurrentItem())+"吗？";
                builder.setTitle(title);
                builder.setMessage("");
                builder.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // positive button logic
                                adapter.removeFragment(viewPager.getCurrentItem());
                                adapter.notifyDataSetChanged();
                                if (adapter.getCount()==1) {
                                    tabLayout.setVisibility(View.GONE);
                                }
                            }
                        });
                builder.setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // negative button logic
                            }
                        });
                break;
            case 1:

                builder.setTitle("城市数量已达上限");
                builder.setMessage("请点击城市标题删除一些再试");
                builder.setPositiveButton("知道了",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                builder.setNegativeButton("",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // negative button logic
                            }
                        });
                break;


        }
        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            moveTaskToBack(false);
           // super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.dingwei) {
            if (NetQuest.NetworkIsAvailable()) {
                location();
                fab.setClickable(false);
            }else {
                SnackbarUtil.ShortSnackbar(coordinator,"网络不可用，定位失败",SnackbarUtil.Alert).show();
            }

        } else if (id == R.id.nav_share) {


        } else if (id == R.id.about) {

        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                Intent intent=new Intent(MainActivity.this,Search.class);
                intent.putExtra("citylist", (Serializable) citylist);
                startActivityForResult(intent,1);
                break;
            case R.id.updatecity:
                if (NetQuest.NetworkIsAvailable()){
                for (int i = 0; i < adapter.getCount(); i++) {
                    adapter.getOneFragment(i).updateui();
                }
                    SnackbarUtil.ShortSnackbar(coordinator,"正在更新...",SnackbarUtil.Info).show();
                }else {
                    SnackbarUtil.ShortSnackbar(coordinator,"网络不可用，请检查网络后再试",SnackbarUtil.Alert).show();
                }

        }

        return super.onOptionsItemSelected(item);
    }
    public void location() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplication());
        //设置定位回调监听
        mLocationClient.setLocationListener(this);
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(false);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔 单位毫秒
        mLocationOption.setInterval(1000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            //定位成功回调信息，设置相关消息
            mcityname = aMapLocation.getCity();//城市信息
            mcityname=mcityname.replace("市","");
            List<String> temptitlelist=adapter.getFragmentTitleList();
            if (temptitlelist.contains(mcityname)) {
                viewPager.setCurrentItem(temptitlelist.indexOf(mcityname));
                SnackbarUtil.ShortSnackbar(coordinator,"定位完成",SnackbarUtil.Info).show();
            }else {
                if (NetQuest.NetworkIsAvailable()) {
                    adapter.addheadFragment(new OneFragment().newInstance(mcityname), mcityname);
                    adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(0);

                    if (adapter.getCount() > 1) {
                        tabLayout.setVisibility(View.VISIBLE);
                    }
                    SnackbarUtil.ShortSnackbar(coordinator, "定位完成", SnackbarUtil.Info).show();
                    fab.setClickable(true);
                }else {
                    SnackbarUtil.ShortSnackbar(coordinator, "暂无网络，定位失败", SnackbarUtil.Alert).show();
                }
            }
        }
        mLocationClient.stopLocation();
        fab.setClickable(true);
    }

    private void initData(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("看看天气");
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener((View.OnClickListener) this);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);


        snackbarView=getWindow().getDecorView();
        coordinator= (CoordinatorLayout) findViewById(R.id.coordinator);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setBackgroundResource(R.drawable.white);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        String allcityjsoninfo=String.format(getString(R.string.allcityjson));
        citylist=JsonJx.getCityList(allcityjsoninfo);
        citymap=JsonJx.getCityMap(allcityjsoninfo);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {   //判断数据来源
            case 1:
                if (resultCode == RESULT_OK) {
                    // resultCode 的值来判断处理结果是否成功
                    mcityname = data.getStringExtra("city");
                    List<String> temptitlelist=adapter.getFragmentTitleList();
                    if (temptitlelist.contains(mcityname)) {
                        viewPager.setCurrentItem(temptitlelist.indexOf(mcityname));
                    }else {
                        if (adapter.getCount()>=6){
                            showLocationDialog(1);
                        }else {

                            adapter.addFragment(new OneFragment().newInstance(mcityname), mcityname);
                            adapter.notifyDataSetChanged();
                            viewPager.setCurrentItem(adapter.getCount() - 1);
                            if (!NetQuest.NetworkIsAvailable()){
                                SnackbarUtil.ShortSnackbar(coordinator,"无网络暂时无法更新",SnackbarUtil.Alert).show();
                            }
                            if (adapter.getCount()>1) {
                                tabLayout.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                }
                break;
            default:

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        dataBase.saveCiytList(adapter.getFragmentTitleList());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewPager.removeAllViews();
        viewPager.removeAllViewsInLayout();
        for (int i = 0; i <adapter.getCount() ; i++) {
            adapter.removeFragment(i);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                if (NetQuest.NetworkIsAvailable()) {
                    location();
                    fab.setClickable(false);
                }else {
                    SnackbarUtil.ShortSnackbar(coordinator,"网络不可用，定位失败",SnackbarUtil.Alert).show();
                }
                break;
            default:

        }
    }
}
