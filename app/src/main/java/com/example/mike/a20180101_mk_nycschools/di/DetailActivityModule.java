package com.example.mike.a20180101_mk_nycschools.di;

import com.example.mike.a20180101_mk_nycschools.ui.detail.DetailPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailActivityModule {

    @Provides
    DetailPresenter providesDetailPresenter(){
        return new DetailPresenter();
    }

}
