package com.example.adrian.mymvpexample.users.presenter;

import com.example.adrian.mymvpexample.jsonplaceholder.interactor.UserInteractor;
import com.example.adrian.mymvpexample.users.view.UsersPageView;

/**
 * Created by Adrian_Czigany on 3/17/2017.
 */

public class UsersPagePresenterImpl implements UsersPagePresenter {

    private UsersPageView usersPageView;

    private UserInteractor userInteractor;

    public UsersPagePresenterImpl(UsersPageView usersPageView, UserInteractor userInteractor) {
        this.usersPageView = usersPageView;
        this.userInteractor = userInteractor;
        
    }


    @Override
    public void onClickBtnFindAllUser() {
        userInteractor.findAllUser();
    }
}
