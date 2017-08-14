package com.example.dkdk6.seoullaw.Activity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.dkdk6.seoullaw.Adapter.TabAdapter;
import com.example.dkdk6.seoullaw.R;

import org.w3c.dom.Text;

/**
 * Created by dkdk6 on 2017-08-14.
 */

public class Main_Activity extends AppCompatActivity {
    ViewPager viewPager;
    TabAdapter adapter;
    TextView infoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        infoText = (TextView)findViewById(R.id.topText);
        // Tab
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setIcon(
                R.drawable.login_image));
        tabLayout.addTab(tabLayout.newTab().setIcon(
                R.drawable.login_image));
        tabLayout.addTab(tabLayout.newTab().setIcon(
                R.drawable.login_image));
        tabLayout.addTab(tabLayout.newTab().setIcon(
                R.drawable.login_image));
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new TabAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0){
                    Log.d("Fragment Home","Selected");
                    infoText.setText("서울로");
                }
                else if(tab.getPosition()==1){
                    Log.d("Fragment Info","Selected");
                    infoText.setText("법률보기");
                }else if(tab.getPosition()==2){
                    Log.d("Fragment Talk","Selected");
                    infoText.setText("법률토크");
                }else if(tab.getPosition()==3){
                    Log.d("Fragment MyPage","Selected");
                    infoText.setText("마이페이지");
                }
              //  tab.getIcon().setColorFilter(getResources().getColor(R.color.pointColor), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
           //    tab.getIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
