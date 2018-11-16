package com.example.mike.a20180101_mk_nycschools.di;

import com.example.mike.a20180101_mk_nycschools.ui.main.MainActivity;

import javax.inject.Inject;

import dagger.Component;

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);
}
