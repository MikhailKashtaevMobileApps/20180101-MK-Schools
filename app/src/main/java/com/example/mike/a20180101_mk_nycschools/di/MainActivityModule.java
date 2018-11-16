package com.example.mike.a20180101_mk_nycschools.di;

import com.example.mike.a20180101_mk_nycschools.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    MainPresenter providesMainPresenter(){
        return new MainPresenter();
    }

}
