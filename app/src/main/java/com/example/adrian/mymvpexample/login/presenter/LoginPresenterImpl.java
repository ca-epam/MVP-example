package com.example.adrian.mymvpexample.login.presenter;

import android.content.SharedPreferences;

import com.example.adrian.mymvpexample.login.view.LoginView;

/**
 * Created by Adrian_Czigany on 2/28/2017.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private static final String TAG = LoginPresenterImpl.class.getName().toString();

    private LoginView loginView;

    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        loginView.showProgressBar();
        loginInteractor.validateLoginCredentials(username, password, this);
    }

    @Override
    public void saveCredentialsToSharedPreferences(SharedPreferences sharedPreferences, final String username) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("logged_username", username);
        editor.commit();
        loginView.navigateToMain();
    }

    @Override
    public void onUsernameError() {
        loginView.errorOnUsername();
        loginView.hideProgressBar();
    }

    @Override
    public void onPasswordError() {
        loginView.errorOnPassword();
        loginView.hideProgressBar();
    }

    @Override
    public void onSuccess() {
        loginView.credentialsVerified();
        loginView.hideProgressBar();
    }
}
