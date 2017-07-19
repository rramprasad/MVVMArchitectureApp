package com.rramprasad.testingsample.utils;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lakeba05 on 7/19/17.
 * Base class for all AppCompatActivity
 * with Android Lifecycle components registry
 */
public abstract class LifecycleAppCompatActivity extends AppCompatActivity implements LifecycleRegistryOwner {

    LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }
}
