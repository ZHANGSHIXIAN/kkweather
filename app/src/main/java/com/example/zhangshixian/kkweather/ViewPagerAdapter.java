package com.example.zhangshixian.kkweather;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZHANGSHIXIAN on 2016/10/29.
 */
class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public   List<Fragment> mFragmentList = new ArrayList<>();
    public   List<String> mFragmentTitleList = new ArrayList<>();
    FragmentManager fm;
    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
        this.fm=manager;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {

        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }
    public void addheadFragment(Fragment fragment, String title) {

        mFragmentList.add(0,fragment);
        mFragmentTitleList.add(0,title);
    }

    public void removeFragment(int position) {
        mFragmentList.remove(position);
        mFragmentTitleList.remove(position);

    }

    public List<Fragment> getFragmentList(){
        return this.mFragmentList;
    }
    public List<String> getFragmentTitleList(){
        return this.mFragmentTitleList;
    }
    public void setFragmentList(List<Fragment> list){
        this.mFragmentList=list;
    }
    public void setFragmentTitleList(List<String> title){
        this.mFragmentTitleList=title;
    }
    public OneFragment getOneFragment(int position){
        return (OneFragment) mFragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return ViewPagerAdapter.POSITION_NONE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem((ViewPager) container, position, (Fragment) object);
        //container.removeView((View) object);
    }
}