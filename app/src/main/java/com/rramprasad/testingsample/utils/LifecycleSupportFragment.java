package com.rramprasad.testingsample.utils;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.support.v4.app.Fragment;

/**
 * Created by lakeba05 on 7/19/17.
 * Base class for all support fragments
 * with Android Lifecycle components registry
 */
public abstract class LifecycleSupportFragment extends Fragment implements LifecycleRegistryOwner {

    LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }
}
