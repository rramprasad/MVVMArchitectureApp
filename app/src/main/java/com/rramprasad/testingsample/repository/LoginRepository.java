package com.rramprasad.testingsample.repository;

import android.arch.lifecycle.MutableLiveData;
import android.os.Handler;
import android.support.test.espresso.IdlingResource;

import com.rramprasad.testingsample.utils.SimpleIdlingResource;

/**
 * Created by Ramprasad on 7/18/17.
 */

public class LoginRepository {

    public MutableLiveData<String> login(String username, String password, final SimpleIdlingResource simpleIdlingResource) {

        // The IdlingResource is null in production.
        if(simpleIdlingResource != null){
            simpleIdlingResource.setIdleState(false);
        }

        final MutableLiveData<String> loginResponseLiveData = new MutableLiveData<String>();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //send username,password to server,
                // For testing purpose,set delay on handler to simulate this process
                loginResponseLiveData.setValue("Login success");
                if(simpleIdlingResource != null){
                    simpleIdlingResource.setIdleState(true);
                }
            }
        };
        new Handler().postDelayed(runnable,5*1000);

        //Return MutableLiveData object to observe on UI
        return loginResponseLiveData;
    }
}
