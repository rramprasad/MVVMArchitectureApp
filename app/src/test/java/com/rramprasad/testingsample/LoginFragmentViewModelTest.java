package com.rramprasad.testingsample;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.rramprasad.testingsample.viewmodel.LoginFragmentViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by lakeba05 on 7/19/17.
 */

public class LoginFragmentViewModelTest {

    private LoginFragmentViewModel mLoginFragmentViewModel;

    @Before
    public void initializeTest(){
        mLoginFragmentViewModel = new LoginFragmentViewModel();
    }

    private final static ScheduledExecutorService mainThread = Executors.newSingleThreadScheduledExecutor();

    @Test
    public void check_do_login(){
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
        LiveData<String> stringLiveData = mLoginFragmentViewModel.doLogin("username@gmail.com", "password@123");


        LifecycleOwner lifecycleOwner = mock(LifecycleOwner.class);
        stringLiveData.observe(lifecycleOwner, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                assertEquals(s,"Login success");
            }
        });
    }
}
