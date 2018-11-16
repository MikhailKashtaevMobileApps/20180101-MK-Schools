package com.example.mike.a20180101_mk_nycschools.di;

import com.example.mike.a20180101_mk_nycschools.ui.main.MainPresenter;

import dagger.Component;

@Component(modules = PresenterModule.class)
public interface MainPresenterComponent {

    void inject( MainPresenter mainPresenter );

}
