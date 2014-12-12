package com.media2359.huttonsandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.media2359.huttonsandroid.app.MainActivity;
import com.media2359.huttonsandroid.app.R;

import org.w3c.dom.Text;

/**
 * Created by tructran on 12/10/14.
 */
public class TabProjectFragment extends Fragment {

    private static final String tag = "TabProjectFragment";
    public static final String DATA_BUNDLE = "com.media2359.huttonsandroid.fragment.TabProjectFragment.DATA_BUNDLE";

    private TextView mTvNewLaunch, mTvOverseas;

    private static final int NUM_PAGES = 2;
    private static final int PAGE_NEW_LAUNCH = 0;
    private static final int PAGE_OVERSEAS = 1;
    private ViewPager mPager;
    private TabProjectContentFragment mFmNewnLaunch, mFmOverseas;
    private MyPagerAdapter mPagerAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fm_tab_project, container, false);

        initWidgets(v);
        initListeners();

        return v;
    }

    public void initWidgets(View v) {
        initFragments();

        mTvNewLaunch = (TextView) v.findViewById(R.id.fm_tab_project_tv_new_launch);
        mTvOverseas = (TextView) v.findViewById(R.id.fm_tab_project_tv_new_overseas);
        mTvNewLaunch.setSelected(true);
        mTvOverseas.setSelected(false);
        mPager = (ViewPager) v.findViewById(R.id.fm_tab_project_view_pager);
        mPagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        mPager.setAdapter(mPagerAdapter);
    }

    public void initFragments() {
        mFmNewnLaunch = new TabProjectContentFragment();
        mFmOverseas = new TabProjectContentFragment();

        Bundle bN = new Bundle();
        bN.putString(DATA_BUNDLE, "New Launch");
        Bundle bO = new Bundle();
        bO.putString(DATA_BUNDLE, "Overseas");

        mFmNewnLaunch.setArguments(bN);
        mFmOverseas.setArguments(bO);
    }

    public void initListeners() {
        mTvNewLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPager.setCurrentItem(PAGE_NEW_LAUNCH);
            }
        });

        mTvOverseas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPager.setCurrentItem(PAGE_OVERSEAS);
            }
        });

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setPageSelected(int position) {
        if (position == PAGE_NEW_LAUNCH) {
            mTvNewLaunch.setSelected(true);
            mTvOverseas.setSelected(false);
        } else {
            mTvNewLaunch.setSelected(false);
            mTvOverseas.setSelected(true);
        }
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == PAGE_NEW_LAUNCH) {
                return mFmNewnLaunch;
            }

            return mFmOverseas;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
