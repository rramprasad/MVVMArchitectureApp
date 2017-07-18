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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //send username,password to server,
                // For testing purpose,set delay on handler to simulate this process
                loginResponseLiveData.setValue("Login success");
            }
        },5*1000);

        //return MutableLiveData object to observe on UI
        return loginResponseLiveData;
    }
}
