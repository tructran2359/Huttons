package com.media2359.huttonsandroid.app;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.media2359.huttonsandroid.fragment.TabMoreFragment;
import com.media2359.huttonsandroid.fragment.TabNotificationFragment;
import com.media2359.huttonsandroid.fragment.TabProjectFragment;
import com.media2359.huttonsandroid.fragment.TabSearchFragment;
import com.media2359.huttonsandroid.helper.CommonHelper;


public class MainActivity extends FragmentActivity {

    public static final String DATA_TO_FRAGMENT = "MainActivity.DATA_TO_FRAGMENT";

    FragmentTabHost mFragmentTabHost;
    FragmentTabHost.TabSpec mTabProject, mTabSearch, mTabNotification, mTabMore;
    RelativeLayout mRlSlidingMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initWidgets();
        initListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Map widgets from xml layout
     */

    public void initWidgets() {
        mFragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mFragmentTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        LayoutInflater inflater = LayoutInflater.from(this);

        mTabProject = mFragmentTabHost.newTabSpec("Project");
        View vProject = inflater.inflate(R.layout.tab_project, null);
        mTabProject.setIndicator(vProject);

        mTabSearch = mFragmentTabHost.newTabSpec("Search");
        View vSearch = inflater.inflate(R.layout.tab_search, null);
        mTabSearch.setIndicator(vSearch);

        mTabNotification = mFragmentTabHost.newTabSpec("Notification");
        View vNoti = inflater.inflate(R.layout.tab_notification, null);
        mTabNotification.setIndicator(vNoti);

        mTabMore = mFragmentTabHost.newTabSpec("More");
        View vMore = inflater.inflate(R.layout.tab_more, null);
        mTabMore.setIndicator(vMore);

        Bundle bProject = new Bundle();
        bProject.putString(DATA_TO_FRAGMENT, "Project");
        mFragmentTabHost.addTab(mTabProject, TabProjectFragment.class, bProject);

        Bundle bSearch = new Bundle();
        bSearch.putString(DATA_TO_FRAGMENT, "Search");
        mFragmentTabHost.addTab(mTabSearch, TabSearchFragment.class, bSearch);

        Bundle bNoti = new Bundle();
        bNoti.putString(DATA_TO_FRAGMENT, "Notification");
        mFragmentTabHost.addTab(mTabNotification, TabNotificationFragment.class, bNoti);

        Bundle bMore = new Bundle();
        bMore.putString(DATA_TO_FRAGMENT, "More");
        mFragmentTabHost.addTab(mTabMore, TabMoreFragment.class, bMore);

        //sliding menu
        mRlSlidingMenu = (RelativeLayout) findViewById(R.id.act_main_nav_root);
        int widthScreen = CommonHelper.getWidthScreen(this);
        if (widthScreen != 0) {
            int slidingMenuSize = widthScreen * 3 / 4;
            ViewGroup.LayoutParams params = mRlSlidingMenu.getLayoutParams();
            params.width = slidingMenuSize;
            mRlSlidingMenu.setLayoutParams(params);
        }

    }

    /**
     *
     * */
    public void initListeners() {

    }
}
