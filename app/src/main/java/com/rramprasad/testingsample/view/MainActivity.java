package com.rramprasad.testingsample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rramprasad.testingsample.R;
import com.rramprasad.testingsample.utils.ActivityUtils;
import com.rramprasad.testingsample.utils.LifecycleAppCompatActivity;

public class MainActivity extends LifecycleAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
    }

    private void initializeViews() {

        LoginFragment loginFragment = LoginFragment.newInstance();

        ActivityUtils.replaceFragmentInActivity(getSupportFragmentManager(),loginFragment,R.id.main_activity_container);
    }
}
