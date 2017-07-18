package com.rramprasad.testingsample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rramprasad.testingsample.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
    }

    private void initializeViews() {
        LoginFragment loginFragment = LoginFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity_container, loginFragment)
                .commit();

    }
}
