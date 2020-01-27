package com.example.study_android;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public PagerAdapter(FragmentManager fragmentManager, int tabcount){
        super(fragmentManager);
        this.tabCount = tabcount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:{

                FlagmentOne fragmentOne = new FlagmentOne();
                return fragmentOne;
            }
            case 1:{
                FlagmentTwo fragmentTwo = new FlagmentTwo();
                return fragmentTwo;
            }
            case 2:{
                FlagmentThree fragmentThree = new FlagmentThree();
                return fragmentThree;
            }
            default :
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
