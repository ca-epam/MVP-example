package com.example.adrian.mymvpexample.omdb.di;

import com.example.adrian.mymvpexample.app.di.AppComponent;
import com.example.adrian.mymvpexample.omdb.presenter.OmdbInteractorImpl;
import com.example.adrian.mymvpexample.omdb.presenter.OmdbPresenterImpl;
import com.example.adrian.mymvpexample.omdb.service.OmdbApiService;
import com.example.adrian.mymvpexample.omdb.view.OmdbApiActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/3/2017.
 */

@Component(dependencies = AppComponent.class, modules = {OmdbModule.class})
@OmdbScope
public interface OmdbComponent {

    OmdbApiService omdbApiService();

    void inject(OmdbApiActivity omdbApiActivity);

    void inject(OmdbInteractorImpl omdbInteractorImpl);

    void inject(OmdbPresenterImpl omdbPresenterImpl);

    final class Injector {
        private Injector() {
        }

        public static OmdbComponent buildComponent(OmdbApiActivity activity) {
            return DaggerOmdbComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .omdbModule(new OmdbModule(activity))
                    .build();
        }
    }

}
