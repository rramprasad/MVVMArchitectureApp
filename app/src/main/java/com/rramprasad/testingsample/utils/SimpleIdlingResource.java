package com.rramprasad.testingsample.utils;

import android.support.annotation.Nullable;
import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Lakeba
 */

public class SimpleIdlingResource implements IdlingResource {


    private static SimpleIdlingResource mSimpleIdlingResource;
    private AtomicBoolean mIsIdleNow = new AtomicBoolean(true);

    @Nullable
    private volatile ResourceCallback mCallback;
    private boolean idleState;
    private boolean mIsIdleState;

    private SimpleIdlingResource() {
    }

    public static SimpleIdlingResource getInstance(){
        if(mSimpleIdlingResource == null) {
            mSimpleIdlingResource = new SimpleIdlingResource();
        }

        return mSimpleIdlingResource;
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public boolean isIdleNow() {
        return mIsIdleNow.get();
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        mCallback = callback;
    }

    /**
     * Sets the new idle state, if isIdleNow is true, it pings the ResourceCallback.
     * @param isIdleNow false if there are pending operations, true if idle.
     */
    public void setIdleState(boolean isIdleNow) {
        mIsIdleNow.set(isIdleNow);
        if(isIdleNow && mCallback != null){
            mCallback.onTransitionToIdle();
        }
    }
}
