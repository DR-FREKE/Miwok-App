package com.example.android.test;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static android.R.attr.fragment;

/**
 * Created by KingSolo on 10/11/2018.
 */

public class FixedPagerAdapter extends FragmentPagerAdapter {

//    private Fragment fragment[] = {new NumbersFragment(), new FamilyFragment(), new ColorsFragment(), new PhrasesFragment()};
    private String tabTitles[] = {"Numbers", "Family", "Colors", "Phrases"};

    public FixedPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new NumbersFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorsFragment();
            case 3:
                return new PhrasesFragment();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position].toUpperCase();
    }

    @Override
    public int getCount() {
        return 4;
    }
}
