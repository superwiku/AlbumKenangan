package com.example.superwiku.bukukenangan;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.superwiku.bukukenangan.adapter.TabFragmentPagerAdapter;

public class DetailActivity extends AppCompatActivity {
    public static String KEY_ACTIVITY="msg_activity";
    private Member member;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    TabFragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);


        Intent i=getIntent();
        member=(Member)i.getSerializableExtra(KEY_ACTIVITY);
        getSupportActionBar().setTitle("Album Kenangan "+member.getNama());

        viewPager=(ViewPager)findViewById(R.id.pager);
        tabLayout=(TabLayout)findViewById(R.id.tabs);
        pagerAdapter=new TabFragmentPagerAdapter(getSupportFragmentManager(),member);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setTabTextColors(getResources().getColor(R.color.colorPrimaryDark),getResources().getColor(R.color.colorWhite));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    public Member getMember(){
        return member;
    }
}
