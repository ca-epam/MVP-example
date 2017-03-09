package com.example.adrian.mymvpexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvpexample.app.BaseApp;
import com.example.adrian.mymvpexample.jsonplaceholder.di.DaggerJsonPlaceholderApiComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiComponent;
import com.example.adrian.mymvpexample.jsonplaceholder.di.JsonPlaceholderApiModule;
import com.example.adrian.mymvpexample.jsonplaceholder.service.PostService;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiActivity;
import com.example.adrian.mymvpexample.jsonplaceholder.view.JsonPlaceholderApiView;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class PostInteractorImpl implements PostInteractor {

    private static final String TAG = PostInteractorImpl.class.getName();

    JsonPlaceholderApiView jsonPlaceholderApiView;

    @Inject
    PostService postService;

    public PostInteractorImpl(JsonPlaceholderApiView jsonPlaceholderApiView) {
        this.jsonPlaceholderApiView = jsonPlaceholderApiView;

        JsonPlaceholderApiComponent jsonPlaceholderApiComponent = DaggerJsonPlaceholderApiComponent.builder()
                .jsonPlaceholderApiModule(new JsonPlaceholderApiModule((JsonPlaceholderApiActivity)jsonPlaceholderApiView))
                .appComponent(BaseApp.get((JsonPlaceholderApiActivity)jsonPlaceholderApiView).getAppComponent())
                .build();
        jsonPlaceholderApiComponent.inject(this);

    }

    @Override
    public void findAllPost() {
        Call<String> call = postService.findAllPost();

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

    @Override
    public void findPostById(final int id) {
        Call<String> call = postService.findPostById(id);

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