package com.example.dicontactsapp.DI;

import com.example.dicontactsapp.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RoomModule.class,ApplicationModule.class})
public interface ContactAppComponent {
    void inject(MainActivity ma);
}
