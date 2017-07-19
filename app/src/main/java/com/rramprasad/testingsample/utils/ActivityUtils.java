package com.rramprasad.testingsample.utils;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by lakeba05 on 7/19/17.
 */

public class ActivityUtils {

    /**
     * Replace fragment in Activity
     * @param fragmentManager
     * @param fragment
     * @param containerId
     */
    public static void replaceFragmentInActivity(FragmentManager fragmentManager, Fragment fragment,int containerId){
        if(fragmentManager != null && fragment != null){
            fragmentManager.beginTransaction()
                    .replace(containerId,fragment)
                    .commit();
        }
    }
}
