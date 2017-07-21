package com.rramprasad.testingsample.view;

import android.os.Bundle;

import com.rramprasad.testingsample.R;
import com.rramprasad.testingsample.utils.ActivityUtils;
import com.rramprasad.testingsample.utils.LifecycleAppCompatActivity;

public class MainActivity extends LifecycleAppCompatActivity {

    //private SimpleIdlingResource mIdlingResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
    }

    private void initializeViews() {

        LoginFragment loginFragment = LoginFragment.newInstance();

        ActivityUtils.replaceFragmentInActivity(getSupportFragmentManager(), loginFragment, R.id.main_activity_container);
    }

    /*@VisibleForTesting
    @NonNull
    public SimpleIdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }*/
}

