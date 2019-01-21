package com.example.rawda.widgets_app;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
    int numberOfFragments;
    Context context;

    public MyPagerAdapter(Context context, FragmentManager fm, int numberOfFragments) {
        super(fm);
        this.context = context;
        this.numberOfFragments = numberOfFragments;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                ParkFragment parkFragment = new ParkFragment();
                return parkFragment;
            case 2:
                SportFragment sportFragment = new SportFragment();
                return sportFragment;
            default:
                return null;
        }
    }
        /**
         * Return the number of views available.
         */
        @Override
        public int getCount () {
            return numberOfFragments;
        }
    }

