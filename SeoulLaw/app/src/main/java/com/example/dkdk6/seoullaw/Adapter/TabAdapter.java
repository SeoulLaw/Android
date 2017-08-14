package com.example.dkdk6.seoullaw.Adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.dkdk6.seoullaw.Tab.Home_Fragment;
import com.example.dkdk6.seoullaw.Tab.Info_Fragment;
import com.example.dkdk6.seoullaw.Tab.Mypage_Fragment;
import com.example.dkdk6.seoullaw.Tab.Talk_Fragment;

/**
 * Created by dkdk6 on 2017-08-14.
 */

public class TabAdapter extends FragmentPagerAdapter {
    int tabCount;
    Home_Fragment home_fragment;
    Talk_Fragment talk_fragment;
    Info_Fragment info_fragment;
    Mypage_Fragment mypage_fragment;

    public TabAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.tabCount = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                home_fragment = new Home_Fragment();
                return home_fragment;
            case 1:
                info_fragment = new Info_Fragment();
                return info_fragment;
            case 2:
               talk_fragment = new Talk_Fragment();
                return talk_fragment;
            case 3:
                mypage_fragment = new Mypage_Fragment();
                return mypage_fragment;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return tabCount;
    }
}
