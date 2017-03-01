package com.example.adrian.mymvpexample.login.presenter;

import android.content.SharedPreferences;
import android.os.Handler;

/**
 * Created by Adrian_Czigany on 3/1/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {

    private SharedPreferences sharedPreferences;

    public LoginInteractorImpl() {
//        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences();
    }

    @Override
    public void validateLoginCredentials(final String username, final String password, final OnLoginFinishedListener onLoginFinishedListener) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                boolean error = false;
                if(username == null || username.equals("")) {
                    onLoginFinishedListener.onUsernameError();
                    error = true;
                }
                if(password == null || password.equals("")) {
                    onLoginFinishedListener.onPasswordError();
                    error = true;
                }
                if(! error) {
                    onLoginFinishedListener.onSuccess();
                }
            }
        },500);


    }

    @Override
    public void storeCredentials(String username, String password) {

    }

}
