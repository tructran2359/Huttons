package com.media2359.huttonsandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.media2359.huttonsandroid.app.R;

/**
 * Created by tructran on 12/12/14.
 */
public class TabProjectContentFragment extends Fragment {

    private TextView mTvContent;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fm_temp, container, false);
        mTvContent = (TextView) v.findViewById(R.id.fm_tab_project_tv_content);

        Bundle b = getArguments();
        if (b != null) {
            String str = b.getString(TabProjectFragment.DATA_BUNDLE, "Nothing");
            mTvContent.setText(str);
        }
        return v;
    }
}
