package com.rramprasad.testingsample.repository;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.os.Handler;

/**
 * Created by Ramprasad on 7/18/17.
 */

public class LoginRepository {

    public MutableLiveData<String> login(String username, String password) {

        final MutableLiveData<String> loginResponseLiveData = new MutableLiveData<String>();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //send username,password to server,
                // For testing purpose,set delay on handler to simulate this process
                loginResponseLiveData.setValue("Login success");
            }
        };
        new Handler().postDelayed(runnable,5*1000);

        //Return MutableLiveData object to observe on UI
        return loginResponseLiveData;
    }
}
