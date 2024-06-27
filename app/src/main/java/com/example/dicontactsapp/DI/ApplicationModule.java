package com.example.dicontactsapp.DI;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final Application app;

    public ApplicationModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application providesApplication()
    {
        return app;
    }
}
