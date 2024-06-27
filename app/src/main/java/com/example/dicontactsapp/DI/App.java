package com.example.dicontactsapp.DI;

import android.app.Application;

public class App extends Application {
    private static App app;
    private ContactAppComponent component;


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        component = DaggerContactAppComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ContactAppComponent getComponent() {
        return component;
    }

    public static App getApp()
    {
        return app;
    }
}
