package com.rramprasad.testingsample.view;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rramprasad.testingsample.R;
import com.rramprasad.testingsample.utils.SimpleIdlingResource;
import com.rramprasad.testingsample.utils.Utils;
import com.rramprasad.testingsample.utils.LifecycleSupportFragment;
import com.rramprasad.testingsample.viewmodel.LoginFragmentViewModel;

/**
 * Created by Ramprasad on 7/18/17.
 */

public class LoginFragment extends LifecycleSupportFragment implements View.OnClickListener {

    private static final String TAG = LoginFragment.class.getSimpleName();
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private LoginFragmentViewModel mLoginFragmentViewModel;
    LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
    private TextView mResultTextView;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        mUsernameEditText = rootView.findViewById(R.id.username_edit_text);
        mPasswordEditText = rootView.findViewById(R.id.password_edit_text);
        Button loginButton = rootView.findViewById(R.id.login_button);
        mResultTextView = rootView.findViewById(R.id.result_textview);
        loginButton.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mLoginFragmentViewModel = ViewModelProviders.of(this).get(LoginFragmentViewModel.class);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_button:
                String username = mUsernameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();

                View focusView = null;
                boolean invalidField = false;

                if(password.isEmpty() || !Utils.isValidPassword(password)){
                    invalidField = true;
                    mPasswordEditText.setError("Invalid password");
                    focusView = mPasswordEditText;
                }

                if(username.isEmpty() || !Utils.isValidUserName(username)){
                    invalidField = true;
                    mUsernameEditText.setError("Invalid username");
                    focusView = mUsernameEditText;
                }

                if(invalidField){
                    focusView.requestFocus();
                }



                //mLoginFragmentViewModel.doLogin(username,password,
                  //    (((MainActivity)getActivity()).getIdlingResource())).observe(this, new Observer<String>() {
                mLoginFragmentViewModel.doLogin(username,password,
                        SimpleIdlingResource.getInstance()).observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable final String s) {
                        Log.d(TAG, "onChanged: "+s);
                        mResultTextView.setText(s);
                    }
                });

                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
