package com.media2359.huttonsandroid.helper;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by tructran on 12/12/14.
 */
public class CommonHelper {

    public static int getWidthScreen (Activity act) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = act.getWindowManager();
        Display d = wm.getDefaultDisplay();
        d.getMetrics(metrics);
        return metrics.widthPixels;
    }
}
