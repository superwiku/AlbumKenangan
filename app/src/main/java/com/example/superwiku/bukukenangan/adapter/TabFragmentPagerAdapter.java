package com.example.superwiku.bukukenangan.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.superwiku.bukukenangan.DetailActivity;
import com.example.superwiku.bukukenangan.Member;
import com.example.superwiku.bukukenangan.fragment.DataDiriFragment;
import com.example.superwiku.bukukenangan.fragment.FotoFragment;
import com.example.superwiku.bukukenangan.fragment.KenanganFragment;

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {

    private Member membernya;
    String[]title=new String[]{"data diri","pesan kesan","foto"};

    public TabFragmentPagerAdapter(FragmentManager fm,Member membernya) {
        super(fm);
        this.membernya=membernya;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0:
                Fragment fragment=new DataDiriFragment();
                Bundle bundle=new Bundle();
                bundle.putSerializable("mmember", membernya);
                fragment.setArguments(bundle);
                return fragment;

            case 1:
                Fragment fragment2=new KenanganFragment();
                Bundle bundle2=new Bundle();
                bundle2.putSerializable("mmmember",membernya);
                fragment2.setArguments(bundle2);
                return fragment2;
            case 2:
                Fragment fragment3=new FotoFragment();
                Bundle bundle3=new Bundle();
                bundle3.putSerializable("mmmmember",membernya);
                fragment3.setArguments(bundle3);
                return fragment3;
        }
        return null;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
