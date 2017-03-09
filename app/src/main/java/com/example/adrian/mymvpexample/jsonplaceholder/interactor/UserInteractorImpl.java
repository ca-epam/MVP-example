package com.example.adrian.mymvpexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.service.UserService;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiActivity;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiView;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class UserInteractorImpl implements UserInteractor {

    private static final String TAG = UserInteractorImpl.class.getName();

    private JsonPlaceholderApiView jsonPlaceholderApiView;

    @Inject
    UserService userService;

    public UserInteractorImpl(JsonPlaceholderApiView jsonPlaceholderApiView) {
        this.jsonPlaceholderApiView = jsonPlaceholderApiView;

        JsonPlaceholderApiComponent.Injector.buildComponent((JsonPlaceholderApiActivity) jsonPlaceholderApiView).inject(this);

    }

    @Override
    public void findAllUser() {
        Call<String> call = userService.findAllUser();

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                String simpleString = response.body();
                Log.i(TAG, simpleString);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
            }
        });
    }
}
