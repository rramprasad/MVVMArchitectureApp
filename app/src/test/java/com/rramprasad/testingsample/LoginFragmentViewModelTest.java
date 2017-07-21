package com.rramprasad.testingsample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.rramprasad.testingsample.repository.LoginRepository;
import com.rramprasad.testingsample.viewmodel.LoginFragmentViewModel;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by lakeba05 on 7/19/17.
 */

public class LoginFragmentViewModelTest {

    private LoginFragmentViewModel mLoginFragmentViewModel;
    private LoginRepository mLoginRepository;

    @Before
    public void initializeTest(){
        mLoginFragmentViewModel = new LoginFragmentViewModel();
    }

    private final static ScheduledExecutorService mainThread = Executors.newSingleThreadScheduledExecutor();

    @Before
    public void setup(){
        mLoginRepository = mock(LoginRepository.class);
    }

    @Test
    public void check_do_login(){
        MutableLiveData<String> mutableLiveData = mock(MutableLiveData.class);
        when(mLoginRepository.login(anyString(), anyString(), idlingResource)).thenReturn(mutableLiveData);
        when(mutableLiveData.getValue()).thenReturn("Testing value");

        LiveData<String> stringLiveData = mLoginFragmentViewModel.doLogin("username@gmail.com", "password@123", (((MainActivity) getActivity()).getIdlingResource()));
        assertEquals(stringLiveData.getValue(),"Testing value");

        /*
        final Handler handler = mock(Handler.class);
        when(handler.postDelayed(any(Runnable.class),anyLong()))
        .thenAnswer(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocation) throws Throwable {
                Runnable runnable = invocation.getArgument(0);
                runnable.run();

                //mainThread.schedule(runnable, anyInt(), TimeUnit.MILLISECONDS);
                return true;
            }
        });
        LiveData<String> stringLiveData = mLoginFragmentViewModel.doLogin("username@gmail.com", "password@123");*/
    }
}
