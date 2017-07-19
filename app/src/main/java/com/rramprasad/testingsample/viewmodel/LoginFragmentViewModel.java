package com.rramprasad.testingsample.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.rramprasad.testingsample.repository.LoginRepository;

/**
 * Created by Ramprasad on 7/18/17.
 */

public class LoginFragmentViewModel extends ViewModel{


    private final LoginRepository mLoginRepository;
    MutableLiveData<String> mLoginResponseLiveData;


    public LoginFragmentViewModel() {
        mLoginRepository = new LoginRepository();
    }

    public LiveData<String> doLogin(String username, String password) {
        mLoginResponseLiveData = mLoginRepository.login(username, password);
        return mLoginResponseLiveData;
    }
}


